package com.tutorial.testing.types;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BlueprintResponse {

    private Long id;

    private String UUID;

    private String name;
}
