package controles;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionImplemet extends BecAutomation{

	private static int idStep = 0;
	
	protected static void click(String xpathOfElement) throws Exception{
		String accion = "click";
		String elemento = xpathOfElement;
		String resultadoEsperado = "Click en el elemento";
		String resultadoLogrado = resultadoEsperado;
		String status = Status.pass.toString();
		String evidence = "";
		
		try {
			Shadow shadow = new Shadow(getDriver());
			WebElement element = shadow.findElement(xpathOfElement);
			if(element != null) {
				element.click();
			}else {
				resultadoLogrado = "Elemento no encontrado: ["+ xpathOfElement +"]";
			}
			evidence = captureScreenShoot(String.format("%02d",idStep++) + accion);
			
		} catch (Exception e) {
			resultadoLogrado = "Error al clickear el elemento: ["+ xpathOfElement+ "], " + e.getMessage();
		}
		
		if (!resultadoEsperado.equals(resultadoLogrado)) {
			status = Status.fail.toString();
		}
		currentTestCase.getSteps().add(genrateStepLog(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence));
	}
	
	protected static void sendKeys(String xpathOfElement, String argumento) throws Exception {
		String accion = "sendKeys";
		String elemento = xpathOfElement;
		String resultadoEsperado = "busqueda de " + argumento;
		String resultadoLogrado = resultadoEsperado;
		String status = Status.pass.toString();
		String evidence = "";
		
		try {
			Shadow shadow = new Shadow(getDriver());
			WebElement element = shadow.findElement(xpathOfElement);
			if (element != null) {
				element.sendKeys(argumento);
			} else {
				resultadoLogrado = "Elemento no encontrado: [" + xpathOfElement + "]";
			}
			evidence = captureScreenShoot(String.format("%02d", idStep++) + accion);
		} catch (Exception e) {
			resultadoLogrado = "Error al Agregar el elemento: [" + xpathOfElement + "], " + e.getMessage();
		}

		if (!resultadoEsperado.equals(resultadoLogrado)) {
			status = Status.fail.toString();
		}

		currentTestCase.getSteps().add(genrateStepLog(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence));
	}
	
protected static void navigate(String argumento) throws Exception {
		
		String accion = "navigate";
		String elemento = argumento;
		String resultadoEsperado = "ir a " + argumento;
		String resultadoLogrado = resultadoEsperado;
		String status = Status.pass.toString();
		String evidence = "";
		
		try {
			
			getDriver().get(elemento);
			
			evidence = captureScreenShoot(String.format("%02d", idStep++) + accion);
		} catch (Exception e) {
			resultadoLogrado = "Error al ir al URL: [" + argumento + "], " + e.getMessage();
		}

		if (!resultadoEsperado.equals(resultadoLogrado)) {
			status = Status.fail.toString();
		}

		currentTestCase.getSteps().add(genrateStepLog(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence));
	}
	
	protected static void navigateBlack() throws Exception {
		String accion = "navigateBack";
		String elemento = "browser";
		String resultadoEsperado = "Volver a la pagina anterior";
		String resultadoLogrado = resultadoEsperado;
		String status = Status.pass.toString();
		String evidence = "";
		
		try {
			
			driver.navigate().back();
			
			evidence = captureScreenShoot(String.format("%02d", idStep++) + accion);
		} catch (Exception e) {
			resultadoLogrado = "Error al volver a la pagina anterior " + e.getMessage();
		}

		if (!resultadoEsperado.equals(resultadoLogrado)) {
			status = Status.fail.toString();
		}

		currentTestCase.getSteps().add(genrateStepLog(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence));
	}
	
	protected static void mouseOver(String xpathOfElement, String argumento) throws Exception {
		String accion = "mouseOver";
		String elemento = "";
		String resultadoEsperado = "Volver a la pagina anterior";
		String resultadoLogrado = resultadoEsperado;
		String status = Status.pass.toString();
		String evidence = "";
		
		try {
			
			WebElement element = isElementPresent(xpathOfElement);
			if (element != null) {
				BecAutomation.action = new Actions(BecAutomation.driver);
				BecAutomation.action.moveToElement(element).build().perform();
			}else {
				resultadoLogrado = "Elemento no encontrado : ["+ xpathOfElement +"]";
			}
			
			evidence = captureScreenShoot(String.format("%02d", idStep++) + accion);
		} catch (Exception e) {
			resultadoLogrado = "Error al volver a la pagina anterior " + e.getMessage();
		}

		if (!resultadoEsperado.equals(resultadoLogrado)) {
			status = Status.fail.toString();
		}

		currentTestCase.getSteps().add(genrateStepLog(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence));
	}
	
	protected static String getText(String xpathOfElement) throws Exception {
		String accion = "getText";
		String elemento = xpathOfElement;
		String resultadoEsperado = "Treer texto de :"+elemento;
		String resultadoLogrado = resultadoEsperado;
		String status = Status.pass.toString();
		String evidence = "";

		try {
			Shadow shadow = new Shadow(getDriver());
			WebElement element = shadow.findElement(xpathOfElement);
			
			if (element != null) {
				element.getText();
			} else {
				resultadoLogrado = "Elemento no encontrado: [" + xpathOfElement + "]";
			}
			evidence = captureScreenShoot(String.format("%02d", idStep++) + accion);
		} catch (Exception e) {
			resultadoLogrado = "Error al traer el elemento: [" + xpathOfElement + "], " + e.getMessage();
		}

		if (!resultadoEsperado.equals(resultadoLogrado)) {
			status = Status.fail.toString();
		}

		currentTestCase.getSteps().add(genrateStepLog(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence));
		return evidence;
	}
	
	protected static String getAtribute(String xpathOfElement, String argumento) throws Exception {
		String accion = "getAtribute";
		String elemento = xpathOfElement;
		String resultadoEsperado = "Treer atributo de : "+elemento;
		String resultadoLogrado = resultadoEsperado;
		String status = Status.pass.toString();
		String evidence = "";
		String valor = null;

		try {
			Shadow shadow = new Shadow(getDriver());
			WebElement element = shadow.findElement(xpathOfElement);
			
			if (element != null) {
				valor = element.getAttribute(argumento);
				//ProductoView.capturaInformacionProducto(valor);
			} else {
				resultadoLogrado = "Elemento no encontrado: [" + xpathOfElement + "]";
			}
			evidence = captureScreenShoot(String.format("%02d", idStep++) + accion);
		} catch (Exception e) {
			resultadoLogrado = "Error al traer el elemento: [" + xpathOfElement + "], " + e.getMessage();
		}

		if (!resultadoEsperado.equals(resultadoLogrado)) {
			status = Status.fail.toString();
		}

		currentTestCase.getSteps().add(genrateStepLog(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence));
		return valor;
	}
	
	private static Step genrateStepLog(String accion, String elemento, String resultadoEsperado,
			String resultadoLogrado, String status, String evidence) throws Exception {
		
		Step valorstep = new Step(accion, elemento, resultadoEsperado, resultadoLogrado, status, evidence);
		
		writeInStepLog(outputPath + currentTestCase.getNombre() + "/steplog.txt", valorstep );
		if (valorstep.getStatus().equals(Status.fail.toString())) {
			throw new Exception(
					"Error en el Step " + valorstep.getElemento() + ", Accion: " + valorstep.getAccion());
		}
		return valorstep;
	}
	
}
