package dataSources;

import constants.Ambientes;
import constants.Constants;
//import io.qameta.allure.model.Status;
import reporter.Reports;
//import utils.ReadProperties;

public class DbUser {
    private String url;
    private String usr;
    private String psw;

    public DbUser(String url, String usr, String psw) {
        this.url = url;
        this.usr = usr;
        this.psw = psw;
    }

    public String getUrl() {
        return url;
    }
    public String getUsr() {
        return usr;
    }
    public String getPsw() {
        return psw;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void setUsr(String usr) {
        this.usr = usr;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }


    public static DbUser getUser(String nameFile){
  //      Properties properties= ReadProperties.readFromConfig(nameFile);
        DbUser dbUser = null;
        if (Constants.AMBIENTE.equals(Ambientes.QA)){
   //         dbUser=new DbUser(properties.getProperty("hostQA"),properties.getProperty("usrQA"),properties.getProperty("pswQA"));
        }else if(Constants.AMBIENTE.equals(Ambientes.INT)){
    //        dbUser=new DbUser(properties.getProperty("hostINT"),properties.getProperty("usrINT"),properties.getProperty("pswINT"));
        }
        checkEmptyVariables(dbUser);
        return dbUser;
    }

    private static void checkEmptyVariables(DbUser user){
        if (user.psw.isEmpty()||user.url.isEmpty()||user.usr.isEmpty()){
     //       Reports.addStep("Existe un string vacio en el objeto usuario:"+user.toString(),false, Status.FAILED,true);
        }
    }

    @Override
    public String toString() {
        return "PostgreUser{" +
                "url='" + url + '\'' +
                ", usr='" + usr + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}