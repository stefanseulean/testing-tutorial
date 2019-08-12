package com.tutorial.testing.service;

import com.tutorial.testing.types.BlueprintRequest;
import com.tutorial.testing.types.BlueprintResponse;

public interface BlueprintService {

    BlueprintResponse createBlueprint(BlueprintRequest blueprintRequest);
}
