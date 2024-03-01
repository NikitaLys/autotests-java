import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunSocksTestOnlyCss {
    WebDriver driver;
    String url = "https://qajava.skillbox.ru/module04/homework/auth/changed.html";

    private By emailLocator = By.cssSelector(".form-input.input-data");
    private By passwordLocator = By.cssSelector(".form-input.password");
    private By sendBtnLocator = By.cssSelector(".form-submit");
    private By errorLocator = By.cssSelector(".form-error-password-email");

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chromedriver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Test for validation error")
    public void testErrorIsDisplayed() {
        driver.findElement(emailLocator).sendKeys("@");
        driver.findElement(passwordLocator).sendKeys("123");
        driver.findElement(sendBtnLocator).click();
        String expectedErrorText = "Некорректный email или пароль";
        WebElement errorText = driver.findElement(errorLocator);
        Assert.assertTrue("Validation error is NOT displayed", errorText.isDisplayed());
        Assert.assertEquals("Validation error is wrong", expectedErrorText, errorText.getText());
    }
}
