package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {
                "src/test/resources/features/BuyPackOfData/ChuyenNghiep/quyBuyPackDataChuyenNghiep.feature",

        },
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class quyBuyPackDataChuyenNghiep extends AbstractTestNGCucumberTests {
}
