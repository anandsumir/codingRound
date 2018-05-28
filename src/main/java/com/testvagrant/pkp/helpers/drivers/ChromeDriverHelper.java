package com.testvagrant.pkp.helpers.drivers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.testvagrant.pkp.builders.BuilderFactory;
import com.testvagrant.pkp.utils.CommonUtils;

public class ChromeDriverHelper implements Driver {
	
	private WebDriver chromeDriver;
	
	static {
		CommonUtils.setDriverPath();
	}
	
	public ChromeDriverHelper() {
		DesiredCapabilities capabilities = BuilderFactory.getCapabilitiesBuilder()
				.buildDefaultChromeCapabiliteis()
				.build();
		ChromeOptions options = BuilderFactory.getChromeOptionsBuilder()
				.fromCapabilities(capabilities)
				.withArgument("--disable-notifications")
				.withArgument("--start-maximized")
				.withArgument("--test-type")
				.withArgument("--enable-strict-powerful-feature-restrictions")
				.build();
		
		this.chromeDriver = new ChromeDriver(options);
		this.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.chromeDriver.manage().window().fullscreen();
	}
	
	public void openUrl(String url) {
		this.chromeDriver.get(url);
	}
	
	public void click(By by) {
		WebElement element = this.chromeDriver.findElement(by);
		element.click();
	}
	
	public void clear(By by) {
		WebElement element = this.chromeDriver.findElement(by);
		element.clear();
	}
	
	public void sendKeys(By by, String value) {
		WebElement element = this.chromeDriver.findElement(by);
		element.sendKeys(value);
	}
	
	public String getText(By by) {
		WebElement element = this.chromeDriver.findElement(by);
		return element.getText();
	}
	
	public WebElement findElement(By by) {
		return this.chromeDriver.findElement(by);
	}
	
	public List<WebElement> findElements(By by) {
		return this.chromeDriver.findElements(by);
	}
	
	public boolean isElementPresent(By by) {
		try {
            this.chromeDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
	}
	
	public Select getSelectFromElement(WebElement element) {
		return new Select(element);
	}
	
	public void quit() {
		this.chromeDriver.quit();
	}

	public void switchToFrame(String by) {
	//	WebElement form = this.chromeDriver.findElement(by);
        this.chromeDriver.switchTo().frame(by);		
	}
	
	public void scrollTo(By by) {
		WebElement element = this.chromeDriver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)chromeDriver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'end', inline: 'nearest'});", element);
	}
	

}
