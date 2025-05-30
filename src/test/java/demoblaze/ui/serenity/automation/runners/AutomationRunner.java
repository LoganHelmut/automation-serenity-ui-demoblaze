package demoblaze.ui.serenity.automation.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/",
        tags = "@regresion",
        glue = {
                "demoblaze.ui.serenity.automation.definitions"
        },
        plugin = {"pretty","json:target/cucumber-reports/cucumber.json"},
        publish = true
)
public class AutomationRunner {

}
