
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class TyposTest {
    @Test
    public void typosText(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/typos");
        String headline = browser.findElement(By.tagName("h3")).getText();
        assertEquals(headline,"Typos");
        String typosTag1 = browser.findElements(By.tagName("p")).get(0).getText();
        assertEquals(typosTag1,"This example demonstrates a typo being introduced. It does it randomly on each page load.");
        String typosTag2 = browser.findElements(By.tagName("p")).get(1).getText();
        assertEquals(typosTag2,"Sometimes you'll see a typo, other times you won't.");


    }
}
