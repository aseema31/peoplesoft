package main.java.com.peoplesoft.container.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ScrollNavigator {

	private WebDriver driver;
	public ScrollNavigator(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickElementWhenClickable(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void navigateToElementInMenu(String locator)
	{
		((JavascriptExecutor) driver).executeScript("var elem = document.getElementById('win7divPTNUI_NB_WRK_GROUPBOX').scrollDown += 100");// elem.scrollTop=elem.scrollHeight;");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=1;i<=10;i++){
			try{
				clickElementWhenClickable(By.linkText(locator), 2);

				break;
			}  
			catch(Exception e){
				js = (JavascriptExecutor) driver;
				js.executeScript("$(\"#ui-id-2\").animate({ scrollBottom: \""+100*i+"px\" })");
			}
		}

	}
}
