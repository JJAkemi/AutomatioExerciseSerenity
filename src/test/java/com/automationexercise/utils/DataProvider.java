package com.automationexercise.utils;

public class DataProvider {
    private static DataProvider instance;
    private ExcelReader excelReader;

    private DataProvider(String excelPath) throws Exception {
        excelReader = new ExcelReader(excelPath);
    }

    public static void init(String excelPath) throws Exception {
        if (instance == null) {
            instance = new DataProvider(excelPath);
        }
    }

    private static DataProvider getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ERROR: DataProvider no ha sido inicializado. Llama a init() primero.");
        }
        return instance;
    }

    // Método estático de conveniencia
    public static String getValue(String sheetName, String columnName, int rowIndex) {
        return getInstance().excelReader.getValue(sheetName, columnName, rowIndex);
    }
}




