import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class JenkinsPipeLineTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        driver.findElement(By.id("j_username")).sendKeys("admin");
        driver.findElement(By.id("j_password")).sendKeys("admin");
        driver.findElement(By.name("Submit")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
    }
    private void createItemUtils(String name, String locator) {

        driver.findElement(By.xpath("//a[@href='/view/all/newJob']")).click();
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.cssSelector(locator)).click();
        driver.findElement(By.id("ok-button")).click();

    }
    private List<String> getProjectList() {
        List<WebElement> jobList = driver.findElements(By.xpath("//td/a[contains(@href,'job')]"));

        return jobList
                .stream()
                .map(WebElement::getText)//как рабоатет =>> .map(element -> element.getText())
                .toList();
    }

    private void returnToHomePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("jenkins-home-link")))
                .click();
    }

    @Test
    public void testSearchPipelineOnMainPage() {

        final String namePipeLine = "Regression";

        createItemUtils(namePipeLine, ".org_jenkinsci_plugins_workflow_job_WorkflowJob");

        returnToHomePage();

        Assert.assertListContainsObject(getProjectList(),
                namePipeLine, "Пайплайн не найден на главной странице или текст не совпадает");

        System.out.println("Пайплайн создан и находится в списке на главной странице");
    }

    @Test
    public void testSearchFreestyleProjectOnMainPage() {

        final  String nameFreestyleProject = "Freestyle";

        createItemUtils(nameFreestyleProject,".hudson_model_FreeStyleProject");

        returnToHomePage();

        Assert.assertListContainsObject(getProjectList(),
                nameFreestyleProject, "Freestyle Project не найден на главной странице или текст не совпадает");

        System.out.println("Freestyle Project создан и находится в списке на главной странице");
    }
}

