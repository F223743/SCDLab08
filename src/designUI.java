import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class designUI {
    
    // Main method to launch the UI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            designUI calculator = new designUI();
            calculator.designUI();
        });
    }

    // Method for UI design
    public void designUI() {
        // Create the main frame
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // Create a panel with GridLayout for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid layout with some padding

        // Create buttons for calculator operations
        JButton addButton = new JButton("+");
        JButton multiplyButton = new JButton("*");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("C");

        // Set button color and font size (From Member 1)
        addButton.setBackground(Color.GREEN);
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));
        multiplyButton.setBackground(Color.GREEN);
        multiplyButton.setFont(new Font("Arial", Font.PLAIN, 16));
        equalsButton.setBackground(Color.GREEN);
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        clearButton.setBackground(Color.GREEN);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 16));

        // Adding the buttons to the panel (From Member 2)
        panel.add(addButton);
        panel.add(multiplyButton);
        panel.add(equalsButton);
        panel.add(clearButton);

        // Add a label to show input (new component)
        JLabel inputLabel = new JLabel("Enter numbers:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        // Create a text field for user input
        JTextField inputField = new JTextField(10);
        
        // Create a panel for label and text field
        JPanel inputPanel = new JPanel();
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        // Add functionality to buttons (For calculator operations)
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Input validation and addition logic (Assume inputField1 and inputField2 hold values)
                int result = add(Integer.parseInt(inputField.getText()), 10); // Example use
                inputField.setText(String.valueOf(result));
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Input validation and multiplication logic
                int result = multiply(Integer.parseInt(inputField.getText()), 10); // Example use
                inputField.setText(String.valueOf(result));
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

    // Example addition method
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Example multiplication method
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}
