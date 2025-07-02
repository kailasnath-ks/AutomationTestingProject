package MavenTestNg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SwagLabs {
	WebDriver driver;
	
@BeforeSuite
public void launchbrowser(){
	driver = new ChromeDriver();
}
@Test
public void swag(){
 driver.get("https://www.saucedemo.com/");
}
@Test 
public void login() {
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
}
}
