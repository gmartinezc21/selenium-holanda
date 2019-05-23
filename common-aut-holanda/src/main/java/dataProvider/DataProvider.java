package dataProvider;

import java.lang.reflect.Method;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "PruebaProvider")
    public static Object[][] getDataFromDataprovider(Method m) {
        return new Object[][]{
                {"Guru99", "India"},
                {"Krishna", "UK"},
                {"Bhupesh", "USA"}
        };
    }
}