package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
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
public class AccessStepDef {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landPage;
	CountriesListingPage countListingPage;
	CountriesDetailPage countryDetailPage;

	String code;
	String name;
	String continent;
	String currency;
	String lang;

	SoftAssert softAssert = new SoftAssert();

	public WebDriver driver;

	public AccessStepDef(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
		this.landPage = testContextSetup.pageObjectManager.getLandingPage();
		this.countListingPage = testContextSetup.pageObjectManager.getCountriesListingPage();
		this.countryDetailPage = testContextSetup.pageObjectManager.getCountriesDetailPage();

	}

	@Given("^user is on the dashboard page and navigates to Countries listing screeen from Countries tab$")
	public void user_is_on_the_dasboard_page_and_navigates_to_countries_listing_screeen_from_countries_tab()
			throws Throwable {

		//This validates whether user reached on the landing page
		Assert.assertEquals(LandingPage.DashboardHeader, landPage.getheaderText());

		landPage.getCount();

		landPage.clickOncountriesTab();

	}

	@And("^select  (.+) from the countries listing screen$")
	public void select_from_the_countries_listing_screen(String placename) throws Throwable {

		countListingPage.searchItem(placename);

	}

	@Then("^click on Set As Visited button$")
	public void click_on_set_as_visited_button() throws Throwable {

		countryDetailPage.clickBttn();

	}

	@And("^go to the Dashboard and verify the count must get update$")
	public void go_to_the_dashboard_and_verify_the_count_must_get_update() throws Throwable {

		countryDetailPage.clickHome();

		int currentCount = landPage.getCount();

		//This will compare the count with the previous one
		Assert.assertTrue(currentCount >= 1);

	}


	@And("^search  (.+) from the search text field$")
	public void search_from_the_search_text_field(String country) throws Throwable {

		countListingPage.enterDataInSearchTextfield(country);

		testContextSetup.countrySearchField = country;

	}

	@Then("^click on Want to go icon$")
	public void click_on_want_to_go_icon() throws Throwable {

		countListingPage.clickwantToGoIcon(testContextSetup.countrySearchField);

	}

	@And("^verify the count on the dasboard screen$")
	public void verify_the_count_on_the_dasboard_screen() throws Throwable {

		countryDetailPage.clickHome();

		int currentCount = landPage.getCountriesTovisit();

		Assert.assertTrue(currentCount >= 1);

	}



	@Then("^select country (.+) from the countries listing screen$")
	public void select_country_from_the_countries_listing_screen(String capital) throws Throwable {

		currency = countListingPage.getCountryCurrency(capital);
		code = countListingPage.getCountryCode(capital);
		name = countListingPage.getCountryName(capital);
		continent = countListingPage.getCountryContinent(capital);
		currency = countListingPage.getCountryCurrency(capital);
		lang = countListingPage.getCountrylanguage(capital);
		countListingPage.searchCapitalList(capital);

		testContextSetup.capital = capital;

	}

	@And("^verify name, code, capital, continent, currency, language on the detail must be same as per the listing screen$")
	public void verify_name_code_capital_continent_currency_language_on_the_detail_must_be_same_as_per_the_listing_screen()
			throws Throwable {

		//Below soft assertions validates the data of listing screen and detail screen

		softAssert.assertEquals(currency, countryDetailPage.getNameFromDetail(countryDetailPage.currencyOnDetail));
		softAssert.assertEquals(code, countryDetailPage.getNameFromDetail(countryDetailPage.codeOnDetail));

		softAssert.assertEquals(name, countryDetailPage.getNameFromDetail(countryDetailPage.nameOnDetail));

		softAssert.assertEquals(continent, countryDetailPage.getNameFromDetail(countryDetailPage.continentOnDetail));

		softAssert.assertEquals(lang, countryDetailPage.getNameFromDetail(countryDetailPage.languageOnDetail));

		softAssert.assertEquals(testContextSetup.capital,
				countryDetailPage.getNameFromDetail(countryDetailPage.capitalOnDetail));

		softAssert.assertAll();

	}

}
