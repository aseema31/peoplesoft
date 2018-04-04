package main.java.com.peoplesoft.container.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.peoplesoft.container.bean.VoucherBean;
import main.java.com.peoplesoft.container.resources.ApplicationConstants;

public class VoucherPage extends IPage{

	public VoucherPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private WebElement supplierNameInput;
	private WebElement invoiceNumberInput;
	private WebElement grossAmountInput;
	private WebElement invoiceDateInput;
	private WebElement addButton;

	public void setAddButton()
	{
		this.addButton = super.getDriver().findElement(By.cssSelector(ApplicationConstants.VOUCHER_BUTTON_ADD));
		this.addButton.click();
	}

	public WebElement getSupplierNameInput() {
		this.supplierNameInput = super.getDriver().findElement(By.id(ApplicationConstants.VOUCHER_INPUT_SUPPLIER_NAME));
		return supplierNameInput;
	}
	public void setSupplierNameInput(String supplierNameInput) {
		getSupplierNameInput();
		this.supplierNameInput.sendKeys(supplierNameInput);
	}
	public WebElement getInvoiceNumberInput() {
		this.invoiceNumberInput = super.getDriver().findElement(By.id(ApplicationConstants.VOUCHER_INPUT_INVOICE_NUMBER));
		return invoiceNumberInput;
	}
	public void setInvoiceNumberInput(String invoiceNumberInput) {
		getInvoiceNumberInput();
		this.invoiceNumberInput.sendKeys(invoiceNumberInput);
	}
	public WebElement getGrossAmountInput() {
		this.grossAmountInput = super.getDriver().findElement(By.id(ApplicationConstants.VOUCHER_INPUT_GROSS_INVOICE_AMOUNT));
		return grossAmountInput;
	}
	public void setGrossAmountInput(String amount) {
		getGrossAmountInput();
		this.grossAmountInput.clear();
		this.grossAmountInput.sendKeys(amount);
	}
	public WebElement getInvoiceDateInput() {
		this.invoiceDateInput = super.getDriver().findElement(By.id(ApplicationConstants.VOUCHER_INPUT_INVOICE_DATE));
		return invoiceDateInput;
	}
	public void setInvoiceDateInput(String  date) {
		getInvoiceDateInput();
		this.invoiceDateInput.sendKeys(date);
	}


	public void inputVoucherData(VoucherBean voucherBean,String path)
	{
		super.getDriver().switchTo().frame(ApplicationConstants.NAVIGATION_VOUCHER_FRAME);	
		setSupplierNameInput(voucherBean.getSupplier().getSupplierName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setInvoiceNumberInput(voucherBean.getInvoiceBean().getInvoiceNumber());
		setInvoiceDateInput(voucherBean.getInvoiceBean().getInvoiceDate());
		setGrossAmountInput(Integer.toString(voucherBean.getInvoiceBean().getInvoiceAmount()));
		setAddButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputAccountDetail(ApplicationConstants.ACCOUNT_NUMBER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSaveVoucherButton();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alertAction(path);
	}

	private void inputAccountDetail(String account)
	{
		WebElement account_textbox = super.getDriver().findElement(By.xpath(ApplicationConstants.VOUCHER_INPUT_ACCOUNT_NUMBER));
		account_textbox.sendKeys(account);

	}

	private void alertAction(String path) {
		
//		System.setProperty("", value)();
		/*Screen s = new Screen();
		Pattern p = new Pattern(path+"\\alertok.PNG");
		try {
			s.find(p);
			s.click(p);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
//		}
	
		boolean a = false;
/*		    try {
		        Alert alert = super.getDriver().switchTo().alert();
		        String AlertText = alert.getText();
		        System.out.println(AlertText);
		        alert.accept();
		        a = true;
		    } catch (Exception e) {
		        a = false;
		    }finally {
		        if (a != true) {
		            // take ur screenshot or whatever
		        	 super.getDriver().findElement(By.id("#ICOK")).click();
		        }
		    }*/
	}

	public boolean isAlertPresent(){ 
		Set<String> handles = super.getDriver().getWindowHandles();
		System.out.println(handles.size());
		try{ 
			Alert a = new WebDriverWait(super.getDriver(), 30).until(ExpectedConditions.alertIsPresent());
			if(a!=null){
				System.out.println("Alert is present");
				super.getDriver().switchTo().activeElement().findElement(By.xpath("//*[@id='#ICOK']")).click();;
				return true;
			}else{
				throw new Throwable();
			}
		} 
		catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false; 
		} 

	} 

	private void setSaveVoucherButton()
	{
		List <WebElement> saveButton = super.getDriver().findElements(By.xpath(ApplicationConstants.VOUCHER_SAVE_BUTTON_XPATH_EXPRESSION));
		saveButton.get(0).click();
	}
}
