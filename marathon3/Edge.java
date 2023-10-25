package marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edge extends BaseClass{
	@BeforeTest
	public void openDb() {
		excelfile="edge";
	}
	@Test(dataProvider="readdata")
public void runedge(String fname, String lname) throws InterruptedException {

	driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Contacts",Keys.ENTER);
	driver.findElement(By.xpath("//mark[text()='Contacts']")).click();
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//a[@title='New']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@role='combobox']")).click();
	driver.findElement(By.xpath("//span[text()='Ms.']")).click();
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
	driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lname);
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	
	String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']/parent::div")).getText();
	if (text.contains(" was created.")) {
		System.out.println("New contact created!");
	} else {
		System.out.println("New contact created not created :(");
	}
	System.out.println("Verification: "+text);
	
	//driver.close();
}
}
//1. Login to https://login.salesforce.com
//2. Click on toggle menu button from the left corner
//3. Click view All and Enter Contacts in Search Box
//4. Click Contacts
//5. Click on New
//6. Pick Salutation as 'Mr.'
//7. Enter First Name as 'Your Name'
//8. Enter Last Name as 'YOur Last Name'
//9. Enter email as 'Your EMail' 
//10. Create a New Account for Account Name
//11. Enter account name as 'Credits' and save
//12. Click and save
//13. Verify contact using Unique name and print the name
//14.Close the browser
//WebDriverManager.edgedriver().setup();
//EdgeDriver driver = new EdgeDriver();
//driver.manage().window().maximize();
//driver.get("https://login.salesforce.com");
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
//driver.findElement(By.xpath("//input[@id='Login']")).click();
//Thread.sleep(4000);
//
//driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("//button[text()='View All']")).click();
//
//Thread.sleep(3000);