//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class DropDownTest {
//    public class Version2Test extends BaseTest {
//
//        private static final String Current_Jenkins_Version = "Jenkins 2.462.3";
//
//        @Test
//        public void CheckVersionTest() {
//
//            WebElement buttonJenkinsVersion = getDriver().findElement(By.xpath("//button[contains(@class, \"jenkins_ver\")]"));
//
//            buttonJenkinsVersion.click();
//
//            WebElement dropdownJenkinsVersion = getDriver().findElement(By.xpath("//a[@href='/manage/about']"));
//
//            Assert.assertEquals(true, buttonJenkinsVersion.isDisplayed());
//            Assert.assertEquals(buttonJenkinsVersion.getText(), Current_Jenkins_Version);
//            Assert.assertEquals(dropdownJenkinsVersion.getText(), "About Jenkins");
//        }
//    }
//}
////WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
////        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main-panel']/form/div[1]/div[1]/div[3]/div")));