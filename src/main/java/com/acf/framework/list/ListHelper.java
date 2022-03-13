package com.acf.framework.list;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acf.framework.helper.Wait.WaitHelper;


/**
 * @author sukhwinder
 *
 */
public class ListHelper {

	public WebDriver driver;

	public ListHelper(WebDriver driver) {
		this.driver = driver;
	}

	
	// This method will return the list from the datatable and click on the desired parameter

	public static void selectDataFromList(By List, String Text, WebDriver driver) throws InterruptedException {

		WaitHelper.waitForPresenceOfElement(List, driver);
		
	
		List<WebElement> list = driver.findElements(List);

		for (int i = 0; i < list.size(); i++)

		{

			if (list.get(i).getText().contains(Text)) {

				list.get(i).click();

				Thread.sleep(3000);

				break;

			}

		}

	}

}
