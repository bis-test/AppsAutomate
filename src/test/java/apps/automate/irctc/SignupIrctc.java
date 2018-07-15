package apps.automate.irctc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupIrctc {
	
	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		WebElement username = driver.findElementById("userRegistrationForm:userName");
		username.sendKeys("bissun009");
		
		
		WebElement password = driver.findElementById("userRegistrationForm:password");
		password.sendKeys("Hello");
		
		
		WebElement cnfpassword = driver.findElementById("userRegistrationForm:confpasword");
		cnfpassword.sendKeys("Hello");
		
		WebElement secq= driver.findElementById("userRegistrationForm:securityQ");
	    Select dd1 = new Select(secq);
	    dd1.selectByVisibleText("Who was your Childhood hero?");
	    
	    
	    WebElement seca = driver.findElementById("userRegistrationForm:confpasword");
		cnfpassword.sendKeys("Hello");
	    
	}

}
