package MavenTestNg;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class DemoGuru {

    WebDriver driver;
    WebDriverWait wait;
    String customerId;
    String loc="C:\\image\\pic";
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaila\\OneDrive\\Desktop\\selenium\\chromedriver-win32\\chromedriver-win32/chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test (priority=1)
    public void addCustomerTest() throws IOException {
        
        driver.get("https://demo.guru99.com/telecom/index.html");

        
        WebElement addCustomerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Customer']")));
        addCustomerLink.click();
        
        
        String fname = "Kailas";
        String lname = "KS";
        String email = "kailas@example.com";
        String address = "Test Street";
        String phone = "9876543210";

        
        driver.findElement(By.id("fname")).sendKeys(fname);
        driver.findElement(By.id("lname")).sendKeys(lname);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.name("addr")).sendKeys(address);
        driver.findElement(By.id("telephoneno")).sendKeys(phone);

        
        driver.findElement(By.name("submit")).click();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("CustomerData");

        
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("First Name");
        header.createCell(1).setCellValue("Last Name");
        header.createCell(2).setCellValue("Email");
        header.createCell(3).setCellValue("Address");
        header.createCell(4).setCellValue("Phone");

      
        Row data = sheet.createRow(1);
        data.createCell(0).setCellValue(fname);
        data.createCell(1).setCellValue(lname);
        data.createCell(2).setCellValue(email);
        data.createCell(3).setCellValue(address);
        data.createCell(4).setCellValue(phone);

        
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\kaila\\OneDrive\\Desktop\\excelsheet\\Customerdata.xlsx");

        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        System.out.println("Excel file written successfully.");
        WebElement cxidElement = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]/h3"));
		customerId = cxidElement.getText();
		System.out.println("Copied Customer ID = " + customerId);
		
        
        File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1,new File(loc+"customer_id.jpg"));
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/ul/li/a")).click();
    }
    @Test (priority=2, dependsOnMethods = "addCustomerTest")
    public void AddTariffCustomer() throws IOException {
  
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"one\"]/div/div[1]/div[2]/h3/a")));
    	element.click();
    	WebElement id = driver.findElement(By.id("customer_id"));
    	id.sendKeys(customerId);
    	driver.findElement(By.name("submit")).click();
    	driver.findElement(By.name("submit")).click();
    	File file2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file2,new File(loc+"Tariff_Plan.jpg"));
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();
    }
        @Test (priority =3)
    
    	public void AddTariffPlan() throws IOException {
        driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[3]/div[1]/h3/a")).click();
        String rental = "1000";
        driver.findElement(By.id("rental1")).sendKeys(rental);
        driver.findElement(By.id("local_minutes")).sendKeys("25");
        driver.findElement(By.id("inter_minutes")).sendKeys("100");
        driver.findElement(By.id("sms_pack")).sendKeys("99");
        driver.findElement(By.id("minutes_charges")).sendKeys("199");
        driver.findElement(By.id("inter_charges")).sendKeys("599");
        driver.findElement(By.id("sms_charges")).sendKeys("99");
        driver.findElement(By.name("submit")).click();
        File file3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file3,new File(loc+"Add_Tariff3.jpg"));
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();
        }
        @Test(priority = 4, dependsOnMethods = "addCustomerTest")
        public void PayBill() throws IOException {
            WebElement pay = driver.findElement(By.xpath("//*[@id=\"one\"]/div/div[3]/div[2]/h3/a"));
            pay.click();
        	driver.findElement(By.id("customer_id")).sendKeys(customerId);
        	driver.findElement(By.name("submit")).click();
        	File file4=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file4,new File(loc+"PayBill.jpg"));
            driver.findElement(By.xpath("//*[@id=\"header\"]/nav/a[2]")).click();
            
        	
        }
     @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
