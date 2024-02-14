import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/login");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mohamed.g.ezzldin97@outlook.com");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ezz@123");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Login')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        wait.until(ExpectedConditions.urlContains("profile"));

        String expectedUrl = "https://automationexercise.com/profile";
        boolean loginSuccessful = driver.getCurrentUrl().contains(expectedUrl);

        System.out.println("Login Successful: " + loginSuccessful);

        driver.quit();
    }
}
