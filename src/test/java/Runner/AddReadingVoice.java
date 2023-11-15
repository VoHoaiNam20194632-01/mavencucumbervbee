package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;
@CucumberOptions(
        features = {
//                "src/test/resources/features/LoginVbee.feature"
                "src/test/resources/features/AddReadingVoice.feature",
//                "src/test/resources/features/AddMusic.feature",
//                "src/test/resources/features/AddText.feature",
//                "src/test/resources/features/BuyPackOfData"
        },
        glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)
@Test
public class AddReadingVoice extends AbstractTestNGCucumberTests {

}