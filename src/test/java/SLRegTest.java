import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SLRegTest {

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
//            char randomChar = (char) ('А' + random.nextInt(32)); // 'А' to 'я'
//            data.append(Character.toUpperCase(randomChar));

            for (int i = 1; i < length; i++) {
                char randomChar = (char) ('а' + random.nextInt(32)); // 'а' to 'я'
                data.append(randomChar);
            }
            return data.toString();
        }

        public static String getRandomEmail(int length) {
            Random random = new Random();
            int randomNumber = random.nextInt(1000000); // Генерируем случайное число от 0 до 9999
            return "Test" + randomNumber + "@test.com";

//            StringBuilder email = new StringBuilder();
//            String emailSymbol = "abcdefghijklmnopqrstuvwxyz";
//
//            for (int i = 0; i < length; i++) {
//                char symbol = emailSymbol.charAt(random.nextInt(emailSymbol.length()));
//                email.append(symbol);
//            }
//            return email.toString() + "@example.com"; // добавляем домен для полноты
        }

        public static String getRandomIdenty(int length) {
            String identyNumberDigits = "123456789";
            StringBuilder generatedIdenty = new StringBuilder();

            for (int i = 1; i < length; i++) {
                char digit = identyNumberDigits.charAt(random.nextInt(identyNumberDigits.length()));
                generatedIdenty.append(digit);
            }
            return generatedIdenty.toString();
        }
    }

    @BeforeTest
    public static String testPhone() {
        RandomDataGenerator newPhone = new RandomDataGenerator();
        return newPhone.getRandomMobilePhone(8);
    }

    @BeforeTest
    public static String testEmail() {
        RandomDataGenerator newEmail = new RandomDataGenerator();
        return newEmail.getRandomEmail(10);
    }

    @BeforeTest
    public static String testSurname() {
        RandomDataGenerator newSurname = new RandomDataGenerator();
        return "Тест" + newSurname.getRandomData(5);
    }

    @BeforeTest
    public static String testName() {
        RandomDataGenerator newName = new RandomDataGenerator();
        return "Тест" + newName.getRandomData(5);
    }

    @BeforeTest
    public static String testIdenty() {
        RandomDataGenerator newIdenty = new RandomDataGenerator();
        return newIdenty.getRandomIdenty(10);
    }

    @Test
    public void testSl() {

        WebDriver driver = new ChromeDriver();
        // Максимизируем окно браузера перед вводом URL
        driver.manage().window().maximize();

        driver.get("https://kz-solva-release-300.kz.idfaws.com/registration/step1");
//        driver.get("http://solva-bank-release.kz.idfaws.com/registration/step1");
        //        driver.get("https://solva.kz/registration/step1");
//        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Устанавливаем неявное ожидание один раз
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement phoneNumber = driver.findElement(By.name("phoneNumber"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.xpath("//main/div/div/form/button/div"));
//        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
//        WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/main/div/div/form/button/div"));
//        WebElement submitButton = driver.findElement(By.xpath("//button[text()='ДАЛЕЕ']"));
//        WebElement fieldName = driver.findElement(By.id("firstName"));
        phoneNumber.sendKeys(testPhone());
        email.sendKeys(testEmail());
        submitButton.click();

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement message = driver.findElement(By.xpath("//body/div/div/form/h2"));
//        Assert.assertEquals(message.getText(), "ВВЕДИТЕ КОД ИЗ SMS");

        WebElement textSMS = driver.findElement(By.xpath("//body/div/div/form/div/div/input"));
        textSMS.sendKeys("1111");

        WebElement firstChecbox = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[4]/div[1]/div/div/button"));
        WebElement secondChecbox = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[4]/div[2]/div/div/button"));
        firstChecbox.click();
        secondChecbox.click();

        WebElement buttonNext = driver.findElement(By.xpath("/html/body/div[4]/div/form/button/div"));
        buttonNext.click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/main/div/div[2]/form/div[1]/h1")));

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement messagePassport = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/form/div[1]/h1"));
        Assert.assertEquals(messagePassport.getText(), "Паспортные данные");

        WebElement fieldSurname = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/form/div[1]/div[1]/div[1]/div/input"));
        fieldSurname.sendKeys(testSurname());

        WebElement fieldName = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/form/div[1]/div[1]/div[2]/div/input"));
        fieldName.sendKeys(testName());

        WebElement fieldBirthday = driver.findElement(By.name("birthday"));
        fieldBirthday.sendKeys("11.11.1995");

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.body.click();");

//        Actions actions = new Actions(driver);
//        actions.moveByOffset(500, 300).click().perform();

        WebElement checkboxIdenty = driver.findElement(By.id("user-information-passportType_IDENTITY_CARD"));
        checkboxIdenty.click();

//        actions.moveByOffset(500, 300).click().perform();

        WebElement fieldIIN = driver.findElement(By.name("iin"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fieldIIN).click().perform();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", fieldIIN);

//        fieldIIN.click();
        fieldIIN.sendKeys("1111");

//        actions.moveByOffset(500, 300).click().perform();

        WebElement fieldIdenty = driver.findElement(By.name("passportNumber"));

        actions.moveToElement(fieldIdenty).click().perform();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.name("passportNumber"))).click();
//        fieldIdenty.click();
        fieldIdenty.sendKeys(testIdenty());

//        actions.moveByOffset(500, 300).click().perform();

//        js.executeScript("document.body.click();");

//        Actions actions = new Actions(driver);
//        actions.moveByOffset(0, 0).click().perform();

        WebElement checkboxMVD = driver.findElement(By.id("passportAuthority_MVD"));

        actions.moveToElement(checkboxMVD).click().perform();
//        js.executeScript("arguments[0].scrollIntoView(true);", checkboxMVD);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("passportAuthority_MVD"))).click();
//        checkboxMVD.click();

//        actions.moveByOffset(500, 300).click().perform();

        WebElement fieldPassportDate = driver.findElement(By.name("passportDate"));
        actions.moveToElement(fieldPassportDate).click().perform();
//        js.executeScript("arguments[0].scrollIntoView(true);", fieldPassportDate);
        fieldPassportDate.sendKeys("11.11.2020");

//        actions.moveByOffset(500, 300).click().perform();

        WebElement fieldPassportExpirationDate = driver.findElement(By.name("passportExpirationDate"));
        actions.moveToElement(fieldPassportExpirationDate).click().perform();
//        js.executeScript("arguments[0].scrollIntoView(true);", fieldPassportExpirationDate);
//        fieldPassportExpirationDate.click();
        fieldPassportExpirationDate.sendKeys("11.11.2030");

//        fieldPassportExpirationDate.sendKeys(Keys.RETURN);

//        actions.moveByOffset(500, 300).click().perform();



        WebElement buttonNext21 = driver.findElement(By.xpath("//div[@class=\"Button-module_content__PpYVU\"]"));

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", buttonNext21);


        actions.moveToElement(buttonNext21).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buttonNext21)).click();

        actions.moveToElement(buttonNext21).click().perform();

    }


//        driver.quit();
}

