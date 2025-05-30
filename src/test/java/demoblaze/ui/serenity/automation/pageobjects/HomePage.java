package demoblaze.ui.serenity.automation.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@DefaultUrl("https://demoblaze.com/")
public class HomePage extends BasePage {
    @FindBy(xpath="//button[@id='next2']")
    private WebElementFacade btnNext;

    @FindBy(css = "#tbodyid .card")
    private List<WebElementFacade> productCards;

    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    private WebElementFacade btnSignUp;


    public List<String> getProductData() {
        return productCards.stream().map(card -> {
            String name = card.findElement(By.cssSelector(".card-title a")).getText();
            String price = card.findElement(By.tagName("h5")).getText();
            String link = card.findElement(By.tagName("a")).getAttribute("href");
            return name + "," + price + "," + link;
        }).collect(Collectors.toList());
    }

    public void clicNextButton(){
        evaluateJavascript("arguments[0].scrollIntoView(true);", btnNext);
        btnNext.waitUntilClickable().click();
    }

    public void waitForProductsToLoad() {
        waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#tbodyid .card")));
    }

    public void clickOnProductByName(String productName) {
        WebElement productLink = getDriver().findElement(By.xpath("//a[text()='" + productName + "']"));
        productLink.click();
    }

    public void clickMenuOptionByText(String menu) {
        String xpath = String.format("//ul[@class='navbar-nav ml-auto']//a[normalize-space(text())='%s']", menu);
        find(By.xpath(xpath)).waitUntilClickable().click();
    }
    public String generateRandomName(String firstName) {
        String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin"};
        Random random = new Random();
        String lastName = lastNames[random.nextInt(lastNames.length)];
        int number = 100 + random.nextInt(900);

        return firstName + "" + lastName+ "" + number;
    }

    public void fillInputById(String id, String value) {
        WebElementFacade input = find(By.id(id));
        input.waitUntilVisible().clear();
        input.type(value);
    }

    public void clickSignUpButton() {
        btnSignUp.waitUntilClickable().click();
    }

    public String getAlertText(){
        waitFor(3).seconds();
        return getDriver().switchTo().alert().getText();
    }
    public void aceptAlert() {
        waitFor(3).seconds();
        getDriver().switchTo().alert().accept();
    }
}
