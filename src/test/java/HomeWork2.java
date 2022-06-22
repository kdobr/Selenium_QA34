import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeWork2 {

    WebDriver wd = new ChromeDriver();

    @BeforeTest
    public void beforeTest(){
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    }

    @Test
    public void fromCssToxPath(){
        wd.findElement(By.cssSelector("a[href]"));
        wd.findElement(By.xpath("//a[@href]"));
        wd.findElement(By.cssSelector("[href ^='/ho']"));
        wd.findElement(By.xpath("//*[starts-with(@href, '/ho')]"));
        wd.findElement(By.cssSelector("div.focus"));
        wd.findElement(By.xpath("//div[@class='focus']"));
        wd.findElement(By.cssSelector("input[type='text']"));
        wd.findElement(By.xpath("//input[@type='text']"));
        wd.findElement(By.cssSelector("div #host"));
        wd.findElement(By.xpath("//div//[@id='host']"));
        wd.findElement(By.cssSelector("table#country tr:nt-child(3)) td:last-child"));
        wd.findElement(By.xpath("//table[@id='country']//tr[(count(preceding-sibling::*))=2]//td[not(following-sibling::*)]"));
        wd.findElement(By.cssSelector("div#idName li:first-child"));
        wd.findElement(By.xpath("//div[@id='idName']//li[not(preceding-sibling::*)]"));
        wd.findElement(By.cssSelector("div#sort>div:nth-child(2)"));
        wd.findElement(By.xpath("//div[@id='sort']/div[count(preceding-sibling::*) = 1]"));
    }


    @Test
    public void fromXPathToCss(){
        wd.findElement(By.xpath("//*[@id='host"));
        wd.findElement(By.cssSelector("#host"));

        wd.findElement(By.xpath("//button[@class='submit']"));
        wd.findElement(By.cssSelector("button.submit"));

        wd.findElement(By.xpath("//div/div/img[@src='paris.jpg']"));
        wd.findElement(By.cssSelector("div>div>img[src='paris.jpg']"));

        wd.findElement(By.xpath("//div[@class='first' and @class='list']"));
        wd.findElement(By.cssSelector("div.first.list"));

        wd.findElement(By.xpath("//div[contains(@class,'st']"));
        wd.findElement(By.cssSelector("div[class*='st']"));

        wd.findElement(By.xpath("//div[@id=’idName’]//h1[last()]"));
        wd.findElement(By.cssSelector("div#idName h1:last-of-type"));

        wd.findElement(By.xpath("//table[@id]//tr[last()]"));
        wd.findElement(By.cssSelector("table[@id] tr:last-of-type"));

        wd.findElement(By.xpath("//a[starts-with(@id,'ret')]"));
        wd.findElement(By.cssSelector("a[id^='ret']"));


    }

    @AfterTest
    public void afterTest(){
        wd.quit();
    }
}
