package com.tutorial.testing.service;

import com.tutorial.testing.rest.BlueprintClient;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;
import com.tutorial.testing.util.BlueprintRequestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlueprintServicePartialMockIT {

    @MockBean
    private BlueprintClient blueprintClient;

    @Autowired
    private BlueprintService blueprintService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void Should_CreateBlueprintEntity() {
        BlueprintRequest actual = BlueprintRequestUtil.createTestBlueprint();

        when(blueprintClient.doSomething()).thenReturn("Mocked string to show for demo purposes !!!");

        BlueprintResponse expected = blueprintService.createBlueprint(actual);

        BlueprintRequestUtil.assertBlueprintResponse(expected, actual);
    }
}
