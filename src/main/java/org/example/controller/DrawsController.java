package org.example.controller;

import org.example.model.Item;
import org.example.model.Vessel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawsController extends JFrame {

    private int padding = 50; // pixels

    private ArrayList<Item> items;
    private Vessel vessel;


    public DrawsController(ArrayList<Item> initialComponents, Vessel vessel) {
        this.items = initialComponents;
        this.vessel = vessel;
        setTitle("title");
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


            // draw vessel
            int[] vesselCoords = drawvessel();
            g.setColor(Color.BLUE);
            g.drawRect(vesselCoords[0], vesselCoords[1], vesselCoords[2], vesselCoords[3]);
            g.drawString("Mittelplate tween Deck", vesselCoords[0], vesselCoords[1]);


            // Draw cargo items
            int tempStartX = drawvessel()[0];
            int tempStartY = drawvessel()[1];
            double scale = scale();
            for (Item item : items) {
                // Draw the cargo item
                g.drawRect(
                        tempStartX + (int) (item.getCoordinateX() * scale),
                        tempStartY + (int) (item.getCoordinateY() * scale),
                        (int) (item.getLength() * scale),
                        (int) (item.getWidth() * scale));

                g.drawString(
                        item.toString(),
                        tempStartX + (int) (item.getCoordinateX() * scale),
                        tempStartY + (int) ((item.getCoordinateY() + item.getWidth()/2) * scale));
            }
        }
    }

    private int[] drawvessel() {
        // g.drawRect(x, y, scaledLength, scaledWidth);
        int[] rectItemGeom = new int[4];
        double scale = scale();
        // Calculate the scaled dimensions
        int scaledLength = (int) (vessel.getLength() * scale);
        int scaledWidth = (int) (vessel.getWidth() * scale);

        // Calculate the position to center the Mittelplate in the window with padding
        int x = (getWidth() - scaledLength) / 2;
        int y = (getHeight() - scaledWidth) / 2;

        rectItemGeom[0] = x;
        rectItemGeom[1] = y;
        rectItemGeom[2] = scaledLength;
        rectItemGeom[3] = scaledWidth;

        return rectItemGeom;


    }

    private double scale() {
        // Get the dimensions of the drawing area
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        // Calculate the scale factor to fit the Mittelplate dimensions in the window
        double lengthScale = (double) (panelWidth - 2 * padding) / vessel.getLength();
        double widthScale = (double) (panelHeight - 2 * padding) / vessel.getWidth();

        return Math.min(lengthScale, widthScale);
    }
}
