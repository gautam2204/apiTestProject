package stepdefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        plugin = {"pretty", "html:target/cucumber"}
        ,dryRun = false,tags = "@Post_Test"
        ,features = "src/test/resources/features"
        ,glue = "stepdefinition")
public class RunCucumberTest {
}