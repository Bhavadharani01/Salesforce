package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week7.day1.ReadExcel;

public class BaseClass {
	public RemoteWebDriver driver;
	String excelfile;
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void launchbrowser(String browser,String url,String uname, String pwrd) throws InterruptedException {
	
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		driver = new ChromeDriver(ch);
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwrd);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		Thread.sleep(3000);
	}
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
	@DataProvider(name= "readdata")
	   public String[][] getData() throws IOException {
		   String [][] data = ReadExcel.readdata(excelfile);  //[row][cols]
		   return data;
}
}
