import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiaryTest {
    private WebDriver driver;
    private WebDriverWait wait;

    String url = "http://qa.skillbox.ru/module15/bignotes/#/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chromedriver", "chromedriver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.navigate().to(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    By newNoteBtnLocator = By.cssSelector("button.pageCreate__sidebarHeaderAdd");
    By popupLocator = By.cssSelector("div .popup");
    By headingInputLocator = By.className("baseInput__field");
    By textLocator = By.className("baseTextarea__text");
    By addNoteBtnLocator = By.cssSelector("button.baseButton.popup__baseButton");

    @Test
    @DisplayName("")
    public void testAddNote() {
        String heading = "My first note";
        String text = "Write autotest for diary";
        driver.findElement(newNoteBtnLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(popupLocator));
        driver.findElement(headingInputLocator).sendKeys(heading);
        driver.findElement(textLocator).sendKeys(text);
        driver.findElement(addNoteBtnLocator).click();
        Assert.assertTrue("Popup is NOT displayed", wait.until(ExpectedConditions.invisibilityOfElementLocated(popupLocator)));
    }

}
