import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PuppyNameTest {
    WebDriver driver;

    private By choiceGirl = By.id("girl");
    private By emailInput = By.name("email");
    private By sendButton = By.id("sendMe");
    private By resultEmail = By.className("your-email");
    private By resultText = By.className("result-text");

    String email = "x@x.xx";

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chromedriver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/practice/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Boy and email test")
    public void boyWithEmailTest() {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(sendButton).click();
        String expectedTextBoy = "Хорошо, мы пришлём имя для вашего мальчика на e-mail:";
        Assert.assertEquals("Wrong result email", email, driver.findElement(resultEmail).getText());
        Assert.assertEquals("Wrong result text", expectedTextBoy, driver.findElement(resultText).getText());
    }


    @Test
    @DisplayName("Girl and email test")
    public void girlWithEmailTest() {
        driver.findElement(choiceGirl).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(sendButton).click();
        String expectedTextGirl = "Хорошо, мы пришлём имя для вашей девочки на e-mail:";
        Assert.assertEquals("Wrong result email", email, driver.findElement(resultEmail).getText());
        Assert.assertEquals("Wrong result text", expectedTextGirl, driver.findElement(resultText).getText());
    }

}
