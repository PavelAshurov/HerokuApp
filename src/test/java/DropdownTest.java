import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DropdownTest {
    @Test
    public void dropdownTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/dropdown");
        WebElement option = browser.findElement(By.id("dropdown"));
        option.click();
        Select optionSelect = new Select(option);
        optionSelect.selectByValue("1");
        WebElement firstPointActive = optionSelect.getFirstSelectedOption();
        String fistOptionText = firstPointActive.getText();
        assertEquals(fistOptionText,"Option 1");
        optionSelect.selectByValue("2");
        WebElement secondPointActive = optionSelect.getFirstSelectedOption();
        String secondOptionText = secondPointActive.getText();
        assertEquals(secondOptionText,"Option 2");
        browser.quit();
    }
}
