import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver driver;
    int number;

    @Test
    public void test_isValid() throws InterruptedException {
        WebElement element1 = driver.findElement(By.cssSelector("input[name='num']"));
        element1.clear();
        element1.sendKeys("1");

        WebElement element = driver.findElement(By.cssSelector("input[name='max']"));
        element.clear();
        element.sendKeys("100");

        WebElement element3 = driver.findElement(By.cssSelector("input[value='Get Numbers']"));
        element3.click();
        Thread.sleep(1500);

        WebElement element4 = driver.findElement(By.cssSelector("pre[class='data']"));
        String a = element4.getText();
        a = a.replaceAll("\\s", "");
        number = Integer.parseInt(a);
        boolean result = isValid(number);
        Assert.assertTrue(result, "Test Abracadabra");
    }

    @BeforeTest
    public void goIn() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vengrzha\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        Thread.sleep(2500);
        driver.get("https://www.random.org/integers/");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    public boolean isValid(int number) {
        return 0 < number & number < 101;
    }
}
