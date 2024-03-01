import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTests {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("valid registration")
    public void validRegistration() {
        driver.findElement(By.id("name")).sendKeys("Who");
        driver.findElement(By.id("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.id("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        String actualResult = driver.findElement(By.className("form-result")).getText();
        String expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals("validRegistration", expectedResult, actualResult);
    }

    @Test
    @DisplayName("empty fields")
    public void emptyFields() {
        driver.findElement(By.className("form-submit")).click();
        String actualResult = driver.findElement(By.className("form-error")).getText();
        String expectedResult = "Введите имя";
        Assert.assertEquals("validRegistration", expectedResult, actualResult);
    }
}

