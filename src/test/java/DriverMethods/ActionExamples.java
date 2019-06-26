package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionExamples {

    WebDriver driver;
    Actions actions;

    @BeforeEach
    public void driverSetup() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        actions = new Actions(driver);
    }

    @AfterEach
    public void closeAndQuit() {

        driver.close();
        driver.quit();
    }

    @Test
    public void clickExample() {
        driver.navigate().to("https://jqueryui.com/selectable/#default");

//        actions.moveByOffset(488, 380).click().build().perform();
        driver.switchTo().frame(0);
        List<WebElement> listElements = driver.findElements(By.cssSelector("#selectable>li"));
        WebElement firstElement = listElements.get(0);
        actions.click(firstElement).click().build().perform();
    }

    @Test
    public void doubleClickExample() {
        driver.navigate().to("https://www.plus2net.com/javascript_tutorial/ondblclick-demo.php");
//        actions.moveByOffset(330, 173).doubleClick().build().perform();

        WebElement box = driver.findElement(By.cssSelector("#box"));
        actions.doubleClick(box).build().perform();
    }

    @Test
    public void contextClickExample() {
        driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement editOptions = driver.findElement(By.cssSelector(".context-menu-icon-edit"));
        WebElement button = driver.findElement(By.cssSelector(".context-menu-one"));
//        actions.moveByOffset(461, 195).contextClick().click(editOptions).build().perform();
        actions.contextClick(button).click(editOptions).build().perform();
    }
}
