package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features/scenario.feature"},
        glue = {"stepDefinitions"},
        tags = "",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}

