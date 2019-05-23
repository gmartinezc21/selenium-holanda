package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class DataFile {

    public void readFileTxt(String ruta) {
        File archivo = new File(ruta);///Users/ibmqanova01/IdeaProjects/commonsAut 15.38.32/allure-results
        String[] arrayStr = new String[100];
        int cont = 0;
        try {
            Scanner sc=new Scanner(archivo);
            while(sc.hasNextLine()){
                //System.out.println(sc.next());
                String[] var = sc.next().split("=");
                //System.out.println(var[0]);
                arrayStr[cont] = var[0];
                arrayStr[cont+1] = var[1];
                cont = cont + 2;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //FileCollection collection = layout.files('src/file1.txt');

    }

    public void readFileXls(String ruta){
        /*
        String hoja = "Hoja1"; //validar si despues es mejor ingresar la hoja manual para poder manipular mas informacion

        try (FileInputStream file = new FileInputStream(new File(ruta))) {
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            XSSFSheet sheet = worbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            Row row;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();
                    System.out.print(cell.getStringCellValue()+" | ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.getMessage();
        }*/
    }
}
