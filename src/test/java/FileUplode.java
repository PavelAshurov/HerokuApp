import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUplode {

    @Test
    public void fileUplode(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/upload");
        browser.findElement(By.id("file-upload")).sendKeys("src/test/resources/TestText.txt");
        browser.findElement(By.id("file-submit")).click();
        String filename = browser.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(filename,"TestText.txt");
    }
}
