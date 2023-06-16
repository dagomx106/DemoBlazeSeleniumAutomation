package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.Base;

public class firstTry extends Base {

	@Test(dataProviderClass=utilities.ReadXLSData.class,dataProvider="Tdata")
	public static void LoginTest(String user, String password) throws InterruptedException {

		logg.info("----Start test case ---");
		driver.findElement(By.id(loc.getProperty("login_link"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("user_field"))).sendKeys(user);
		driver.findElement(By.id(loc.getProperty("pass_field"))).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("login_btn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("name_user")));
		System.out.println("Success");
		
		logg.info("----Test case completed----");
	}

//	@DataProvider(name = "Tdata")
//	public Object[][] dataSet() {
//		return new Object[][] { 
//			{"seletest001", "001"}, 
//			{"seletest001", "5001"}, 
//			{"seletest", "001"} 
//		};
//	}

}
