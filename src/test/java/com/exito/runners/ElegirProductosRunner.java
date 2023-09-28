package com.exito.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/elegirProductos.feature",
        glue = "com.exito.stepDefinitions",
        snippets = SnippetType.CAMELCASE
)
public class ElegirProductosRunner {
}
