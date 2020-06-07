package First.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumCheck {
	@Test
	public void initialisedriver(){
		System.out.println("HELLO THIS IS selenium CHECK");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91812\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.close();
	}
}
