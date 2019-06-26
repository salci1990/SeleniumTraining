package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionKeyboardExample {

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
    public void sendKeysExample() {

        driver.navigate().to("https://fakestore.testelka.pl/moje-konto/");
        WebElement login = driver.findElement(By.cssSelector("#username"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login);

        actions.sendKeys(login, Keys.SHIFT,  "testowy user").build().perform();
        actions.click(login).sendKeys(Keys.SHIFT, "testowy user").build().perform();
    }

    @Test
    public void pressingKeysExample() {

        driver.navigate().to("https://fakestore.testelka.pl/moje-konto/");
        WebElement login = driver.findElement(By.cssSelector("#username"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login);

        actions.keyDown(Keys.SHIFT).sendKeys(login, "testowy user").keyUp(Keys.SHIFT).build().perform();
    }

    @Test
    public void pressingKeysExample2() {

        driver.navigate().to("https://jqueryui.com/selectable/#default");

        driver.switchTo().frame(0);
        List<WebElement> listIntems = driver.findElements(By.cssSelector("li.ui-selectee"));

        actions.keyDown(Keys.CONTROL).click(listIntems.get(0)).click(listIntems.get(1)).click(listIntems.get(2)).keyUp(Keys.CONTROL).click(listIntems.get(3))
                .build().perform();
    }
}