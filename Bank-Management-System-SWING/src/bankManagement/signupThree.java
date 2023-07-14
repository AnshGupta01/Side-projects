package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton saving_acc,current_acc, Fd_account, recurring_account;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    public signupThree(String formno){
        this.formno = formno;

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Rale way", Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel account_type = new JLabel("Account Type:");
        account_type.setFont(new Font("Rale way", Font.BOLD,22));
        account_type.setBounds(100,140,200,30);
        add(account_type);

        saving_acc = new JRadioButton("Saving's Account");
        saving_acc.setFont(new Font("Rale way", Font.BOLD, 16));
        saving_acc.setBackground(Color.WHITE);
        saving_acc.setBounds(100,180,200,20);
        add(saving_acc);

        Fd_account = new JRadioButton("FD Account");
        Fd_account.setFont(new Font("Rale way", Font.BOLD, 16));
        Fd_account.setBackground(Color.WHITE);
        Fd_account.setBounds(350,180,200,20);
        add(Fd_account);

        current_acc = new JRadioButton("Current Account");
        current_acc.setFont(new Font("Rale way", Font.BOLD, 16));
        current_acc.setBackground(Color.WHITE);
        current_acc.setBounds(100,220,200,20);
        add(current_acc);

        recurring_account = new JRadioButton("Recurring Account");
        recurring_account.setFont(new Font("Rale way", Font.BOLD, 16));
        recurring_account.setBackground(Color.WHITE);
        recurring_account.setBounds(350,220,200,20);
        add(recurring_account);

        ButtonGroup account_group = new ButtonGroup();
        account_group.add(saving_acc);
        account_group.add(recurring_account);
        account_group.add(Fd_account);
        account_group.add(current_acc);

        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("Rale way", Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Rale way", Font.BOLD,22));
        number.setBounds(300,300,300,30);
        add(number);

        JLabel info = new JLabel("Your 16-Digit Card Number");
        info.setFont(new Font("Rale way", Font.BOLD,12));
        info.setBounds(100,330,300,15);
        add(info);

        JLabel pin = new JLabel("Card PIN:");
        pin.setFont(new Font("Rale way", Font.BOLD,22));
        pin.setBounds(100,370,300,30);
        add(pin);

        JLabel info_2 = new JLabel("Your 4-Digit Card PIN");
        info_2.setFont(new Font("Rale way", Font.BOLD,12));
        info_2.setBounds(100,400,300,15);
        add(info_2);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Rale way", Font.BOLD,22));
        pnumber.setBounds(300,370,300,30);
        add(pnumber);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Rale way", Font.BOLD,22));
        services.setBounds(100,450,400,30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Rale way", Font.BOLD, 16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Rale way", Font.BOLD, 16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Rale way", Font.BOLD, 16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL ALERTS");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Rale way", Font.BOLD, 16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Rale way", Font.BOLD, 16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Rale way", Font.BOLD, 16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I herby declare that above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Rale way", Font.BOLD, 12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Rale way", Font.BOLD, 12));
        submit.setBounds(220,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Rale way", Font.BOLD, 12));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLayout(null);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){

            String account_type = null;
            if(saving_acc.isSelected()){
                account_type = "Savings Account";
            } else if(current_acc.isSelected()){
                account_type = "Current Account";
            } else if(Fd_account.isSelected()){
                account_type = "FD Account";
            } else if(recurring_account.isSelected()){
                account_type = "Recurring Account";
            }

            Random random = new Random();
            String card_no =""+ Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pin_no = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facilities = "";
            if(c1.isSelected()){
                facilities = facilities + " ATM CARD";
            } else if(c2.isSelected()){
                facilities = facilities + " INTERNET BANKING";
            } else if(c3.isSelected()){
                facilities = facilities + " MOBILE BANKING";
            } else if(c4.isSelected()){
                facilities = facilities + " EMAIL ALERTS";
            } else if(c5.isSelected()){
                facilities = facilities + " CHEQUE BOOK";
            } else if(c6.isSelected()){
                facilities = facilities + " E-STATEMENTS";
            }

            try{
                if(account_type.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query = "insert into signupthree values('"+formno+"','"+account_type+"','"+card_no+"','"+pin_no+"','"+facilities+"')";
                    String query2 = "insert into login values('"+formno+"','"+card_no+"','"+pin_no+"')";

                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your Card Number is:" + card_no +"\n PIN is:" + pin_no);
                    setVisible(false );
                    new deposit(pin_no).setVisible(true );
                }
            } catch(Exception e){
                System.out.println(e);
            }

        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new signupThree("");
    }
}
