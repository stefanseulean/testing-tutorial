package com.tutorial.testing.util;

import com.tutorial.testing.entitites.BlueprintEntity;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;

import static org.junit.Assert.*;

public class BlueprintRequestUtil {

    public static final String NAME = "First UUID";

    public static final String UUID = "d5d5523c-bc82-11e9-9cb5-2a2ae2dbcce4";

    public static BlueprintRequest createTestBlueprint() {
        BlueprintRequest blueprintRequest = new BlueprintRequest();
        blueprintRequest.setName(BlueprintRequestUtil.NAME);
        blueprintRequest.setUUID(BlueprintRequestUtil.UUID);
        return blueprintRequest;
    }

    public static void assertBlueprintEntity(BlueprintEntity expected, BlueprintRequest actual) {
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getUUID(), actual.getUUID());
    }

    public static void assertBlueprintResponse(BlueprintResponse expected, BlueprintRequest actual) {
        assertNotNull(expected.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getUUID(), actual.getUUID());
    }
}
