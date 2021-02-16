import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DragAndDrop {
    @Test
    public void dragAndDrop(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        browser.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement element1 = browser.findElement(By.id("column-a"));
        WebElement element2 = browser.findElement(By.id("column-b"));
        Actions action = new Actions(browser);
        action.moveToElement(element2).clickAndHold().moveToElement(element1).release(element2).build().perform();
        String text = browser.findElement(By.id("column-a")).getText();
        assertEquals(text,"A");

        }
    }

