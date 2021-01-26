import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest {
    @Test
    public void addAndRemoveOfTwoElemets() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = browser.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        browser.findElements(By.xpath("//button[text() = 'Delete']")).get(1).click();
        int buttonsAmount = browser.findElements(By.xpath("//button[text() = 'Delete']")).size();
        assertEquals(buttonsAmount,1,"Кнопок DELETE больше чем ожидалось");
        browser.quit();
    }
}
