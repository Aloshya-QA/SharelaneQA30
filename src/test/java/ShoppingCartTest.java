import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ShoppingCartTest {
    @Test
    public void checkDiscount0() {
        ChromeOptions options = new ChromeOptions();    //флаг для запуска браузера бег графического интерфейса
        options.addArguments("--headless=new");         //фиксит попап о смене пароля (upd* - не помогает)
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345"));


        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6"));

        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/shopping_cart.py"));

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "0");
        softAssert.assertEquals(discount$, "0");
        softAssert.assertEquals(total$, "190");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345"));


        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6"));

        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/shopping_cart.py"));

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "2");
        softAssert.assertEquals(discount$, "4");
        softAssert.assertEquals(total$, "196");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345"));


        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6"));

        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/shopping_cart.py"));

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "3");
        softAssert.assertEquals(discount$, "15");
        softAssert.assertEquals(total$, "485");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount4() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&" +
                "first_name=test&last_name=test&email=test%40test.test&password1=12345&password2=12345"));


        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6"));

        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/shopping_cart.py"));

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "4");
        softAssert.assertEquals(discount$, "40");
        softAssert.assertEquals(total$, "960");

        driver.quit();
        softAssert.assertAll();
    }
}
