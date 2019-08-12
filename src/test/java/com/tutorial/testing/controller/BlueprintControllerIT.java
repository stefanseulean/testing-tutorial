package com.tutorial.testing.controller;

import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;
import com.tutorial.testing.util.BlueprintRequestUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlueprintControllerIT {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void Should_CreateBlueprintEntity_ReturnsStatusOk() {
        BlueprintRequest actual = BlueprintRequestUtil.createTestBlueprint();

        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();

        header.add("Content-Type", "application/json");

        HttpEntity<Object> httpEntity = new HttpEntity<Object>(actual, header);

        ResponseEntity<BlueprintResponse> response = restTemplate.exchange(
                createURLWithPort("/demo/testing"), HttpMethod.POST, httpEntity, BlueprintResponse.class);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
