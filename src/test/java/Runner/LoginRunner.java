package Runner;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {
//        features = {"src/test/resources/features/Studio/Login/FailedLogin.feature",
                "src/test/resources/features/Studio/Login/SuccessfulLogin.feature"
        },
        glue = "StepDefinitions",
        plugin = {"pretty", "json:target/cucumber-reports/report.json","pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class LoginRunner extends AbstractTestNGCucumberTests {

        @After
        public  void TearDown(){}
}
