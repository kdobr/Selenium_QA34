import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.Test;

public class Start {

    WebDriver wd;

    @Test
    public void start() throws InterruptedException {
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        WebElement loginBtn = wd.findElement(By.cssSelector(".navbar-component_nav__1X_4m a[href='/login']"));
        loginBtn.click();
        WebElement loginTab = wd.findElement(By.cssSelector(".login_login__3EHKB input[placeholder='Email']"));
        WebElement passwordTab = wd.findElement(By.cssSelector(".login_login__3EHKB input[placeholder='Password']"));
        loginTab.sendKeys("abc");
        passwordTab.sendKeys("efg");
        Thread.sleep(3000);
        wd.quit();



    }
}
