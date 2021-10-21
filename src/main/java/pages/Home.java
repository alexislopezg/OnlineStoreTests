package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Page {

    @FindBy(id = "search_query_top")
    private WebElement inputSearch;

    public Home(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://automationpractice.com/index.php");
    }

    public void searchFor(String query) {
        inputSearch.sendKeys(query, Keys.ENTER);
    }
}
