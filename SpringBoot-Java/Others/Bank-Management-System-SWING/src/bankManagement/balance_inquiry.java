package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance_inquiry extends JFrame implements ActionListener {

    JButton back;
    String pin_no;
    balance_inquiry(String pin_no){
        setLayout(null);
        this.pin_no=pin_no;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(360,555,150,35);
        back.addActionListener(this);
        image.add(back);
        int balance = 0;

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '" + pin_no + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current account balance is Rs: "+ balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(160,310,700,35);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transactions(pin_no).setVisible(true);
    }
    public static void main(String[] args) {
        new balance_inquiry("");
    }
}
