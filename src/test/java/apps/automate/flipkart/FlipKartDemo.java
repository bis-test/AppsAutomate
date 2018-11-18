package apps.automate.flipkart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartDemo {

	public static void main(String[] args) {
		//Create webdriver object
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("alokzee007@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("alokamit");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();

		//driver.findElement(By.name("q")).sendKeys("tv");

		//driver.findElement(By.name("q")).sendKeys("Acer Aspire 3 Pentium Quad Core"); 
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Go to the TV menu
		WebElement tvMenu = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(tvMenu).click().perform();
		System.out.println("The TV menu clicked successfully");

		//driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[3]/div/ul/li[2]/ul/li/ul/li[1]/ul/li[8]/a/span")).click();
		//Click on the samsung TV
		WebElement samsungMenu = driver.findElement(By.xpath("(//span[text()='Samsung'])[2]"));
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(samsungMenu));
		builder.moveToElement(samsungMenu).click().perform();
		System.out.println("The samsung TV selected successfully");

	}

}
