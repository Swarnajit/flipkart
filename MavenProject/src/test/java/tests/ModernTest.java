package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ModernTest {
  @Test
  public void f() {
		System.setProperty("webdriver.chrome.driver", "G:/Eclipse Works/chromedriver.exe");	
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.amazon.com");
		System.out.println(dr.getTitle());
  }
}
