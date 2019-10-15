package seleniumMavenProject.MyMavenProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Test
public class TestMavenProject {
	
  public static WebDriver driver;
  
  @BeforeTest
  public void launchBrowser() {
	  String driverPath="D:\\Selenium_Practice_Code\\Browser_Driver\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @Test(priority=0, description="Open application in chrome driver.")
  public void openApplication(){ 
	  
	  driver.get("http://way2automation.com/way2auto_jquery/alert.php");
	  driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
	  driver.findElement(By.xpath("//*[@id='load_form']/fieldset[1]/input[@name='username']")).sendKeys("bkunwar"); 
	  driver.findElement(By.xpath("//*[@id='load_form']/fieldset[2]/input[@name='password']")).sendKeys("admin@123"); 
	  driver.findElement(By.xpath("//div[@id='login']/form/div/div[2]/input[@type='submit']")).click();

  }
  
  @Test(priority=1, description="Verify Home page Title")
  public void verifyHomepageTitle(){
	  String expectedTitle="Welcome to the Test Site";
	  String actualTitle=driver.getTitle();
	  AssertJUnit.assertEquals(expectedTitle,actualTitle);  
  }
  
  @Test(priority=2, description="verify Tooltip like inside Widget")
  public void verifyTooltip() throws InterruptedException {
	  Actions actions = new Actions(driver);
	  Thread.sleep(9000);
	  actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Widget')]"))).perform();
	  Thread.sleep(9000);
	  driver.findElement(By.xpath("//a[@href='tooltip.php']")).click();
	  Thread.sleep(9000);
  }
  
  
  @AfterTest
  public void terminateBrowser(){
	  
	  driver.close();
  }
  
  
}
