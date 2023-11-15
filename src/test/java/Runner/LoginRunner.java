package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {
                "src/test/resources/features/LoginVbee.feature"
        },
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        tags= "@login"
)

public class LoginRunner extends AbstractTestNGCucumberTests {


}
