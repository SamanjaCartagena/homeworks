package theInternet;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;

public class Hovers extends PageObjectBase {
	protected Hovers(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	@FindBy(how=How.CLASS_NAME,using="figure")
	WebElement element;
	public Hovers navigate() {
	       super.navigate("/hovers");
			return this;
		}
	int count =0;
	String textUser[] = new String[3];
	public String[] getTextUser() {
		return textUser;
	}
	public void setTextUser(String[] textUser) {
		this.textUser = textUser;
	}
	public void hovered() throws InterruptedException {
		List<WebElement> figure = driver.findElements(By.className("figure"));
		//sSystem.out.println(figure.size());
		
		for(int i=0; i<figure.size(); i++) {
			Thread.sleep(2000);
			figure.get(i).click();
		textUser[i]=figure.get(i).getText();
	//	System.out.println(textUser[i]);
			
		}

	/**	WebElement images= driver.findElement(By.class("figure"))
		Actions action = new Actions(driver);
		
		action.moveToElement(element).build().perform();
		**/
	}
	
}
