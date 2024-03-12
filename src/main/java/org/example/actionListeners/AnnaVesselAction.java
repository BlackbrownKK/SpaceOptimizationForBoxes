package org.example.actionListeners;

import org.example.vessels.Anna;
import org.example.vessels.Mittelplate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnaVesselAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        StartAction.vessel = new Anna();
    }
}