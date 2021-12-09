package com.softwaretesting.STQA_sce_project;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.softwaretesting.STQA_sce_project.App;

public class App 
{
	static WebDriver driver=null;
	
	@Test(priority = 1)
	public void doSetUp()
	{
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
         driver=new ChromeDriver();
	}
	
	@Test(priority = 2)
	public void openBrowser()
	{
		
		//driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
	}
	
	@Test(priority = 3)
	public void giveInfo() throws InterruptedException
	{
		WebElement selectTrain=driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
		selectTrain.click();	
		
		

		//code to remove language pop up
		Thread.sleep(3000);
		WebElement lang=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div[8]/span"));
		lang.click();
		System.out.println("Language pop up closed");
		
		
		//code to click on FROM tab
		Thread.sleep(3000);
		WebElement from=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label"));
		from.click();
		
		//code to write city
		Thread.sleep(3000);
		WebElement fromCity=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
		fromCity.sendKeys("Mumbai");
		System.out.println("Key sent at FROM");
		
		
		//code to select written city from dropdown
		Thread.sleep(3000);
		List<WebElement> dropdown=driver.findElements(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]"));
		for(int i=0;i<dropdown.size();i++)
		{
			String City=dropdown.get(i).getText();
			System.out.println("City = "+City);
			if(City.contains("Mumbai"))
			{
				dropdown.get(i).click();
				break;
			}
		}
		
		//code to write city
		Thread.sleep(3000);
		WebElement toCity=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input"));				
		toCity.sendKeys("Pune");
		System.out.println("Key sent at TO");
		
		//code to select written city from dropdown2
		Thread.sleep(3000);
		List<WebElement> dropdown2=driver.findElements(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]"));
		for(int i2=0;i2<dropdown2.size();i2++)
		{
			String City2=dropdown2.get(i2).getText();
			System.out.println("City2="+City2);
			if(City2.contains("Pune"))
			{
				dropdown2.get(i2).click();
				break;
			}
		}	
		
		
		//code to select month
		Thread.sleep(3000);
		WebElement month=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div"));
		WebElement nextMonth=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")); 
		
		while(!(month.getText().contains("December")))
		{
			nextMonth.click();
		}
		
		System.out.println("Month Selected");
		
		
		//code to select date of month
		Thread.sleep(3000);
		List<WebElement> dates=driver.findElements(By.className("DayPicker-Day"));
		for(int i4=0;i4<dates.size();i4++)
		{
			String date=dates.get(i4).getText();
			if(date.equalsIgnoreCase("11"))
			{
				dates.get(i4).click();
				break;
			}
		}
		
		System.out.println("Date Selected");
		
		//code to click on search button
		Thread.sleep(3000);
		WebElement search=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a"));
		search.click();
		System.out.println("Search clicked");
		
		
		//code to select flight
		Thread.sleep(5000);
		WebElement viewPrice=driver.findElement(By.className("appendRight8"));
		viewPrice.click();
		System.out.println("View Price clicked");
		
		
		String firstWindowHandler=driver.getWindowHandle();
		System.out.println("FirstWindowHandler="+firstWindowHandler);
		
		//code to select book now button
		Thread.sleep(5000);
		WebElement book=driver.findElement(By.className("buttonPrimary"));
		book.click();
		System.out.println("Book Now Clicked");
		
		//code to handle newly opened tab
		Thread.sleep(5000);
		Set<String> windowHandles=driver.getWindowHandles();
		for(String handle:windowHandles)
		{
			if(!(handle.equals(firstWindowHandler)))
			{
				driver.switchTo().window(handle);
				
				//code to select security option
				Thread.sleep(3000);
				WebElement security2=driver.findElement(By.xpath("//*[@id=\"INSURANCE\"]/div/div[4]/div[1]/label"));
				security2.click();
				System.out.println("Insurance option clicked");
				
				
				
				//code to click on add adult
				Thread.sleep(3000);
				WebElement addAdult=driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/div[2]/div[3]/button"));
				addAdult.click();
				System.out.println("Add Adult clicked");
				
				//code to enter first name
				Thread.sleep(3000);
				WebElement fname=driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/div[2]/div[2]/div/div[2]/div/div/div[1]/div/input"));
				fname.sendKeys("Rma Sham");
				System.out.println("First name entered");
				
				//code to enter last name
				Thread.sleep(3000);
				WebElement lname=driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/div[2]/div[2]/div/div[2]/div/div/div[2]/div/input"));
				lname.sendKeys("Korav");
				System.out.println("Last name entered");
				
				//code to click on gender
				Thread.sleep(3000);
				WebElement gender=driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/div[2]/div[2]/div/div[2]/div/div/div[3]/div/div/label[2]"));
				gender.click();
				System.out.println("Gender selected");
				
				//code to enter phone number
				Thread.sleep(3000);
				WebElement phone=driver.findElement(By.xpath("//*[@id=\"Mobile No\"]/div/input"));
				phone.sendKeys("1000000000");
				System.out.println("phone entered");
				
				//code to enter email address
				Thread.sleep(3000);
				WebElement mail=driver.findElement(By.xpath("//*[@id=\"Email\"]/div/input"));
				mail.sendKeys("abc123@gmail.com");
				
				
				//code to select suggested mail id 
				Thread.sleep(3000);
				WebElement suggession=driver.findElement(By.xpath("//*[@id=\"Email\"]/div/div/div"));
				suggession.click();
				System.out.println("Email entered");
				
	
				
				
				//code to click on continue btn
				Thread.sleep(3000);
				WebElement cont=driver.findElement(By.xpath("//*[@id=\"mainSection_0\"]/div[6]/button"));
				cont.click();
				System.out.println("Continue clicked");
				
				//code to confirm submitted details
				Thread.sleep(3000);
				WebElement confirm=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div/div[2]/button"));
				confirm.click();
				System.out.println("Confirm clicked");
				
				
				//code to select seat
				Thread.sleep(3000);
				WebElement seat=driver.findElement(By.xpath("//*[@id=\"BOM$NAG$2021-12-11 19:00$G8-344_9B\"]/div"));
				seat.click();
				System.out.println("Seat selected");
				
				//code to move second seat selection image
				Thread.sleep(3000);
				WebElement move=driver.findElement(By.xpath("//*[@id=\"SEATS_N_MEALS\"]/div/div/div/div[2]/button"));
				move.click();
				System.out.println("Moved to select next seat");
				
				//code to select second journey seat
				Thread.sleep(5000);
				WebElement seat2=driver.findElement(By.xpath("//*[@id=\"NAG$PNQ$2021-12-12 06:10$G8-501_3B\"]/div"));
				seat2.click();
				System.out.println("Seat2 selected");
				
				//code to skip add ons
				Thread.sleep(3000);
				WebElement skipAddOn=driver.findElement(By.xpath("//*[@id=\"mainSection_1\"]/div[2]/span"));
				skipAddOn.click();
				System.out.println("Skipped add ons");
				
				
				//code to proceed to pay btn click
				Thread.sleep(3000);
				WebElement proceed=driver.findElement(By.xpath("//*[@id=\"ACKNOWLEDGE_SECTION\"]/div/button"));
				proceed.click();
				System.out.println("Proceed to pay clicked");
				
			}
		}
		
		
		
		
	}

	
	@AfterTest
	public void QuitBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Test completed successfully");
	}
    
}
