package com.acf.framework.link;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author sukhwinder
 *
 */
public class LinkHelper {

	public WebDriver driver;

	public LinkHelper(WebDriver driver) {
		this.driver = driver;

	}

	public static void verifyLinks(WebDriver driver) {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("No of links are " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement E1 = links.get(i);
			String url = E1.getAttribute("href");
			verifyLinks(url);
		}

	}

	// This method verifies the response code for the specified URLS

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " a broken link");
			}

			else {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}

}
