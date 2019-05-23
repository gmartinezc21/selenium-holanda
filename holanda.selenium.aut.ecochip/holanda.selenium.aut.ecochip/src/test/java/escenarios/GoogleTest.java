package escenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GoogleTest {

	WebDriver driver;
	String driverPath = "C:/Selenium/Driver/";

	@BeforeTest
	public void setUp() {
		System.out.println("Opening chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void googleTitleTest() {
		System.out.println("Open Chrome downloads");
		driver.get("http://bci-front-cer01.us-south.containers.mybluemix.net/nuevaWeb/fe-ecochip-widget-re-v1-0/");

		System.out.println("Validate downloads page header text");
		WebElement root1 = driver.findElement(By.tagName("bci-widget"));

		//Get shadow root element
		WebElement shadowRoot1 = expandRootElement(root1);

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("app-simulator-personal-info"));
		WebElement shadowRoot2 = expandRootElement(root2);

		shadowRoot2.findElement(By.cssSelector("form > bci-wk-input-text > input[type=text]")).sendKeys("17732427-2");

		// Verify header title
		//Assert.assertEquals("Downloads", actualHeading);


		}


	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver)
				.executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}



}
