import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlexOsipovTest {

    WebDriver driver;

    @BeforeTest
    public void enterDriver() {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void timeOuts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterTest
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

        WebElement formAuthentication = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[21]/a"));
        formAuthentication.click();

        WebElement loginTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/h2"));
        Assert.assertEquals(loginTitle.getText(), "Login Page");
    }

}
//*[@id="username"]