package theInternet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;

public class DisappearingElements extends PageObjectBase {

	protected DisappearingElements(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
   
	public DisappearingElements navigate() {
	       super.navigate("/disappearing_elements");
			return this;
		}
	int count =0;
	public int btnClick() throws InterruptedException {
		WebElement gallery;
	
		List<WebElement> li = driver.findElements(By.tagName("li"));
      //  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		if(li.size()<5) {
			driver.navigate().refresh();
		}
		else {
         gallery =driver.findElement(By.xpath("//a[text()='Gallery']"));
    	 
    	 
    		gallery.click();
    		count++;
    
		}	
    	  
    	 return count;
        
	}		
}
