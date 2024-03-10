package org.example;

//todo step by stem dwawings of cargo unit


import org.example.controller.CargoCollectionMaker;
import org.example.controller.DrawsController;
import org.example.controller.PlannerController;
import org.example.model.Vessel;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CargoCollectionMaker cargoCollectionMaker = new CargoCollectionMaker();


        Vessel vessel = new Vessel("Mittelplate",59174, 10200, 3440 );
        int gapX = 350;
        int gapY = 350;

        PlannerController plannerController = new PlannerController(
                cargoCollectionMaker.getCargoList(),
                vessel,
                gapX,gapY);
        SwingUtilities.invokeLater(() -> {
            DrawsController drawsController = new DrawsController(plannerController.planer(), vessel);
                    drawsController.setVisible(true);
        });
    }
}