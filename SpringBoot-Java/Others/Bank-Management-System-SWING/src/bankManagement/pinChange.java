package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

    String pin_no;
    JPasswordField pin,repin;
    JButton change, back;
    pinChange(String pin_no){
        this.pin_no= pin_no;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your PIN:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(260,310,700,35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD,16));
        pinText.setBounds(160,350,200,35);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Rale way", Font.BOLD,25));
        pin.setBounds(320,355,150,25);
        image.add(pin);

        JLabel RepinText = new JLabel("Re-enter PIN:");
        RepinText.setForeground(Color.WHITE);
        RepinText.setFont(new Font("System", Font.BOLD,16));
        RepinText.setBounds(160,390,300,35);
        image.add(RepinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Rale way", Font.BOLD,25));
        repin.setBounds(320,395,150,25);
        image.add(repin);

        change = new JButton("Change your PIN");
        change.setBounds(360,520,150,35);
        change.addActionListener(this);
        image.add(change);

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
        if(ae.getSource()==change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!rpin.equals(npin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                else if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Entered PIN is empty");
                    return;
                }
                else if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-entered PIN is empty");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+npin+"' where pin = '"+pin_no+"'";
                String query2 = "update login set pin = '"+npin+"' where pin = '"+pin_no+"'";
                String query3= "update signupthree set pin = '"+npin+"' where pin = '"+pin_no+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN is updated Successfully");

                setVisible(false);
                new transactions(rpin).setVisible(true);


            } catch (Exception e){
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new transactions(pin_no).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new pinChange("").setVisible(true);
    }
}
