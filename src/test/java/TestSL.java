import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class TestSL {

    static class RandomDataGenerator {

        private static final Random random = new Random();

        public static String getRandomMobilePhone(int length) {
            String phonePrefix = "+77";
            String phoneNumberDigits = "123456789";
            StringBuilder generatedPhone = new StringBuilder();

            for (int i = 1; i < length; i++) {
                char digit = phoneNumberDigits.charAt(random.nextInt(phoneNumberDigits.length()));
                generatedPhone.append(digit);
            }
            return phonePrefix + generatedPhone.toString();
        }

        public static String getRandomData(int length) {
            StringBuilder data = new StringBuilder();
            char randomChar = (char) ('А' + random.nextInt(32)); // 'А' to 'я'
            data.append(Character.toUpperCase(randomChar));

            for (int i = 1; i < length; i++) {
                randomChar = (char) ('а' + random.nextInt(32)); // 'а' to 'я'
                data.append(randomChar);
            }
            return data.toString();
        }

        public static String getRandomEmail(int length) {
            StringBuilder email = new StringBuilder();
            String emailSymbol = "abcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < length; i++) {
                char symbol = emailSymbol.charAt(random.nextInt(emailSymbol.length()));
                email.append(symbol);
            }
            return email.toString() + "@example.com"; // добавляем домен для полноты
        }
    }

    @BeforeTest
    public static String testPhone() {
        RandomDataGenerator phoneNew = new RandomDataGenerator();
        return phoneNew.getRandomMobilePhone(8);
    }

    @BeforeTest
    public static String testEmail() {
        RandomDataGenerator emailNew = new RandomDataGenerator();
        return emailNew.getRandomEmail(10);
    }

    @BeforeTest
    public static String testSurname() {
        RandomDataGenerator surnameNew = new RandomDataGenerator();
        return surnameNew.getRandomData(10);
    }

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


        phoneNumber.sendKeys(testPhone());
        email.sendKeys(testEmail());
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

        WebElement fieldSurname = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/form/div[1]/div[1]/div[1]/div/input"));
        fieldSurname.sendKeys(testSurname());

    }


//        driver.quit();
}

