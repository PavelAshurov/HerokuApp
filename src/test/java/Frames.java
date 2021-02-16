import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Frames {

    @Test
    public void frames(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/frames");
        browser.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a")).click();
        browser.switchTo().frame("mce_0_ifr");
        String textOfFrame = browser.findElement(By.id("tinymce")).getText();
        Assert.assertEquals(textOfFrame,"Your content goes here.");
        browser.quit();
    }
}
