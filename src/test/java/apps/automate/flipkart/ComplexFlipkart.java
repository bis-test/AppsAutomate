//@author-Biswajit

package apps.automate.flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplexFlipkart {

	public static void main(String[] args) {
		//Launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		System.out.println("The browser launched successfully");

		//go to flipkart
		driver.get("https://www.flipkart.com/");
		driver.getKeyboard().sendKeys(Keys.ESCAPE);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("The flipkart site opened successfully");
		
		
		//Go to the TV menu
		WebElement tvMenu = driver.findElementByXPath("//span[text()='TVs & Appliances']");
		Actions builder = new Actions(driver);
		builder.moveToElement(tvMenu).click().perform();
		System.out.println("The TV menu clicked successfully");
		
        //Click on the samsung
		WebElement samsungMenu = driver.findElementByXPath("(//span[text()='Samsung'])[2]");
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(samsungMenu));
        builder.moveToElement(samsungMenu).click().perform();
        System.out.println("The samsung TV selected successfully");
        
		//set min & max filter
        WebElement minp = driver.findElementByXPath("(//select[@class='a_eCSK'])[1]");
        Select dd1 = new Select(minp);
		dd1.selectByIndex(3);
		
		
		WebElement maxp = driver.findElementByXPath("(//select[@class='a_eCSK'])[2]");
        Select dd2 = new Select(maxp);
		dd2.selectByIndex(3);
		System.out.println("The min & max filters applied successfully");
		
		
		//set screen size filter
		//WebElement screensize = driver.findElementByXPath("//div[@class='dRqIrL _2GQLOX']");
		//screensize.click();
		//builder.moveToElement(screensize).click().perform();
		//System.out.println("The screen size filter applied successfully");
		
		
		//Read the price of first product
		String price= driver.findElementByXPath("(//div[@class='_1vC4OE _2rQ-NK'])[1]").getText();
		String x1 = price.replaceAll("\\D", "");
		System.out.println("The price of product on home page="+x1);

	
		//Click the first product
		WebElement firstprod = driver.findElementByXPath("//div[text()='Samsung Series 6 123cm (49 inch) Full HD Curved LED Smart TV']");
		firstprod.click();
		
		//switch to another window
		Set<String> allwindows = driver.getWindowHandles();	
		List<String> listwindows = new ArrayList<String>();
		listwindows.addAll(allwindows);
		driver.switchTo().window(listwindows.get(1));
		System.out.println("The product page opened successfully");
		
		//Read the price
		String price2= driver.findElementByXPath("//div[@class='_1vC4OE _37U4_g']").getText();
		String y1 = price.replaceAll("\\D", "");
		System.out.println("The price on product page="+y1);
		
		if (x1.equals(y1))
		{
			System.out.println("The price of products are matching");
		}
		else
		{
			System.out.println("The price of products are not matching in home and product page");
		}
		//driver.close();
		driver.switchTo().window(listwindows.get(0));

	
		
		
		//Compare products
		
		WebElement comp1 = driver.findElementByXPath("(//span[text()='Add to Compare'])[1]");
		wait.until(ExpectedConditions.elementToBeClickable(comp1));
		comp1.click();
		
		WebElement comp2 = driver.findElementByXPath("(//span[text()='Add to Compare'])[2]");
		wait.until(ExpectedConditions.elementToBeClickable(comp2));
		comp2.click();
		
		WebElement comp3 = driver.findElementByXPath("//span[text()='COMPARE']");
		wait.until(ExpectedConditions.elementToBeClickable(comp3));
		comp3.click();
		System.out.println("Product compared successfully");
		
		
		//Read prices of compared products
		String cprice1= driver.findElementByXPath("(//div[@class='_1vC4OE'])[1]").getText();
		String cprice2=driver.findElementByXPath("(//div[@class='_1vC4OE'])[2]").getText();
		
		cprice1= cprice1.substring(1,cprice1.length());
		String x = cprice1.replaceAll("\\D", "");
		
		cprice2=cprice2.substring(1,cprice2.length());
		String y= cprice2.replaceAll("\\D", "");
		
		
		int price1= Integer.parseInt(x);
		int price3=Integer.parseInt(y);
		
		//print the lowest price.
		if (price1<price3)
		{
			System.out.println("The lowest price=" +price1);
		}
		else
		{
			System.out.println("The lowest price="+price3);
		}
	    
		
		
	}

}
