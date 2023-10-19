package kasirAja;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    // login dengan DDT

    @Test
    public void loginDDT()
    {
        WebDriver driver;
        String base_url = "https://kasirdemo.belajarqa.com";

        WebDriverManager.chromedriver().setup();

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        opt.setHeadless(false);

        String csv_dir = System.getProperty("user.dir") + "/src/test/java/data/test-data.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csv_dir))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String email = nextLine[0];
                String password = nextLine[1];
                String status = nextLine[2];

                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(base_url);

                // pengisian form
                driver.findElement(By.id("email")).sendKeys(email);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//button[@type='submit']")).click();

                // assertion
                if (status.equals("success")) {
                    driver.findElement(By.xpath("//div[contains(text(), 'dashboard')]"));
                    String username = driver.findElement(By.xpath("//dd(contains(text(), 'hai')]/preceding-sibling::dt")).getText();
                    Assert.assertEquals(username, "tdd-selenium");
                } else {
                    String error_login = driver.findElement(By.xpath("//div[@role='alert']")).getText();
                    Assert.assertEquals(error_login, "Kredensial yang Anda berikan salah");
                }

                driver.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
