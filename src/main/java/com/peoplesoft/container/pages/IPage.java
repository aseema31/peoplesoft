package main.java.com.peoplesoft.container.pages;

import org.openqa.selenium.WebDriver;

public class IPage {
	private WebDriver driver;
	
 public IPage(WebDriver driver)
 {
	 this.driver = driver;
 }

public WebDriver getDriver() {
	return driver;
}
 
}
