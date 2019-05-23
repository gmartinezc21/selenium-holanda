package reporter;

import driver.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class Reports {

    private static SoftAssert softAssert = new SoftAssert();

    public static void addStep(String descripcion, Boolean screenshot, Status status, Boolean fatal) {
        if (screenshot) {
            String uuid = UUID.randomUUID().toString();
            StepResult result = new StepResult().setName(descripcion).setStatus(status);
            Allure.getLifecycle().startStep(uuid, result);
            reportScreenshot();
            Allure.getLifecycle().stopStep(uuid);
            softAssert.assertTrue(true, descripcion);
        } else {
            String uuid = UUID.randomUUID().toString();
            StepResult result = new StepResult().setName(descripcion).setStatus(status);
            Allure.getLifecycle().startStep(uuid, result);
            Allure.getLifecycle().stopStep(uuid);
            softAssert.assertTrue(true, descripcion);
        }
        if (status.equals(Status.FAILED)) {
            softAssert.fail(descripcion);
        }
        if (fatal) {
            //reportScreenshot();
            Assert.fail(descripcion);
        }
        System.out.println("[Reports]"+descripcion);
    }

    public static void addStep(String descripcion, Status status, Boolean fatal){
        addStep( descripcion,  false,  status,  fatal);
    }

    public static void addStep(String descripcion,Boolean screenshot, Status status){
        addStep( descripcion,  screenshot,  status,  false);
    }

    private static void reportScreenshot() {
        File scrFile;
        scrFile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
        File foto = new File(scrFile.getPath());
        InputStream imagen;
        try {
            imagen = new FileInputStream(foto);
            Allure.addAttachment("Imagen adjunta", imagen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void finalAssert() {
        softAssert.assertAll();
    }
    public static void genericFail(NoSuchElementException ex, Boolean fatal) {
        addStep("No se encontró un elemento: " + ex.getMessage(), true, Status.FAILED, true);
    }
    public static void clean() {
        softAssert = new SoftAssert();
    }
}