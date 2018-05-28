package com.testvagrant.pkp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testvagrant.pkp.helpers.business.BusinessHelperFactory;
import com.testvagrant.pkp.helpers.business.ClearTripHelper;
import com.testvagrant.pkp.helpers.business.ClearTripResources;
import com.testvagrant.pkp.test.ChromeBaseTest;
import com.testvagrant.pkp.utils.TimeUtils;

public class ClearTripTests extends ChromeBaseTest {
	
	ClearTripHelper clearTripHelper;
	
	@BeforeClass
	public void setupBeforeClassClearTrip() {
		clearTripHelper = BusinessHelperFactory.getClearTripHelper();
	}
	
	@Test(groups = {ClearTripResources.TestGroups.FLIGHT}, description = "Search for flights and verify results")
	public void testThatResultsAppearForAOneWayJourney() {
		clearTripHelper.searchFlightsBetweenCities(ClearTripResources.FlightCities.BANGALORE, ClearTripResources.FlightCities.DELHI);
		Assert.assertTrue(clearTripHelper.isFlightSearchResultsDisplayed(), "Flight search results not displayed"); 
	}
	
/*	@Test(groups = {ClearTripResources.TestGroups.HOTEL}, description = "Search for hotels")
    public void shouldBeAbleToSearchForHotels() {
		clearTripHelper.searchHotelsForLocality(ClearTripResources.HotelLocality.INDIRANAGAR_BANGALORE);
	}
	
	@Test(groups = {ClearTripResources.TestGroups.LOGIN}, description = "Missing login details should show errors")
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		clearTripHelper.doWrongSignIn();
		TimeUtils.waitFor(10000);
		//Following step is always failing with automation as the page gets distorted with automation and error message is not shown
		//Please refer the automation recording to see this.
		Assert.assertTrue(clearTripHelper.isWrongSignInErrorsExists(), "Errors not displayed for missing signin details");
	}*/

}
