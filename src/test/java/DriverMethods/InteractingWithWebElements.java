package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InteractingWithWebElements {

    WebDriver driver;

    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.zooniverse.org");
    }

    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testZooniverse(){
        driver.findElement(By.cssSelector("button[value='sign-in']")).click();
        driver.findElement(By.cssSelector("input[name='login']")).sendKeys("malaMi");
//        driver.findElement(By.cssSelector("input[name='login']")).clear();
//        sleep(1000);
//        driver.findElement(By.cssSelector("input[name='login']")).sendKeys("Tadam!");
//        sleep(1000);
        driver.findElement(By.cssSelector("input[name='login']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("hasłotestowe");
        driver.findElement(By.cssSelector("button[type='submit']")).submit();
        Assertions.assertEquals("MALAMI", driver.findElement(By.cssSelector("span[class=account-bar'] strong")).getText(), "User name is not correct!");
    }
}
