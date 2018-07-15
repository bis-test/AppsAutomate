//@author-Biswajit Sundara
//@date-05/05/2018
//@topic- Selenium log in program


package apps.automate.leaftaps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeaptapsCreateLead {

	public static void main(String[] args) throws InterruptedException
	{

		//Launch browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		//open the website
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();

		//Enter user id
		driver.findElementById("username").sendKeys("DemoSalesManager");

		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");

		//Click the login button
		driver.findElementByClassName("decorativeSubmit").click();


		//Click the crmfsa link
		driver.findElementByLinkText("CRM/SFA").click();


		//Click create account
		driver.findElementByLinkText("Create Lead").click();		


		//Enter the company name
		WebElement cName = driver.findElementByXPath("(//input[@name='companyName'])[2]");
		cName.sendKeys("Alight Solutions");

		//Enter first & last name
		WebElement firstName = driver.findElementByXPath("(//input[@name='firstName'])[3]");
		firstName.sendKeys("Biswajit");

		WebElement lastName = driver.findElementByXPath("(//input[@name='lastName'])[3]");
		lastName.sendKeys("Sundara");

		//select the source from drop downs
		WebElement source= driver.findElementById("createLeadForm_dataSourceId");
		Select dd = new Select(source);
		dd.selectByVisibleText("Conference");


		//select the campaign from drop downs
		WebElement ind1= driver.findElementById("createLeadForm_marketingCampaignId");
		Select dd1 = new Select(ind1);
		dd1.selectByIndex(3);

		
		//select the industry from drop downs
		WebElement ind= driver.findElementById("createLeadForm_industryEnumId");
		Select dd2 = new Select(ind);
		java.util.List<WebElement> alloptions = dd2.getOptions();
		System.out.println("Available industries");
		for (WebElement eachoption : alloptions) 
		{
			System.out.println(eachoption.getText());
		}


		//Select the calendar
		WebElement birthdate = driver.findElementById("createLeadForm_birthDate-button");
		birthdate.click();
        Thread.sleep(3000);

		
		//Navigate to the year. From 2018 go back to 32 years to open 1986
		WebElement yearNav = driver.findElementByXPath("(//div[@unselectable='on'])[3]");
		for (int i=0;i<=31;i++)
			yearNav.click();

        //Navigate to Aug month. The current month is July so click once
		WebElement monthNav = driver.findElementByXPath("(//div[@unselectable='on'])[6]");
		monthNav.click();

		//Navigate to the date 9th.
		WebElement dateNav = driver.findElementByXPath("(//td[@class='day selected']/preceding::td[@class='day weekend'])[3]");
		dateNav.click();

		//Print the birthdate.
		WebElement bdate = driver.findElementByXPath("//input[@name='birthDate']");
		System.out.println("Lead birth date="+ bdate.getAttribute("value"));


		//Click on the create lead button
		WebElement crlead = driver.findElementByXPath("//input[@name='submitButton']");
		crlead.click();
		System.out.println("Lead is created successfully.");


		//Close the browser
		System.out.println("Browser is closed");
		driver.close();

	}
}
