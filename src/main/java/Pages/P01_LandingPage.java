package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.getJsonData;

public class P01_LandingPage {
    private WebDriver driver ;

    private final By homePageButton_en = By.id("home-button-1");
    private final By homePageButton_ar = By.id("home-button-2");

   public P01_LandingPage(WebDriver driver) {
       this.driver = driver;
  }


    public P01_LandingPage navigateToLanding()
    {
        driver.get(getJsonData("data","landing-url"));
        return this;
    }
    public P02_HomePage clickOnHomePageButton_en(){

        driver.findElement(homePageButton_en).click();
        return new P02_HomePage(driver);
    }
    public P02_HomePage clickOnHomePageButton_ar(){
        driver.findElement(homePageButton_ar).click();
        return new P02_HomePage(driver);
    }
}
