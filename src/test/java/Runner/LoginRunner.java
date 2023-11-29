package Runner;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {
                "src/test/resources/features/Login/LoginVbee.feature"
        },
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags= "@login"
)

public class LoginRunner extends AbstractTestNGCucumberTests {

        @After
        public  void TearDown(){}
}
