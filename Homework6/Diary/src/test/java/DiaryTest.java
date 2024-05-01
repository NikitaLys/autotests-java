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
    By headingInputLocator = By.cssSelector(".popup__baseInput input[placeholder='Введите заголовок']");
    By textLocator = By.cssSelector(".popup__textarea textarea.baseTextarea__text");
    By addNoteBtnLocator = By.cssSelector("button.baseButton.popup__baseButton");
    By addedHeadingLocator = By.cssSelector(".articlePreview:nth-of-type(1) .articlePreview__title");
    By addedTextLocator = By.cssSelector(".articlePreview:nth-of-type(1) .articlePreview__text");

    @Test
    @DisplayName("Test adding note in popup")
    public void testAddNote() {
        String heading = "My first note";
        String text = "Write autotest for diary";
        driver.findElement(newNoteBtnLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(popupLocator));
        driver.findElement(headingInputLocator).sendKeys(heading);
        driver.findElement(textLocator).sendKeys(text);
        driver.findElement(addNoteBtnLocator).click();
        Assert.assertTrue("Popup is displayed", wait.until(ExpectedConditions.invisibilityOfElementLocated(popupLocator)));
        Assert.assertEquals("Wrong added heading", heading, driver.findElement(addedHeadingLocator).getText());
        Assert.assertEquals("Wrong added text", text, driver.findElement(addedTextLocator).getText());
    }

}
