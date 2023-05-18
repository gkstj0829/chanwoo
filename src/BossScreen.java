// BossScreen.java
import javax.swing.*;
import java.awt.event.*;

public class BossScreen extends BasicScreen {
    private Util util;

    public BossScreen() {
        super();
        util = new Util();

        frame.setTitle("Boss Screen");

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                util.addEmployee();
            }
        });

        JButton removeButton = new JButton("Remove Employee");
        removeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                util.removeEmployee();
            }
        });

        JButton payrollButton = new JButton("Calculate Total Payroll");
        payrollButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                util.calculateTotalPayroll();
            }
        });

        JButton scheduleButton = new JButton("Display Schedule");
        scheduleButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                util.displaySchedule();
            }
        });

        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(payrollButton);
        panel.add(scheduleButton);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
