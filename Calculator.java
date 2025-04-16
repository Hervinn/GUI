import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField textField;
    double num1, num2, result;
    String operator;

    public Calculator() {
        // Frame settings
        setTitle("Calculator");
        setSize(400, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Text field
        textField = new JTextField();
        textField.setBounds(30, 40, 340, 50);
        add(textField);

        // Buttons
        String[] buttons = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+"
        };

        int x = 30, y = 100;
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.setBounds(x, y, 80, 50);
            btn.addActionListener(this);
            add(btn);
            x += 85;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 55;
            }
        }

        // Clear Button
        JButton clear = new JButton("C");
        clear.setBounds(30, y, 340, 50);
        clear.addActionListener(e -> textField.setText(""));
        add(clear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789.".contains(cmd)) {
            textField.setText(textField.getText() + cmd);
        } else if ("+-*/".contains(cmd)) {
            num1 = Double.parseDouble(textField.getText());
            operator = cmd;
            textField.setText("");
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num2 != 0 ? num1 / num2 : 0; break;
            }
            textField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
