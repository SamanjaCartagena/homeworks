package theInternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class MultipleWindows extends PageObjectBase{

	protected MultipleWindows(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
	public MultipleWindows navigate() {
	       super.navigate("/windows");
               
			return this;
		}
	String t;
	public void mWindows() {
		WebElement clickLink = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickLink.click();
	    driver.navigate().to("http://the-internet.herokuapp.com/windows/new");
	   
	    	t=driver.getTitle();
	    
	    
		
	}
}
