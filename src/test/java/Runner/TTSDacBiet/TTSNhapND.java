package Runner.TTSDacBiet;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {
                "src/test/resources/features/textTranfer/professional/TtsImportText.feature"

        },
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@Test
public class TTSNhapND extends AbstractTestNGCucumberTests {
    @AfterClass
    public void TearDown(){

    }
}