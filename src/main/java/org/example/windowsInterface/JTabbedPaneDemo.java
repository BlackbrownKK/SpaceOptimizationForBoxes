// Demonstrate JTabbedPane.

package org.example.windowsInterface;

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneDemo {

    public JTabbedPaneDemo() {

        // Set up the JFrame.
        JFrame jfrm = new JFrame("PreViewer");
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(800, 600);

        // Create the tabbed pane.
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Cities", new CitiesPanel());
        jtp.addTab("Deck", new Deck());
        jtp.addTab("Flavors", new FlavorsPanel());

        // Create a panel to hold the JTabbedPane and the additional JFrame.
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(jtp, BorderLayout.CENTER);

        // Create the additional JFrame.
        JFrame additionalFrame = new JFrame("Additional Frame");
        additionalFrame.setSize(400, 300);
        additionalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose when closed, not exit.
        additionalFrame.setVisible(true);

        // Add the components to the mainPanel.
        mainPanel.add(additionalFrame, BorderLayout.SOUTH);

        // Add the mainPanel to the JFrame.
        jfrm.add(mainPanel);

        // Display the frame.
        jfrm.setVisible(true);
    }


}


// Make the panels that will be added to the tabbed pane.
class ResultField extends JPanel {

    public ResultField() {
        setLayout(new BorderLayout());

        // Add drawing area
        JPanel drawingArea = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Perform custom drawing here
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400); // Set preferred size of drawing area
            }
        };
        add(drawingArea, BorderLayout.CENTER);
    }
}


// Make the panels that will be added to the tabbed pane.
class CitiesPanel extends JPanel {

    public CitiesPanel() {
        JButton b1 = new JButton("option 1");
        add(b1);
        JButton b2 = new JButton("option 2");
        add(b2);
        JButton b3 = new JButton("option 3");
        add(b3);
        JButton b4 = new JButton("option 4");
        add(b4);
    }
}

class Deck extends JPanel {

    public Deck() {
        setLayout(new GridLayout(6, 1)); // 6 rows, 1 column

        JTextField lengthInput = new JTextField(15);
        add(lengthInput);

        JTextField widthInput = new JTextField(15);
        add(widthInput);

        JTextField heightInput = new JTextField(15);
        add(heightInput);

        // Create a panel to group gapX and gapY text fields horizontally
        JPanel gapPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns
        JTextField gapX = new JTextField(15);
        JTextField gapY = new JTextField(15);
        gapPanel.add(gapX);
        gapPanel.add(gapY);
        add(gapPanel);
    }
}

class FlavorsPanel extends JPanel {

    public FlavorsPanel() {
        JComboBox<String> jcb = new JComboBox<>();
        jcb.addItem("Vanilla");
        jcb.addItem("Chocolate");
        jcb.addItem("Strawberry");
        add(jcb);
    }
}
