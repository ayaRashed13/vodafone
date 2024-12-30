package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.clickingOnElement;
import static Utilities.Utility.findWebElement;

public class P04_CartPage {
    private By logo = By.className("header-icon");
    private final WebDriver driver;

    public P04_CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyThatRegisterPageAppear() {
        return findWebElement(driver,logo).isDisplayed();
    }
}
