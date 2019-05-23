package utils;

//import driver.DriverContext;
//import io.qameta.allure.Step;
//import io.qameta.allure.model.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.commandhandler.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporter.Reports;

import java.time.Duration;

public class ControllledActions {

    public static boolean exists(WebElement element){
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException ex){
            return false;
        }catch (StaleElementReferenceException ex){
            return false;
        }
    }

    public static boolean isElementPresentWait(WebElement elementName, int timeout){
        try{
            System.out.println("Valida si Es visible el elemnto a validar.");
            //WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), timeout);
            //wait.until(ExpectedConditions.visibilityOf(elementName));
            //System.out.println("Es visible el elemnto a validar.");
            return true;
        }catch(Exception e){
            System.out.println("No es visible el elemento a validar.");
            return false;
        }
    }

    //Ciclo de espera de 60 segundos con la condición positiva
    //Mientras exista el element
    //@Step("Carga de maximo de 60 segundos")
    public static void loading(WebElement element, int tiempo, String descripcion){
        try{
            long tiempoStart = System.currentTimeMillis();
            long tiempoEnd = tiempoStart + 60*1000; // 60 seconds * 1000 ms/sec

            do {
                if (System.currentTimeMillis() >= tiempoEnd){
                    //Reports.addStep(descripcion,true, Status.FAILED,true);
                }
                Duration.ofMillis(100);
            }while (isElementPresentWait(element,tiempo));

        }catch (NoSuchElementException ex){
            //Reports.addStep("[ControlledActions] Error: No se pudo encontrar elemento "+ex.getMessage(),true, Status.FAILED,true);
        }
    }

    //Ciclo de espera de 60 segundos con la condición negada
    //Mientras no exista el element
    //@Step("Carga mientras un elemento NO exista")
    public static void loadingNegado(WebElement element, int tiempo, String descripcion){
        try{
            long tiempoStart = System.currentTimeMillis();
            long tiempoEnd = tiempoStart + 60*1000; // 60 seconds * 1000 ms/sec

            do {
                if (System.currentTimeMillis() >= tiempoEnd){
                    //Reports.addStep(descripcion,true, Status.FAILED,true);
                }
                Duration.ofMillis(100);
            }while (!isElementPresentWait(element,tiempo));

        }catch (NoSuchElementException ex){
            //Reports.addStep("[ControlledActions] Error: Un elemento no fue encontrado: "+ex.getMessage(),true, Status.FAILED,true);
        }
    }
}