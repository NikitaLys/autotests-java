import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FindElementTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chromedriver",
                "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Find element test")
    public void findElementTest() {
        WebElement feedback = driver.findElement(By.linkText("Обратная связь"));
        WebElement preorders = driver.findElement(By.linkText("Предзаказы"));
        WebElement firstBook = driver.findElement(By.className("book-add"));
        WebElement cartCount = driver.findElement(By.id("cart_count"));
        WebElement menuElement = driver.findElement(By.id("genres"));
        WebElement search = driver.findElement(By.id("search-input"));
    }

    @Test
    @DisplayName("Find all books test")
    public void findAllBooksTest() {
        int actualBookCount = 0;
        List<WebElement> books = driver.findElements(By.className("book-info"));
        for (WebElement book : books) {
            actualBookCount++;
        }

        Assert.assertEquals("15 books on page", 15, actualBookCount);

    }


}
