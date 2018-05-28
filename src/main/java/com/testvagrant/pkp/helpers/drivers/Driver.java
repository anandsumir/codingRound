package com.testvagrant.pkp.helpers.drivers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface Driver {
	
	public void openUrl(String url);
	public void click(By by);
	public void clear(By by);
	public void sendKeys(By by, String value);
	public String getText(By by);
	public WebElement findElement(By by);
	public List<WebElement> findElements(By by);
	public boolean isElementPresent(By by);
	public Select getSelectFromElement(WebElement element);
	public void quit();
	public void switchToFrame(String by);
	public void scrollTo(By by);

}
