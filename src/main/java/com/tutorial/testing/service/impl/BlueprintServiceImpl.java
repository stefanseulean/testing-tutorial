package com.tutorial.testing.service.impl;

import com.tutorial.testing.datamapper.BlueprintDataMapper;
import com.tutorial.testing.entitites.BlueprintEntity;
import com.tutorial.testing.repository.BlueprintRepository;
import com.tutorial.testing.rest.BlueprintClient;
import com.tutorial.testing.service.BlueprintService;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlueprintServiceImpl implements BlueprintService {

    @Autowired
    private BlueprintClient blueprintClient;

    @Autowired
    private BlueprintRepository blueprintRepository;

    @Override
    public BlueprintResponse createBlueprint(BlueprintRequest blueprintRequest) {
        log.debug("Enter createBlueprint,blueprintRequest:{}", blueprintRequest);

        BlueprintEntity blueprintEntity = blueprintRepository
                .save(BlueprintDataMapper.convertToBlueprintEntity(blueprintRequest));

        blueprintClient.doSomething();//for the scope of showing how to partial mock this part !!!!

        BlueprintResponse blueprintResponse = BlueprintDataMapper.convertToBlueprintResponse(blueprintEntity);

        log.debug("Exit createBlueprint,blueprintResponse:{}", blueprintResponse);
        return blueprintResponse;
    }
}
