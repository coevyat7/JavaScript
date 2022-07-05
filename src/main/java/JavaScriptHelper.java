import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    private WebDriver driver;
    public JavaScriptHelper(WebDriver driver){
        this.driver=driver;
    }
    private Object executeScript(String script){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js.executeScript(script);
    }
    private Object executeScript(String script,Object...args){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return  js.executeScript(script,args);
    }
    public String getPageTitle(){
        String title= (String) executeScript("return document.title");
        return title;
    }
    public String getPageURL(){
        String url= (String) executeScript("return document.URL");
        return url;
    }
    public void drawBorder(WebElement element){
        executeScript("arguments[0].style.border='3px solid red'",element);
    }
    public void clickElement(WebElement element){
        executeScript("arguments[0].click()",element);
    }
    public void scrollPageDown(){
        executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public  void scrollPageUp(){
        executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    public void zoomPage(){
        executeScript("document.body.style.zoom='150%'");
    }
    public void changeColor(String color,WebElement element){
        executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
        try {
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
