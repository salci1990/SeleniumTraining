package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoreMethodsOnElements {

    WebDriver driver;
    WebDriverWait wait;

    By cookieConsentBar = By.cssSelector("a[class*=dissmis-link']");
    By pilatesGroup = By.cssSelector("a[href*='pilates']");
    By product = By.cssSelector("li.post-61");
    By addToCartButton = By.cssSelector("button[name='add-to-cart']");
    By goToCartButton = By.cssSelector("a.cart-contents");

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.navigate().to("https://fakestroe.testelka.pl");

        wait = new WebDriverWait(driver, 10);

        driver.findElement(cookieConsentBar).click();
        driver.findElement(pilatesGroup).click();
        driver.findElement(product).click();
        driver.findElement(addToCartButton).click();
        driver.findElement(goToCartButton).click();
    }

    @AfterEach
    public void closeAndQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void infoOnElement(){

        WebElement element = driver.findElement(By.cssSelector("button[name='update_cart']"));
        String text = element.getText();
        String attribute = element.getAttribute("role");
        String cssValue = element.getCssValue("background-color");
        String tag = element.getTagName();
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Rectangle locationAndSize = element.getRect();
        boolean isDisplayed = element.isDisplayed();
        boolean isSelected = element.isSelected();
        boolean isEnable = element.isEnabled();
    }

}
