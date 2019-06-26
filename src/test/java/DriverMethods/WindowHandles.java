package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {

    WebDriver driver;
    WebDriverWait wait;
    By cookieAccept = By.cssSelector("#cn-accept-cookie");

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.navigate().to("https://testelka.pl/blog/");

        wait = new WebDriverWait(driver, 5);

        driver.findElement(cookieAccept).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieAccept));
    }

    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void windowHandlesTest(){
        driver.findElement(By.cssSelector("i.fa-youtube")).click();
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        windows.remove(parentWindow);
        String secondWindow = windows.iterator().next();
        driver.switchTo().window(secondWindow);
        String  sctiveWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("div[id='logo-icon-container']")).click();
        driver.switchTo().window(parentWindow);

    }
}
