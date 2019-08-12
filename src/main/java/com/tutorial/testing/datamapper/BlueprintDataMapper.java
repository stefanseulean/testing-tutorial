package com.tutorial.testing.datamapper;

import com.tutorial.testing.entitites.BlueprintEntity;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlueprintDataMapper {

    public static BlueprintEntity convertToBlueprintEntity(BlueprintRequest blueprintRequest) {
        log.debug("Enter convertToBlueprintEntity,blueprintRequest:{}", blueprintRequest);

        BlueprintEntity blueprintEntity = new BlueprintEntity();

        blueprintEntity.setName(blueprintRequest.getName());
        blueprintEntity.setUUID(blueprintRequest.getUUID());

        log.debug("Exit convertToBlueprintEntity,blueprintEntity:{}", blueprintEntity);
        return blueprintEntity;
    }

    public static BlueprintResponse convertToBlueprintResponse(BlueprintEntity blueprintEntity) {
        log.debug("Enter convertToBlueprintResponse,blueprintEntity:{}");

        BlueprintResponse blueprintResponse = new BlueprintResponse();

        blueprintResponse.setId(blueprintEntity.getId());
        blueprintResponse.setName(blueprintEntity.getName());
        blueprintResponse.setUUID(blueprintEntity.getUUID());

        log.debug("Exit convertToBlueprintResponse,blueprintResponse:{}", blueprintResponse);
        return blueprintResponse;
    }
}
