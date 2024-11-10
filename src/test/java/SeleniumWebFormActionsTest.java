import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWebFormActionsTest {

    private Actions actions;

//    // проверяет есть ли акшионс, чтобы было только одно акшионс,
//    если нету, то возвращает актионс//

    private Actions getActions() {
        if (actions == null) {
            actions = new Actions(driver);
        }
        return actions;
    }

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    protected void quitDriver() {
//        driver.quit();
//    }

    @Test
    public void testSliderActions() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        final WebElement slider = driver.findElement(By.className("form-range"));

        getActions()
                .clickAndHold(slider)                    //Actions
                .moveByOffset(-200, 0)    //Actions сдвинули мышку по координатам от схваченной мышки
                .release()                               //Actions отпустить мышку
                .perform();                              //void - Actions не выполняются, пока не укажим Perform

        Assert.assertEquals("0", slider.getAttribute("value"));
    }

    @Test
    public void testSliderClick() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        final WebElement slider = driver.findElement(By.className("form-range"));

        final Dimension size = slider.getSize();
        int sliderWidth = size.getWidth();

        getActions()
                .moveToElement(slider)                                  //мышка передвинулась на середину элемента(всегда)
                .moveByOffset(sliderWidth * 2/10, 0)     //сдвинули мышку вправо на 2/10 ширины
                .click()
                .perform();

        Assert.assertEquals("7", slider.getAttribute("value"));
    }
}