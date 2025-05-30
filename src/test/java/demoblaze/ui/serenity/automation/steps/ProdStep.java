package demoblaze.ui.serenity.automation.steps;

import demoblaze.ui.serenity.automation.pageobjects.ProdPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;

public class ProdStep {
    ProdPage prodPage;

    @Step
    public void addToCart(){
        prodPage.clicAddToCartButton();
    }

    @Step
    public void aceptAlert(){
        prodPage.aceptAlert();
    }
}
