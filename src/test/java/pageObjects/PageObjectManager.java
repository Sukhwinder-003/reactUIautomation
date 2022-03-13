package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LandingPage landPage;
	public CountriesListingPage countListingPage;
	public CountriesDetailPage countryDetail;


	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}


	public LandingPage getLandingPage() {

		landPage = new LandingPage(driver);
		return landPage;
	}

	public CountriesListingPage getCountriesListingPage() {

		countListingPage = new CountriesListingPage(driver);
		return countListingPage;
	}

	public CountriesDetailPage getCountriesDetailPage() {

		countryDetail = new CountriesDetailPage(driver);
		return countryDetail;
	}

}
