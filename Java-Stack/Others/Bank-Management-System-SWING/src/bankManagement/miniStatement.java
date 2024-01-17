package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class miniStatement extends JFrame implements ActionListener {

    miniStatement(String pin_no){
        setTitle("Mini-Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("ICICI Bank");
        bank.setBounds(160,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pin_no+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) +
                        "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin_no+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
            balance.setText("Your current account balance is Rs: "+bal);
        } catch (Exception e){
            System.out.println(e);
        }

        mini.setBounds(20,140,400,195);

        setSize(400,600);
        setLocation(100,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args) {
        new miniStatement("");
    }


}
