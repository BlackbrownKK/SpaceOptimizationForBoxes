package org.example.actionListeners;

import org.example.model.Vessel;
import org.example.vessels.Lagos;
import org.example.vessels.Mittelplate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LagosVesselAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        StartAction.vessel = new Lagos();
    }
}