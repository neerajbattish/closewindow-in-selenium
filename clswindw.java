package add;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clswindw {

	WebDriver driver;
	String path;
	WebDriverWait wait;
	WebElement pop;
public void Launch()
{
	
wait=new WebDriverWait(driver, 1);
	path=System.getProperty("user.dir")+"//Driver//chromedriver.exe";
	System.out.println(path);
	System.setProperty("webdriver.chrome.driver", path);
	driver=new ChromeDriver();
	//driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	//driver.get("http://www.popuptest.com/goodpopups.html");
	//driver.get("http://www.popuptest.com/goodpopups.html");
	pop=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Good PopUp #1')]")));
	//pop=(new WebDriverWait(driver,1)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Good PopUp #1')]")));
	//pop=driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]"));
	pop.click();
	Set<String> win = driver.getWindowHandles();
	Iterator<String> itr=win.iterator();
	String parentid=itr.next();
	String childid=itr.next();
	driver.switchTo().window(childid);
	System.out.println(driver.getTitle());
	driver.close();
	driver.switchTo().window(parentid);
	System.out.println(driver.getTitle());
	
	
}
public static void main(String[] args)  {
	
	clswindw oo=new clswindw();
	oo.Launch();

	}
}

