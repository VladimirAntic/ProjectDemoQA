package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage {
    WebDriver driver;

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    WebElement folders, homeFolder, desktopFolder, documentsFolder,
            downloadsFolder, collapseButton, expandButton;

    public List<WebElement> getFolders() {
        return driver.findElements(By.className("rct-title"));
    }

    public WebElement getHomeFolder() {
        WebElement home = null;
        for (int i = 0; i < getFolders().size(); i++) {
            if (getFolders().get(i).getText().equals("Home")) {
                home = getFolders().get(i);}
        }
        return home;
    }

    public WebElement getDesktopFolder() {
        WebElement home = null;
        for (int i = 0; i < getFolders().size(); i++) {
            if (getFolders().get(i).getText().equals("Desktop")) {
                home = getFolders().get(i);}
        }
        return home;
    }

    public WebElement getDocumentsFolder() {
        WebElement home = null;
        for (int i = 0; i < getFolders().size(); i++) {
            if (getFolders().get(i).getText().equals("Documents")) {
                home = getFolders().get(i);}
        }
        return home;
    }

    public WebElement getDownloadsFolder() {
        WebElement home = null;
        for (int i = 0; i < getFolders().size(); i++) {
            if (getFolders().get(i).getText().equals("Downloads")) {
                home = getFolders().get(i);}
        }
        return home;
    }

    public WebElement getCollapseButton() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-collapse-all"));
    }

    public WebElement getExpandButton() {
        return driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-all"));
    }
    public void clickOnHomeFolder(){
        getHomeFolder().click();
    }
    public void clickOnExpandButtono(){
        getExpandButton().click();
    }
    public void clickOnDesktopFolder(){
        getDesktopFolder().click();
    }
    public void clickOnColapseButton(){
        getCollapseButton().click();
    }
    public void clickOnDocumentFolde(){
        getDocumentsFolder().click();
    }
    public void clickOnDownloadsFolder(){
        getDownloadsFolder().click();
    }
}


