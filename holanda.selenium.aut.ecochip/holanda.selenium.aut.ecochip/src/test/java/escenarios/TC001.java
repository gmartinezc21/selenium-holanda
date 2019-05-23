package escenarios;


import controles.Action;
import controles.BecAutomation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 extends Setup {

	
	@Test
	public void runTest(){
			try {
				BecAutomation.executeAction(Action.navigate, null, "http://www.pcfactory.cl");
				//BecAutomation.executeAction(Action.sendkey, Login.xpathInputUsuario + " ", "usuario");
				//BecAutomation.executeAction(Action.sendkey, Login.xpathInputPass + " ", "qanova");
				//BecAutomation.executeAction(Action.click, Login.xpathSubmitButon + "" , null);
				Thread.sleep(10000);







			} catch (Exception e) {
				Assert.fail();
			}
			
			
		
	}
	
}
