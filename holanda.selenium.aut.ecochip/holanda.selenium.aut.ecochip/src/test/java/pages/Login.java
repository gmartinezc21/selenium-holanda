package pages;


import controles.BecAutomation;

public class Login {

	public final static String xpathInputRut = "form > bci-wk-input-text > input[type=text]";
	public final static String xpathInputRenta = "form > bci-wk-select.top-margin-40.upLabel.ng-touched.ng-dirty.ng-valid.bci-blur > select > option:nth-child(1)";
	public final static String xpathEdad = "form > bci-wk-select:nth-child(3) > select > option:nth-child(22)";
	public final static String xpathComprar = "form > bci-wk-select:nth-child(4) > select > option:nth-child(1)";
	public final static String xpathButtonContinuar = "form > button";

	public static void inputUsuario(String criterio) {
		BecAutomation.isElementPresent(xpathInputRut).sendKeys(criterio);
	}
	
	public static void selectRenta(String criterio) {
		BecAutomation.isElementPresent(xpathInputRenta).click();
	}
	/*public static void inputRenta(String criterio) {
		BecAutomation.isElementPresent(xpathSelectRenta);
	}*/
	public static void selectEdad(String criterio) {
		BecAutomation.isElementPresent(xpathEdad).click();
	}
	/*public static void inputEdad(String criterio) {
		BecAutomation.isElementPresent(xpathSelectEdad);
	}*/
	public static void selectCompra(String criterio) {
		BecAutomation.isElementPresent(xpathComprar).click();
	}
	public static void buttonContinuar(String criterio) {
		BecAutomation.isElementPresent(xpathButtonContinuar).click();
	}
}
