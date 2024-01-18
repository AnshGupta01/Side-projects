package bankManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JButton sign_up, loginButton, clear;
    JTextField cardText;
    JPasswordField pinText;
    login(){
        setTitle("BANK ATM");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //load image
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //scale image
        ImageIcon i3 = new ImageIcon(i2); //converted image to image icon again to place on frame
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Calibre", Font.BOLD, 38));
        add(text);

        JLabel card_no = new JLabel("Card No:");
        card_no.setBounds(120,150,150,30);
        card_no.setFont(new Font("Rale way", Font.BOLD, 28));
        add(card_no);

        cardText = new JTextField();
        cardText.setBounds(300, 150, 230,30);
        cardText.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardText);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("Rale way", Font.BOLD, 28));
        add(pin);

        pinText = new JPasswordField();
        pinText.setBounds(300, 220, 230,30);
        pinText.setFont(new Font("Arial",Font.BOLD, 14));

        add(pinText);

        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(300,300,100,30);
        loginButton.addActionListener(this);
        add(loginButton);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(300,350,230,30);
        sign_up.addActionListener(this);
        add(sign_up);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
            cardText.setText("");
            pinText.setText("");

        }
        else if(e.getSource()==loginButton){
            Conn conn = new Conn();
            String card_no = cardText.getText();
            String pin_no = pinText.getText();
            String query = "select * from login where cardnumber = '"+card_no+"' and pin = '"+pin_no+"'";
            try{
                ResultSet ra = conn.s.executeQuery(query);
                if(ra.next()){
                    setVisible(false);
                    new transactions(pin_no).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect details entered for login");
                }
            } catch(Exception aae){
                System.out.println(aae);
            }
        }
        else if(e.getSource()==sign_up){
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}

