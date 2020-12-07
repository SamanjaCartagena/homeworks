package theInternet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;

public class Frames extends PageObjectBase {
	protected Frames(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
	public Frames navigate() {
	       super.navigate("/frames");
			return this;
		}
	String title1;
	public void checkFrame() throws InterruptedException  {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//body")).sendKeys("Hi");
     
    
	}
}
