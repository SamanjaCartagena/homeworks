package theInternet;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import framework.PageObjectBase;

public class Addremove extends PageObjectBase {

	protected Addremove(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
   @FindBy(id="content")
   WebElement btn;
	public Addremove navigate() {
	       super.navigate("/add_remove_elements/");
			return this;
		}
	WebElement addBtn;
	public void btnClick() throws InterruptedException {
		for(int i=0; i<10; i++) {
	    addBtn=	driver.findElement(By.xpath("//button[text()='Add Element']"));
	addBtn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

	}
		List<WebElement> dels = driver.findElements(By.xpath("//button[text()='Delete']"));
		System.out.println(dels.size());
		Assert.assertEquals(dels.size(), 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for(int i=0; i<dels.size(); i++) {
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		}
	
	}
	
		
}
