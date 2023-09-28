package com.exito.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatosExcel {

    private static XSSFWorkbook book;
    private static FileInputStream file;
    private FileOutputStream fileWrite;

    public String leerDatoExcel(String hoja, String ruta, int rowValue, int cellValue) throws IOException {

        String valor = null;
        file = new FileInputStream(new File(ruta));
        book = new XSSFWorkbook(file);
        Sheet sheet = book.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        switch (cell.getCellTypeEnum()){
            case STRING:
                valor = cell.getStringCellValue();
                break;
            case NUMERIC:
                String valor1 = String.valueOf(cell.getNumericCellValue());
                valor = Limpiar.LimpiarNumeroDecimal(valor1);
                break;
        }
        //valor = cell.getStringCellValue();
        book.close();
        file.close();
        return valor;
    }

    public double leerDatoExcelNumeric(String hoja, String ruta, int rowValue, int cellValue) throws IOException {

        double valor;
        file = new FileInputStream(new File(ruta));
        book = new XSSFWorkbook(file);
        Sheet sheet = book.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        valor = cell.getNumericCellValue();
        book.close();
        file.close();
        return valor;

    }

}
