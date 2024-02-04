package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.SPACE;

public class PracticeFormPage {

    WebDriver driver;
    WebElement firstName, lastName, email, gender, mobile, dateOfBirth,
            subjects, hobbies, currentAddress, state,
            city, submitButton, closeButton, uploadPicture;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getFirstName() {return driver.findElement(By.id("firstName"));}

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

    public WebElement getSubjects() {
        return driver.findElement(By.id("subjectsInput"));
    }

    public List<WebElement> getHobbies() {
        return driver.findElements(By.cssSelector("input[type='checkbox']"));
    }

    public WebElement getUploadPicture() {
        return driver.findElement(By.id("uploadPicture"));
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getCity() {
        return city;
    }


//----------------------------

    Faker faker = new Faker();

    public void inputFirstName() {
        getFirstName().clear();
        getFirstName().sendKeys(faker.name().firstName());
    }

    public void inputLastName() {
        getLastName().clear();
        getLastName().sendKeys(faker.name().lastName());
    }

    public void inputMobileNumber() {
        getMobile().clear();
        getMobile().sendKeys(faker.number().digits(10));
    }

    public void chooseGender() {
        getGender().click();
    }

    public void clickOnSubmit() {
        getSubmitButton().submit();
    }

    public void inputEmail() {
        getEmail().clear();
        getEmail().sendKeys(faker.internet().emailAddress());
    }

    public void inputDate() {
        getDateOfBirth().click();
        getDateOfBirth().sendKeys(Keys.CONTROL + "a");
        getDateOfBirth().sendKeys(faker.date().birthday().toString());
        getDateOfBirth().sendKeys(ENTER);
    }

    public void inputCurrentAddress(){
        getCurrentAddressField().clear();
        getCurrentAddressField().sendKeys(faker.address().fullAddress());
    }
    public void clickOnCloseButton(){
        getCloseButton().click();
    }

    public void inputSubject(){
        getSubjects().clear();
        getSubjects().sendKeys("faker.job().title()");
    }

    public void inputHobbies(){
       int i = faker.number().numberBetween(0,2);
        getHobbies().get(i).sendKeys(SPACE);
    }


}


