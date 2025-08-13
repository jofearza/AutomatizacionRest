package io.swagger.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityBaseRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/pets_store.feature",
        glue = "io.swagger.petstore.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@EliminacionMascota"
)
public class PetStoreRunner {
}
