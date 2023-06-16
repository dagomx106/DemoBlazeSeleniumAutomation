package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public static Properties loc = new Properties();
	public static FileReader fr2;
	public static Logger logg;
	
	@BeforeMethod
	public void Setup() throws IOException {
		
		logg = LogManager.getLogger(this.getClass());
		
		if(driver == null) {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
			fr2 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			loc.load(fr2);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else if (prop.getProperty("browser").equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("testurl"));
		
		logg.info("----All setup----");
		
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
