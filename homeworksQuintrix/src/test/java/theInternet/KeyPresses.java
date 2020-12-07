package theInternet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class KeyPresses extends PageObjectBase{
	protected KeyPresses(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	String current;
	@FindBy(id="target")
	WebElement shows;
	public KeyPresses navigate() {
	       super.navigate("/key_presses");
            
			return this;
		}
	  String random="wehfdbljhwbjwbed9873";

	char receive[]= new char[random.length()] ;
  public void press() {
	  String random="wehfdbljhwbjwbed9873";
	  for (int i = 0; i < random.length(); i++){
	        char c = random.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        shows.sendKeys(s);
	        
	    }
driver.findElement(By.tagName("form")).submit();
current= driver.getCurrentUrl();
}
  
  
}
