package org.example.actionListeners;

import org.example.controller.CargoCollectionMaker;
import org.example.controller.DrawsController;
import org.example.controller.PlannerController;
import org.example.model.Vessel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartAction implements ActionListener {

    public static Vessel vessel;
    int gapX = 350;
    int gapY = 350;

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }


    public StartAction() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CargoCollectionMaker cargoCollectionMaker = new CargoCollectionMaker();

        PlannerController plannerController = new PlannerController(
                cargoCollectionMaker.getCargoList(),
                vessel,
                gapX, gapY);
        SwingUtilities.invokeLater(() -> {
            DrawsController drawsController = new DrawsController(plannerController.planer(), vessel);
            drawsController.setVisible(true);
        });
    }
}
