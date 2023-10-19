import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    @Test // Tag untuk running script dibawah
    public void open_browser() {
        WebDriver driver;
        String base_url = "https://kasirdemo.belajarqa.com";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(base_url);

        String title = driver.getTitle();
        System.out.println(title);

        driver.close();
    }

    @Test
    public void get_title()
    {
        WebDriver driver;
        String base_url = "https://kasirdemo.belajarqa.com";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().window().maximize();
        driver.get(base_url);

        String title = driver.getTitle();
        System.out.println(title);

        String username_button = "username";

        WebElement element1 = driver.findElement(By.id(username_button));
        WebElement element2 = driver.findElement(By.className("button"));

        // get form
        element1.click();
        element1.sendKeys("email.com");
        element1.getText();

        element2.isDisplayed();
        element2.click();

        driver.findElement(By.xpath("/*contains")).isDisplayed();
        driver.findElement(By.cssSelector("#button")).isDisplayed();

        driver.close();
    }

}
