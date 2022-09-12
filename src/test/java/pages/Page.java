package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert ;

import utils.Driver;

public class Page{

    private WebDriver driver = Driver.getDriver();
    private By searchText = By.id("search_query_top");
    private By searchButton = By.name("submit_search");
    private By more = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span");
    private By sizeSelect = By.id("group_1");
    private By colour1 = By.name("Blue");
    private By colour2 = By.name("Beige");
    private By colour3 = By.name("Orange");
    private By addToCart = By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    private By quickView = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
    private By quickView1 = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
    private By close = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span");
    private By home = By.xpath("//*[@id=\"columns\"]/div[1]/a[1]/i");
    private By cart = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
    private By checkout = By.xpath("//*[@id=\"button_order_cart\"]/span");
    private By delete1 = By.xpath("//*[@id=\"4_16_0_0\"]");
    private By total1 = By.xpath("//*[@id=\"total_product_price_1_4_0\"]");
    private By total2 = By.xpath("//*[@id=\"total_product_price_5_25_0\"]");
    private By total = By.xpath("//*[@id=\"total_price\"]");
    
    
    Actions action = new Actions(driver);

    public void getUrl(String url) {
        driver.navigate().to(url);
    }
    
    public void addTshirtToCart(String dresstype1, Integer size1) {
    	driver.findElement(searchText).click();
    	driver.findElement(searchText).sendKeys(dresstype1);
    	driver.findElement(searchButton).click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,500)");
    	action.moveToElement((WebElement) driver.findElement(quickView)).perform();
    	driver.findElement(more).click();
    	Select select1 = new Select((WebElement) driver.findElement(sizeSelect));
    	select1.selectByIndex(size1);
    	driver.findElement(colour1).click();
    	JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	js1.executeScript("window.scrollBy(0,500)");
    	driver.findElement(addToCart).click();
    	driver.findElement(close).click();
    	driver.findElement(home).click();
    }
  
    
    public void addEveningDressToCart(String dresstype2, Integer size2) {
    	driver.findElement(searchText).click();
    	driver.findElement(searchText).sendKeys(dresstype2);
    	driver.findElement(searchButton).click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,500)");
    	Actions action = new Actions(driver);
    	action.moveToElement((WebElement) driver.findElement(quickView)).perform();
    	driver.findElement(more).click();
    	Select select1 = new Select((WebElement) driver.findElement(sizeSelect));
    	select1.selectByIndex(size2);
    	driver.findElement(colour2).click();
    	JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	js1.executeScript("window.scrollBy(0,500)");
    	driver.findElement(addToCart).click();
    	driver.findElement(close).click();
    	driver.findElement(home).click();
    }
    
    public void addSummerDressToCart(String dresstype3, Integer size3) {
    	driver.findElement(searchText).click();
    	driver.findElement(searchText).sendKeys(dresstype3);
    	driver.findElement(searchButton).click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,500)");
    	action.moveToElement((WebElement) driver.findElement(quickView1)).perform();
    	driver.findElement(more).click();
    	Select select1 = new Select((WebElement) driver.findElement(sizeSelect));
    	select1.selectByIndex(size3);
    	driver.findElement(colour3).click();
    	JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	js1.executeScript("window.scrollBy(0,500)");
    	driver.findElement(addToCart).click();
    	driver.findElement(close).click();
    	driver.findElement(home).click();
    }
    
    public void checkout() throws InterruptedException {
    	action.moveToElement((WebElement) driver.findElement(cart)).perform();
    	driver.findElement(checkout).click();
    	
    }
    
    public void removeEveningDressFromCart() {
    	JavascriptExecutor js2 = (JavascriptExecutor)driver;
    	js2.executeScript("window.scrollBy(0,500)");
    	driver.findElement(delete1).click();
    	driver.findElement(home).click();
    }
    
    public void assertEachItem() {
    	JavascriptExecutor js3 = (JavascriptExecutor)driver;
    	js3.executeScript("window.scrollBy(0,500)");
    	String total_faded_tshirt = driver.findElement(total1).getText();
    	String total_summer_printed = driver.findElement(total2).getText();
    	String cost1 = "$33.02";
    	String cost2 = "$28.98";
    	
    	System.out.println("total_faded_tshirt"+total_faded_tshirt);
    	System.out.println("total_summer_printed"+total_summer_printed);
    			
    	Assert.assertEquals(total_faded_tshirt, cost1);
    	Assert.assertEquals(total_summer_printed, cost2);
    }
    
    public void assertCartTotal() {
    	String total_cost = driver.findElement(total).getText();
    	String total_cost_expected = "$64.00";
    	
    	System.out.println("total_cost"+total_cost);
    	Assert.assertEquals(total_cost_expected, total_cost);
    	
    }
    
}
