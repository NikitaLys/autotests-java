import jdk.jfr.Name;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloVasjaTest {
    public ChromeDriver goToWeb() {
        System.setProperty("webdriver.chrome.driver", "chrome\\chromedriver.exe");
        return new ChromeDriver();
    }


    @Test
    @Name("Test with name")
    public void testHello() {
        WebDriver driver = goToWeb();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.className("custom-form__field")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Вася!";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    @Name("Test without name")
    public void testEmptyHello() {
        WebDriver driver = goToWeb();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");

        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
