package com.tutorial.testing.datamapper;

import com.tutorial.testing.entitites.BlueprintEntity;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.util.BlueprintRequestUtil;
import org.junit.Test;

public class BlueprintDataMapperTest {

    @Test
    public void Should_ConvertToBlueprintEntity() {
        BlueprintRequest actualResult = BlueprintRequestUtil.createTestBlueprint();

        BlueprintEntity expectedResult = BlueprintDataMapper.convertToBlueprintEntity(actualResult);

        BlueprintRequestUtil.assertBlueprintEntity(expectedResult, actualResult);
    }
}
