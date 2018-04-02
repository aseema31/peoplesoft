package main.java.com.peoplesoft.container.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountPayable extends IPage {
	public AccountPayable(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private List<WebElement> accountPayableOptionsList;
	private List<WebElement> voucherOptionsList;
	private List<WebElement> addUpdateOptionsList;

	public List<WebElement> getAccountPayableList()
	{
		setAccountPayableList();
		return this.accountPayableOptionsList;
	}

	private void setAccountPayableList()
	{
		String xpathExpression = "//div[starts-with(@id,'win8divPTNUI_NB_CNTREC_PTNUI_LINK')]";//"PTNUI_NB_CNTREC_PTNUI_LINK";
		this.accountPayableOptionsList = super.getDriver().findElements(By.xpath(xpathExpression));

	}

	private void setVoucherOptionsList()
	{
		String xpathExpression = "//div[starts-with(@id,'win9divPTNUI_NB_CNTREC_PTNUI_LINK')]";//"win9divPTNUI_NB_CNTREC_PTNUI_LINK";
		this.voucherOptionsList = super.getDriver().findElements(By.xpath(xpathExpression));
	}
	private void browseAccountPayable(int index)
	{
		getAccountPayableList().get(index).click();
	}
	private void browseVoucherOptions(int index)
	{
		getVoucherOptionsList().get(index).click();
	}

	private void browseAddUpdateOptions(int index)
	{
		getAddUpdateOptionsList().get(index).click();
	}
	private List<WebElement> getVoucherOptionsList() {
		// TODO Auto-generated method stub
		setVoucherOptionsList();
		return this.voucherOptionsList;
	}

	public List<WebElement> getAddUpdateOptionsList() {
		setAddUpdateOptionsList();
		return addUpdateOptionsList;
	}

	public void setAddUpdateOptionsList() {
		
		String xpathExpression = "//div[starts-with(@id,'win10divPTNUI_NB_CNTREC_PTNUI_LINK')]";//"PTNUI_NB_CNTREC_PTNUI_LINK";
		this.addUpdateOptionsList = super.getDriver().findElements(By.xpath(xpathExpression));
		
	}

	 public void openRegularEntryVoucher() throws InterruptedException
	 {
		 Thread.sleep(5000);
		 browseAccountPayable(0);
		 Thread.sleep(5000);
		 browseVoucherOptions(0);
		 Thread.sleep(5000);
		 browseAddUpdateOptions(0);
		
	 }
}
