package controles;


import escenarios.Setup;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BecAutomation {
	private static String executionTimeTest;
	public static String outputPath;
	protected static WebDriver driver;
	protected static Actions action;
	public static List<TestCase> testCases;
	public static TestCase currentTestCase;
	
	public static void instanceBecAutomation(String nombre, String objetivo, Date fechaEjecucion, String status) {
		BecAutomation.currentTestCase = new TestCase(nombre, objetivo, fechaEjecucion, status);
		BecAutomation.testCases.add(BecAutomation.currentTestCase);
		File chromeDriverFile = new File("Driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
		BecAutomation.setDriver(new ChromeDriver());
		DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		executionTimeTest = format.format(new Date());
		outputPath = "output/" + executionTimeTest + "/";
	}

	public static String executeAction(Action accion, String xpathOfElement, String argument) throws Exception {
		String returnValue = "";
//		Step stepGenerate = null;
		switch (accion) {
		case click:
			ActionImplemet.click(xpathOfElement);
			break;
		case sendkey:
			ActionImplemet.sendKeys(xpathOfElement, argument);
			break;
		
		case navigate:
			ActionImplemet.navigate(argument);
			break;
			
		case navigateBack:
			ActionImplemet.navigateBlack();
			break;
		
		case mouseOver:
			ActionImplemet.mouseOver(xpathOfElement, argument);
			break;
		
		case getText:
			ActionImplemet.getText(xpathOfElement);
			break;
		
		case getAtribute:
			ActionImplemet.getAtribute(xpathOfElement, argument);
			break;
		default:
			throw new Exception("Action no implementada " + accion);
		}
				
		
		return returnValue;
	}

	protected static void writeInStepLog(String pathSteplog, Step stepGenerate) throws IOException {
		File stepLogFile = new File(pathSteplog);
		List<String> contentFile = new ArrayList<>();
		if (stepLogFile.exists()) {

			contentFile.addAll(Files.readAllLines(stepLogFile.toPath()));

		}
		
		contentFile.add(stepGenerate.generateFileLineforStepLog());

		Files.write(stepLogFile.toPath(), contentFile);
	}

	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BecAutomation.driver = driver;
	}

	protected static String captureScreenShoot(String nameImage) {
		String pathImage = "";
		try {
			pathImage = outputPath + currentTestCase.getNombre() + "/evidence/";
			File to = new File(pathImage);
			to.mkdirs();
			pathImage = pathImage + nameImage + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			to = new File(pathImage);
			Files.copy(scrFile.toPath(), to.toPath());

		} catch (IOException e) {
			System.err.println(e.getMessage());
			pathImage = "";
		}
		return pathImage;

	}

	public static void waitTime(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	public static WebElement isElementPresent(String xpath) {
		WebElement result = null;

		int countTimeOut = 0;
		do {
			try {
				Thread.sleep(1000);
				result = driver.findElement(By.xpath(xpath));

			} catch (Exception e) {
				System.err.println("Espero 1 segundo.");
			}
			countTimeOut++;
		} while (result == null && countTimeOut < Setup.TIME_OUT);

		return result;

	}

	public static List<WebElement> isElementsPresent(String xpath) {
		List<WebElement> result = new ArrayList<>();

		int countTimeOut = 0;
		do {
			try {
				Thread.sleep(1000);
				result = driver.findElements(By.xpath(xpath));
				if (result.isEmpty()) {
					throw new Exception("Lista sin resultados");
				}
			} catch (Exception e) {
				System.err.println("Espero 1 segundo.");
			}
			countTimeOut++;
		} while (result == null && countTimeOut < Setup.TIME_OUT);

		return result;

	}

	public static String getPropertiOfElement(String xpath, String atribute) {
		String result = "";

		try {
			result = isElementPresent(xpath).getAttribute(atribute);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return result;
	}

	public static String getTextOfElement(String xpath) {
		String result = "";

		try {
			result = isElementPresent(xpath).getText();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return result;
	}

	public static Actions getAction() {
		return action;
	}

	public static void evaluateTestCase() {
		currentTestCase.setStatus(Status.pass.toString());
		for (Step step : currentTestCase.getSteps()) {
			if (step.getStatus().equals(Status.fail.toString())) {
				currentTestCase.setStatus(Status.fail.toString());
			}

		}

	}
	
	

}
