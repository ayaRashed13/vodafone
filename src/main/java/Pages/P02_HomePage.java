package Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Utilities.Utility.*;

public class P02_HomePage {
    private WebDriver driver;
    private By searchBox = By.cssSelector("#searchInput");
    private By firstItem = By.xpath("(//div[@class='product-result'])[1] /img");
    private By first = By.xpath("(//div[@class='img-container'] /img)[1]");
    private By second = By.xpath("(//div[@class='img-container'] /img)[2]");
    private final By appleCategory = By.id("Apple");
    private By cookieCloseButton = By.id("onetrust-accept-btn-handler");

    public P02_HomePage(WebDriver driver) {

        this.driver = driver;

    }
    public P02_HomePage navigateToHome()
    {
        driver.get(getJsonData("data","home-url"));
        return this;
    }

    public P03_ProductDetailsPage enterSearchText(String product) {
        sendData(driver,searchBox,product);
        clickingOnElement(driver,firstItem);
        return new P03_ProductDetailsPage(driver);
    }

    public P03_ProductDetailsPage selectFirstItem() {
        clickingOnElement(driver,appleCategory);
        clickingOnElement(driver,first);
        return new P03_ProductDetailsPage(driver);
    }
    public P03_ProductDetailsPage selectSecondItem() {
        clickingOnElement(driver,appleCategory);
        clickingOnElement(driver,second);
        return new P03_ProductDetailsPage(driver);
    }

    public void closeCookiesPopup() {
        List<WebElement> elements = driver.findElements(cookieCloseButton);
        if (elements.isEmpty())
            System.out.println("Accept cookies button is not appeared yet.");
        else
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(cookieCloseButton))
                    .click();
    }


}
