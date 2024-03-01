import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailInputTest {
    WebDriver driver;
    private By emailLocator = By.className("email");
    private By sendButton = By.id("write-to-me");
    private By resultText = By.className("result-text");

    private By resultEmail = By.className("result-email");


    @Before
    public void setUp() {
        System.setProperty("webdrive.drive.chromedriver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Input valid mail")
    public void testEmailInput() {
        var email = "x@x.xx";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(sendButton).click();
        Assert.assertTrue("Text isn't shown", driver.findElement(resultText).isDisplayed());
        Assert.assertEquals("Wrong result email", email, driver.findElement(resultEmail).getText());

    }

    @Test
    @DisplayName("Input empty mail")
    public void testEmptyEmailInput() {
        driver.findElement(sendButton).click();
        Assert.assertFalse("Text result is shown", driver.findElement(resultEmail).isDisplayed());
    }

}
