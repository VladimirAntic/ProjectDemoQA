package Pages;




import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WebTables {


    WebDriver driver;

    public WebTables(WebDriver driver) {
        this.driver = driver;
    }

    WebElement addButton, firstNameField, lastNameField, emailField,
            ageField, salaryField, departmentField, submitButton, searchBox, deleteButton,
             RowInfo, CellInfo, deletebuttons;


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

    public WebElement getSearchBox() {
        return driver.findElement(By.id("searchBox"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.cssSelector("span[title='Delete']"));
    }

    public List<WebElement> getRowInfo() {return driver.findElements(By.className("rt-tr-group"));}

    public List<WebElement> getCellInfo() {return driver.findElements(By.className("rt-td"));}

    public String cellText(int i) {return getCellInfo().get(i).getText();}
    public String rowText(int i) {
        return getRowInfo().get(i).getText();
    }

    //----------------------------

    public void clickOnSubmitButton(){
        getSubmitButton().click();
    }
    public void clickOnAddButton(){
        getAddButton().click();
    }
    public void clickOnDeleteButton(){
        getDeleteButton().click();
    }

    public List<WebElement> getDeletebuttons() {
        List<WebElement> list = new ArrayList<>();
        boolean element = false;
        for(int i =1;i<=8;i++){
            try{WebElement x = driver.findElement(By.id("delete-record-"+i));
                element = x.isDisplayed();}
            catch (Exception e){}
            if(element) {
                list.add(driver.findElement(By.id("delete-record-"+i)));}
            element = false;
        }
        return list;
    }
    public void deleteAll(){
        int counter = getDeletebuttons().size();
        for(int i=0;i<counter;i++){
            clickOnDeleteButton();
        }
    }
    public void SearchEntireTable(String target){
        useSeachBox(target);
        boolean contains = false;
        deleteAll();
        do {
            fillForm(1);
            for (int i = 0; i < getRowInfo().size(); i++) {
                if (rowText(i).toUpperCase().contains(target.toUpperCase())) {
                    contains = true;
                }
            }
        }
        while (!contains);
    }
    public void fillForm(int numberOfForm){
        Faker faker = new Faker();
        for(int i=0;i<numberOfForm;i++) {
            clickOnAddButton();
            getFirstNameField().clear();
            getFirstNameField().sendKeys(faker.name().firstName());
            getLastNameField().clear();
            getLastNameField().sendKeys(faker.name().lastName());
            getEmailField().clear();
            getEmailField().sendKeys(faker.internet().emailAddress());
            getAgeField().clear();
            getAgeField().sendKeys(faker.number().digits(2));
            getSalaryField().clear();
            getSalaryField().sendKeys(faker.number().digits(3));
            getDepartmentField().clear();
            getDepartmentField().sendKeys(faker.job().title());
            clickOnSubmitButton();
        }
    }
    public void useSeachBox(String x){
        getSearchBox().clear();
        getSearchBox().sendKeys(x);
    }




}
