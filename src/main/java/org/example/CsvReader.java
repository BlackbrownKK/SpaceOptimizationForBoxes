package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    String[][] inputDataFromCsvFile;
    String patch = "C:\\Users\\Юлия\\Downloads\\report - workshop.csv";

    public void initialiseArray(){
        FileReader reader = null;
        try {
            reader = new FileReader(patch);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVParser Initial = null;
        try {
            Initial = CSVFormat.DEFAULT.withHeader().parse(reader);
            // Count the number of lines (rows) in the CSV file
            int numberLines = (int) Initial.stream().count();
            // Get the number of columns from the header
            int numberColum = Initial.getHeaderMap().size();
            // Initialize the array with the determined dimensions
            inputDataFromCsvFile = new String[numberLines][numberColum];
            Initial.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String[][] perCsV() {
        FileReader reader = null;
        try {
            reader = new FileReader(patch);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVParser Initial = null;
        try {
            CSVParser csvParser = null;
            csvParser = CSVFormat.DEFAULT.withHeader().parse(reader);
            // Loop through the CSV records and populate the array
            int rowIndex = 0;
            for (CSVRecord record : csvParser) {
                int columnIndex = 0;
                for (String field : record) {
                    inputDataFromCsvFile[rowIndex][columnIndex] = field;
                    columnIndex++;
                }
                rowIndex++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputDataFromCsvFile;
    }
}

