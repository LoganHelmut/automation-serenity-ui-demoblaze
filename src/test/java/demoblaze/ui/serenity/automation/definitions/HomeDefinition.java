package demoblaze.ui.serenity.automation.definitions;

import demoblaze.ui.serenity.automation.steps.HomeStep;
import demoblaze.ui.serenity.automation.steps.ProdStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class HomeDefinition {
    @Steps
    HomeStep homeStep;
    @Steps
    ProdStep prodStep;

    @Given("I open the website")
    public void iOpenTheWebsite(){
        homeStep.loadUrl();
    }

    @And("I go to the menu {string}")
    public void iGotoTheMenu(String menu){
        homeStep.goToMenu(menu);
    }
    @When("I extract the data from the products")
    public void iExtractTheDataFromTheProducts(){
        homeStep.extractProducts();
    }
    @Then("I should save the information into a text file named {string}")
    public void saveListToFile(String filePath) {
        homeStep.saveProductsToFile(filePath);
    }

    @Given("I add a product with the name {string} to the cart")
    public void iAddAProductWithTheNameToTheCart(String productName) {
        homeStep.goToMenu("Home");
        homeStep.selectProduct(productName);
        prodStep.addToCart();
        prodStep.aceptAlert();

    }

    @When("I sign up with user {string} and password {string}")
    public void iSignUp(String user, String password){
        String userName = homeStep.generateUserName(user);
        homeStep.fillForm("sign-username",userName);
        homeStep.fillForm("sign-password",password);
        homeStep.signUp();

    }

    @When("I should see an alert with the message {string}")
    public void iSignUp(String message){
        homeStep.shouldSeeTheAlertText(message);
        homeStep.aceptAlert();

    }
}
