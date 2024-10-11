import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSL {

    @Test
    public void testSl() {

        WebDriver driver = new ChromeDriver();

//      driver.get("https://kz-solva-release-300.kz.idfaws.com/registration/step1");
        driver.get("https://solva.kz/registration/step1");

//      System.out.println("Title -->  " + driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement phoneNumber = driver.findElement(By.name("phoneNumber"));
        WebElement email = driver.findElement(By.name("email"));
//        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitButton = driver.findElement(By.xpath("//main/div/div/form/button/div"));
//        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/main/div/div/form/button/div"));
//        WebElement submitButton = driver.findElement(By.xpath("//button[text()='ДАЛЕЕ']"));


        phoneNumber.sendKeys("775555555");
        email.sendKeys("775555555@gmail.com");
        submitButton.click();

        WebElement message = driver.findElement(By.xpath("//body/div/div/form/h2"));
        Assert.assertEquals(message.getText(), "ВВЕДИТЕ КОД ИЗ SMS");

        @Test
                public void test_2() {

        }


//        driver.quit();
    }
}
