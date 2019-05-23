package dataSources;

import exceptions.SmokeTestException;
//import io.qameta.allure.model.Status;
import org.testng.Assert;
import reporter.Reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Postgre {
    public static Connection getConnection(DbUser dbUser,Boolean smokeTest) throws SmokeTestException {
        if (smokeTest){
            throw new SmokeTestException("[Postgre]Esto es un Smoketest, se ignorará esta accion");
        }
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(
                    "jdbc:postgresql://"+ dbUser.getUrl()+"?sslmode=prefer",dbUser.getUsr(),dbUser.getPsw());
            if(connection.isClosed()){
                System.out.println("Falla");
            }else{
                System.out.println("Conectado");
            }
  //          Reports.addStep("Se genero conexion a Postgre",false, Status.PASSED,false);
        } catch (SQLException e) {
            Assert.fail("Error de conexion a SQL, se detiene prueba"+e.getMessage());
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}