package org.example.controller;

import org.example.tools.CsvReader;
import org.example.model.Item;

import java.util.ArrayList;

public class CargoCollectionMaker {


// prepare first ungroup collection

    private ArrayList<Item> cargoList = new ArrayList<>();

    public ArrayList<Item> getCargoList() {
        initialiseCargoList ();
        return cargoList;
    }

    private void initialiseCargoList () {
        int itemIdItaration = 0;
        CsvReader csvReader = new CsvReader();
        String [][] inputData = csvReader.getInputDataFromCsvFile();
        for (int i = 1; i < inputData.length; i++) {
            Item item = new Item(
                    inputData[i][0],
                    itemIdItaration,
                    parseToInt(inputData[i][1]),
                    parseToInt(String.valueOf(Math.round(parseToDouble(inputData[i][2]) * 1000))),
                    parseToInt(String.valueOf(Math.round(parseToDouble(inputData[i][3]) * 1000))),
                    parseToInt(String.valueOf(Math.round(parseToDouble(inputData[i][4]) * 1000))),
                    parseToDouble(inputData[i][5]));
            cargoList.add(item);
            itemIdItaration++;
        }
    }

    public static int parseToInt(String str) throws NumberFormatException {
        if (str.endsWith(".0")) {
            String newStr = str.substring(0, str.length() - 2);
            return Integer.parseInt(newStr);
        }
        return Integer.parseInt(str);
    }
        public static double parseToDouble(String str) throws NumberFormatException {
            return Double.parseDouble(str);
        }
}
