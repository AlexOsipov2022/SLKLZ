import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlexOsipovOldTest {

    private WebDriver driver;

    @BeforeMethod
    public void enterCondition() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testMainPage() {
        driver.get("https://the-internet.herokuapp.com/");

        WebElement titleMessage = driver.findElement(By.className("heading"));
        Assert.assertEquals(titleMessage.getText(), "Welcome to the-internet");
    }

    @Test
    public void formAuthentication() {
        driver.get("https://the-internet.herokuapp.com/");

        WebElement formAuthentication = driver.findElement(By.xpath("//a[@href='/login']"));
//        WebElement formAuthentication = driver.findElement(By.xpath("//a[text()='Form Authentication']"));
        formAuthentication.click();

        WebElement loginTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        Assert.assertEquals(loginTitle.getText(), "Login Page");
    }

    @Test
    public void corectPassword() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement userName = driver.findElement(By.id("username"));
        WebElement userPassword = driver.findElement(By.id("password"));
        WebElement buttonLogin = driver.findElement(By.cssSelector("button[type='submit']"));

        userName.sendKeys("tomsmith");
        userPassword.sendKeys("SuperSecretPassword!");
        buttonLogin.click();

        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
