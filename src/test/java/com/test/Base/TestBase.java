package com.test.Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.io.*;
public class TestBase {
	public static WebDriver driver ;
	public WebDriverWait explicitWait;
	final int  Page_load_Time=30;
	final int IMPLICIT_WAIT=10;
	final int EXPLICIT_WAIT=10;
		Properties prop;
	public Logger logger=LogManager.getLogger(TestBase.class);
	

	 public TestBase() {
		 prop=new Properties();
		 try {
	//		 String prjPath=System.getProperty("user.dir ");
		FileInputStream fIn=new FileInputStream("C:\\Users\\Owner\\Desktop\\home work folder\\Shamshinur\\src\\test\\java\\config.properties")	;
		try {
			prop.load(fIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		 	
	}
	 public void initial(String browser ) throws IOException {
		 driver=getBrowser(browser);
	    driver.manage().window().maximize();
	    logger.info("Window maximized");
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Page_load_Time,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
		 driver.get(prop.getProperty("URL"));
         takeScreenshot("Homepagesceenshot");
		 
	 }
     private WebDriver getBrowser(String browsernm) {
    	 
    	 WebDriver crntDriver=null;
    	 String pathString=System.getProperty("user.dir");
    	 if(browsernm.equalsIgnoreCase("chrome")) {
    		 System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
    		 crntDriver=new ChromeDriver();
    	 }else if(browsernm.equalsIgnoreCase("Internet Explore")) {
    		 System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
    		 crntDriver=new InternetExplorerDriver();
    		 
    	 } else if(browsernm.equalsIgnoreCase("Edge")) {
    		 System.setProperty("webdriver.chrome.driver","c:\\selenium\\edgedriver.exe");
    		 crntDriver=new EdgeDriver();
    	 }
		return crntDriver;
 
     }
     public void quitApp() {
    	 driver.close();
     }
     public   void takeScreenshot(String outFileName) throws IOException {
    	 TakesScreenshot screenshot=(TakesScreenshot)driver;
    File srFile =	 screenshot.getScreenshotAs(OutputType.FILE);
    File dFile=new
    		File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\test\\ScreenShot"+outFileName+".png");
     FileUtils.copyFile(srFile, dFile);
     }
}
