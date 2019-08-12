package com.tutorial.testing.service;


import com.tutorial.testing.datamapper.BlueprintDataMapper;
import com.tutorial.testing.entitites.BlueprintEntity;
import com.tutorial.testing.repository.BlueprintRepository;
import com.tutorial.testing.rest.BlueprintClient;
import com.tutorial.testing.service.impl.BlueprintServiceImpl;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;
import com.tutorial.testing.util.BlueprintRequestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PrepareForTest({BlueprintService.class, BlueprintDataMapper.class})
public class BlueprintServicePowerMockTest {

    @MockBean
    private BlueprintClient blueprintClient;

    @MockBean
    private BlueprintRepository blueprintRepository;

    @InjectMocks
    private BlueprintService blueprintService = new BlueprintServiceImpl();

    public void init() {
        MockitoAnnotations.initMocks(toString());
    }

    @Test
    public void Should_CreateBlueprintEntity() {

        BlueprintRequest blueprintRequest = BlueprintRequestUtil.createTestBlueprint();

        PowerMockito.mockStatic(BlueprintDataMapper.class);

        when(BlueprintDataMapper.convertToBlueprintEntity(new BlueprintRequest())).thenReturn(new BlueprintEntity());
        when(blueprintRepository.save(new BlueprintEntity())).thenReturn(new BlueprintEntity());
        when(blueprintClient.doSomething()).thenReturn("Dummy");
        when(BlueprintDataMapper.convertToBlueprintResponse(new BlueprintEntity()))
                .thenReturn(new BlueprintResponse());

        BlueprintResponse blueprintResponse = blueprintService.createBlueprint(blueprintRequest);

        //verify instructions
        //assert instructions
        //...and so on..the scope is to demonstrate how to mock static methods
    }
}
