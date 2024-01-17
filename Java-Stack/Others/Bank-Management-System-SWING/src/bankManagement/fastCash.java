package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
    String pin_no;
    JButton hundred,thousand, five,two, fiveK,ten,back;
    fastCash(String pin_no){
        this.pin_no= pin_no;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount:");
        text.setBounds(215,310,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        hundred = new JButton("Rs 100");
        hundred.setBounds(150,450,150,35);
        hundred.addActionListener(this);
        image.add(hundred);

        five = new JButton("Rs 500");
        five.setBounds(360,450,150,35);
        five.addActionListener(this);
        image.add(five);

        thousand = new JButton("Rs 1000");
        thousand.addActionListener(this);
        thousand.setBounds(150,485,150,35);
        image.add(thousand);

        two = new JButton("Rs 2000");
        two.addActionListener(this);
        two.setBounds(360,485,150,35);
        image.add(two);

        fiveK = new JButton("Rs 5000");
        fiveK.addActionListener(this);
        fiveK.setBounds(150,520,150,35);
        image.add(fiveK);

        ten = new JButton("Rs 10,000");
        ten.addActionListener(this);
        ten.setBounds(360,520,150,35);
        image.add(ten);

        back = new JButton("Back");
        back.setBounds(360,555,150,35);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transactions(pin_no).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pin_no+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pin_no+"','"+date+"', 'Withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs:"+amount+ " Debited Successfully");

                setVisible(false);
                new transactions(pin_no).setVisible(true);

            } catch (Exception aae){
                System.out.println(aae);
            }
        }
    }
    public static void main(String[] args) {
        new fastCash("");
    }

}
