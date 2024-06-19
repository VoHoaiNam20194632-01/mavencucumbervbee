package Runner.Register;//package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {
                "src/test/resources/features/Register/RegisterPass.feature"
        },
        glue = "StepDefinitions",
//        glue = {"StepDefinitions", "AllureScreenshotListener"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class RegisterRunnerP extends AbstractTestNGCucumberTests {

    @AfterClass
    public void TearDown(){

    }
}


