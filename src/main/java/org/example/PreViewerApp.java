package org.example;

import org.example.menu.MenuRunApp;
import org.example.windowsInterface.JTabbedPaneDemo;

import javax.swing.*;
import java.awt.*;

public class PreViewerApp {
    public static void main(String[] args) {
        // Create the frame on the event dispatching thread.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuRunApp();
            }
        });
    }
}
