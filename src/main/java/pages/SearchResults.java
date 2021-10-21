package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends Page {

    @FindBy(css = "[title='Faded Short Sleeve T-shirts']")
    private WebElement itemFadedTShirt;

    @FindBy(className = "alert")
    private WebElement labelNoProductFound;

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    public boolean isItemFound() {
        return itemFadedTShirt.isDisplayed();
    }

    public boolean isAlertFound() {
        return labelNoProductFound.isDisplayed();
    }
}
