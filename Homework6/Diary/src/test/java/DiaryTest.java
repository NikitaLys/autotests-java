import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DiaryTest {

    private WebDriver driver;
    private WebDriverWait wait;

    String url = "http://qa.skillbox.ru/module15/bignotes/#/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chromedriver", "chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
//        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //Locators for "Adding note in popup"
    By newNoteBtnLocator = By.cssSelector("button.pageCreate__sidebarHeaderAdd");
    By popupLocator = By.cssSelector("div .popup");
    By headingInputLocator = By.cssSelector(".popup__baseInput input[placeholder='Введите заголовок']");
    By textLocator = By.cssSelector(".popup__textarea textarea.baseTextarea__text");
    By addNoteBtnLocator = By.cssSelector("button.baseButton.popup__baseButton");
    By addedHeadingLocator = By.cssSelector(".articlePreview:nth-of-type(1) .articlePreview__title");
    By addedTextLocator = By.cssSelector(".articlePreview:nth-of-type(1) .articlePreview__text");

    //Locators for "Delete note"
    By sidebarOpenArticleBtn = By.cssSelector(".articlePreview__link");
    By sidebarFirstArticleTitle = By.cssSelector(".pageArticle__articlePreview:nth-of-type(1) .articlePreview__title");
    By sidebarFirstArticleText = By.cssSelector(".pageArticle__articlePreview:nth-of-type(1) .articlePreview__text");
    By openedArticleTitle = By.cssSelector(".baseInput.pageArticle__baseInput .baseInput__field");
    By openedArticleText = By.cssSelector(".baseTextarea__inner .baseTextarea__text");
    By openedArticleDeleteBtn = By.cssSelector(".pageArticle__buttons .pageArticle__button:nth-of-type(2)");

    @Test
    @DisplayName("Adding note in popup")
    public void testAddNote() {
        String heading = "My first note";
        String text = "Write autotest for diary";
        driver.findElement(newNoteBtnLocator).click();
        driver.findElement(headingInputLocator).sendKeys(heading);
        driver.findElement(textLocator).sendKeys(text);
        driver.findElement(addNoteBtnLocator).click();
        Assert.assertTrue("Popup is displayed", wait.until(ExpectedConditions.invisibilityOfElementLocated(popupLocator)));
        Assert.assertEquals("Wrong added heading", heading, driver.findElement(addedHeadingLocator).getText());
        Assert.assertEquals("Wrong added text", text, driver.findElement(addedTextLocator).getText());
    }

    @Test
    @DisplayName("Delete note")
    public void testDeleteNote() {
        driver.findElement(sidebarOpenArticleBtn).click();
        String articleTitle = driver.findElement(openedArticleTitle).getAttribute("value");
        Assert.assertEquals("Article title is NOT matched",
                articleTitle,
                driver.findElement(sidebarFirstArticleTitle).getText()
        );
        Assert.assertEquals("Article text is NOT matched",
                driver.findElement(openedArticleText).getAttribute("value"),
                driver.findElement(sidebarFirstArticleText).getText()
        );
        driver.findElement(openedArticleDeleteBtn).click();
        String sidebarArticle = driver.findElement(sidebarFirstArticleTitle).getText();
        Assert.assertFalse("Note is NOT deleted, article in sidebar is equals to deleted - " 
                + sidebarArticle, articleTitle.equals(sidebarArticle));
    }
}
