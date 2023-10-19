package kasirAja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {

    @Test
    public void successLoginCase()
    {
        WebDriver driver;
        String base_url = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver setup
        // membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get(base_url);

        // Assert nama toko di dashboard page
        String login_page_assert = driver.findElement(By.xpath("//h2[contains(text(), 'hai, kasirAja')]")).getText();
        Assert.assertEquals(login_page_assert, "hai, kasirAja");

        //input email
        driver.findElement(By.id("email")).sendKeys("sel@admin.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("test321");
        // click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // quit
//        driver.close();
    }

    @Test
    public void failedLoginCase()
    {
        WebDriver driver;
        String base_url = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver setup
        // membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(base_url);

        // Assert nama toko di dashboard page
        String login_page_assert = driver.findElement(By.xpath("//h2[contains(text(), 'hai, kasirAja')]")).getText();
        Assert.assertEquals(login_page_assert, "hai, kasirAja");

        //input email
        driver.findElement(By.id("email")).sendKeys("sel@admin.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("12345");
        // click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String error_login = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(error_login, "Kredensial yang Anda berikan salah");
//        // quit
        driver.close();
    }
}
