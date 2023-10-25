package marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome extends BaseClass{
	@BeforeTest
	public void openDb() {
        excelfile="chrome";
   }
	
	   @Test(dataProvider="readdata")
public void runchrome(String qname, String dname) throws InterruptedException {

	driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("content",Keys.ENTER);
	driver.findElement(By.xpath("//mark[text()='Content']")).click();
	
	Thread.sleep(3000);
	WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
    driver.executeScript("arguments[0].click()", chatter);
	
	driver.findElement(By.xpath("//span[text()='Question']")).click();
	System.out.println("Chatter Page Title: "+driver.getTitle());////Chatter Home | Salesforce
	driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(qname);
	driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(dname);
	driver.findElement(By.xpath("//button[text()='Ask']")).click();
	
	driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Chrome",Keys.ENTER);
	Thread.sleep(3000);
	String text = driver.findElement(By.xpath("//div[@class='cuf-body cuf-questionTitle forceChatterFeedBodyQuestionWithoutAnswer']")).getText();
	if (text.contains("Chrome")) {
		System.out.println("Verified!");
	} else {
		System.out.println("Not verified");
	}
	
	//driver.close();
}

}

//01) Launch https://login.salesforce.com/ 
//02) Login to Salesforce with your username and password
//03) Click on the App Launcher (dots)
//04) Click View All
//05) Type Content on the Search box
//06) Click Content Link
//07) Click on Chatter Tab
//08) Verify Chatter title on the page
//09) Click Question tab
//10) Type Question with data (coming from excel)
//11) Type Details with data (coming from excel)
//12) Click Ask
//13) Confirm the question appears
//14) Close the browser
//WebDriverManager.chromedriver().setup();
//ChromeOptions ch=new ChromeOptions();
//ch.addArguments("--disable-notifications");
//ChromeDriver driver = new ChromeDriver(ch);
//driver.manage().window().maximize();
//driver.get("https://login.salesforce.com/");
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
//driver.findElement(By.xpath("//input[@id='Login']")).click();
//Thread.sleep(3000);
//
//driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("//button[text()='View All']")).click();
//
//Thread.sleep(3000);