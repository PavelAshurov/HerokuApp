import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControls {

    @Test
    public void dynamicControls() {


        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser,10);
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox =browser.findElement(By.cssSelector("[type=checkbox]"));
        checkbox.click();
        checkbox.isSelected();
        Assert.assertTrue(checkbox.isSelected());
        WebElement removeButton = browser.findElement(By.cssSelector("[onclick='swapCheckbox()']"));
        removeButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        String text = browser.findElement(By.id("message")).getText();
        Assert.assertEquals(text,"It's gone!");
        WebElement input = browser.findElement(By.cssSelector("input[type=text]"));
        Assert.assertFalse(input.isEnabled());
        browser.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(input.isEnabled());




    }
}
