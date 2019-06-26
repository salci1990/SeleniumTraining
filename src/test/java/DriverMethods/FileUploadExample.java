package DriverMethods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FileUploadExample {

    WebDriver driver;

    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void driverSetup() {

        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1290, 730));
        driver.manage().window().setPosition(new Point(10, 40));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.navigate().to("https://gofile.io/?t=welcome");
    }

    @AfterEach
    public void closeAndQuit() {

        driver.close();
        driver.quit();
    }

    @Test
    public void fileUploadTest(){

        driver.findElement(By.cssSelector("button[class='btn btn-lg']")).click();
        WebElement uploadFileInput = driver.findElement(By.cssSelector("button[id='btnChooseFiles']"));
        String expectedFileName = "KG-Git-Workflow.pdf";
        String path = "/home/whysoserious/Desktop/" + expectedFileName;
        uploadFileInput.sendKeys(path);

        String actualFileName = driver.findElement(By.cssSelector("td[class='sorting_1']")).getText();

        Assertions.assertEquals(expectedFileName, actualFileName, "Name of uploaded file is different than expected one.");
    }
}
