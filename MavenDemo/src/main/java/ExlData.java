import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExlData {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();	
		String url="https://www.saucedemo.com/";
	driver.get(url);
	driver.manage().window().maximize();
	
     FileInputStream excel=new FileInputStream("C:\\Users\\kaila\\OneDrive\\Desktop\\excelsheet\\logindetails.xlsx");
	
	XSSFWorkbook wb=new XSSFWorkbook(excel);//Used to reading and writing open office xml(xlsx) format files.
	
	XSSFSheet sh= wb.getSheet("sheet1");
	System.out.println(sh.getLastRowNum());
	
	
	for(int i=1;i<=sh.getLastRowNum();i++)
	{
	driver.findElement(By.xpath("//*[@name='user-name']")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
	driver.findElement(By.xpath("//*[@name='password']")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
	driver.findElement(By.xpath("//*[@id='login-button']")).click();
	Thread.sleep(2000);
	if(driver.getCurrentUrl().equals("https://www.saucedemo.com/"))
	{
		System.out.println("Login Failed");
		sh.getRow(i).createCell(2).setCellValue("Failed");
	}
	else
	{
		System.out.println("Logged in Successfully");
		sh.getRow(i).createCell(2).setCellValue("Successful");
	}
	FileOutputStream fout=new FileOutputStream("C:\\\\Users\\\\kaila\\\\OneDrive\\\\Desktop\\\\excelsheet\\\\logindetails.xlsx");
	wb.write(fout);
	driver.get("https://www.saucedemo.com/");

	}

}
}