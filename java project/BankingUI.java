 import java.awt.*;
import javax.swing.*;

abstract class Bank {
    double principal;

    Bank(double principal) {
        this.principal = principal;
    }

    abstract double calculateInterest();
}

class SavingsBank extends Bank {
    SavingsBank(double principal) {
        super(principal);
    }

    @Override
    double calculateInterest() {
        return principal * 0.04;
    }
}

class CurrentBank extends Bank {
    CurrentBank(double principal) {
        super(principal);
    }

    @Override
    double calculateInterest() {
        return principal * 0.02;
    }
}

public class BankingUI extends JFrame {

    JTextField amountField;
    JButton savingsBtn, currentBtn;
    JLabel result;

    BankingUI() {
        setTitle("Banking System");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter Amount:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        amountField = new JTextField(15);
        amountField.setMaximumSize(new Dimension(200, 30));
        amountField.setAlignmentX(Component.CENTER_ALIGNMENT);

        savingsBtn = new JButton("Savings Interest");
        currentBtn = new JButton("Current Interest");

        savingsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        result = new JLabel("Result will appear here");
        result.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(amountField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(savingsBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(currentBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(result);
        panel.add(Box.createVerticalGlue());

        add(panel);

        savingsBtn.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            Bank b = new SavingsBank(amount);
            result.setText("Savings Interest: " + b.calculateInterest());
        });

        currentBtn.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            Bank b = new CurrentBank(amount);
            result.setText("Current Interest: " + b.calculateInterest());
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BankingUI();
    }
}