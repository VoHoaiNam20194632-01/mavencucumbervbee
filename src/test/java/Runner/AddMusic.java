package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
@CucumberOptions(
        features = {
                "src/test/resources/features/AddMusic.feature",
        },
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)
@Test
public class AddMusic extends AbstractTestNGCucumberTests {

}