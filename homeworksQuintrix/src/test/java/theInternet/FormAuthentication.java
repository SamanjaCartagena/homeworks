package theInternet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import framework.PageObjectBase;

public class FormAuthentication extends PageObjectBase {

	protected FormAuthentication(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login")
	WebElement submitBtn;
	
	public FormAuthentication navigate() {
       super.navigate("/login");
		return this;
	}
	
	String crr;
	public void login() {
		
		
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		submitBtn.submit();
		
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		crr= driver.getCurrentUrl();
		
	}
	


}
