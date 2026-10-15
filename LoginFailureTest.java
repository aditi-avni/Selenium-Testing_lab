
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFailureTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://www.saucedemo.com");

            driver.findElement(By.id("user-name"))
                  .sendKeys("standard_user");

            driver.findElement(By.name("password"))
                  .sendKeys("wrong_password");

            driver.findElement(
                By.cssSelector("input#login-button")
            ).click();

            String errorMessage = driver.findElement(
                By.cssSelector("[data-test='error']")
            ).getText();

            System.out.println("Error Message: " + errorMessage);

            if (driver.getCurrentUrl().contains("inventory")) {
                System.out.println("Login Failure Test FAILED");
            } else {
                System.out.println("Login Failure Test PASSED");
            }

        } finally {
            driver.quit();
        }
    }
}
