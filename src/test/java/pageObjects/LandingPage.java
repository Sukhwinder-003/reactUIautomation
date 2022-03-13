package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import com.acf.framework.helper.Button.ButtonHelper;
import com.acf.framework.helper.Generic.GenericHelper;
import com.acf.framework.link.LinkHelper;

/**
 * @author sukhwinder
 *
 */
public class LandingPage {

	public WebDriver driver;
	public static int count;

	public static String DashboardHeader = "Dashboard";

	SoftAssert softAssert = new SoftAssert();

	ButtonHelper bttHelper;
	LinkHelper linkHelper;
	GenericHelper gHelper;


	/** Web Elements */

	@FindBy(xpath = "//*[contains(text(), 'Dashboard')]")
	@CacheLookup
	private WebElement dashboardHeading;

	public static By countriesTab = By.xpath("//a[@title='Countries']");
	public static By homeTab = By.xpath("//a[@title='Home']");
	public static By countriesvisitedCount = By
			.xpath("//*[contains(text(), 'Countries visited')]/preceding-sibling::div");
	public static By countriesTovisitCount = By
			.xpath("//*[contains(text(), 'Countries to visit')]/preceding-sibling::div");
	public static By headerDashboard = By.xpath("//h3[normalize-space()='Dashboard']");

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		bttHelper = new ButtonHelper(driver);
		linkHelper = new LinkHelper(driver);
		gHelper = new GenericHelper(this.driver);


	}

	public String getheaderText() {

		String text = driver.findElement(headerDashboard).getText();

		return text;

	}

	public int getCount() {

		String count = driver.findElement(countriesvisitedCount).getText();

		int foo = Integer.parseInt(count);

		return foo;

	}

	public int getCountriesTovisit() {

		String count = driver.findElement(countriesTovisitCount).getText();

		int foo = Integer.parseInt(count);

		return foo;

	}

	public void clickOncountriesTab() throws InterruptedException {

		bttHelper.click(countriesTab, driver);

	}

	public boolean verifyLandingPage() {

		return gHelper.IsElementPresentQuick(dashboardHeading);
	}

	public void verifyLinkOnDashboard() throws InterruptedException {

		LinkHelper.verifyLinks(driver);

	}

}
