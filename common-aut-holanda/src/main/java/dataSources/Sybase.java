package dataSources;

import exceptions.SmokeTestException;
//import io.qameta.allure.model.Status;
import org.testng.Assert;
import reporter.Reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Sybase {

    public static Connection getConnection(DbUser dbUser,final Boolean smokeTest) throws SmokeTestException {
        if (smokeTest){
            throw new SmokeTestException("[Sybase]Esto es un Smoketest, se ignorará esta accion");
        }
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(
                    //"jdbc:sybase:Tds:161.131.105.203:20000/mvtosctacte", "tycdata", "c3er29se");
                    "jdbc:jtds:sybase://"+ dbUser.getUrl(), dbUser.getUsr(), dbUser.getPsw());
  //          Reports.addStep("Se genero conexión a Sybase en ambiente de certificación",false, Status.PASSED,false);
        } catch (SQLException e) {
            Assert.fail("Error de conexión a SQL, se detiene prueba"+e.getMessage());
            e.printStackTrace();
        }finally {
            return connection;
        }
    }
}