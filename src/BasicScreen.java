import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicScreen implements ActionListener {
    protected JTextField userText;
    protected JButton button;
    protected JLabel success;
    protected JFrame frame;

    public BasicScreen() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = userText.getText();
    }
}