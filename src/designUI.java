import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class designUI {

    private JTextField inputField1, inputField2, resultField;
    private Calculator calculator = new Calculator();
    private String operation = ""; // To store the selected operation

    // Main method to launch the UI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            designUI calculatorUI = new designUI();
            calculatorUI.designUI();
        });
    }

    // Method for UI design
    public void designUI() {
        // Create the main frame
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        // Create a panel with GridLayout for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid layout with padding

        // Create buttons for calculator operations
        JButton addButton = new JButton("+");
        JButton multiplyButton = new JButton("*");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("C");

        // Set button color and font size
        addButton.setBackground(Color.GREEN);
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));
        multiplyButton.setBackground(Color.GREEN);
        multiplyButton.setFont(new Font("Arial", Font.PLAIN, 16));
        equalsButton.setBackground(Color.GREEN);
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        clearButton.setBackground(Color.GREEN);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Adding the buttons to the panel
        panel.add(addButton);
        panel.add(multiplyButton);
        panel.add(equalsButton);
        panel.add(clearButton);

        // Add labels and text fields for user input and result
        JLabel inputLabel1 = new JLabel("Enter number 1:");
        inputLabel1.setFont(new Font("Arial", Font.PLAIN, 18));
        inputField1 = new JTextField(10);

        JLabel inputLabel2 = new JLabel("Enter number 2:");
        inputLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        inputField2 = new JTextField(10);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        resultField = new JTextField(10);
        resultField.setEditable(false); // Result field is not editable

        // Create a panel for label and text fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(inputLabel1);
        inputPanel.add(inputField1);
        inputPanel.add(inputLabel2);
        inputPanel.add(inputField2);
        inputPanel.add(resultLabel);
        inputPanel.add(resultField);

        // Add functionality to buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = "+"; // Set the operation to addition
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = "*"; // Set the operation to multiplication
            }
        });

        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate and perform the selected operation
                performCalculation();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all input and result fields
                inputField1.setText("");
                inputField2.setText("");
                resultField.setText("");
                operation = "";
            }
        });

        // Create the main panel for the frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.CENTER);

        // Add main panel to frame and display
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Method to perform calculation based on selected operation
    private void performCalculation() {
        try {
            int num1 = Integer.parseInt(inputField1.getText());
            int num2 = Integer.parseInt(inputField2.getText());

            if (operation.equals("+")) {
                int result = calculator.addition(num1, num2);
                resultField.setText(String.valueOf(result));
            } else if (operation.equals("*")) {
                int result = calculator.multiplication(num1, num2);
                resultField.setText(String.valueOf(result));
            } else {
                JOptionPane.showMessageDialog(null, "Please select an operation!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid integers.");
        }
    }
}
