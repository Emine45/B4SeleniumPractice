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

public class TestCase1 {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testCase1(){
        driver.get("http://zero.webappsecurity.com/");
        WebElement singIn = driver.findElement(By.id("signin_button"));
        singIn.click();
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");
        WebElement singINButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singINButton.click();
        WebElement payBills = driver.findElement(By.linkText("Pay Bills"));
        payBills.click();
        WebElement amount = driver.findElement(By.name("amount"));
        amount.sendKeys("100");
        WebElement date =driver.findElement(By.id("sp_date"));
        date.sendKeys("2020-08-23");
        WebElement payButton = driver.findElement(By.id("pay_saved_payees"));
        payButton.click();
        String actualMessage = driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
        String expectedMessage = "The payment was successfully submitted.";
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
