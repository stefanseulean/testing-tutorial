package com.tutorial.testing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.util.BlueprintRequestUtil;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import org.apache.http.HttpStatus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlueprintUnirestRestApiIT {

    @LocalServerPort
    private int port;

    @BeforeClass
    public static void setup() {
        Unirest.config().setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @AfterClass
    public static void cleanup() throws IOException {
        Unirest.shutDown();
    }

    @Test
    public void Should_CreateBlueprintEntity_ReturnsStatusOk() {
        BlueprintRequest actual = BlueprintRequestUtil.createTestBlueprint();

        HttpResponse<JsonNode> jsonResponse
                = Unirest.post(createURLWithPort("/demo/testing"))
                .body(actual)
                .header("Content-Type", "application/json")
                .asJson();

        assertEquals(jsonResponse.getStatus(), HttpStatus.SC_OK);

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
