package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.navigate().to("https://www.nasa.gov/");

        wait = new WebDriverWait(driver, 10);

    }

    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void frameExamples(){
        WebElement frame = driver.findElement(By.cssSelector("twitter-widget-0"));
        driver.switchTo().frame(frame);
        WebElement viewOnTwitter = driver.findElement(By.cssSelector("a[data-scribe='element:twitter_url']"));
//        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector("div.navbar-header>a.logo"));
    }
}
