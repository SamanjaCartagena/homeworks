package theInternet;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import framework.PageObjectBase;

public class HorizontalSlider extends PageObjectBase{
	
	protected HorizontalSlider(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	
	public HorizontalSlider navigate() {
	       super.navigate("/horizontal_slider");
			return this;
		}
   String num;
	public void slide() {
		WebElement min= driver.findElement(By.xpath("//input[@min='0.0']"));
		
		WebElement max= driver.findElement(By.xpath("//input[@max='5.0']"));
	
	WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
	
	Actions a = new Actions(driver);
     Action action=(Action)a.dragAndDropBy(max, 0, 5).build();
     action.perform();
     num = driver.findElement(By.id("range")).getText();
     System.out.println(num);
	Action action2= a.clickAndHold(min).build();

	action2.perform();
	
	}
}
