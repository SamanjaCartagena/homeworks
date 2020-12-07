package theInternet;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class ContextMenu extends PageObjectBase{

	protected ContextMenu(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="hot-spot")
	WebElement box;
	public ContextMenu navigate() {
	       super.navigate("/context_menu");
			return this;
		}
	String alertString;
	public void popUp() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.contextClick(box).perform();
		Thread.sleep(400);
		Alert a = driver.switchTo().alert();
		 alertString = a.getText();
		
		a.accept();
	}
	public String getAlertString() {
		return alertString;
	}
	public void setAlertString(String alertString) {
		this.alertString = alertString;
	}
	
}
