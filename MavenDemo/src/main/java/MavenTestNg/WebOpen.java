package MavenTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebOpen {
	WebDriver driver;
	long starttime;
	long endtime;
	long totaltime;
	
	@BeforeSuite
	public void launchbrowser() {
		 starttime =System.currentTimeMillis();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\selenium drivers\\chromedriver-win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
	}
	@Test
	public void opengoogle() {
		
		driver.get("https://www.google.com/");
		
		
	 }
	@Test
 public void openbing() {
	
		driver.get("https://www.bing.com/");
		
	 }
	@Test
 public void openyahoo() {
		
		driver.get("https://www.yahoo.com/");
		
		
}
    @AfterSuite
	public void closebrowser() {
    	
    	driver.quit();
    	endtime=System.currentTimeMillis();
		 totaltime=endtime-starttime;
		System.out.println(totaltime);
		
}
}
