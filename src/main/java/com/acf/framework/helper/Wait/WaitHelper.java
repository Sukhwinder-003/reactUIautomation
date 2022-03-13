
package com.acf.framework.helper.Wait;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.acf.constants.Constants.WAIT_EXPLICIT_SEC;

/**
 * @author sukhwinder
 *
 */
public class WaitHelper {

	public WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;

	}

	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

	public void hardWait(int timeOutInMiliSec) {
		try {
			Thread.sleep(timeOutInMiliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void implicitWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void waitForElementToBeClickable(By Xpath, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));
	}

	public static void waitForPresenceOfElement(By Xpath, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.presenceOfElementLocated(Xpath));
	}

}
