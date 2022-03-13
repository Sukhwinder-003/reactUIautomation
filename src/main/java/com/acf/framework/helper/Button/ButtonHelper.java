
package com.acf.framework.helper.Button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acf.framework.helper.Wait.WaitHelper;


/**
 * @author sukhwinder
 *
 */
public class ButtonHelper {

	public WebDriver driver;

	
	WaitHelper wHelper = new WaitHelper(driver);


	public ButtonHelper(WebDriver driver) {

		this.driver = driver;
	}

	public void click(By locator, WebDriver driver) {
		

		wHelper.waitForElementToBeClickable(locator, driver);
		click(driver.findElement(locator));
	}

	public void click(WebElement element) {
		element.click();
	}
}
