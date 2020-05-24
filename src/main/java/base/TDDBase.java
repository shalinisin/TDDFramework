package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




//import utilities.TDDUtil;



public class TDDBase {
	
		public String browserName;
		public Properties prop;
		public static WebDriver driver;
		
		
		public TDDBase() {
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("C:\\Users\\SING110\\Documents\\JAVARELATEDITEMS\\POMWorkspace\\TDDFramework"
						+ "\\src\\main\\java\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		public void initialization() {
			browserName = prop.getProperty("browser");
			System.out.println(browserName);
			
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SING110\\Documents"
						+ "\\JAVARELATEDITEMS\\BrowserEXE\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
				
			}else if(browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\SING110\\Documents"
						+ "\\JAVARELATEDITEMS\\BrowserEXE\\chromedriver_win32\\firefoxdriver.exe");
				 driver = new FirefoxDriver();
			}else if(browserName.equals("ie")) {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\SING110\\Documents"
						+ "\\JAVARELATEDITEMS\\BrowserEXE\\chromedriver_win32\\internetexplorerdriver.exe");
				 driver = new InternetExplorerDriver();
			}else
				System.out.println("Browser is not found");
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get((prop.getProperty("url")));
			
			
		}
		
		
	}

