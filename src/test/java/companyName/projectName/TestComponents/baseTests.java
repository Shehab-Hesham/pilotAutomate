package companyName.projectName.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import companyName.projectName.pageElements.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class baseTests {
	
	public WebDriver driver;
	public landingPage land;

	public WebDriver initializeDriver() throws IOException {
		//properties class
		Properties prop = new Properties();
		FileInputStream convFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(convFile);
	
		String browserName = System.getProperty("browser")!=null? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			//Headless mode
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); //fullscreen run in headless
		}
		else if(browserName.contains("edge")) {
			 driver = new EdgeDriver();
		}
		else if(browserName.contains("firefox")) {
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		//implicit wait just in case internet slows down
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeTest
	public landingPage launchApp() throws IOException{
		driver = initializeDriver();
		land = new landingPage(driver); //one driver (same) for all
		land.goTo();
		return land;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir"));
		FileUtils.copyFile(source,  file);
		return System.getProperty("user.dir");
		
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		//json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		//String to Hashmap
		ObjectMapper mapper = new ObjectMapper();
		
		List <HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
