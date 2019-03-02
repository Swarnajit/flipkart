package functionLibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class LibraryClass {
	public static void captureScreenMethod(WebDriver driver) throws Exception{
		Date now=new Date();
		 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy h-m-s"); 
		 FileHandler.copy(screenshotFile, new File("Screenshots\\"+sdf.format(now)+".png"));
		 }
}
