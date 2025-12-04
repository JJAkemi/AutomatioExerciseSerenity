package com.automationexercise.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {
    private Workbook workbook;

    public ExcelReader(String path) throws Exception {
        System.out.println("=== INICIO DE CARGA DEL ARCHIVO EXCEL ===");
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new Exception("ERROR: El archivo no se encuentra en la ruta: " + path);
            }

            FileInputStream fis = new FileInputStream(file);
            workbook = WorkbookFactory.create(fis);

            System.out.println("Archivo cargado correctamente desde: " + path);
            System.out.println("=== FIN DE CARGA DEL ARCHIVO EXCEL ===");
        } catch (Exception e) {
            System.out.println("ERROR al cargar el archivo Excel: " + e.getMessage());
            throw e;
        }
    }

    // Ahora rowIndex corresponde directamente a la fila en Excel
    public String getValue(String sheetName, String columnName, int rowIndex) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            System.out.println("ERROR: La hoja '" + sheetName + "' no existe en el archivo.");
            return null;
        }

        // Buscar índice de la columna en encabezado (fila 0)
        Row headerRow = sheet.getRow(0);
        int columnIndex = -1;
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                columnIndex = cell.getColumnIndex();
                break;
            }
        }
        if (columnIndex == -1) {
            System.out.println("ERROR: La columna '" + columnName + "' no existe en la hoja '" + sheetName + "'.");
            return null;
        }

        // Usamos directamente rowIndex (0 = encabezado, 1 = primera fila de datos, etc.)
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            System.out.println("ERROR: No existe la fila con índice " + rowIndex + " en la hoja '" + sheetName + "'.");
            return null;
        }

        Cell cell = row.getCell(columnIndex);
        return cell != null ? cell.getStringCellValue() : null;
    }
}

