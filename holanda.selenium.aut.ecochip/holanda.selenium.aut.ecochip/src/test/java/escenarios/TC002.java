package escenarios;


import controles.Action;
import controles.BecAutomation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

public class TC002 extends Setup{

    @Test
    public void runTest01(){
        try {
            BecAutomation.executeAction(Action.navigate, null, "http://bci-front-cer01.us-south.containers.mybluemix.net/nuevaWeb/fe-ecochip-widget-re-v1-0/");
            BecAutomation.executeAction(Action.sendkey, Login.xpathInputRut + " ", "177324272");
            Thread.sleep(2000);
            BecAutomation.executeAction(Action.click, Login.xpathInputRenta + " ", null);
            Thread.sleep(2000);
            BecAutomation.executeAction(Action.click, Login.xpathEdad + " ", null);
            Thread.sleep(2000);
            BecAutomation.executeAction(Action.click, Login.xpathComprar + "", null);
            Thread.sleep(2000);
            BecAutomation.executeAction(Action.click, Login.xpathButtonContinuar + "" , null);
            Thread.sleep(2000);

        } catch (Exception e) {
            Assert.fail();
        }
    }

    /*@Test
    public void runTest02(){
        try {

        }catch (Exception e){
            Assert.fail();
        }
    }*/

}
