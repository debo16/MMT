package org.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBooking {
	public static String url ="https://www.makemytrip.com/";
	WebDriver driver;

@BeforeTest
	public void bt() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();

}
@Test
public void HolidayPackage() throws InterruptedException {
	Thread.sleep(10000);
	WebElement holidaypackages = driver.findElement(By.linkText("Holiday Packages"));
	Thread.sleep(5000);
	holidaypackages.click();
	Thread.sleep(10000);
	WebElement departcity = driver.findElement(By.xpath("//*[@for='fromCity']"));
	Thread.sleep(3000);
	departcity.click();
	Thread.sleep(5000);
	List<WebElement> Bangalore = driver.findElements(By.xpath("//li[contains(text(),'Bangalore')]"));
	Thread.sleep(5000);
	Bangalore.get(0).click();

	WebElement destcity = driver.findElement(By.id("toCity"));
	Thread.sleep(5000);
	destcity.click();
	Thread.sleep(5000);
	WebElement search = driver.findElement(By.xpath("//input[@class='dest-search-input']"));
	Thread.sleep(5000);
	search.click();
	Thread.sleep(15000);
	search.sendKeys("Singapore");
	Thread.sleep(9000);
	List<WebElement> Singapore = driver.findElements(By.xpath("//div[@class='dest-city-name']"));
	Thread.sleep(8000);
	Singapore.get(0).click();
	Thread.sleep(5000);
	List<WebElement> pickdate = driver.findElements(By.xpath("//p[contains(text(),'18')]"));
	Thread.sleep(5000);
	pickdate.get(1).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@class='applyBtn']")).click();
	Thread.sleep(5000);

	WebElement filter = driver.findElement(By.xpath("//div[(text() ='Filters')]"));
	Thread.sleep(1000);
	filter.click();


	driver.findElement(By.xpath("//button[@id='search_button']")).click();
	Thread.sleep(15000);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3500)");
	Thread.sleep(10000);

	js.executeScript("window.scrollBy(0,900)");
	Thread.sleep(10000);



	List<WebElement> element = driver.findElements(By.xpath("//button[@class='slick-arrow slick-next ']"));
	Thread.sleep(4000);
	element.get(4).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//h4[contains(text(),'Relaxing Singapore Getaway')]")).click();
	Thread.sleep(20000);


	//Loop through until we find a new window handle
	String originalWindow = driver.getWindowHandle();

	for (String windowHandle : driver.getWindowHandles()) {
	    if(!originalWindow.contentEquals(windowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	}
	js.executeScript("window.scrollBy(0,500)");

	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[3]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@id='change']")).click();
	Thread.sleep(25000);


	driver.findElement(By.xpath("//*[@id='starRatingContainer_star_rating']/div/div[3]/span[1]")).click();
	Thread.sleep(5000);


	List<WebElement> element1 = driver.findElements(By.xpath("//span[text()='Select']"));
	Thread.sleep(3000);

	element1.get(0).click();
	Thread.sleep(5000);

	driver.findElement(By.xpath("//p[text()='Update Package']")).click();

	Thread.sleep(10000);


	WebElement e = driver.findElement(By.xpath("//div[@class='hotel-row-body']"));
	Thread.sleep(3000);

	WebElement eleSelected1= driver.findElement(By.xpath("//div[@class='hotel-row-body']"));
	String c = eleSelected1.getText();


	Assert.assertTrue( c.contains("PARKROYAL COLLECTION Pickering, Singapore"));
	WebElement actionplan = driver.findElement(By.xpath("//*[@id=\"initeraryNav\"]/li[1]"));
	Thread.sleep(3000);
	actionplan.click();
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(0,800)");
	List<WebElement> activity = driver.findElements(By.xpath("//*[@id=\"chooseAndAddBtn\"]"));
	Thread.sleep(3000);
	activity.get(0).click();
	Thread.sleep(3000);
	WebElement searchact = driver.findElement(By.xpath("//input[@placeholder='Search by Activity name']"));
	Thread.sleep(2000);
	searchact.sendKeys("mirr");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'Select')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[contains(text(),'Update Package')]")).click();


	Thread.sleep(5000);
	String activity2 = driver.findElement(By.xpath("//p[@class='activity-row-details-title']")).getText();
	Assert.assertTrue( activity2.contains("Canopy Park & Mirror Maze"));
	driver.quit();
}

}

