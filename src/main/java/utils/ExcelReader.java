package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static String readData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file); // Use XSSFWorkbook for .xlsx files
        Sheet sheet = workbook.getSheet(sheetName); // Get the specified sheet

        // Get the specific row and column data
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        
        // Depending on the type of cell, read the data accordingly
        String cellValue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue(); // For string type cells
                    break;
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue()); // For numeric type cells
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue()); // For boolean type cells
                    break;
                default:
                    break;
            }
        }

        workbook.close(); // Close the workbook after reading
        return cellValue;
    }
}
