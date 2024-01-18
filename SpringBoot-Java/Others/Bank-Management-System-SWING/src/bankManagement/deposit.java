package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
    JButton deposit, back;
    String pin_no;
    JTextField amount;
    deposit(String pin_no){
        setLayout(null);
        this.pin_no=pin_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(175,310,400,35);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Rale way", Font.BOLD,22));
        amount.setBounds(175,350,320,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(360,525,150,35);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(360,560,150,35);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter an amount you want to deposit");
            }
            else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pin_no+"','"+date+"','Deposit','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs:"+number+" deposited successfully");
                    setVisible(false);
                    new transactions(pin_no).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }

            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new transactions(pin_no).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new deposit("");
    }

}
