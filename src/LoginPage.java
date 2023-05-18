// LoginPage.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPage extends BasicScreen { 

    public static void main(String[] args) { 
        new LoginPage();
    }

    public LoginPage() {
        super();
        frame.setTitle("Login Page");
        JPanel panel = new JPanel();
        panel.setLayout(null);  // Set layout for the panel
        placeComponents(panel);
        frame.add(panel);
        frame.getRootPane().setDefaultButton(button);
        frame.setVisible(true);  // Set frame visible after all components are added
    }

    private void placeComponents(JPanel panel) {

        JLabel userLabel = new JLabel("Enter PIN or Password");
        userLabel.setBounds(220, 170, 160, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(220, 200, 160, 25);
        panel.add(userText);

        button = new JButton("Login");
        button.setBounds(260, 240, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(220, 280, 300, 25);
        panel.add(success);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = userText.getText();
        String loginResult = checkCredentials(userInput);

        switch (loginResult) {
            case "employee":
                success.setText("Welcome Employee!");
                frame.dispose();
                new EmployeeScreen();
                break;
            case "boss":
                success.setText("Welcome Boss!");
                frame.dispose();
                new BossScreen();
                break;
            default: 
                success.setText("Invalid PIN or Password!");
        }
    }

    private String checkCredentials(String userInput) { 
        if (userInput.equals("12345678")) {
            return "employee";
        } else if (userInput.equals("BossPassword")) {
            return "boss";
        } else {
            return "invalid";
        }
    }
}