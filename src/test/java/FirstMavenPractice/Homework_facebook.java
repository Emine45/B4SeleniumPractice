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
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Homework_facebook {
// 1. Go to “https://facebook.com”
// 2. Click create new account button
// 3. Enter a name firstName input box
// 4. Enter a surname surName input box
// 5. Enter an email into email input box
// 6. Re-enter the same email into email input box
// 7. Enter a new password
// 8. Select a day
// 9. Select a moth
// 10. Select a year
// 11. Select a gender
// 12. Verify the gender is selected and verify the other gender is not selected

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() {
     // 1. Go to “https://facebook.com”
        driver.get("https://facebook.com");

     // 2. Click create new account button
        WebElement createAccountButton = driver.findElement(By.linkText("Create New Account"));
        createAccountButton.click();

     // 3. Enter a name firstName input box
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Sofia");

     // 4. Enter a surname surName input box
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Right");

     // 5. Enter an email into email input box
        WebElement email= driver.findElement(By.name("reg_email__"));
        email.sendKeys("SofiaUSA@gmail.com");

     // 6. Re-enter the same email into email input box
        WebElement reEmail= driver.findElement(By.name("reg_email_confirmation__"));
        reEmail.sendKeys("SofiaUSA@gmail.com");

     // 7. Enter a new password
        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("Sofia123");

     // 8. Select a day
        WebElement day = driver.findElement(By.id("day"));
        Select select2 = new Select(day);
        select2.selectByValue("20");

     // 9. Select a month
        WebElement month = driver.findElement(By.name("birthday_month"));
        Select select1= new Select(month);
        select1.selectByValue("5");
     // 10. Select a year
        WebElement year = driver.findElement(By.id("year"));
        Select select3 = new Select(year);
        select3.selectByValue("2001");
     // 11. Select a gender
        WebElement gender = driver.findElement(By.xpath("//input[@id='u_1_2']"));
        gender.click();

     // 12. Verify the gender is selected and verify the other gender is not selected
        Assert.assertTrue(gender.isSelected());

        WebElement male = driver.findElement(By.xpath("//input[@id='u_1_3']"));
        Assert.assertFalse(male.isSelected());

        WebElement custom = driver.findElement(By.xpath("//input[@id='u_1_4']"));
        Assert.assertFalse(custom.isSelected());

        }

     @After
     public void tearDown() {
        driver.quit();
      }
}
