package driver;

import constants.Constants;
import constants.Navegador;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverContext {
    private static DriverManager driverManager = new DriverManager();

    public static void setUp(Navegador nav) {
        driverManager.resolveDriver(nav);
    }

    public static WebDriver getDriver()
    {
        return driverManager.getDriver();
    }

    public static void quitDriver() {
        driverManager.getDriver().quit();
    }

    public static void setDriverTimeout(Integer tiempo){
        driverManager.getDriver().manage().timeouts().implicitlyWait(tiempo,TimeUnit.SECONDS);
    }
    public static void setDriverDefaultTimeout(){
        setDriverTimeout(Constants.DRIVER_DEFAULT_TIMEOUT);
    }
}
