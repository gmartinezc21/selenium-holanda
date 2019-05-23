package escenarios;

import controles.BecAutomation;
import controles.Status;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Date;


public class Setup {

	public final static int TIME_OUT = 10;
	
	@BeforeClass
	public static void init() {
		if(BecAutomation.testCases == null) {
			BecAutomation.testCases = new ArrayList<>();
		}
	}
	
	@BeforeMethod
	public void beforeTestSetup() {
		String nombre = this.getClass().getSimpleName();
		String objetivo = "Objetivo de relleno para ejemplificar esto.";
		Date fechaEjecucion = new Date();
		String status = Status.norun.toString();
		BecAutomation.instanceBecAutomation(nombre, objetivo, fechaEjecucion, status);
		
	}
	
	@AfterTest
	public void afterTestSetup() {
		BecAutomation.getDriver().close();
	}
}
