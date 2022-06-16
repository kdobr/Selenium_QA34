import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class StartCSS {

    WebDriver wd;

    WebElement loginOnHeader;
    WebElement emailInLoginForm;
    WebElement passwordInLoginForm;
    WebElement registrationButton;
    WebElement loginButton;

    WebDriverWait wait;

    By.ByCssSelector emailSelector = new By.ByCssSelector(".login_login__3EHKB [placeholder='Email'");
    By.ByCssSelector passwordSelector = new By.ByCssSelector(".login_login__3EHKB [placeholder='Password'");
    By.ByCssSelector registrationButtonSelector = new By.ByCssSelector(".login_login__3EHKB :last-child");
    By.ByCssSelector registrationButtonSelector2 = new By.ByCssSelector(".login_login__3EHKB>button:last-of-type");
    By.ByCssSelector loginButtonSelector = new By.ByCssSelector(".login_login__3EHKB :nth-last-child(2)");
    By.ByCssSelector loginButtonSelector2 = new By.ByCssSelector(".login_login__3EHKB>button:nth-last-of-type(2)");

    @BeforeTest
    public void openBrowser() {

        //arrange driver and waits
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(wd, Duration.ofSeconds(3));

        //navigating to homepage
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        //find login form element
        loginOnHeader = wd.findElement(By.cssSelector("[class^=navbar] :last-child"));
    }

    @Test
    public void registration() throws InterruptedException {
        //open login form
        loginOnHeader.click();

        //fill email
        emailInLoginForm = wd.findElement(emailSelector);
        emailInLoginForm.sendKeys("zz@zz.zz");

        //transfer to password input
        emailInLoginForm.sendKeys(Keys.TAB);

        //fill password
        passwordInLoginForm = wd.findElement(passwordSelector);
        passwordInLoginForm.sendKeys("Paarol1$");

        //find and push reg button 2 ways
        registrationButton = wd.findElement(registrationButtonSelector2);
      //  registrationButton = wd.findElement(registrationButtonSelector);
        registrationButton.click();

        //wait until "contact page" tab appear before closing browser
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.contact-page_message__2qafk")));
        //Thread.sleep(3000); - tried without waits with this "sleep".
    }

    @Test
    public void login() throws InterruptedException {
        //open login form
        loginOnHeader.click();

        //fill email
        emailInLoginForm = wd.findElement(emailSelector);
        emailInLoginForm.sendKeys("a@bb.ccc");

        //transfer to password input
        emailInLoginForm.sendKeys(Keys.TAB);

        //fill password
        passwordInLoginForm = wd.findElement(passwordSelector);
        passwordInLoginForm.sendKeys("Paarol1$");

        // find and push login button 2 ways
//        loginButton = wd.findElement(loginButtonSelector);
        loginButton = wd.findElement(loginButtonSelector2);
        loginButton.click();

        // this "sleep" is only for our better perception. Method works without it.
        Thread.sleep(3000);
    }

    @AfterTest
    public void closeBrowser() {

        //closing browser
        wd.quit();
    }
}
