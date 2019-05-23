package utils;

import reporter.Reports;
import org.openqa.selenium.WebElement;
//import io.qameta.allure.Step;
//import io.qameta.allure.model.Status;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;

public class Utils {

    /*
    @Step("Validación de texto")
    public static boolean validarTexto(String textoApp,String textoAValidar){
        if (textoApp.trim().equals(textoAValidar.trim())){
            Reports.addStep("Texto:"+textoApp+" validado segun diseño y es correcto",false,Status.PASSED,false);
            return true;
        }else{
            Reports.addStep("Texto desplegado en app:"+textoApp+" validado segun diseño y no es correcto, deberia desplegar:"+textoAValidar,false,Status.FAILED,false);
            return false;
        }
    }


    @Step("Validación de objeto y texto")
    public static void reporteValidacionTextos(MobileElement objeto,String textoEsperado){
        try{
            boolean existeObjeto = MetodosGenericos.visualizarObjeto(objeto,5);
            if(existeObjeto==true){
                if (objeto.getText().equals(textoEsperado)){
                    Reports.addStep("Se visualiza el texto esperado:'"+textoEsperado+"'.",false, Status.PASSED,false);
                }else{
                    Reports.addStep("Se visualiza el texto:‘"+objeto.getText()+"‘, mientras se esperaba:‘"+textoEsperado+"‘",true, Status.FAILED,false);
                }
            }else{
                Reports.addStep("No se visualiza el texto:‘"+textoEsperado+"’ en la vista desplegada.",false, Status.FAILED,false);
            }
        }catch(Exception e){
            System.out.println("No se  logra ejecutar funcion reporteValidacionTextos, motivo:"+e.getMessage());
            Reports.addStep("Error en el metodo ‘reporteValidacionTextos’, motivo:"+e.getMessage(),true,Status.FAILED,true);
        }
    }*/

    //no lleva step por que no reporta
    public static boolean validarTextoSinReporte(String textoApp,String textoAValidar){
        if (textoApp.trim().equals(textoAValidar.trim())){
            return true;
        }else{
            return false;
        }
    }
    //no lleva step por que no reporta
    /*public static boolean isEnabled(MobileElement element) throws NoSuchElementException {
        System.out.println("Esta el elemento habilitado?:"+element.getAttribute("enabled"));
        return element.getAttribute("enabled").trim().equals("true");
    }*/

    /***
     * Valida si una cadena es numerica
     * @param cadena es un string
     * @return
     */
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}
