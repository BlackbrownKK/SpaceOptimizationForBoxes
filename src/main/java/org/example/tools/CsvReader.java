package org.example.tools;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    String[][] inputDataFromCsvFile;

    public String[][] getInputDataFromCsvFile() {
        initialiseArray();
        excelDataExtractor(excelRowCount(),excelColumnCount());
        return inputDataFromCsvFile;
    }

    String patch = "src/main/resources/cargoList - workshop.csv.xlsx";


    public int excelRowCount() {
        int rowCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(patch);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            // Assuming there's only one sheet in the Excel file
            Sheet sheet = workbook.getSheetAt(0);

            rowCount = sheet.getPhysicalNumberOfRows();



        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
        return rowCount;
    }


    private int excelColumnCount() {
        int maxColumnCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(patch);
        Workbook workbook = WorkbookFactory.create(fileInputStream)) {

            // Assuming there's only one sheet in the Excel file
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                int lastColumn = Math.max(row.getLastCellNum(), row.getPhysicalNumberOfCells());
                maxColumnCount = Math.max(maxColumnCount, lastColumn);
            }
        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
        return maxColumnCount;
    }


    public void initialiseArray() {
            inputDataFromCsvFile = new String[excelRowCount()][excelColumnCount()];
    }

    public void excelDataExtractor (int rowCount, int maxColumnCount) {
        initialiseArray();
        try (FileInputStream fileInputStream = new FileInputStream(patch);
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {
            // Assuming there's only one sheet in the Excel file
            Sheet sheet = workbook.getSheetAt(0);

            // Populate the array with data from the Excel file
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < maxColumnCount; j++) {
                        Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        inputDataFromCsvFile[i][j] = cell.toString();
                    }
                }
            }

        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
    }
}
