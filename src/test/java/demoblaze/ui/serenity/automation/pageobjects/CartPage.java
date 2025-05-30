package demoblaze.ui.serenity.automation.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(css = "button[data-target='#orderModal']")
    private WebElementFacade btnPlaceOrder;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElementFacade btnPurchase;

    @FindBy(xpath = "//div[contains(@class, 'sweet-alert')]//h2")
    private WebElementFacade alertTitle;

    @FindBy(xpath = "//div[contains(@class, 'sweet-alert')]//p[contains(@class, 'lead')]")
    private WebElementFacade purchaseSummary;

    public  void clicPlaceOrderButton(){
        btnPlaceOrder.waitUntilClickable().click();
    }
    public  void clicPurchaseButton(){
        btnPurchase.waitUntilClickable().click();
    }

    public void fillInputById(String id, String value) {
        WebElementFacade input = find(By.id(id));
        input.waitUntilVisible().clear();
        input.type(value);
    }

    public String getAlertTitle(){
        return alertTitle.waitUntilVisible().getText().trim();
    }
    public String getPurchaseSummaryValue(String label) {
        String[] lines = purchaseSummary.waitUntilVisible().getText().split("\\n");
        for (String line : lines) {
            if (line.startsWith(label + ": ")) {
                return line.replace(label + ": ", "").trim();
            }
        }
        return null;
    }
}
