package Runner.BuyTieuChuan;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {
                "src/test/resources/features/BuyPackOfData/Tieuchuan/namBuyPackDataTieuChuan.feature",

        },
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@Test
public class namBuyPackDataTieuChuan  extends AbstractTestNGCucumberTests {
        @AfterClass
        public void TearDown(){

        }
}