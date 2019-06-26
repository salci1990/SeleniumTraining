package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(8, 30));
        driver.navigate().to("https://www.dunckelfeld.de/");

        wait = new WebDriverWait(driver, 30);
    }

    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void waitExample(){
        WebElement animation = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".startanimation")));
        wait.until(ExpectedConditions.stalenessOf(animation));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.cc-dismiss"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Projekte']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='UNIVERSAL MUSIC Deutschland']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#zusammenfassung]"))).click();

        By wireframesBy = By.cssSelector("span[class='countup']");
        wait.until(ExpectedConditions.textToBe(wireframesBy, "670"));
    }
}
