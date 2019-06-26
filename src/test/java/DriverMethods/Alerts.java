package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Alerts {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver");

        driver= new FirefoxDriver();
        driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(8, 30));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        js = (JavascriptExecutor)driver;

    }

    @AfterEach
    public void closeAndQuit() {
        driver.quit();
    }

    @Test
    public void promptBoxTest(){
        String javascript = "prompt('Mozesz tutaj cos wpisac: ')";
        js.executeScript(javascript);
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Teeeeeeeeeeeest");
        driver.switchTo().alert().accept();
        js.executeScript(javascript);
        driver.switchTo().alert().dismiss();
    }
}
