package businessComponent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import functionLibrary.LibraryClass;
import objects.BookingPage;
import objects.Homepage;
import objects.LeasePage;
import objects.SpacePage;

public class TestingContinue {
	
	WebDriver dr;
	WebDriverWait wait;
@BeforeTest
	public void testSetup() {
	System.setProperty("webdriver.chrome.driver", "G:/Eclipse Works/chromedriver.exe");
	dr=new ChromeDriver();
	wait=new WebDriverWait(dr,50);
	dr.get("https://kerb.works");
	System.out.println(dr.getTitle());
	dr.manage().window().maximize();
	
}
@Test(priority=1)
public void testCaseOne() throws Exception
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(Homepage.searchBar));

	Actions action=new Actions(dr);
	
	dr.findElement(Homepage.searchBar).click();
	dr.findElement(Homepage.searchBar).sendKeys(Homepage.searchCity);
	LibraryClass.captureScreenMethod(dr);
	//dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	Thread.sleep(10000);
	int i=0;
	List<WebElement> cities=dr.findElements(Homepage.citylist);
	for(WebElement e:cities)
	{

		
		if(i==0)
		{
			wait.until(ExpectedConditions.elementToBeClickable(e));
			e.click();
			Thread.sleep(2000);
			try {
				LibraryClass.captureScreenMethod(dr);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
		i++;
		//System.out.println(e.getCssValue(""));

	}
	WebElement search=dr.findElement(Homepage.searchButton);
	//wait.until(ExpectedConditions.)
	wait.until(ExpectedConditions.elementToBeClickable(search));
	action.moveToElement(search).click().build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Homepage.searchResult));
	LibraryClass.captureScreenMethod(dr);
	
	
	//dr.findElement(By.className("tab-icon-wrapper")).click();
	
	//Assert.assertEquals(dr.getTitle().contains("Amazon"), true);
}
@Test(priority=2)
public void testCaseTwo() throws Exception
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(Homepage.spaceButton));
	dr.findElement(Homepage.leaseButton).click();
	Thread.sleep(10000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(LeasePage.header));
	String leaseHeaderText=dr.findElement(LeasePage.header).getText();
	System.out.println(leaseHeaderText);
	if(leaseHeaderText.contains(LeasePage.headerCheck))
	{
		LibraryClass.captureScreenMethod(dr);
	}
	dr.findElement(Homepage.spaceButton).click();
	Thread.sleep(10000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(SpacePage.header));
	String findHeaderText=dr.findElement(SpacePage.header).getText();
	System.out.println(findHeaderText);
	if(findHeaderText.contains(SpacePage.headerCheck))
	{
		LibraryClass.captureScreenMethod(dr);
	}	

	dr.findElement(Homepage.bookingButton).click();
	Thread.sleep(10000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(BookingPage.header));
	String bookingHeaderText=dr.findElement(BookingPage.header).getText();
	System.out.println(bookingHeaderText);
	if(bookingHeaderText.contains(BookingPage.headerCheck))
		
	{
		LibraryClass.captureScreenMethod(dr);
	}	
}
@AfterTest
public void testFinish()
{
	dr.quit();
}
}
