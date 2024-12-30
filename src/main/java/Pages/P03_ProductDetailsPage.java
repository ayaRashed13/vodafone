package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.clickingOnElement;

public class P03_ProductDetailsPage {
    private WebDriver driver;
    private By addToCartButton = By.cssSelector("div .add-to-cart");
    public P03_ProductDetailsPage(WebDriver driver) {
        this.driver = driver;

    }
    public P02_HomePage clickOnAddToCart() {
        clickingOnElement(driver,addToCartButton);
        return new P02_HomePage(driver);
    }
}
