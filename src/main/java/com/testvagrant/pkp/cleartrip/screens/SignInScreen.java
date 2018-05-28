package com.testvagrant.pkp.cleartrip.screens;

import static com.testvagrant.pkp.helpers.drivers.DriverHelperFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.testvagrant.pkp.helpers.business.ClearTripResources;

public class SignInScreen {

	private String idSignInButton = "signInButton";
	private String idErrorsHead = "errors1";
	private String idLoginForm = "modal_window";
	
	public void submitEmptySignIn() {
	    getDriver().findElement(By.xpath("//*[@id='signInButton']")).click();
	    getDriver().switchToFrame(idLoginForm); 
	    getDriver().scrollTo(By.xpath("//*[@id='signInButton']"));
	    getDriver().findElement(By.xpath("//*[@id='signInButton']")).click();
		//getDriver().click(By.id(idSignInButton));
		//js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'end', inline: 'nearest'});", getDriver().findElement(By.id("idSignInButton")));
		
	}
	
	public boolean isSignInErrorsExist() {
		String errors = getDriver().getText(By.id(idErrorsHead));
		return errors.contains(ClearTripResources.Errors.SIGN_IN_ERRORS);
	}
	
	public void switchToLoginFrame() {
		getDriver().switchToFrame(idLoginForm); 
	}
	
}
