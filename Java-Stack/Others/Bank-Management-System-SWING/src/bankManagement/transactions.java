package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transactions extends JFrame implements ActionListener {
    String pin_no;
    JButton deposit, withdraw, fastCash, mini_statement, pin_change, balance, exit;

    transactions(String pin_no) {
        this.pin_no = pin_no;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your transaction:");
        text.setBounds(215, 310, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(150, 450, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBounds(360, 450, 150, 35);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.addActionListener(this);
        fastCash.setBounds(150, 485, 150, 35);
        image.add(fastCash);

        mini_statement = new JButton("Mini-Statement");
        mini_statement.addActionListener(this);
        mini_statement.setBounds(360, 485, 150, 35);
        image.add(mini_statement);

        pin_change = new JButton("PIN-Change");
        pin_change.addActionListener(this);
        pin_change.setBounds(150, 520, 150, 35);
        image.add(pin_change);

        balance = new JButton("Balance Inquiry");
        balance.addActionListener(this);
        balance.setBounds(360, 520, 150, 35);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(360, 555, 150, 35);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new deposit(pin_no).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new withdrawal(pin_no).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new fastCash(pin_no).setVisible(true);
        } else if (ae.getSource() == pin_change) {
            setVisible(false);
            new pinChange(pin_no).setVisible(true);
        } else if(ae.getSource() == balance){
            setVisible(false);
            new balance_inquiry(pin_no).setVisible(true);
        } else if(ae.getSource() == mini_statement){
            new miniStatement(pin_no).setVisible(true);
        }
    }
    public static void main (String[]args){
        new transactions("");
    }
}
