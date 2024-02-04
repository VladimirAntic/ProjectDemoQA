package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage {
    WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement yesRadioButton, impressiveRadioButton, noRadio, SuccessMesage, ImpressiveMessage, YesMessage;

    public WebElement getYesRadioButton() {
        return driver.findElement(By.cssSelector("label[for='yesRadio']"));
    }

    public WebElement getImpressiveRadioButton() {
        return driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
    }

    public WebElement getNoRadio() {
        return driver.findElement(By.cssSelector("label[for='noRadio']"));
    }

    public WebElement getSuccessMesage() {
        return driver.findElement(By.className("text-success"));

    }

    public WebElement getImpressiveMessage() {
        WebElement x = null;
        if(getSuccessMesage().getText().equals("Impressive"))
        x = getSuccessMesage();
        return x;
    }

    public WebElement getYesMessage() {
        WebElement x = null;
        if(getSuccessMesage().getText().equals("Yes"))
            x = getSuccessMesage();
        return x;
    }
    public void clickOnYesRadioButton(){
        getYesRadioButton().click();
    }
    public void clickOnImpressiveRadioButton(){
        getImpressiveRadioButton().click();
    }




}
