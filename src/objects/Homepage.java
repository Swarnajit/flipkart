package objects;

import org.openqa.selenium.By;

public class Homepage {

	public static final By searchBar=By.xpath("//input[contains(@placeholder,'Where do you want to park?')]");
	public static final By citylist=By.xpath("//span[contains(text(),'Brisbane')]");
	public static final By searchResult=By.xpath("//div[@class='kerbMapMarker']");
	public static final By searchButton=By.xpath("//button[contains(text(),'Find a space')]");
	public static String searchCity="Brisbane";
	public static final By leaseButton=By.xpath("//span[contains(@class,'tabTitle') and contains(text(),'Lease a space')]");
	public static final By spaceButton=By.xpath("//span[contains(@class,'tabTitle') and contains(text(),'Find a space')]");
	public static final By bookingButton=By.xpath("//span[contains(@class,'tabTitle') and contains(text(),'Bookings')]");
}
