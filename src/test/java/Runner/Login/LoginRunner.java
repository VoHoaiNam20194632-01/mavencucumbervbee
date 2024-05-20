package Runner.Login;//package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {
//        features = {"src/test/resources/features/Studio/Login/FailedLogin.feature",
                        "src/test/resources/features/Studio/Login/Gg.feature"
        },
        glue = "StepDefinitions",
//        glue = {"StepDefinitions", "AllureScreenshotListener"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class LoginRunner extends AbstractTestNGCucumberTests {

        @AfterClass
        public void TearDown(){

        }
}


