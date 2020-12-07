package theInternet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import framework.PageObjectBase;

public class Entry extends PageObjectBase {

	protected Entry(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
  String closeBtn;
  WebElement thirdChild;
	public Entry navigate() {
	       super.navigate("/entry_ad");
			return this;
		}




	public void textBox() throws InterruptedException {
	// WebElement restart=driver.findElement(By.xpath("//div[@id='content']/div/p[3]/a"));
		 thirdChild = driver.findElement(By.xpath("//div[@class='modal']/div[3]/p"));
		 closeBtn= thirdChild.getText();
		 
		System.out.println(closeBtn);
		Thread.sleep(2000);
		thirdChild.click();
	//	restart.click();
		
	}
	
	
}