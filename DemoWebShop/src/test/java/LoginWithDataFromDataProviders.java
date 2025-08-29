import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataFromDataProviders {
	
	@Test(dataProvider = "testData1")
	public void loginToWebShop(String username, String password) throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Log in']")).click();
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
	
	@DataProvider(name="testData1")
	public Object[][] getTestData()
	{
		return new Object[][] {{"sapare.thippeswamy@ltimindtree.com","R@cclive2020"}};
	}
}
