import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;
import pages.SearchResults;

import static com.google.common.truth.Truth.assertThat;

public class OnlineStoreTests {

    private WebDriver driver;
    private Home home;
    private SearchResults searchResults;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        home = new Home(driver);
        searchResults = new SearchResults(driver);
        home.open();
    }

    @Test // What_How_Expected
    public void Search_FadedTshirt_ShouldBeFound() {
        home.searchFor("Faded T-shirt");
        assertThat(searchResults.isItemFound()).isTrue();
    }

    @Test // What_How_Expected
    public void Search_FadedTshirt_ShouldNotBeFound() {
        home.searchFor("Faded Tshirt");
        assertThat(searchResults.isAlertFound()).isTrue();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
