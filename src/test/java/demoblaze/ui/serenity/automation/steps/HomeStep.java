package demoblaze.ui.serenity.automation.steps;

import demoblaze.ui.serenity.automation.pageobjects.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class HomeStep {
    HomePage homePage;
    List<String> products;

    @Step
    public void loadUrl(){
        homePage.open();
    }

    @Step
    public void extractProducts(){
        products = homePage.getProductData();
        homePage.clicNextButton();
        homePage.waitForProductsToLoad();
        homePage.waitFor(3000).milliseconds();
        products.addAll(homePage.getProductData());

        Serenity.recordReportData()
                .withTitle("Products")
                .andContents(products.toString());
    }

    @Step
    public void saveProductsToFile(String filePath) {
        try {
            Files.write(Paths.get(filePath), products, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the file", e);
        }
    }

    @Step
    public void selectProduct(String productName){
        homePage.clickOnProductByName(productName);
    }

    @Step
    public void goToMenu(String menu){
        homePage.clickMenuOptionByText(menu);
    }

    @Step
    public String generateUserName(String name){
        return homePage.generateRandomName(name);
    }

    @Step
    public void fillForm(String id, String value){
        homePage.fillInputById(id,value);
    }
    @Step
    public void signUp(){
        homePage.clickSignUpButton();
    }

    @Step
    public void shouldSeeTheAlertText(String text){
        String actualText = homePage.getAlertText();
        Assert.assertEquals(text,actualText);
    }
    @Step
    public void aceptAlert(){
        homePage.aceptAlert();
    }


}
