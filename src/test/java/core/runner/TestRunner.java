package core.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/java/features/", // Ruta de los archivos .feature
        glue = {"stepsDefinition", "core.hooks.Hooks"},    // Paquete donde están los step definitions
        tags = "@this",                       // Etiquetas a ejecutar
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html",

        },
        monochrome = true // Salida limpia en la consola

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
