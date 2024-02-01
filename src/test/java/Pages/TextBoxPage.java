package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBoxPage {


    WebDriver driver;

    public TextBoxPage(WebDriver driver) {this.driver = driver;}

    WebElement fullNameField, EmailField, submitButton,
            currentAddressField, permanentAddressField,
            confirmationNameField, confirmationEmailField,
            confirmationcurrentAddressField, confirmationpermanentAddressField;
    List<WebElement> currentAddress;


    public List<WebElement> getCurrentAddress() {
        return driver.findElements(By.id("currentAddress"));
    }

    List<WebElement> permanentAddress;

    public List<WebElement> getPermanentAddress() {
        return driver.findElements(By.id("permanentAddress"));
    }

    public WebElement getFullNameField() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressField() {
       return getCurrentAddress().get(0);
    }

    public WebElement getPermanentAddressField() {
        return getPermanentAddress().get(0);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getConfirmationNameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getConfirmationEmailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getConfirmationcurrentAddressField() {
        return getCurrentAddress().get(1);
    }

    public WebElement getConfirmationpermanentAddressField() {
        return getPermanentAddress().get(1);
    }

    public void clickOnSubmitButton(){
        getSubmitButton().click();
    }
    public void inputFulName(String fullName){
        getFullNameField().clear();
        getFullNameField().sendKeys(fullName);
    }
    public void inputEmailFileds(String email){
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }
    public void inputCurrentAddressFields(String currentAddress){
        getCurrentAddressField().clear();
        getCurrentAddressField().sendKeys(currentAddress);
    }
    public void inputPermanentAddressField(String permanentAddress){
        getPermanentAddressField().clear();
        getPermanentAddressField().sendKeys(permanentAddress);
    }
}
