package com.pruebatecnicaqa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.pruebatecnicaqa.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    plugin = {"pretty"},
    tags = "not @ignore"
)
public class RegressionTestRunner {
} 