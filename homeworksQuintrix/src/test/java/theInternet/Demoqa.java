package theInternet;

import java.sql.DriverAction;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import framework.PageObjectBase;

public class Demoqa extends PageObjectBase {
	protected Demoqa(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
	  @FindBy(id="firstName")
	   WebElement inputName1;
	  @FindBy(id="lastName")
	  WebElement inputName2;
	  @FindBy(id="userEmail")
	  WebElement email;
	  @FindBy(id="gender-radio-2")
	  WebElement wgender;
	  @FindBy(id="userNumber")
	  WebElement phone;
	  @FindBy(id="dateOfBirthInput")
	  WebElement birthdate;
	  @FindBy(id="city")
	  WebElement selectCity;
	  @FindBy(id="submit")
	  WebElement submitBtn;
		public Demoqa navigate() {
		       super.navigate("/automation-practice-form");
				return this;
			}

		
		public void formFilling() throws InterruptedException {
			inputName1.sendKeys("Samanja");
			inputName2.sendKeys("Cartagena");
			email.sendKeys("c.samanja09@gmail.com");
			 WebElement radio = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radio);
		 
			phone.sendKeys("827346872346723");
		      
			birthdate.sendKeys(Keys.CONTROL, Keys.chord("a"));
			birthdate.sendKeys(Keys.CLEAR);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			birthdate.sendKeys("9 June 1988");
			birthdate.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[@id='subjectsWrapper']/div[2]/div/div/div/div[2]")).sendKeys("Math");
			
		//	driver.findElement(By.xpath("//div[@id='subjectsWrapper']/div[2]/div/div/div")).sendKeys("Math");
			//driver.findElement(By.cssSelector("div[class*='subjects']")).sendKeys("CSC");
			JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 350)", "");
					
			 WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", checkBox1);	
			 
			 WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", checkBox2);		
			 
			 WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", checkBox3);		
			 
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			 WebElement fileUpload= driver.findElement(By.id("uploadPicture"));
			 fileUpload.sendKeys("C:\\Users\\c.samanja09\\Desktop\\ManualTests\\case6.txt");
             
			 
			 
			 WebElement currentAddress= driver.findElement(By.id("currentAddress"));
			 currentAddress.sendKeys("27 37 27 Astoria");
		  
			 
			 WebElement selectCity= driver.findElement(By.id("react-select-4-input"));
			 JavascriptExecutor js1 = (JavascriptExecutor) driver;
			 js1.executeScript("arguments[0].removeAttribute('disabled','disabled')",selectCity);
			 
			 System.out.println("select city is "+selectCity.isEnabled());
			 
			 System.out.println(""+selectCity.getTagName());
			 
           WebElement country = driver.findElement(By.className("css-1g6gooi"));
           country.click();
           
           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 
               selectCity.sendKeys("Delhi");
             //  selectCity.sendKeys(Keys.ENTER);
               
               
               driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          submitBtn.submit();
          
          Thread.sleep(2000);

          
          WebElement closeBtn= driver.findElement(By.xpath("//body/div/div/div/div[3]/button"));
          closeBtn.click();

			
			
		}
}
