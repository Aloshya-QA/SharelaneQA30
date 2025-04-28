import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest {

    @Test
    public void checkSignUpValidData() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();

        Assert.assertTrue(isDisplayed);

        driver.findElement(By.name("first_name")).sendKeys("Maksim");
        driver.findElement(By.name("last_name")).sendKeys("Petrov");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("123qwe");
        driver.findElement(By.name("password2")).sendKeys("123qwe");

        driver.findElement(By.cssSelector("[value=Register]")).click();

        String completeMsg = driver.findElement(By.className("confirmation_message")).getText();

        Assert.assertEquals(completeMsg, "Account is created!");

        driver.quit();
    }
}
