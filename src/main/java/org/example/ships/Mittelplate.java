package org.example.ships;

import org.example.controller.CargoCollectionMaker;
import org.example.model.Item;

import javax.swing.*;
import java.awt.*;

public class Mittelplate extends JFrame {
    private double length = 59174; // mm
    private double width = 10200; // mm
    private double height = 3440; // mm
    private int padding = 50; // pixels

    public Mittelplate() {
        setTitle("Mittelplate");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        add(new DrawingPanel());
    }

    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Get the dimensions of the drawing area
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calculate the scale factor to fit the Mittelplate dimensions in the window
            double lengthScale = (panelWidth - 2 * padding) / length;
            double widthScale = (panelHeight - 2 * padding) / width;
            double scale = Math.min(lengthScale, widthScale);

            // Calculate the scaled dimensions
            int scaledLength = (int) (length * scale);
            int scaledWidth = (int) (width * scale);

            // Calculate the position to center the Mittelplate in the window with padding
            int x = (panelWidth - scaledLength) / 2;
            int y = (panelHeight - scaledWidth) / 2;

            // Draw the Mittelplate with padding
            g.drawRect(x, y, scaledLength, scaledWidth);
            g.drawString("Mittelplate tween Deck", x, y);


            // Draw cargo items
            CargoCollectionMaker cargoCollectionMaker = new CargoCollectionMaker();
            int tempStartX = x;
            int tempStartY = y;

            for (int i = 0; i < 10; i++) {
                // Check if the cargo item has length and width
                // Calculate the scaled dimensions for the cargo item
                Item item = cargoCollectionMaker.getCargoList().get(i);

                int scaledCargoLength = (int) (item.getLength() * 1000 * scale);
                int scaledCargoWidth = (int) (item.getWidth() * 1000 * scale);

                // Calculate the position to center the cargo item relative to the Mittelplate
                int cargoX = tempStartX;
                int cargoY = tempStartY;

                // Draw the cargo item
                g.drawRect(cargoX, cargoY, scaledCargoLength, scaledCargoWidth);
                g.drawString(item.getName(), cargoX, cargoY);
                tempStartX = cargoX + scaledCargoLength;
            }
        }
    }
}


