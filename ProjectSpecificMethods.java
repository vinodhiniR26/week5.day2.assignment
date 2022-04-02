package week5.day2.assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.LearnExcelSheet;

/*  Project specific methods write to common class of web drivers and its extends the class into create
 * ,edit,delete and duplicate lead for classes
*/


public class ProjectSpecificMethods {
	public String excelfilepath;
	public RemoteWebDriver driver;  //this is common driver for chrome, safari, opera,google instead of WebDriver for each  class
	@Parameters({"URL","BROWSER_NAME"})	//this get the value for  the URL from the XML
	@BeforeMethod
	public void beforeMethod(String url,String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}
	
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10	));
}

@AfterMethod
public void afterMethod() {
	driver.close();
}

@DataProvider(name="Dynamic_Data")// it refer @Test - EditLead
public String[][] testData() throws IOException{
	String[][] data = LearnExcelSheet.getData("Excel file path"); //while this line is error is Compile Time Exception so,we need to add throws exception
	return data;	
	
}

@DataProvider(name="Create_Lead_Data")
public String[][] createLeadData() throws IOException{
	String[][] data = LearnExcelSheet.getData(excelfilepath);
	return data;
}

@DataProvider(name="edit_Lead_Data")
public String[][] editLeadData() throws IOException{
	String[][] data = LearnExcelSheet.getData(excelfilepath);
	return data;
}

@DataProvider(name="delete_Lead_Data")
public String[][] deleteLeadData() throws IOException{
	String[][] data = LearnExcelSheet.getData(excelfilepath);
	return data;
}


@DataProvider(name="duplicate_Lead_Data")
public String[][] duplicateLeadData() throws IOException{
	String[][] data = LearnExcelSheet.getData(excelfilepath);
	return data;
}

@DataProvider(name="merge_Lead_Data")
public String[][] mergeLeadData() throws IOException{
	String[][] data = LearnExcelSheet.getData(excelfilepath);
	return data;
}
}
