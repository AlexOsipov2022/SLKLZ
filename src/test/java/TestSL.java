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
    public void testSl() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://kz-solva-release-300.kz.idfaws.com/registration/step1");
//        driver.get("https://solva.kz/registration/step1");

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

        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//body/div/div/form/h2"));
        Assert.assertEquals(message.getText(), "ВВЕДИТЕ КОД ИЗ SMS");

        WebElement textSMS = driver.findElement(By.xpath("//body/div/div/form/div/div/input"));
        textSMS.sendKeys("1111");

        WebElement firstChecbox = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[4]/div[1]/div/div/button"));
        WebElement secondChecbox = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[4]/div[2]/div/div/button"));
        firstChecbox.click();
        secondChecbox.click();

        WebElement buttonNext = driver.findElement(By.xpath("/html/body/div[4]/div/form/button/div"));
        buttonNext.click();

        Thread.sleep(2000);
        WebElement messagePassport = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/form/div[1]/h1"));
        Assert.assertEquals(messagePassport.getText(), "Паспортные данные");

    }


//        driver.quit();
}

