package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTables {


    WebDriver driver, addButton, firstNameField, lastNameField, emailField,
            ageField, salaryField, departmentField, submitButton;

    public WebTables(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getFirstNameField() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getAgeField() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getSalaryField() {
        return driver.findElement(By.id("salary"));
    }

    public WebElement getDepartmentField() {
        return driver.findElement(By.id("department"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }
    //----------------------------
    public void clickOnSubmitButton(){
        getSubmitButton().click();
    }
    public void clickOnAddButton(){
        getAddButton().click();
    }
}
