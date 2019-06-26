package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebStorageExamples {

    ChromeDriver driver;

    @BeforeEach
    public void driverSetup() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeAndQuit() {

        driver.close();
        driver.quit();
    }

    @Test
    public void localStorageExample() {

        driver.navigate().to("https://airly.eu/map/pl/#50.06237,19.93898");
        LocalStorage local = driver.getLocalStorage();
        String value = local.getItem("persist:map");
        int siee = local.size();
        Set<String> keys = local.keySet();
        String removeTheValue = local.removeItem("persist:map");
        local.setItem("spell", "Alohomora");
        local.clear();
    }

    @Test
    public void sessionStorageExample() {

        driver.navigate().to("https://www.youtube.com/watch?v=DPfHHls50-w");
        final SessionStorage session = driver.getSessionStorage();
        String value = session.getItem("yt-remote-session-app");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        int siee = session.size();
        Set<String> keys = session.keySet();
        String removeTheValue = session.removeItem("yt-remote-session-app");
        session.setItem("spell", "Alohomora");
        session.clear();
    }
}
