package org.example.actionListeners;

import org.example.model.Vessel;
import org.example.vessels.Mittelplate;
import org.example.vessels.Monika;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonikaVesselAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        StartAction.vessel = new Monika();
    }
}