package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {
                "src/test/resources/features/BuyPackOfData/Tieuchuan/namBuyPackDataTieuChuan.feature",

        },
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class namBuyPackDataTieuChuan  extends AbstractTestNGCucumberTests {
}
