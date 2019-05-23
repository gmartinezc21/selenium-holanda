package dataSources;

import exceptions.SmokeTestException;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql{
    public static Connection getConnection(DbUser dbUser,final Boolean smokeTest)throws SmokeTestException{
        if (smokeTest){
            throw new SmokeTestException("[MySql]Esto es un Smoketest, se ignorará esta accion");
        }
        try {
            String connectionUrl = "jdbc:mysql://"+dbUser.getUrl();
            System.out.println(connectionUrl+" "+dbUser.getUsr()+" "+dbUser.getPsw());
            Connection conn = DriverManager.getConnection(connectionUrl,dbUser.getUsr(),dbUser.getPsw());
            return conn;
        } catch (SQLException e) {
            Assert.fail("Error de conexión a SQL, se detiene prueba:"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
