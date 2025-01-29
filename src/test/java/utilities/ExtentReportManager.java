package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseClass;

public class ExtentReportManager implements ITestListener {
	
public ExtentSparkReporter sparkReporter;
public ExtentReports reports;
public ExtentTest test;
String repName;
	    
	    
	    public void onStart(ITestContext context) {
	    	String timestamp= new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());//creating current time
	    	repName="Test-Report"+timestamp+".html";
	    	sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specifing location
	    	sparkReporter.config().setDocumentTitle("Opencart Automation Report");
	    	sparkReporter.config().setReportName("opencart funtional testing");
	    	sparkReporter.config().setTheme(Theme.STANDARD);
	    	reports=new ExtentReports();
	    	reports.attachReporter(sparkReporter);
	    	reports.setSystemInfo("Application", "Opencart");
	    	reports.setSystemInfo("module", "Admin");
	    	reports.setSystemInfo("submodule", "customer");
	    	reports.setSystemInfo("UserName",System.getProperty("user.name"));
	    	reports.setSystemInfo("Environment", "QA");
	    	String os=context.getCurrentXmlTest().getParameter("os");
	    	reports.setSystemInfo("operating system", os);
	    	String browser=context.getCurrentXmlTest().getParameter("browser");
	    	reports.setSystemInfo("Browser", browser);
	    	List<String> includedgroups = context.getCurrentXmlTest().getIncludedGroups();
	    	if(!includedgroups.isEmpty())
	    	{
	    		reports.setSystemInfo("Groups", includedgroups.toString());
	    	}
	    	
	        
	    }

	   
	   
	   
	    public void onTestSuccess(ITestResult result) {
		    	test=reports.createTest(result.getClass().getName());
		    	test.assignCategory(result.getMethod().getGroups());
		    	test.log(Status.PASS,result.getName()+"got successfully executed");
		      
	    }

	   
	    public void onTestFailure(ITestResult result) {
	    	test=reports.createTest(result.getClass().getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.log(Status.FAIL,result.getName()+ "got failed");
	    	test.log(Status.INFO,result.getThrowable().getMessage());
	    try	{String imgpath = new BaseClass().captureScreen(result.getName());
	    	test.addScreenCaptureFromPath(imgpath);}
	    catch(IOException e)
	    {
	    		e.printStackTrace();    }
	        
	    }

	    
	    public void onTestSkipped(ITestResult result) {
	    	test=reports.createTest(result.getClass().getName());
	    	test.assignCategory(result.getMethod().getGroups());
	    	test.log(Status.SKIP,result.getName()+"got skipped");
	    	test.log(Status.INFO,result.getThrowable().getMessage());
	        
	    }

	   
	    public void onFinish(ITestContext context) {
	    	reports.flush();
	    	String extentReportpath = System.getProperty("user.dir")+".\\reports\\"+repName;
	    	File extentReport=new File(extentReportpath);
	    	try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        
	    }
	}



