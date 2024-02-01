package Tests;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoQAPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");


    }

/*
@Test(invocationCount = 2)
public void testFlow() throws InterruptedException {
        userCanFillForm();
        Thread.sleep(3000);
        confirmationFormTest();
    Thread.sleep(3000);
        webElementsIsPresent();
    Thread.sleep(3000);
        fillFormWithExcelFile();
    Thread.sleep(3000);
        userCanFillFormWithJustMandatoryFields();
    Thread.sleep(3000);
        userCanFillFormWithAllFields();
}
*/
//============Elements page tests===============

    //++++++++Text Box page tests+++++++++++++++
    @Test(priority = 10)
    public void userCanFillForm(){
        String fullName = "Antic Vladimir";
        String email = "mail@mail.com";
        String currentAddress = "Cara Kralja 11";
        String permanentAddress = "Bata Djosa 5";
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Text Box");
        Assert.assertTrue(textBoxPage.getSubmitButton().isDisplayed());
        textBoxPage.inputFulName(fullName);
        textBoxPage.inputEmailFileds(email);
        textBoxPage.inputCurrentAddressFields(currentAddress);
        textBoxPage.inputPermanentAddressField(permanentAddress);
        textBoxPage.getSubmitButton().click();
        Assert.assertTrue(textBoxPage.getConfirmationNameField().isDisplayed());
        Assert.assertTrue(textBoxPage.getConfirmationEmailField().isDisplayed());
        Assert.assertTrue(textBoxPage.getConfirmationcurrentAddressField().isDisplayed());
        Assert.assertTrue(textBoxPage.getConfirmationpermanentAddressField().isDisplayed());
    }
    @Test(priority = 11)
    public  void confirmationFormTest(){
        String fullName = "Antic Vladimir";
        String email = "mail@mail.com";
        String currentAddress = "Cara Kralja 11";
        String permanentAddress = "Bata Djosa 5";
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Text Box");
        Assert.assertTrue(textBoxPage.getSubmitButton().isDisplayed());
        textBoxPage.inputFulName(fullName);
        textBoxPage.inputEmailFileds(email);
        textBoxPage.inputCurrentAddressFields(currentAddress);
        textBoxPage.inputPermanentAddressField(permanentAddress);
        textBoxPage.getSubmitButton().click();
        Assert.assertTrue(textBoxPage.getConfirmationNameField().isDisplayed());
        Assert.assertTrue(textBoxPage.getConfirmationEmailField().isDisplayed());
        Assert.assertTrue(textBoxPage.getConfirmationcurrentAddressField().isDisplayed());
        Assert.assertTrue(textBoxPage.getConfirmationpermanentAddressField().isDisplayed());
        Assert.assertEquals(textBoxPage.getConfirmationNameField().getText(),"Name:"+fullName );
        Assert.assertEquals(textBoxPage.getConfirmationEmailField().getText(),"Email:"+email );
        Assert.assertEquals(textBoxPage.getConfirmationcurrentAddressField().getText(),"Current Address :"+currentAddress );
        Assert.assertEquals(textBoxPage.getConfirmationpermanentAddressField().getText(),"Permananet Address :"+permanentAddress );
    }
    //++++++++++++Checkbox page tests++++++++++++++++++++++++

    @Test(priority = 12)
    public void webElementsIsPresent() {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Check Box");
        Assert.assertTrue(checkboxPage.getHomeFolder().isDisplayed());
        Assert.assertTrue(checkboxPage.getExpandButton().isDisplayed());
        Assert.assertTrue(checkboxPage.getCollapseButton().isDisplayed());

    }
    @Test(priority = 12)
    public void TestingWebElements() throws InterruptedException {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Check Box");
        checkboxPage.clickOnHomeFolder();
        checkboxPage.clickOnExpandButtono();
        checkboxPage.clickOnDesktopFolder();
        checkboxPage.clickOnColapseButton();
        checkboxPage.clickOnExpandButtono();
        checkboxPage.clickOnDocumentFolde();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",checkboxPage.getDownloadsFolder());
        checkboxPage.clickOnDownloadsFolder();
        checkboxPage.clickOnColapseButton();

    }

    //++++++++++++Elements page tests++++++++++++++++++++++++
    @Test(priority = 15)
    public void fillFormWithExcelFile() {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Web Tables");
        String firstName = excelReader.getStringData("Forms", 1, 0);
        String lastName = excelReader.getStringData("Forms", 1, 1);
        String email = excelReader.getStringData("Forms", 1, 2);
        String age = String.valueOf(excelReader.getIntegerData("Forms", 1, 3));
        String salary = String.valueOf(excelReader.getIntegerData("Forms", 1, 4));
        String department = excelReader.getStringData("Forms", 1, 5);
        webTables.clickOnAddButton();
        webTables.getFirstNameField().sendKeys(firstName);
        webTables.getLastNameField().sendKeys(lastName);
        webTables.getEmailField().sendKeys(email);
        webTables.getAgeField().sendKeys(age);
        webTables.getSalaryField().sendKeys(salary);
        webTables.getDepartmentField().sendKeys(department);
        webTables.clickOnSubmitButton();
    }
    //============Practice Forms page tests===============
    @Test(priority = 20)
    public void userCanFillFormWithJustMandatoryFields() {
        homePage.clickOnCard("Forms");
        sidebarPage.clickOnSidebarButton("Practice Form");
        practiceFormPage.inputFirstName("Vlada");
        practiceFormPage.inputLastName("Antic");
        practiceFormPage.chooseGender();
        practiceFormPage.inputMobileNumber("1234567890");
        practiceFormPage.clickOnSubmit();
        practiceFormPage.clickOnCloseButton();

    }

    @Test(priority = 21)
    public void userCanFillFormWithAllFields() {
        homePage.clickOnCard("Forms");
        sidebarPage.clickOnSidebarButton("Practice Form");
        practiceFormPage.inputFirstName("Vlada");
        practiceFormPage.inputLastName("Antic");
        practiceFormPage.inputEmail("mail@mail.com");
        practiceFormPage.inputDate("13 June 2000");
        practiceFormPage.chooseGender();
        practiceFormPage.inputMobileNumber("1231231231");
        practiceFormPage.inputCurrentAddress();
        practiceFormPage.clickOnSubmit();
        practiceFormPage.clickOnCloseButton();

    }
}
