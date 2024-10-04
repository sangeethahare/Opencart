package baseTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"sanity","Regression","master"})
	@Parameters({"browser"})
	public void setUp(String br) throws IOException
	{
		//reading common data from property file
		FileReader file=new FileReader("./src//test//resources//commondata.properties");
		 p = new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome":	driver=new ChromeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default:System.out.println("invalid browser..");return;//controll completly out from testcase
		}
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("url"));
	driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity","Regression","master"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	
	}
	public String randomString()
	{
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('a', 'z') // Customize range as needed
	            .get();
	        
	        String randomString = generator.generate(8); // Generate a 10-character random string
	        return randomString;
	}
	public String randomNumber()
	{
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('0', '9') // Customize range as needed
	            .get();
	        
	        String randomString = generator.generate(10); // Generate a 10-character random string
	        return randomString;
	}
	public String randomAlphaNumeric()
	{
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('0', 'z') // Customize range as needed
	            .get();
	        
	        String randomString = generator.generate(5); // Generate a 10-character random string
	        return randomString;
	}
	public String captureScreen(String tname) throws IOException
	{
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetpath = System.getProperty("user.dir")+tname+"_"+".\\screenshots\\"+timestamp;
		File targetFile=new File(targetpath);
		sourceFile.renameTo(targetFile);
		return targetpath;
	}
	

}
