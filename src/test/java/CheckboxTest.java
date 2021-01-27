import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class CheckboxTest {
    @Test
    public void checkboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        boolean firstCheckboxNotActive = browser.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        assertFalse(firstCheckboxNotActive);
        browser.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        boolean firstCheckboxActive = browser.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        assertTrue(firstCheckboxActive);
        boolean secondCheckBoxActive = browser.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        assertTrue(secondCheckBoxActive);
        browser.findElements(By.cssSelector("[type=checkbox]")).get(1).click();
        boolean secondCheckBoxNotActive = browser.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        assertFalse(secondCheckBoxNotActive);
        browser.quit();
    }

}
