
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://www.saucedemo.com");

            System.out.println("Page Title: " + driver.getTitle());

            driver.findElement(By.id("user-name"))
                  .sendKeys("standard_user");

            driver.findElement(By.name("password"))
                  .sendKeys("secret_sauce");

            driver.findElement(
                By.xpath("//input[@id='login-button']")
            ).click();

            if (driver.getCurrentUrl().contains("inventory")) {
                System.out.println("Login Test PASSED");
            } else {
                System.out.println("Login Test FAILED");
            }

        } finally {
            driver.quit();
        }
    }
}
