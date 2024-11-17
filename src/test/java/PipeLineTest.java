//package school.redrover;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import school.redrover.runner.BaseTest;
//import school.redrover.runner.TestUtils;
//
//public class CreateDeletePipelineTest extends BaseTest {
//
//    //    private static final String PROJECT_NAME = "TestPipeline";
//    private static final String PROJECT_NAME = java.util.UUID.randomUUID().toString();
//
//    @Test
//    public void testCreatePipeline() {
//
//        WebElement newItemButton = getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']"));
//
//        newItemButton.click();
//
//        WebElement fieldItemName = getDriver().findElement(By.className("jenkins-input"));
//
//        fieldItemName.click();
//
//        fieldItemName.sendKeys(PROJECT_NAME);
//
//        WebElement buttunPipeline = getDriver().findElement(By.xpath("//span[@class='label' and text()='Pipeline']"));
//
//        buttunPipeline.click();
//
//        WebElement buttonOk = getDriver().findElement(By.id("ok-button"));
//
//        buttonOk.click();
//
//        WebElement dashboardButton = getDriver()
//                .findElement(By.xpath("//*[@class='model-link' and text()='Dashboard']"));
//
//        dashboardButton.click();
//
//        WebElement projectName = getDriver().findElement(By.xpath("//a[@href='job/%s/']".formatted(PROJECT_NAME)));
//
//        Assert.assertEquals(projectName.getText(), PROJECT_NAME);
//
//        new Actions(getDriver()).moveToElement(projectName).perform();
//
//        WebElement chevronButton = getWait5().until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//button[@data-href='http://localhost:8080/job/%s/']".formatted(PROJECT_NAME))));
//
//        TestUtils.moveAndClickWithJavaScript(getDriver(), chevronButton);
//
//        WebElement deletePipeline = getDriver().findElement(By.xpath("//*[@href=\"/job/%s/doDelete\"]".formatted(PROJECT_NAME)));
//
//        deletePipeline.click();
//
//        WebElement popupButtonOk = getDriver().findElement(By.xpath("//button[@data-id='ok']"));
//
//        popupButtonOk.click();
//
//    }
//}
