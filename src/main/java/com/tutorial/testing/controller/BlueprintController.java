package com.tutorial.testing.controller;

import com.tutorial.testing.entitites.BlueprintEntity;
import com.tutorial.testing.repository.BlueprintRepository;
import com.tutorial.testing.service.BlueprintService;
import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/demo/testing")
public class BlueprintController {

    @Autowired
    private BlueprintService blueprintService;

    @Autowired
    private BlueprintRepository blueprintRepository;

    @PostMapping
    public ResponseEntity<BlueprintResponse> createBlueprint(@RequestBody BlueprintRequest blueprintRequest) {

        BlueprintResponse blueprintResponse = blueprintService.createBlueprint(blueprintRequest);

        return ResponseEntity.ok(blueprintResponse);
    }

    @GetMapping
    public ResponseEntity getBlueprintEntries() {
        List<BlueprintEntity> blueprintEntity = blueprintRepository.findAll();
        return ResponseEntity.ok(blueprintEntity);
    }
}
