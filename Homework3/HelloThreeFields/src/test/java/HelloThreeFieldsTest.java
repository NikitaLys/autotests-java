import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloThreeFieldsTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("")
    public void allFieldsAreFilled() {
        driver.findElement(By.name("name")).sendKeys("Nikita");
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        driver.findElement(By.name("phone")).sendKeys("1234567");
        driver.findElement(By.className("button")).click();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Здравствуйте, Nikita.\nНа вашу почту " +
                "(mail@mail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 1234567.";
        Assert.assertEquals("All fields are filled", expectedResult,actualResult);
    }

    @Test
    @DisplayName("")
    public void oneFieldIsFilled() {
        driver.findElement(By.name("phone")).sendKeys("1234567");
        driver.findElement(By.className("button")).click();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult = "Здравствуйте, .\nНа вашу почту " +
                "() отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 1234567.";
        Assert.assertEquals("One field is filled", expectedResult,actualResult);
    }

    @Test
    @DisplayName("")
    public void zeroFieldIsFilled() {
        driver.findElement(By.className("button")).click();
        String actualResult = driver.findElement(By.className("start-screen__res")).getText();
        String expectedResult ="Здравствуйте, .\nНа вашу почту " +
                "() отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals("Zero field is filled", expectedResult,actualResult);
    }


}

