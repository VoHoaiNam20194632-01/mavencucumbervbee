package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {
                "src/test/resources/features/BuyPackOfData/thangBuyPackDataTieuChuan.feature"
        },
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@Test
public class BuyPackOfDataTieuChuan extends AbstractTestNGCucumberTests {

}