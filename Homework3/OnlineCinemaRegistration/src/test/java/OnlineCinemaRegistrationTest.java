import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineCinemaRegistrationTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("valid registration")
    public void validRegistration() {
        driver.findElement(By.className("form-input")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.id("confirm_password")).sendKeys("qwerty!123");
        driver.findElement(By.tagName("button")).click();
        String actualResult = driver.findElement(By.className("form-result")).getText();
        String expectedResult = "Вам на почту skillbox@test.ru выслано письмо с подтверждением";
        Assert.assertEquals("validRegistration", expectedResult, actualResult);
    }

}
