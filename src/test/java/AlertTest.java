import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {

     @Test
    public void alert1Test(){
         System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
         WebDriver browser = new ChromeDriver();
         browser.manage().window().maximize();
         browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
         browser.get("http://the-internet.herokuapp.com/javascript_alerts");
         browser.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
         Alert alert1 = browser.switchTo().alert();
         alert1.getText();
         Assert.assertEquals(alert1.getText(),"I am a JS Alert");
         alert1.dismiss();
         browser.quit();
     }

     @Test
    public void alert2Test(){
         System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
         WebDriver browser = new ChromeDriver();
         browser.manage().window().maximize();
         browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
         browser.get("http://the-internet.herokuapp.com/javascript_alerts");
         browser.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
         Alert alert2 = browser.switchTo().alert();
         alert2.accept();
        String result = browser.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You clicked: Ok");
     }

     @Test
    public void alert3Test(){
         System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
         WebDriver browser = new ChromeDriver();
         browser.manage().window().maximize();
         browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
         browser.get("http://the-internet.herokuapp.com/javascript_alerts");
         browser.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
         Alert alert3 = browser.switchTo().alert();
         alert3.sendKeys("TMS");
         alert3.accept();
         String result = browser.findElement(By.id("result")).getText();
         Assert.assertEquals(result,"You entered: TMS");
     }

}
