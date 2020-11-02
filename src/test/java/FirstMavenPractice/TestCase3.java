package FirstMavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {
// 1.Go to   “https://www.saucedemo.com/”
// 2. Enter “standard_user” userName input box
// 3. Enter “secret_sauce” password input box
// 4. Click Login button
// 5. Get the first Item name
// 6. Click Add to Cart
// 7. Click Shopping Cart
// 8. Verify that is you add the item successfully.

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TestCase3() {
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();
        WebElement firstItem = driver.findElement(By.xpath("//a[@href='./inventory-item.html?id=4']/div[@class='inventory_item_name']"));
        String getTextItem = firstItem.getText();
        WebElement addCart = driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]"));
        addCart.click();
        WebElement CartButton = driver.findElement(By.xpath("//a[@href='./cart.html']"));
        CartButton.click();
        WebElement selectedItem = driver.findElement(By.id("item_4_title_link"));
        String actualItem = selectedItem.getText();
        Assert.assertEquals(getTextItem,actualItem);

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
