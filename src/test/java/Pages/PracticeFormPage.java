package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class PracticeFormPage {

    WebDriver driver;
    WebElement firstName, lastName, email, gender, mobile, dateOfBirth, subjects, hobbies, picture, currentAddress, state, city, submitButton, closeButton;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getGender() {
        return driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
    }

    public WebElement getMobile() {
        return driver.findElement(By.id("userNumber"));
    }

    public WebElement getDateOfBirth() {
        return driver.findElement(By.id("dateOfBirthInput"));
    }

    public WebElement getCloseButton() { return driver.findElement(By.id("closeLargeModal"));}



    public WebElement getCurrentAddressField() {
        return driver.findElement(By.id("currentAddress"));
    }


    //----------------------------

    public void inputFirstName(String firstName) {
        getFirstName().clear();
        getFirstName().sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        getLastName().clear();
        getLastName().sendKeys(lastName);
    }

    public void inputMobileNumber(String number) {
        getMobile().clear();
        getMobile().sendKeys(number);
    }

    public void chooseGender() {
        getGender().click();
    }

    public void clickOnSubmit() {
        getSubmitButton().submit();
    }

    public void inputEmail(String email) {
        getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void inputDate(String date) {
        getDateOfBirth().click();
        getDateOfBirth().sendKeys(Keys.CONTROL + "a");
        getDateOfBirth().sendKeys(date);
        getDateOfBirth().sendKeys(ENTER);
    }

    public void inputCurrentAddress(){
        getCurrentAddressField().clear();
        getCurrentAddressField().sendKeys("Cara Kralja 23");
    }
    public void clickOnCloseButton(){
        getCloseButton().click();
    }

}

