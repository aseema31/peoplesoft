package main.java.com.peoplesoft.container.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.peoplesoft.container.resources.ApplicationConstants;
import main.java.com.peoplesoft.container.util.ScrollNavigator;

public class HomePage extends IPage{
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//	private WebElement homeIcon;
	private WebElement navigationIcon;
	private List<WebElement> navigatorList;
	private WebElement notificationIcon;
//	private WebElement actioListIcon;
	private ScrollNavigator scrollNavigator;

	public WebElement getNavigationIcon() {
		setNavigationIcon();
		return navigationIcon;
	}
	public void setNavigationIcon() {
		WebDriverWait wait = new WebDriverWait(super.getDriver(), 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ApplicationConstants.LOCATOR_HOME_NAVIGATOR_ICON )));
		this.navigationIcon = super.getDriver().findElement(By.id(ApplicationConstants.LOCATOR_HOME_NAVIGATOR_ICON ));
	}

	public WebElement getNotificationIcon() {
		return notificationIcon;
	}
	public void setNotificationIcon(WebElement notificationIcon) {
		this.notificationIcon = notificationIcon;
	}

	public void openNavigationBar()
	{
		getNavigationIcon().click();
	}
	public List<WebElement> getNavigator()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.getDriver().switchTo().frame(ApplicationConstants.NAVIGATION_FRAME);
		WebDriverWait wait = new WebDriverWait(super.getDriver(), 25);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("li")));//(By.("PTNUI_NAVBAR")));;//(super.getDriver().findElement(By.id("PTNUI_NAVBAR"))));//(By.("PTNUI_NB_HDRWRK_PTNUI_TITLE")));//(super.getDriver().findElement(By.id("PTNUI_NB_HDRWRK_PTNUI_TITLE"))));
		navigatorList = super.getDriver().findElements(By.tagName("li"));//("//li[starts-with(@id,'PTNUI_DOCK_REC')]"));
		return navigatorList;
	}
	
	public void navigateNavBar(int index)
	{
		openNavigationBar();
		getNavigator();
		navigatorList.get(index).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openMenuEntry(ApplicationConstants.MENU_CONSTANTS_ACCOUNT_PAYABLE);
	}
	private void openMenuEntry(String nameOfEntry)
	{
		//Accounts Payable
		scrollNavigator = new ScrollNavigator(super.getDriver());
		scrollNavigator.navigateToElementInMenu(nameOfEntry);
	}


}
