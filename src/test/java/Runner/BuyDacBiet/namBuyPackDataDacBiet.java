package Runner.BuyDacBiet;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {
                "src/test/resources/features/BuyPackOfData/DacBiet/namBuyPackDataDacBiet.feature",

        },
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@Test
public class namBuyPackDataDacBiet extends AbstractTestNGCucumberTests {
        @AfterClass
        public void TearDown(){

        }
}
