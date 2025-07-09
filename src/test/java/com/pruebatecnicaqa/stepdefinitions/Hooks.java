package com.pruebatecnicaqa.stepdefinitions;

import com.pruebatecnicaqa.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    
    @Before
    public void setUp(Scenario scenario) {
        // Forzar la inicialización del contexto
        TestContext.getInstance().getActor();
    }

    @After
    public void tearDown(Scenario scenario) {
        TestContext.tearDown();
    }
} 