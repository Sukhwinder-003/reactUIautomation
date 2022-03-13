package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.acf.framework.helper.Button.ButtonHelper;
import com.acf.framework.helper.Wait.WaitHelper;
import com.acf.framework.link.LinkHelper;

/**
 * @author sukhwinder
 *
 */
public class CountriesDetailPage {

	public WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	LinkHelper linkHelper;
	WaitHelper waitHelper;
	ButtonHelper bttnHelper;

	/** Web Elements */
	public static By setAsVisitedBttn = By
			.xpath("//button[@class='sc-gtssRu sc-dlnjPT sc-iJCRLp gmjWml cuIYFB dZcYVK']");
	public static By nameOnDetail = By.xpath("//div[normalize-space()='Name']/following-sibling::div");
	public static By codeOnDetail = By.xpath("//div[normalize-space()='Code']/following-sibling::div");
	public static By capitalOnDetail = By.xpath("//div[normalize-space()='Capital']/following-sibling::div");
	public static By continentOnDetail = By.xpath("//div[normalize-space()='Continent']/following-sibling::div");
	public static By currencyOnDetail = By.xpath("//div[normalize-space()='Currency']/following-sibling::div");
	public static By languageOnDetail = By.xpath("//div[normalize-space()='Language']/following-sibling::div");

	public CountriesDetailPage(WebDriver driver) {
		this.driver = driver;

		linkHelper = new LinkHelper(driver);
		waitHelper = new WaitHelper(driver);
		bttnHelper = new ButtonHelper(driver);

	}

	
	
	public void clickBttn() throws InterruptedException {

		bttnHelper.click(setAsVisitedBttn, driver);

	}

	public void clickHome() throws InterruptedException {

		bttnHelper.click(LandingPage.homeTab, driver);

	}

	public void verifyLinkOnDetail() throws InterruptedException {

		LinkHelper.verifyLinks(driver);

	}

	public String getNameFromDetail(By locator) throws InterruptedException {

		waitHelper.implicitWait(driver);

		String name = driver.findElement(locator).getText();

		return name;

	}

}
