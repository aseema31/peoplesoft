package test.java.com.peoplesoft.container.test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

import main.java.com.peoplesoft.container.bean.InvoiceBean;
import main.java.com.peoplesoft.container.bean.SupplierBean;
import main.java.com.peoplesoft.container.bean.VoucherBean;
import main.java.com.peoplesoft.container.pages.AccountPayable;
import main.java.com.peoplesoft.container.pages.HomePage;
import main.java.com.peoplesoft.container.pages.LoginPage;
import main.java.com.peoplesoft.container.pages.VoucherPage;
import main.java.com.peoplesoft.container.resources.ApplicationConstants;
import main.java.com.peoplesoft.container.util.CaptureScreenshotOnFailedTest;

public class PeopleSoftTest {
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentTestInterruptedException testexception;
	private WebDriver driver;
	private LoginPage login;
	private HomePage homePage;
	private AccountPayable accPayable;
	private VoucherPage voucherpage;
	private String path;

	
	@BeforeSuite
	public void setup()
	{

		extent = new ExtentReports("src/resources/Test_Execution_Report.html", true);
		extent.loadConfig(PeopleSoftTest.class.getResource("/resources/extent-config.xml"));
		extent.addSystemInfo("Environment","SIT");

	}
	@BeforeMethod
	public void BeforeMethod(Method method){
		test = extent.startTest( (this.getClass().getSimpleName() +" :: "+  method.getName()),method.getName());
		test.assignAuthor("QABot");
		test.assignCategory("Environment","QA");
	}
	@AfterSuite
	public void AfterSuite(){
		extent.flush();
		extent.close();
	}


	@Parameters({"driverpath"})
	@BeforeTest
	public void setPath(String driverpath)
	{
		System.out.println(driverpath);

		System.setProperty("webdriver.chrome.driver",driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		/*	driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(ApplicationConstants.APPLICATION_URL);*/

		String host = System.getProperty("seleniumHubHost");
		System.out.println("======"+host+"=======");
		try {
			driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(ApplicationConstants.APPLICATION_URL);
	}
	@Test
	public void createVoucher() {

		login = new LoginPage(driver);
		test.log(LogStatus.INFO, "Logged into to Peoplesoft application");
		login.login(ApplicationConstants.USERNAME, ApplicationConstants.PASSWORD);
		homePage = new HomePage(driver);
		test.log(LogStatus.INFO, "Navigating to create voucher page");
		homePage.navigateNavBar(ApplicationConstants.NAVIGATOR);
		accPayable = new AccountPayable(driver);
		test.log(LogStatus.INFO, "Creating regular voucher");
		try {
			accPayable.openRegularEntryVoucher();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		voucherpage = new VoucherPage(driver);
		test.log(LogStatus.INFO, "Enter Voucher data");
		voucherpage.inputVoucherData(getData(),path);
		test.log(LogStatus.PASS, "QABot");
	}
	@AfterTest
	public void takeScreenshotOnFailure()
	{
		
	}
	@AfterMethod
	void tearDown(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			CaptureScreenshotOnFailedTest captureScreenshotOnFailedTest  = new CaptureScreenshotOnFailedTest(driver  );
			captureScreenshotOnFailedTest.captureScreenshotOnFailure(result);
		}
		else
		{
			String directory = "screenshots";
			new File(directory).mkdirs(); // Insure directory is there
		}
		extent.endTest(test);

	}
	@AfterSuite
	public void teardown()
	{
		driver.close();
	}
	private VoucherBean getData()
	{
		Random ran = new Random();
		VoucherBean voucherBean = new VoucherBean();
		voucherBean.setSupplier(new SupplierBean("East Bay Travel\t", ""));
		String str ="Test "+ ran.nextInt();
		voucherBean.setInvoiceBean(new InvoiceBean(str, 100));

		return voucherBean;
	}
}
