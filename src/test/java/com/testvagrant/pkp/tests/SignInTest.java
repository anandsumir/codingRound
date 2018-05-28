package com.testvagrant.pkp.tests;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {
    
WebDriver driver;
ChromeOptions opts;

	
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() throws InterruptedException {

        setDriverPath();

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.id("userAccountLink")).click();
        driver.findElement(By.id("SignIn")).click();
        Thread.sleep(3000);
        driver.switchTo().frame("modal_window");
        driver.findElement(By.xpath("//*[@id='signInButton']")).click();
        String errors1 = driver.findElement(By.xpath("//div[@id='errors1']")).getText();
        Thread.sleep(5000);
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
        
        

    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
        	opts = new ChromeOptions();
        	opts.addArguments("--disable-notifications");
        	System.setProperty("webdriver.chrome.driver", "chromedriver");	
        	driver=new ChromeDriver(opts);
            
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }


}
