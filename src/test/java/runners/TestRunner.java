package runners;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/feature" },
        glue = {"classpath:src/test/steps", "classpath:io.cucumber" },
        monochrome = true,
        plugin = { "pretty","html:target/cucumber-reports/userFeature.html",
                "json:target/userFeature.json"
        }
)
public class TestRunner {





}
