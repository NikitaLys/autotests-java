import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallMasterTest {
    WebDriver driver;
    String url = "https://qajava.skillbox.ru/module04/lesson3/index.html";

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

    // Inputs
    private By nameFieldLocator = By.cssSelector(".form-input.fio");
    private By streetFieldLocator = By.cssSelector(".data.form-input.street");
    private By houseNumLocator = By.cssSelector(".form-input.house");
    private By flatNumLocator = By.cssSelector(".form-input.flat");
    private By preferDayLocator = By.cssSelector(".form-input.flat");
    private By sendBtnLocator = By.cssSelector(".form-submit");

    //Result
    private By resultBlockLocator = By.cssSelector(".form-result-data");

//    Screenshot from console
//    https://share.zight.com/E0uJZ5zA

    @Test
    @DisplayName("")
    public void testResultIsDisplayed() {
        driver.findElement(nameFieldLocator).sendKeys("TEST");
        driver.findElement(streetFieldLocator).sendKeys("TEST 1");
        driver.findElement(houseNumLocator).sendKeys("2");
        driver.findElement(flatNumLocator).sendKeys("1");
        driver.findElement(preferDayLocator).sendKeys("TEST");
        driver.findElement(sendBtnLocator).click();
        Assert.assertTrue("Result block is NOT displayed", driver.findElement(resultBlockLocator).isDisplayed());
    }


}
