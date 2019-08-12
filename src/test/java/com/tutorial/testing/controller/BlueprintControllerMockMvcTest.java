package com.tutorial.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.testing.repository.BlueprintRepository;
import com.tutorial.testing.service.BlueprintService;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.util.BlueprintRequestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(BlueprintController.class)
public class BlueprintControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BlueprintService blueprintService;

    @MockBean
    private BlueprintRepository blueprintRepository;

    public void CreateBlueprint__should_return_status_ok(){

    }

    @Test
    public void Should_CreateBlueprintEntity_ReturnsStatusOk() throws Exception {
        BlueprintRequest blueprintRequest = BlueprintRequestUtil.createTestBlueprint();

        when(blueprintService.createBlueprint(blueprintRequest)).thenReturn(any());

        mvc.perform(MockMvcRequestBuilders.post("/demo/testing")
                .content(asJsonString(blueprintRequest))
                .content(asJsonString(blueprintRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
