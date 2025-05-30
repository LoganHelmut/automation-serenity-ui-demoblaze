package demoblaze.ui.serenity.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;

public class BasePage extends PageObject{

    public void checkByXpath(String xpath) {
		WebElement lWelBtn = getDriver().findElement(By.xpath(""+xpath+""));
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", lWelBtn);
		
    }

    public void clickByXpath(String xpath) {
		WebElement lWelBtn = getDriver().findElement(By.xpath(""+xpath+""));
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", lWelBtn);
    }
	public void clickButton(String pStrText) {
		WebElement lWelBtn = getDriver().findElement(By.xpath("//button[text()='"+pStrText+"']"));
		JavascriptExecutor js =(JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", lWelBtn);
	}

    public Boolean isPresent(String xpath) {
        Boolean isPresent=false;
        List<WebElement> elementos = findElements(xpath);

        if(elementos.size()!=0){
            isPresent=true;
        }
        //isPresent = findElements(xpath).size() > 0;
        return isPresent;
    }
    public List<WebElement> findElements(String xpath) {
        List<WebElement> elements;
        elements = getDriver().findElements(By.xpath(xpath));
        return elements;
    }
    public WebElement findElement(String xpath) {
        if (isPresent(xpath) != true) {
            waitFor(5).seconds();
        }
        WebElement element = getDriver().findElement(By.xpath(xpath));
        return element;
    }

    public void waitUntilElementIsAvailable(String xpath, Integer time){
        Integer waitTime = time;
        Boolean elementPresent = false;
        for(int i=0;i<=time;i=i+5){

            elementPresent = isPresent(xpath);
            if(elementPresent==true){
                elementPresent = true;
                i=time+1;
            }else{
                waitFor(5).seconds();
            }
        }
    }
}
