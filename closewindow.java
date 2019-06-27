package add;


import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closewindow {

	WebDriver driver;
	String path;
public void Launch()
{
	

	path=System.getProperty("user.dir")+"//Driver//chromedriver.exe";
	System.out.println(path);
	System.setProperty("webdriver.chrome.driver", path);
	driver=new ChromeDriver();
	driver.get("https://www.naukri.com/");
	//String windowTitle = driver.getTitle();
	String mainWindow = driver.getWindowHandle();
	
	Set<String> allWindow = driver.getWindowHandles();
	for (String currentWindow : allWindow) {
		if (!currentWindow.equals(mainWindow)) {
			driver.switchTo().window(currentWindow);
			driver.close();
		}
	}
}
public static void main(String[] args)  {
	
	closewindow oo=new closewindow();
	oo.Launch();

	}
}
