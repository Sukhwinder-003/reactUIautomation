package stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.acf.framework.link.LinkHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.CountriesDetailPage;
import pageObjects.CountriesListingPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

/**
 * @author sukhwinder
 *
 */
public class LinkStepDef {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landPage;
	CountriesListingPage countListingPage;
	CountriesDetailPage countryDetailPage;

	public WebDriver driver;

	LinkHelper linkHelper = new LinkHelper(driver);

	public LinkStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landPage = testContextSetup.pageObjectManager.getLandingPage();
		this.countListingPage = testContextSetup.pageObjectManager.getCountriesListingPage();
		this.countryDetailPage = testContextSetup.pageObjectManager.getCountriesDetailPage();

	}

	@Given("^user is on the dasboard page and verify the link$")
	public void user_is_on_the_dasboard_page_and_verify_the_link() throws Throwable {

		//calling this method to verify link under Dashboard screen
		landPage.verifyLinkOnDashboard();

	}

	@Then("^go to country listing screen verify the link$")
	public void go_to_country_listing_screen_verify_the_link() throws Throwable {

		landPage.clickOncountriesTab();

		//calling this method to verify link under listing screen
		countListingPage.verifyLinkOnListing();

	}

	@And("^navigates to (.+) capital and again verify the link$")
	public void navigates_to_capital_and_again_verify_the_link(String capital) throws Throwable {

		countListingPage.searchCapitalList(capital);
		
		//calling this method to verify link under couuntry detail screen
		countryDetailPage.verifyLinkOnDetail();

	}

}
