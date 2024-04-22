package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
@CucumberOptions(
        features = {
                "src/test/resources/features/textTransfer/textTransfer.feature",
        },
        glue = "StepDefinitions",
//        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        plugin = {"pretty", "html:target/cucumber-html-reports","pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@Test
public class AddReadingVoice extends AbstractTestNGCucumberTests {

}