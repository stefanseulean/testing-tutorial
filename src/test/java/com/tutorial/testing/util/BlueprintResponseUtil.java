package com.tutorial.testing.util;

import com.tutorial.testing.types.BlueprintResponse;

public class BlueprintResponseUtil {

    public static final Long ID = 1L;

    public static final String NAME = "First UUID";

    public static final String UUID = "d5d5523c-bc82-11e9-9cb5-2a2ae2dbcce4";

    public static BlueprintResponse createTestBlueprintResponse() {
        BlueprintResponse blueprintResponse = new BlueprintResponse();
        blueprintResponse.setId(ID);
        blueprintResponse.setName(BlueprintResponseUtil.NAME);
        blueprintResponse.setUUID(BlueprintResponseUtil.UUID);
        return blueprintResponse;
    }
}
