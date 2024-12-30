package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;
import java.util.List;

public class Utility {
    public final static String TEST_DATA_PATH = "src/test/resources/TestData/";

    public static void clickingOnElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
               driver.findElement(locator).click();
    }

    public static void sendData(WebDriver driver, By locator, String data) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public static String getText(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }
    public static void scrolling(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findWebElement(driver, locator));
    }
    public static WebElement findWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
    public static List<WebElement> findWebElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }
    public static String getJsonData(String jsonFilename, String field) {
        try {
            // Define object of file Reader
            FileReader reader = new FileReader(TEST_DATA_PATH + jsonFilename + ".json");
            // Parse the JSON directly into a JsonElement
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonObject().get(field).getAsString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
