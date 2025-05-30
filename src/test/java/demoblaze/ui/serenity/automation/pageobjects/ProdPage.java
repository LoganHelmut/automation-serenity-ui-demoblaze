package demoblaze.ui.serenity.automation.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Alert;

public class ProdPage extends BasePage{

    @FindBy(xpath = "//a[normalize-space(text())='Add to cart']")
    private WebElementFacade btnAddToCart;


    public void clicAddToCartButton(){
        btnAddToCart.waitUntilClickable().click();
    }
    public void aceptAlert() {
        waitFor(3).seconds();
        getDriver().switchTo().alert().accept();
    }
}
