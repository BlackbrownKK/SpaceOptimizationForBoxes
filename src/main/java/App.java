import org.example.controller.CargoCollectionMaker;
import org.example.controller.DrawsController;
import org.example.controller.PlannerController;
import org.example.model.Vessel;

import javax.swing.*;

public class App {

    static int length = 0 ;
    static int width = 0 ;
    static int height = 0 ;

    public static void main(String[] args) {
    // Create cargo collection
    CargoCollectionMaker cargoCollectionMaker = new CargoCollectionMaker();

    // Create JFrame
    JFrame frame = new JFrame("deck parameters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

    // Create text fields for vessel parameters
    JTextField lengthField = new JTextField(10);
    JTextField widthField = new JTextField(10);
    JTextField heightField = new JTextField(10);

    // Create submit button
    JButton submitButton = new JButton("start planning");
        submitButton.addActionListener(e -> {
        // Get input values
          length = Integer.parseInt(lengthField.getText());
          width = Integer.parseInt(widthField.getText());
          height = Integer.parseInt(heightField.getText());

        // Create deck


            Vessel vessel = new Vessel( "example", length, width, height);
            int gapX = 350;
            int gapY = 350;


            PlannerController plannerController = new PlannerController(
                    cargoCollectionMaker.getCargoList(),
                    vessel,
                    gapX,gapY);



            // Create and show DrawsController
            JFrame drawsFrame = new JFrame("Cargo Planner");
            drawsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            DrawsController drawsController = new DrawsController(plannerController.planer(), vessel);
            drawsFrame.setContentPane(drawsController.getContentPane()); // Set the content pane properly
            drawsFrame.setSize(1500 , 10005); // Set the size manually to ensure it's large enough
            drawsFrame.pack();
            drawsFrame.setLocationRelativeTo(null);
            drawsFrame.setVisible(true);
    });

    // Add components to frame
        frame.add(new JLabel("Length:"));
        frame.add(lengthField);
        frame.add(new JLabel("Width:"));
        frame.add(widthField);
        frame.add(new JLabel("Height:"));
        frame.add(heightField);
        frame.add(submitButton);

    // Center frame on screen
        frame.setLocationRelativeTo(null);

    // Make frame visible
        frame.setVisible(true);
}

}
