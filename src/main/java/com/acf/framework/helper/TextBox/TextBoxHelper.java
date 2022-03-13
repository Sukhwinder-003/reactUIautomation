
package com.acf.framework.helper.TextBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.acf.framework.helper.Wait.WaitHelper;

/**
 * @author sukhwinder
 *
 */
public class TextBoxHelper {

	public WebDriver driver;

	WaitHelper wHelper = new WaitHelper(driver);

	public TextBoxHelper(WebDriver driver) {

		this.driver = driver;

	}

	public void sendKeys(By locator, String value, WebDriver driver) {

		wHelper.waitForElementToBeClickable(locator, driver);

		driver.findElement(locator).sendKeys(value);

	}

	public String getText(By locator, WebDriver driver) {

		String text = driver.findElement(locator).getText();
		return text;

	}

}
