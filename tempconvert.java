import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tempconvert extends JFrame implements ActionListener {
    private JLabel inputLabel, outputLabel;
    private JTextField inputField, outputField;
    private JButton fahrenheitButton, celsiusButton;

    public tempconvert() {
        // Set up the GUI components
        inputLabel = new JLabel("Enter temperature:");
        outputLabel = new JLabel("Converted temperature:");
        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);
        fahrenheitButton = new JButton("Fahrenheit to Celsius");
        celsiusButton = new JButton("Celsius to Fahrenheit");

        // Add action listeners to the buttons
        fahrenheitButton.addActionListener(this);
        celsiusButton.addActionListener(this);

        // Create a panel to hold the input and output components
        JPanel inputOutputPanel = new JPanel(new GridLayout(2, 2));
        inputOutputPanel.add(inputLabel);
        inputOutputPanel.add(inputField);
        inputOutputPanel.add(outputLabel);
        inputOutputPanel.add(outputField);

        // Create a panel to hold the conversion buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(fahrenheitButton);
        buttonPanel.add(celsiusButton);

        // Create a main panel to hold the other panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputOutputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the JFrame
        add(mainPanel);

        // Set JFrame properties
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Event handler for button clicks
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        double temperature = 0.0;

        try {
            temperature = Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (e.getSource() == fahrenheitButton) {
            double convertedTemp = (temperature - 32) * 5 / 9;
            outputField.setText(String.format("%.2f", convertedTemp) + " °C");
        } else if (e.getSource() == celsiusButton) {
            double convertedTemp = (temperature * 9 / 5) + 32;
            outputField.setText(String.format("%.2f", convertedTemp) + " °F");
        }
    }

    public static void main(String[] args) {
        new tempconvert();
    }
}
