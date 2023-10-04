package jenkinsMavenIntegration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestCase {
	
	public By invisible = By.xpath("//h4[contains(text(),'Pumpkin')]");
	
	@Test
	public void launchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\amanchoudhary\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Google"),"Title match");
		
		driver.quit();
	}
	
	@Test
	public void launchBrowser2()
	{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		System.out.println(driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("GreenKart"),"Title match");
		
		driver.quit();

	}
	
	@Test
	public void specialCharSearch()
	{
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String searchItem = "$";
		String expectedMessage = "Sorry, no products matched your search!";

		driver.findElement(By.cssSelector("form input")).clear();
		driver.findElement(By.cssSelector("form input")).sendKeys(searchItem);

		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Sorry, no products matched your search!')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Sorry, no products matched your search!')]")).getText(), expectedMessage);
		driver.quit();
		

	}
	
	@Test
	public void notExisted()
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String searchItem = "Doesn't exist";
  		String expectedMessage = "Sorry, no products matched your search!";

  		driver.findElement(By.cssSelector("form input")).clear();
  		driver.findElement(By.cssSelector("form input")).sendKeys(searchItem);

  		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Sorry, no products matched your search!')]")).getText());
  		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Sorry, no products matched your search!')]")).getText(), expectedMessage);
  		driver.quit();
		
	}
	
	@Test
	public void searchProduct()
	{
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	
		String searchItem = "Mushroom";
		String expectedMessage = "Mushroom - 1 Kg";
		
		driver.findElement(By.cssSelector("form input")).clear();
		driver.findElement(By.cssSelector("form input")).sendKeys(searchItem);

		System.out.println(driver.findElement(By.cssSelector("form input")).getText());
  		Assert.assertEquals(driver.findElement(By.xpath("//h4[normalize-space()='Mushroom - 1 Kg']")).getText(), expectedMessage);
  		driver.quit();


	}
	
	

}
