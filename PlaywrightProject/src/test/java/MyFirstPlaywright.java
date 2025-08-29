import java.awt.print.Pageable;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MyFirstPlaywright {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playWright = Playwright.create();
		Browser browser=playWright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		try {
		page.navigate("https://parabank.parasoft.com/parabank/overview.htm");
		page.locator("//input[@name='username']").fill("abc3");
		page.locator("//input[@name='password']").fill("pass@1234");
		page.locator("//input[@type='submit']").click();
		String welcomePage= page.locator("//h1[contains(text(),'Accounts Overviewa')]").textContent();
		
		
		Thread.sleep(2000);
		}
		finally{
			
		page.close();
		browser.close();
		playWright.close();}
		
	}

}
