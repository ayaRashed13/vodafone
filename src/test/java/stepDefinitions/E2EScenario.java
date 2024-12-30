package stepDefinitions;

import Pages.P01_LandingPage;
import Pages.P02_HomePage;
import Pages.P04_CartPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static Utilities.Utility.getJsonData;

public class E2EScenario {

    private WebDriver driver;
    private ChromeOptions chromeOptions;

    @Before
    public void setup() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        new P01_LandingPage(driver).navigateToLanding();
    }

    @Given("The Home page is loaded")
    public void theHomePageIsLoaded() {
        new P01_LandingPage(driver)
                .clickOnHomePageButton_en()
                .closeCookiesPopup();
    }

    @When("Adding 3 Items to the cart")
    public void addingItemsToCart() {
        new P02_HomePage(driver)
                .selectFirstItem()
                .clickOnAddToCart()
                .navigateToHome()
                .selectSecondItem()
                .clickOnAddToCart()
                .navigateToHome()
                .enterSearchText(getJsonData("data", "product"))
                .clickOnAddToCart();
    }

    @Then("Items should be added to the cart")
    public void itemsShouldBeAddedToTheCart() {
        Assert.assertTrue(new P04_CartPage(driver).verifyThatRegisterPageAppear());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
