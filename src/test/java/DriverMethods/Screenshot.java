package DriverMethods;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Screenshot {

    ChromeDriver driver;

    @BeforeEach
    public void driverSetup() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.zooniverse.org");
    }

    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }

    @Test
    public void screenshotExample() throws IOException {

        driver.findElement(By.cssSelector("button[value='sign-in']")).click();
        driver.findElement(By.cssSelector("input[name='login']")).sendKeys("malaMi");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("hasłotestowe");
        driver.findElement(By.cssSelector("form")).submit();
        sleep(2000);
        takeScreenshot();
        WebElement userName = driver.findElement(By.cssSelector("span[class='account-bar'] strong"));
        Assertions.assertEquals("MALAMI", userName.getText(), "User displayed on header is not correct.");
    }

    private void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        FileHandler.copy(screenshot, new File("/home/whysoserious/Desktop/testelka_komendy/testt/"+ formatter.format(timeNow) + ".png"));
    }

    private void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}