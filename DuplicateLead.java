package week5.day2.assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DuplicateLead extends ProjectSpecificMethods{
	@BeforeTest
	public void SetData() {
		excelfilepath = ("./TestData/duplicatedata.xlsx");
	}
//	@DataProvider(name = "Data_provider2")
//	public  String[][] TestData() {
//		String[][] data = new String[1][3];
//		data[0][0]="DemoSalesManager";
//		data[0][1]="crmsfa";
//		data[0][2]="9";
//		return data;
		
		

//	}
@Test(dataProvider="duplicate_Lead_Data", invocationCount = 2)
	public  void DuplicateLead(String username, String password, String phonenumber) throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
	
	}
}
