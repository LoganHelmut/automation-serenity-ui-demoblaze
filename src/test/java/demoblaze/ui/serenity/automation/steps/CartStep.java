package demoblaze.ui.serenity.automation.steps;

import demoblaze.ui.serenity.automation.pageobjects.CartPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class CartStep {
    CartPage cartPage;

    @Step
    public void placeOrder(){
        cartPage.clicPlaceOrderButton();
    }
    @Step
    public void fillForm(String id, String value){
        cartPage.fillInputById(id,value);
    }
    @Step
    public void purchase(){
        cartPage.clicPurchaseButton();
    }

    @Step
    public void shouldSeeTheAlertTitle(String title){
        String actualTitle = cartPage.getAlertTitle();
        Assert.assertEquals(title,actualTitle);
    }
    @Step
    public void shouldSeeTheLabel(String label,String expectedValue){
        String actualValue = cartPage.getPurchaseSummaryValue(label);
        Assert.assertEquals(expectedValue,actualValue);
    }


}
