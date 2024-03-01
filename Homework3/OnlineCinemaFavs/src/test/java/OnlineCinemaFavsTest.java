import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineCinemaFavsTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @DisplayName("Normal user flow with film and serial")
    @Test
    public void positiveTest() {
        String favFilm = "James Bond";
        String favSerial = "Vikings";
        driver.findElement(By.id("films")).sendKeys(favFilm);
        driver.findElement(By.id("serials")).sendKeys(favSerial);
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var actualResultFilm = driver.findElement(By.id("best_films")).getText();
        var actualResultSerials = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("Favorite film", favFilm, actualResultFilm);
        Assert.assertEquals("Favorite serial", favSerial, actualResultSerials);
    }

    @DisplayName(" ")
    @Test
    public void noNameTest() {
        String favFilm = "James Bond";
        String favSerial = "Vikings";
        driver.findElement(By.id("films")).sendKeys(favFilm);
        driver.findElement(By.id("serials")).sendKeys(favSerial);
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var actualResultFilm = driver.findElement(By.id("best_films")).getText();
        var actualResultSerials = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("Favorite film", favFilm, actualResultFilm);
        Assert.assertEquals("Favorite serial", favSerial, actualResultSerials);
    }
}
