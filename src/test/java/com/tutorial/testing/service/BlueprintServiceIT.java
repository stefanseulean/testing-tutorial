package com.tutorial.testing.service;

import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;
import com.tutorial.testing.util.BlueprintRequestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlueprintServiceIT {

    @Autowired
    private BlueprintService blueprintService;

    @Test
    public void Should_CreateBlueprintEntity() {
        BlueprintRequest actual = BlueprintRequestUtil.createTestBlueprint();

        BlueprintResponse expected = blueprintService.createBlueprint(actual);

        BlueprintRequestUtil.assertBlueprintResponse(expected, actual);
    }
}
