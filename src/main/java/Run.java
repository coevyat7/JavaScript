import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Run {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        invokeBrowser();
        JavaScriptHelper js = new JavaScriptHelper(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        System.out.println(js.getPageTitle());
        System.out.println(js.getPageURL());
        js.drawBorder(searchBox);
        js.zoomPage();
        searchBox.sendKeys("sport");
        WebElement click = driver.findElement(By.id("nav-search-submit-button"));
        js.clickElement(click);

        WebElement result = driver.findElement(By.xpath("//span[text()='RESULTS']"));
        js.changeColor("#000000", result);
        

    }

    static void invokeBrowser() {
        try {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.amazon.com/");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
