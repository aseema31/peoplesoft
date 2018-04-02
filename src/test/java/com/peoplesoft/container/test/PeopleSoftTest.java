package test.java.com.peoplesoft.container.test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.com.peoplesoft.container.bean.InvoiceBean;
import main.java.com.peoplesoft.container.bean.SupplierBean;
import main.java.com.peoplesoft.container.bean.VoucherBean;
import main.java.com.peoplesoft.container.pages.AccountPayable;
import main.java.com.peoplesoft.container.pages.HomePage;
import main.java.com.peoplesoft.container.pages.LoginPage;
import main.java.com.peoplesoft.container.pages.VoucherPage;
import main.java.com.peoplesoft.container.resources.ApplicationConstants;

public class PeopleSoftTest {
	private WebDriver driver;
	private LoginPage login;
	private HomePage homePage;
	private AccountPayable accPayable;
	private VoucherPage voucherpage;
	private String path;

	@BeforeSuite
	public void setup()
	{
		

	}
	@Parameters({"path","driverpath"})
	@BeforeTest
	public void setPath(String path,String driverpath)
	{
		this.path = path;
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ApplicationConstants.APPLICATION_URL);
	}
	@Test
	public void createVoucher() {

		login = new LoginPage(driver);
		login.login(ApplicationConstants.USERNAME, ApplicationConstants.PASSWORD);
		homePage = new HomePage(driver);
		homePage.navigateNavBar(ApplicationConstants.NAVIGATOR);
		accPayable = new AccountPayable(driver);
		try {
			accPayable.openRegularEntryVoucher();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		voucherpage = new VoucherPage(driver);
		voucherpage.inputVoucherData(getData(),path);

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
