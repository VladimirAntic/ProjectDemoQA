package Pages;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksPage {
    WebDriver driver;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement homeLink, createdLink, linkResponse, noContent, moved, badRequest,
            unauthorized, forbidden, notFound;

    public WebElement getHomeLink() {
        return driver.findElement(By.linkText("Home"));
    }

    public WebElement getCreatedLink() {
        return driver.findElement(By.linkText("Created"));
    }

    public WebElement getLinkResponse() {
        return driver.findElement(By.id("linkResponse"));
    }

    public WebElement getNoContent() {
        return driver.findElement(By.id("no-content"));
    }

    public WebElement getMoved() {
        return driver.findElement(By.id("moved"));
    }

    public WebElement getBadRequest() {
        return driver.findElement(By.id("bad-request"));
    }

    public WebElement getUnauthorized() {
        return driver.findElement(By.id("unauthorized"));
    }

    public WebElement getForbidden() {
        return driver.findElement(By.id("forbidden"));
    }

    public WebElement getNotFound() {
        return driver.findElement(By.id("invalid-url"));
    }

    //____________________________________________________________

    public String LinkResponseText(){
        String temp;
        temp = getLinkResponse().getText();
        return temp;
    }

    public void clickOnHomeLink(){
        getHomeLink().click();
    }
    public  void clickOnCreated(){
        getCreatedLink().click();
    }
    public void clickOnNoContent(){
        getNoContent().click();
    }
    public void clickOnMoved(){
        getMoved().click();
    }
    public void clickOnBadRequest(){
        getBadRequest().click();
    }
    public void cliclOnUnauthorized(){
        getUnauthorized().click();
    }
    public void clickOnForbidden(){
        getForbidden().click();
    }
    public void clickOnNotFound(){
        getNotFound().click();
    }
}
