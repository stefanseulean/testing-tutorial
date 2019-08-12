package com.tutorial.testing.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BlueprintClient {

    public String doSomething() {
        return "Method to demonstrate how to partial mock an integration test with mockito";
    }
}
