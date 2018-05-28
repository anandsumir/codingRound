package com.testvagrant.pkp.cleartrip.screens;

import static com.testvagrant.pkp.helpers.drivers.DriverHelperFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlightBookingScreen {
	
	private String idOneWayRadioButton = "OneWay";
	private String idFromText = "FromTag";
	private String idToText = "ToTag";
	private String idSearchButton = "SearchBtn";
	private String idOriginOptions = "ui-id-1";
	private String idDestinationOptions = "ui-id-2";
	private String xpathDatePickerTable = "//*[@id='ui-datepicker-div']/div[1]/table/tbody";
	
	public void submitFlightSearch(String origin, String destination) {
		getDriver().click(By.id(idOneWayRadioButton));
		getDriver().click(By.id(idFromText));
		getDriver().sendKeys(By.id(idFromText), origin);
		List<WebElement> originOptions = getDriver().findElement(By.id(idOriginOptions)).findElements(By.tagName("li"));
		originOptions.get(0).click();
		getDriver().click(By.id(idToText));
		getDriver().sendKeys(By.id(idToText), destination);
		List<WebElement> destinationOptions = getDriver().findElement(By.id(idDestinationOptions)).findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		WebElement element = getDriver().findElement(By.xpath(xpathDatePickerTable));
		List<WebElement> allCells = element.findElements(By.tagName("td"));
		System.out.println(allCells.size());
		for (WebElement cell : allCells) {
			System.out.println(cell.getAttribute("data-handler"));
			String dataHanlderAttribute = cell.getAttribute("data-handler");
			System.out.println(dataHanlderAttribute);
			if (null != dataHanlderAttribute && dataHanlderAttribute.equals("selectDay")) {
				System.out.println("Inside if condition");
				System.out.println("/n" + getDriver().findElement(By.xpath("//td/a[contains(text(),'29')]")).getText());
				getDriver().findElement(By.xpath("//td/a[contains(text(),'29')]")).click();;
				//System.out.println("/n" + cell.getText());
				//cell.click();
				break;
			}
		}
	//	getDriver().click(By.xpath(xpathDatePickerTable)); 
	    getDriver().click(By.id(idSearchButton)); 
	}


}
