package main.java.com.peoplesoft.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.peoplesoft.container.resources.ApplicationConstants;


public class LoginPage extends IPage{

	private WebElement usernameTextBox;
	private WebElement passwordTextBox;
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getUsernameTextBox() {
		setUsernameTextBox();
		return usernameTextBox;
	}

	public WebElement getPasswordTextBox() {
		setPasswordTextBox();
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		setLoginButton();
		return loginButton;
	}

	private void setUsernameTextBox() {
		WebDriverWait wait = new WebDriverWait(super.getDriver(), 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ApplicationConstants.LOCATOR_NAME_USERNAME )));//(super.getDriver().findElement()));
		this.usernameTextBox = super.getDriver().findElement(By.id(ApplicationConstants.LOCATOR_NAME_USERNAME ));
	}

	private void setPasswordTextBox() {
//		WebDriverWait wait = new WebDriverWait(super.getDriver(), 25);
//		wait.until(ExpectedConditions.visibilityOf(super.getDriver().findElement(By.id(ApplicationConstants.LOCATOR_NAME_PASSWORD ))));
		this.passwordTextBox = super.getDriver().findElement(By.id(ApplicationConstants.LOCATOR_NAME_PASSWORD ));
	}

	private void setLoginButton() {
//		WebDriverWait wait = new WebDriverWait(super.getDriver(), 25);
//		wait.until(ExpectedConditions.visibilityOf(super.getDriver().findElement(By.name(ApplicationConstants.LOCATOR_NAME_SUBMIT ))));
		this.loginButton = super.getDriver().findElement(By.name(ApplicationConstants.LOCATOR_NAME_SUBMIT ));
	}
	
	public void login(String username, String password)
	{
	 this.getUsernameTextBox().sendKeys(username);
	 this.getPasswordTextBox().sendKeys(password);
	 this.getLoginButton().click();
	}

}
