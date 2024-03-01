import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoeShopTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chromedriver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Positive shoe size test")
    public void PositiveShoeSizeTest() {
        driver.findElement(By.id("size")).sendKeys("44");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.className("error")).getText();
        String expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals("Positive shoe size test", expectedResult, actualResult);
    }
    @Test
    @DisplayName("Negative shoe size test")
    public void NegativeShoeSizeTest() {
        driver.findElement(By.id("size")).sendKeys("45");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        String expectedResult = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals("Negative shoe size test", expectedResult, actualResult);
    }
}
