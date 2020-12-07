package theInternet;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class JavaScriptAlert extends PageObjectBase{
	protected JavaScriptAlert(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
   
	public JavaScriptAlert navigate() {
	       super.navigate("/javascript_alerts");
			return this;
		}
    String text1, text2, text3;
	public void jsAlerts() throws InterruptedException {
		WebElement js1= driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		js1.click();
	
		Thread.sleep(1000);
		Alert a = driver.switchTo().alert();
		text1= a.getText();
		System.out.println(text1);
		a.accept();
		Thread.sleep(1000);
		WebElement js2= driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		
		js2.click();
		Thread.sleep(1000);
		Alert a1 = driver.switchTo().alert();
		text2=a1.getText();
		a1.accept();
		Thread.sleep(1000);
		js2.click();
		Alert a3 = driver.switchTo().alert();
		text3=a3.getText();
		a3.dismiss();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		WebElement js3= driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		js3.click();
		Alert a2 = driver.switchTo().alert();
        
		Thread.sleep(2000);
		a2.accept();
		
	}
}
