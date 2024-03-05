package org.example;

//todo step by stem dwawings of cargo unit


import org.example.ships.Mittelplate;

import javax.swing.*;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Mittelplate drawer = new Mittelplate();
            drawer.setVisible(true);
        });


        CsvReader csvReader = new CsvReader();
        csvReader.getInputDataFromCsvFile();
        System.out.println(Arrays.deepToString(csvReader.getInputDataFromCsvFile()));
    }
}