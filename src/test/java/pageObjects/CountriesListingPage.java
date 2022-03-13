package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.acf.framework.helper.Button.ButtonHelper;
import com.acf.framework.helper.TextBox.TextBoxHelper;
import com.acf.framework.helper.Wait.WaitHelper;
import com.acf.framework.link.LinkHelper;
import com.acf.framework.list.ListHelper;

/**
 * @author sukhwinder
 *
 */
public class CountriesListingPage {

	public static WebDriver driver;
	ListHelper listHelper;
	LinkHelper linkHelper;
	TextBoxHelper textBoxHelper;
	ButtonHelper bttHelper;
	WaitHelper waitHelper;
	String countryContinent;
	SoftAssert softAssert = new SoftAssert();

	/** Web Elements */

	By countryList = By.xpath("//table[@name ='Countries']//td[4]");
	By capitalList = By.xpath("//table[@name ='Countries']//td[6]");
	public static By countrySearchTextfield = By.xpath("//input[@placeholder='Filter by country name']");

	public CountriesListingPage(WebDriver driver) {
		this.driver = driver;
		linkHelper = new LinkHelper(driver);
		listHelper = new ListHelper(driver);
		textBoxHelper = new TextBoxHelper(driver);
		bttHelper = new ButtonHelper(driver);
		waitHelper = new WaitHelper(driver);

	}

	public void searchItem(String name) throws InterruptedException {

		ListHelper.selectDataFromList(countryList, name, driver);

	}

	public void searchCapitalList(String name) throws InterruptedException {

		ListHelper.selectDataFromList(capitalList, name, driver);

	}

	public void sendDataInSearchTextfield(String Name) throws InterruptedException {

		textBoxHelper.sendKeys(countrySearchTextfield, Name, driver);

	}

	public void enterDataInSearchTextfield(String name) {

		textBoxHelper.sendKeys(countrySearchTextfield, name, driver);

	}

	public void clickwantToGoIcon(String name) throws InterruptedException {

		waitHelper.implicitWait(driver);

		By wantToGoIcon = By.xpath("//td[contains(text()," + "'" + name + "'" + ")]/following-sibling::td[6]");

		bttHelper.click(wantToGoIcon, driver);

	}

	public void verifyLinkOnListing() throws InterruptedException {

		LinkHelper.verifyLinks(driver);

	}

	public String getCountryName(String name) throws InterruptedException {

		waitHelper.implicitWait(driver);

		String countryName = driver
				.findElement(By.xpath("//td[contains(text()," + "'" + name + "'" + ")]/preceding-sibling::td[2]"))
				.getText();

		return countryName;

	}

	public String getCountryCode(String name) throws InterruptedException {
		waitHelper.implicitWait(driver);

		String countryCode = driver
				.findElement(By.xpath("//td[contains(text()," + "'" + name + "'" + ")]/preceding-sibling::td[3]"))
				.getText();

		return countryCode;

	}

	public String getCountryContinent(String name) throws InterruptedException {

		waitHelper.implicitWait(driver);
		countryContinent = driver
				.findElement(By.xpath("//td[contains(text()," + "'" + name + "'" + ")]/preceding-sibling::td[1]"))
				.getText();

		return countryContinent;

	}

	public String getCountryCurrency(String name) throws InterruptedException {
		waitHelper.implicitWait(driver);

		String countryCurrency = driver
				.findElement(By.xpath("//td[contains(text()," + "'" + name + "'" + ")]/following-sibling::td[1]"))
				.getText();

		return countryCurrency;

	}

	public String getCountrylanguage(String name) throws InterruptedException {

		waitHelper.implicitWait(driver);

		String countryLang = driver
				.findElement(By.xpath("//td[contains(text()," + "'" + name + "'" + ")]/following-sibling::td[2] "))
				.getText();

		return countryLang;
	}

}
