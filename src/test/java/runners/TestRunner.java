package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty",
                    "html:Cucumber_reports/cucumber_report.html",
                    "json:Cucumber_reports/cucumber_report.json"},
            features="./src/test/resources/features",
            glue="tests",
            tags="@SalesandExpensesHeader",
            dryRun = true

    )
    public class TestRunner {

    }
