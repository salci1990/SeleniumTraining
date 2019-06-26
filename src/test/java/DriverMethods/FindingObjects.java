package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FindingObjects {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() throws MalformedURLException {

//        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(8, 30));
        driver.navigate().to("https://pl.wikipedia.org");

    }

    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void findingElementsById(){
        driver.findElement(By.id("searchInput"));
        driver.findElement(By.name("search"));
        driver.findElement(By.className("searchButton"));

        List<WebElement> externalClassElements = driver.findElements(By.className("external"));

        WebElement elementWithTwoClasses = null;

        for( WebElement externalClassElement: externalClassElements){
            String elementClass = externalClassElement.getAttribute("class");
            if (elementClass.equals("external text")){
                elementWithTwoClasses = externalClassElement;
            }
        }
        Assertions.assertTrue(elementWithTwoClasses !=null, "Element was not found");

        int numberOfImages = driver.findElements(By.tagName("img")).size();
    }

    @Test
    public void findingElementByLinkTest(){
        driver.findElement(By.linkText("Wikisłownik"));
        driver.findElement(By.partialLinkText("redagować"));
    }
}