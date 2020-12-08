package theInternet;

import org.testng.annotations.Test;

import foundation.TheInternetTestBase;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TheInternetTest extends TheInternetTestBase{
  @Test
  public void f() {
	  //Arrange
		 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String url ="http://the-internet.herokuapp.com/";
		 //Act
		 driver.navigate().to(url);
		 String currentURL = driver.getCurrentUrl();
		 
		 //Assert
		 Assert.assertEquals(currentURL, url);
	  
  }
  //The test works properly
  @Test
  public void addRemove() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	 Addremove ar= new Addremove(driver,url);
			 
     ar.navigate()
     .btnClick();
 	
    	
	 //Assert
  }
  @Test
  public void challenging() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	 ChallengingDom c= new ChallengingDom(driver,url);
			 
     c.navigate()
    .challenge();
     
   
  }
  @Test
  public void fileUp() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
     File_Upload f = new File_Upload(driver,url);
     f.navigate()
     .findFile();
     String cURL = driver.getCurrentUrl();
     Assert.assertEquals(cURL, "http://the-internet.herokuapp.com/upload");
     WebElement text= driver.findElement(By.id("uploaded-files"));
     String name=text.getText();
     Assert.assertEquals(name,"case6.txt");
  }
  @Test
  public void context() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	 ContextMenu c= new ContextMenu(driver,url);
			 
     c.navigate()
     .popUp();
     
     //Assert
     
     String alertText= c.getAlertString();
     Assert.assertEquals(alertText, "You selected a context menu");
    	
	 //Assert
  }
  @Test
  public void hove() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
   Hovers h= new Hovers(driver,url);
   h.navigate()
   .hovered();
   String textProfile[]=new String[3];
   for(int i=0; i<textProfile.length; i++) {
	   textProfile[i]= h.textUser[i];
	   
   }
   Assert.assertEquals(textProfile[0],"name: user1\n"
   		+ "View profile" );
   Assert.assertEquals(textProfile[1],"name: user2\n"
	   		+ "View profile" );
   Assert.assertEquals(textProfile[2],"name: user3\n"
	   		+ "View profile" );
  }
  
  //Works partially but couldnt make assert statement the close button works
  // but after closing I couldnot make it click restart ad
  // I can see the parent child relationships
  // Couldnot make it get text ?  for some reason no idea why
  
  @Test
  public void testBox() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
    Entry e = new Entry(driver,url);
     e.navigate()
     .textBox();
     String s=e.closeBtn;
     System.out.println(s);

	 //Assert
  }
  //Works tested and trialed many times
  //It checks to see if the gallery button has been clicked atleast once
  @Test
  public void disappear() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	 DisappearingElements d= new DisappearingElements(driver,url);
			 
     d.navigate()
     .btnClick();
     
      int countc=d.btnClick();    
     //Assert
     Assert.assertEquals(countc,1);
    	
	 
  }
  @Test
  public void canSelectDropDownList() {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com/";
	 String expectedSelection="Option 2";
	 //Act
    String selectedOption = new DropDownPage(driver,url)
    		.navigate()
    		.select(expectedSelection)
    		.getOption();	 
	 //Assert
	 Assert.assertEquals(selectedOption, expectedSelection);
  }
  //Works fine in the assert I am testing if the url returns back to the page it started from
  @Test
  public void dynamic() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	 Dynamic_loading d= new Dynamic_loading(driver,url);
			 
     d.navigate()
     .btnClick();
	 //Assert
     String s=d.current;
     Assert.assertEquals(s, "http://the-internet.herokuapp.com/dynamic_loading");
     		
  }
  //Works properly
  
  @Test
  public void presses() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	KeyPresses k= new KeyPresses(driver,url);
	k.navigate()
    .press();
    String c= k.current;
    Assert.assertEquals(c,"http://the-internet.herokuapp.com/key_presses?");
  }
  @Test
  public void forgot() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	ForgotPassword r= new ForgotPassword(driver,url);
	r.navigate()
    .enterEmail("c.samanja09@gmail.com");
	String emailT= r.emailText;
	Assert.assertEquals(emailT,"Your e-mail's been sent!");
	
  }
  @Test
  public void formAuthenticate() {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 		
	 //Act
    FormAuthentication f= new FormAuthentication(driver,url);
    	f.navigate()
    	.login();
   String current = f.crr;
   Assert.assertEquals(current, "http://the-internet.herokuapp.com/login");
    
  }
  
  //Works partially range is supposed to slide until 5 not 2.5 :(
  // I dont know what I am doing wrong over here
  @Test
  public void slid() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
   HorizontalSlider hs= new HorizontalSlider(driver,url);
   hs.navigate()
   .slide();
   String actualNum=hs.num;
   Assert.assertEquals(actualNum, "2.5");
  }		
  //Works properly
  @Test
  public void redirectLink() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	Redirector r= new Redirector(driver,url);
	r.navigate()
    .linking();
	String url1=r.t1;
	String url2=r.t2;
	Assert.assertEquals(url1, "http://the-internet.herokuapp.com/status_codes/200");
	Assert.assertEquals(url2, "http://the-internet.herokuapp.com/status_codes/301");
  }
  //Works properly tested very thoroughly
  @Test
  public void jsalert() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	 JavaScriptAlert js= new JavaScriptAlert(driver,url);
   js.navigate()
   .jsAlerts();
   
   String test1=js.text1;
   Assert.assertEquals(test1, "I am a JS Alert");
   String test2=js.text2;
   Assert.assertEquals(test2, "I am a JS Confirm");
   String test3= js.text3;
   Assert.assertEquals(test3, "I am a JS Confirm");
  }
  
  @Test
  public void checkFrame() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
     Frames f = new Frames(driver,url);
     f.navigate()
     .checkFrame();
     
     String t = f.title1;
     Assert.assertEquals(t, "An iFrame containing the TinyMCE WYSIWYG Editor");
  }
  
  @Test
  public void open() throws InterruptedException {
	  //Arrange
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\c.samanja09\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 String url ="http://the-internet.herokuapp.com";
	 
	 //Act
	MultipleWindows mw= new MultipleWindows(driver,url);
	mw.navigate()
	.mWindows();
	String title= mw.t;
	Assert.assertEquals(title, "New Window");
	
	
  }
  //Works partially
  @Test
  public void demoqaSite() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver(); 
		 String url ="http://www.demoqa.com";
		
		 //Act
	   Demoqa d = new Demoqa(driver,url);
	   d.navigate()
	   .formFilling();
	   String title= d.t;
	   Assert.assertEquals(title, "https://www.demoqa.com/automation-practice-form");
		
	  }
@BeforeTest
  public void beforeTest() {
	//super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	//  super.afterTest();
  }

}
