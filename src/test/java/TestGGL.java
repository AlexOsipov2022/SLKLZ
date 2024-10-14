import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestGGL {

    @Test
    public void testGGL() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://www.google.com");


        WebElement textArea = driver.findElement(By.className("gLFyf"));
        textArea.sendKeys("Selenium");

        Thread.sleep(1000); //Задержка между операциями

        WebElement submitButton = driver.findElement(By.className("gNO89b"));
        submitButton.click();

        WebElement message = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[2]/div/span"));
        Assert.assertEquals(message.getText(), "Selenium automates browsers. That's it! What you do with that power is entirely up to you. Primarily it is for automating web applications for testing purposes.");

        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void testZara() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://www.zara.com/by/ru/");


        WebElement textArea = driver.findElement(By.className("gLFyf"));
        textArea.sendKeys("Selenium");

        Thread.sleep(1000); //Задержка между операциями

        WebElement submitButton = driver.findElement(By.className("gNO89b"));
        submitButton.click();

        WebElement message = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[2]/div/span"));
        Assert.assertEquals(message.getText(), "Selenium automates browsers. That's it! What you do with that power is entirely up to you. Primarily it is for automating web applications for testing purposes.");

        Thread.sleep(1000);
        driver.quit();
    }


}
