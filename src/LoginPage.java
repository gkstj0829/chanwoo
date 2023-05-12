// LoginPage.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener { // 프로그램 실행하면 가장 먼저 나오는 화면 구현한 GUI

    private static JTextField userText;
    private static JButton button;
    private static JLabel success;
    private JFrame loginFrame;

    public static void main(String[] args) { // 나중에 main 함수 클래스를 따로 만들면 수정해야 할 부분. 일단 Test를 위해 임시로 적어놓았다.
        new LoginPage();
    }

    public LoginPage() {
        loginFrame = new JFrame("Login Page");
        loginFrame.setSize(600, 400);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginFrame.add(panel);
        placeComponents(panel);

        loginFrame.getRootPane().setDefaultButton(button);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

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
        String loginResult = checkCredentials(userInput); //나중에 백엔드 만들면 거기서 "employee" 또는 "boss" 를 return해서 loginResult에 넣어주면 됨.


        switch (loginResult) {
            case "employee":
                success.setText("Welcome Employee!");
                loginFrame.dispose();
                new EmployeeScreen();
                break;
            case "boss":
                success.setText("Welcome Boss!");
                loginFrame.dispose();
                new BossScreen();
                break;
            default: // loginResult가 employee 또는 boss가 아니라면 입력한 값이 data base에 없는 것으므로, 잘못 입력한 것으로 간주.
                success.setText("Invalid PIN or Password!");
        }
    }

    private String checkCredentials(String userInput) { // '12345678' 입력: 직원 // 'BossPassword'입력 : 사장님
        if (userInput.equals("12345678")) {
            return "employee";
        } else if (userInput.equals("BossPassword")) {
            return "boss";
        } else {
            return "invalid";
        }
    }
}
