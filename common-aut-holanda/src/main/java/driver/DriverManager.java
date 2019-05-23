package driver;

import constants.Constants;
import constants.Navegador;
//import io.qameta.allure.model.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import reporter.Reports;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class DriverManager {
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private WebDriver webDriver;


    private void resolveDriver(Navegador nav, String a) {
        resolveDriver(nav);
    }
    protected void resolveDriver(Navegador nav) {

        if (nav == Navegador.Chrome) {
            webDriver = new ChromeDriver();
            //Reports.addStep("Navegador Chrome lanzado, false, Status.PASSED, false);

        }else if(nav == Navegador.Firefox) {
            webDriver = new FirefoxDriver();
            //Reports.addStep("Navegador Firefox lanzado, false, Status.PASSED, false);

        }else if(nav == Navegador.Explorer) {
            webDriver = new ChromeDriver();
            //Reports.addStep("Navegador Edge lanzado, false, Status.PASSED, false);
        }
        webDriver.manage().timeouts().implicitlyWait(Constants.DRIVER_DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    protected WebDriver getDriver() { return webDriver; }
    protected void setDriver(WebDriver webDriver) { this.webDriver = webDriver; }
}