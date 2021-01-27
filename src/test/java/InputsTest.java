import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class InputsTest {
    @Test
    public void positiveinputsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/inputs");
        WebElement imput = browser.findElement(By.tagName("input"));
        imput.sendKeys(Keys.ARROW_DOWN);
        String negativeNum = imput.getAttribute("value");
        assertEquals(negativeNum, "-1");
        imput.sendKeys(Keys.ARROW_DOWN);
        imput.sendKeys(Keys.ARROW_DOWN);
        imput.sendKeys(Keys.ARROW_DOWN);
        negativeNum = imput.getAttribute("value");
        assertEquals(negativeNum, "-4");
        browser.get("http://the-internet.herokuapp.com/inputs");
        imput = browser.findElement(By.tagName("input"));
        imput.sendKeys(Keys.ARROW_UP);
        String positiveNum = imput.getAttribute("value");
        assertEquals(positiveNum, "1");
        imput.sendKeys(Keys.ARROW_UP);
        imput.sendKeys(Keys.ARROW_UP);
        imput.sendKeys(Keys.ARROW_UP);
        imput.sendKeys(Keys.ARROW_UP);
        imput.sendKeys(Keys.ARROW_UP);
        positiveNum = imput.getAttribute("value");
        assertEquals(positiveNum, "6");
        browser.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = browser.findElement(By.tagName("input"));
        input.sendKeys("FFFFFFFFFF");
        String textInput = input.getAttribute("value");
        assertEquals(textInput,"");
        input.sendKeys("@#$%^%$^%");
        String specSymbolsInput = input.getAttribute("value");
        assertEquals(specSymbolsInput,"");
        input.sendKeys("        ");
        String spaceInput = input.getAttribute("value");
        assertEquals(textInput,"");
        browser.quit();
    }

}
