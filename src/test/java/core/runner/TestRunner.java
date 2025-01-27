package core.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/", // Ruta de los archivos .feature
        glue = {"stepsDefinition", "core.hooks.Hooks"},    // Paquete donde están los step definitions
        tags = "@this",                       // Etiquetas a ejecutar
        plugin = {
                "pretty"
        },
        monochrome = true // Salida limpia en la consola

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
