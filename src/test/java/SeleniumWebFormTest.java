import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumWebFormTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

//    @AfterMethod
//    protected void quitDriver() {
//        driver.quit();
//    }

    @Test
    public void testDropdownSelect() {
       final WebElement dropdownSelect = driver.findElement(By.className("form-select"));
       Select simpleDropdownSelect = new Select(dropdownSelect);
        simpleDropdownSelect.selectByValue("3");

        String newValue = dropdownSelect.getAttribute("value");

        Assert.assertEquals(newValue, "3");
    }
    @Test
    public  void testDefaultcheckbox() {
        final WebElement checkboxDefault = driver.findElement(By.id("my-check-2"));

        // Кликаем на чекбокс, если он еще не выбран
        if (!checkboxDefault.isSelected()) {
            checkboxDefault.click();
        }
        Assert.assertEquals(checkboxDefault.isSelected(), checkboxDefault.isSelected());
    }

    @Test
    public  void testCheckedcheckbox() {
        final WebElement checkboxChecked = driver.findElement(By.id("my-check-1"));

        if (checkboxChecked.isSelected()) {
            checkboxChecked.click();
        }
        Assert.assertEquals(!checkboxChecked.isSelected(), !checkboxChecked.isSelected());
    }


}
