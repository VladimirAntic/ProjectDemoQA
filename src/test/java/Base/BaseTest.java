package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public PracticeFormPage practiceFormPage;

    public TextBoxPage textBoxPage;
    public CheckboxPage checkboxPage;
    public WebTables webTables;
    public RadioButtonPage radioButtonPage;
    public LinksPage linksPage;
    public WebDriverWait wait;
    public ExcelReader excelReader;





    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        excelReader = new ExcelReader("Data.xlsx");


        homePage = new HomePage(driver);
        sidebarPage = new SidebarPage(driver);
        practiceFormPage = new PracticeFormPage(driver);
        webTables = new WebTables(driver);
        textBoxPage = new TextBoxPage(driver);
        checkboxPage = new CheckboxPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
        linksPage = new LinksPage(driver);
    }
}