package demoblaze.ui.serenity.automation.definitions;

import demoblaze.ui.serenity.automation.steps.CartStep;
import demoblaze.ui.serenity.automation.utils.DataModel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CartDefinitions {
    @Steps
    CartStep cartStep;
    @Given("I place an order")
    public void iPlaceAnOrder(DataTable dataTable) {
        DataModel dataModel = DataModel.setData(dataTable);
        cartStep.placeOrder();
        cartStep.fillForm("name",dataModel.getDynamicVariable("name"));
        cartStep.fillForm("country",dataModel.getDynamicVariable("country"));
        cartStep.fillForm("city",dataModel.getDynamicVariable("city"));
        cartStep.fillForm("card",dataModel.getDynamicVariable("creditCard"));
        cartStep.fillForm("month",dataModel.getDynamicVariable("month"));
        cartStep.fillForm("year",dataModel.getDynamicVariable("year"));
    }
    @When("I complete the purchase")
    public void iCompleteThePurchase() {
        cartStep.purchase();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String title) {
        cartStep.shouldSeeTheAlertTitle(title);
    }

    @Then("I should see the datails of the purchase")
    public void iShouldSeeTheDatailsOfThePurchase(DataTable dataTable) {
        DataModel dataModel = DataModel.setData(dataTable);
        cartStep.shouldSeeTheLabel("Amount",dataModel.getDynamicVariable("amount"));
        cartStep.shouldSeeTheLabel("Card Number",dataModel.getDynamicVariable("cardNumber"));
        cartStep.shouldSeeTheLabel("Name",dataModel.getDynamicVariable("name"));
    }
}
