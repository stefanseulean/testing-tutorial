package com.tutorial.testing.types;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BlueprintRequest {

    private String UUID;

    private String name;
}
