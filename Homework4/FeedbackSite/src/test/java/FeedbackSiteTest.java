import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FeedbackSiteTest {
    WebDriver driver;
    String url = "https://qajava.skillbox.ru/module04/lesson3/os.html";
    // Inputs
    private By nameFieldLocator = By.cssSelector(".data.text");
    private By emailFieldLocator = By.cssSelector(".data.field");
    private By commentFieldLocator = By.cssSelector(".field.text");
    private By sendBtnLocator = By.id("comment");
    // Result
    private By resultTextHeadingLocator = By.className("message-header");
    private By resultTextLocator = By.className("message-description");

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
    @DisplayName("")
    public void testIsDisplayed() {
        driver.findElement(nameFieldLocator).sendKeys("Name");
        driver.findElement(emailFieldLocator).sendKeys("email@email.com");
        driver.findElement(commentFieldLocator).sendKeys("some comment");
        driver.findElement(sendBtnLocator).click();
        Assert.assertTrue("Result heading is NOT displayed", driver.findElement(resultTextHeadingLocator).isDisplayed());
        Assert.assertTrue("Result text is NOT displayed", driver.findElement(resultTextLocator).isDisplayed());
    }

}
