package Tests;

import Base.BaseTest;
import Pages.WebTables;
import com.beust.ah.A;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DemoQAPageTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");
    }

@Test(invocationCount = 2)
public void testFlow() throws InterruptedException {

        userCanFillForm();
        confirmationFormTest();
        webElementsIsPresent();
        testingWebElements();
        elementsIsPresent();
        testingelementsAndMessage();
        webtablesElementstest();
        userCanFillFormWithRandomFields();
        userCanDeleteForms();
        userCanSearchEntireTable();
        fillFormWithExcelFile();
        linksPagetest();
        userCanFillFormWithJustMandatoryFields();
        userCanFillFormWithAllFields();
}

//============Elements page tests===============

    //++++++++Text Box page tests+++++++++++++++
    @Test(priority = 10)
    public void userCanFillForm(){
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();
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
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();
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
    public void testingWebElements() throws InterruptedException {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Check Box");
        checkboxPage.clickOnExpandButtono();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",checkboxPage.getDownloadsFolder());
        Assert.assertEquals(17, checkboxPage.getUncheckedCheckbox().size());
        checkboxPage.clickOnHomeFolder();
        checkboxPage.clickOnExpandButtono();
        checkboxPage.clickOnDesktopFolder();
        Assert.assertEquals(3, checkboxPage.getUncheckedCheckbox().size());
        checkboxPage.clickOnColapseButton();
        checkboxPage.clickOnExpandButtono();
        checkboxPage.clickOnDocumentFolde();
        Assert.assertEquals(13, checkboxPage.getUncheckedCheckbox().size());
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);",checkboxPage.getDownloadsFolder());
        checkboxPage.clickOnDownloadsFolder();
        Assert.assertEquals(17, checkboxPage.getUncheckedCheckbox().size());
        checkboxPage.clickOnColapseButton();
    }

    //++++++++++++Radio Button page tests++++++++++++++++++++++++
    @Test(priority = 13)
    public void elementsIsPresent() {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Radio Button");
        Assert.assertTrue(radioButtonPage.getImpressiveRadioButton().isDisplayed());
        Assert.assertTrue(radioButtonPage.getYesRadioButton().isDisplayed());
        Assert.assertTrue(radioButtonPage.getNoRadio().isDisplayed());
    }
    @Test(priority = 14)
    public void testingelementsAndMessage() throws InterruptedException {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Radio Button");
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(radioButtonPage.getYesMessage().isDisplayed());
        boolean isImpressiveMessagePresent = false;
        try {isImpressiveMessagePresent = radioButtonPage.getImpressiveMessage().isDisplayed();
        } catch (Exception e) {}
        Assert.assertFalse(isImpressiveMessagePresent);
        Thread.sleep(2000);
        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(radioButtonPage.getImpressiveMessage().isDisplayed());
        boolean isYesMessagePresent = false;
        try {isYesMessagePresent = radioButtonPage.getYesMessage().isDisplayed();
        } catch (Exception e) {}
        Assert.assertFalse(isYesMessagePresent);
        Thread.sleep(2000);
        radioButtonPage.clickOnYesRadioButton();
        Assert.assertTrue(radioButtonPage.getYesMessage().isDisplayed());
        try {isImpressiveMessagePresent = radioButtonPage.getImpressiveMessage().isDisplayed();
        } catch (Exception e) {}
        Assert.assertFalse(isImpressiveMessagePresent);
        Thread.sleep(2000);
        radioButtonPage.clickOnImpressiveRadioButton();
        Assert.assertTrue(radioButtonPage.getImpressiveMessage().isDisplayed());
        try {isYesMessagePresent = radioButtonPage.getYesMessage().isDisplayed();
        } catch (Exception e) {}
        Assert.assertFalse(isYesMessagePresent);
    }

    //++++++++++++Webtables page tests++++++++++++++++++++++++

    @Test(priority = 15)
    public void webtablesElementstest(){
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Web Tables");
        Assert.assertTrue(webTables.getSearchBox().isDisplayed());
        Assert.assertTrue(webTables.getAddButton().isDisplayed());
        Assert.assertTrue(webTables.getSearchBox().isDisplayed());
    }
    @Test(priority = 16)
    public void userCanFillFormWithRandomFields(){
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Web Tables");
        Assert.assertEquals(3, webTables.getDeletebuttons().size());
        webTables.fillForm(5);
        Assert.assertEquals(8, webTables.getDeletebuttons().size());
    }
    @Test(priority = 17)
    public void userCanDeleteForms() throws InterruptedException {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Web Tables");
        webTables.deleteAll();
        Assert.assertEquals(0, webTables.getDeletebuttons().size());
        webTables.fillForm(5);
        webTables.deleteAll();
        Assert.assertEquals(0, webTables.getDeletebuttons().size());
    }
    @Test(priority = 18)
    public void userCanSearchEntireTable() {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Web Tables");
        webTables.SearchEntireTable("yahoo");
    }
    @Test(priority = 19)
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

    //============Links page tests===============

    @Test(priority = 20)
    public void linksPagetest() throws InterruptedException {
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnSidebarButton("Links");
        linksPage.clickOnHomeLink();
        ArrayList<String> listaTabova =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
        driver.close();
        driver.switchTo().window(listaTabova.get(0));
        Thread.sleep(1000);
        linksPage.clickOnCreated();
        Assert.assertEquals(linksPage.LinkResponseText(),
                "Link has responded with staus 201 and status text Created");
        linksPage.clickOnNoContent();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.LinkResponseText(),
                "Link has responded with staus 204 and status text No Content");
        linksPage.clickOnMoved();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.LinkResponseText(),
                "Link has responded with staus 301 and status text Moved Permanently");
        linksPage.clickOnBadRequest();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.LinkResponseText(),
                "Link has responded with staus 400 and status text Bad Request");
        linksPage.cliclOnUnauthorized();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.LinkResponseText(),
                "Link has responded with staus 401 and status text Unauthorized");
        linksPage.clickOnForbidden();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.LinkResponseText(),
                "Link has responded with staus 403 and status text Forbidden");
        linksPage.clickOnNotFound();
        Thread.sleep(1000);
        Assert.assertEquals(linksPage.LinkResponseText(),
                "Link has responded with staus 404 and status text Not Found");
    }

    //============Practice Forms page tests===============
    @Test(priority = 21)
    public void userCanFillFormWithJustMandatoryFields() {
        driver.navigate().to("https://demoqa.com/");
        homePage.clickOnCard("Forms");
        sidebarPage.clickOnSidebarButton("Practice Form");
        wait.until(ExpectedConditions.elementToBeClickable(practiceFormPage.getFirstName()));
        practiceFormPage.inputFirstName();
        practiceFormPage.inputLastName();
        practiceFormPage.chooseGender();
        practiceFormPage.inputMobileNumber();
        practiceFormPage.clickOnSubmit();
    }
    @Test(priority = 22)
    public void userCanFillFormWithAllFields() {
        driver.navigate().to("https://demoqa.com/");
        homePage.clickOnCard("Forms");
        sidebarPage.clickOnSidebarButton("Practice Form");
        practiceFormPage.inputFirstName();
        practiceFormPage.inputLastName();
        practiceFormPage.inputEmail();
        practiceFormPage.inputDate();
        practiceFormPage.chooseGender();
        practiceFormPage.inputMobileNumber();
        practiceFormPage.inputCurrentAddress();
        practiceFormPage.inputSubject();
        practiceFormPage.inputHobbies();
        practiceFormPage.clickOnSubmit();
        practiceFormPage.clickOnCloseButton();
    }

}
