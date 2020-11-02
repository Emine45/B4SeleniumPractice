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

public class TestCase4 {
// 1.Go to “https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.ph  p/auth/login”
// 2. Enter “opensourcecms” userName input box
// 3. Enter “opensourcecms” password input box
// 4. Click Login button
// 5. Click PIM link
// 6. Verify the Change Password is displayed

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCase4() throws InterruptedException {
        driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.ph  p/auth/login");
        WebElement userNameButton = driver.findElement(By.id("txtUsername"));
        userNameButton.sendKeys("opensourcecms");
        WebElement passwordButton = driver.findElement(By.id("txtPassword"));
        passwordButton.sendKeys("opensourcecms");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement pimButton = driver.findElement(By.xpath("//span[@class='drop current']"));
        pimButton.click();
        Thread.sleep(2000);
        WebElement changePassword=driver.findElement(By.linkText("Change Password"));
        Assert.assertTrue(changePassword.isDisplayed());

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
