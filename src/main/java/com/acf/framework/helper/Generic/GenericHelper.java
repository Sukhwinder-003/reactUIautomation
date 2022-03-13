
package com.acf.framework.helper.Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericHelper {

	public WebDriver driver;

	public GenericHelper(WebDriver driver) {
		this.driver = driver;
	}

	// Below verification is to validate when element is displayed

	public boolean IsElementPresentQuick(WebElement locator) {
		boolean flag;
		try {
			boolean abc = locator.isDisplayed();
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			flag = locator.isDisplayed();
		} catch (Exception e) {
			flag = locator.isDisplayed();
		}
		return flag;
	}

}
