package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;

    public WebDriver initilizeDriver()throws FileNotFoundException, IOException {
        Properties p= new Properties();

        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        p.load(fis);
        if(p.getProperty("browser").equalsIgnoreCase("chrome")){
            String projectPath= System.getProperty("user.dir");
            System.out.println(projectPath);
            String driver_Path=System.getProperty("user.dir")+"\\Driver\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver",driver_Path);
             driver= new ChromeDriver(); }
        return  driver;
    }

//    public static ExtentReports getReportObject()
//    {
//
//        String path =System.getProperty("user.dir")+"\\reports\\index.html";
//        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//        reporter.config().setReportName("Web Automation Results");
//        reporter.config().setDocumentTitle("Test Results");
//
//        extent =new ExtentReports();
//        extent.attachReporter(reporter);
//        extent.setSystemInfo("Tester", "Rahul Shetty");
//        return extent;
//
//    }



    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;


    }



}
