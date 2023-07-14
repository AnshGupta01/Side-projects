package bankManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signupOne extends JFrame implements ActionListener {

    long random;
    JTextField name_t, fname_t,email_t,address_t,city_t,state_t,pin_t;
    JButton next;
    JRadioButton male,female,unknown_married,married,unmarried;
    JDateChooser dob_t;
    signupOne(){
        setLayout(null);
        Random r1 = new Random();
        random = Math.abs((r1.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO:"+ random);
        formno.setFont(new Font("Rale way",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personal_details = new JLabel("Page 1: Personal Details");
        personal_details.setFont(new Font("Rale way",Font.BOLD,22));
        personal_details.setBounds(290,80,400,30);
        add(personal_details);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Rale way",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        name_t = new JTextField();
        name_t.setFont(new Font("Rale way", Font.BOLD, 14));
        name_t.setBounds(300,140,400,30);
        add(name_t);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Rale way",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fname_t = new JTextField();
        fname_t.setFont(new Font("Rale way", Font.BOLD, 14));
        fname_t.setBounds(300,190,400,30);
        add(fname_t);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Rale way",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dob_t = new JDateChooser();
        dob_t.setBounds(300,240,400,30);
        dob_t.setForeground(new Color(105,105,105));
        add(dob_t);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Rale way",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(300,290,120,30);
        female.setBounds(450,290,120,30);
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        add(male);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Rale way",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        email_t = new JTextField();
        email_t.setFont(new Font("Rale way", Font.BOLD, 14));
        email_t.setBounds(300,340,400,30);
        add(email_t);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Rale way",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        unknown_married = new JRadioButton("Other");
        married.setBounds(300,390,120,30);
        unmarried.setBounds(450,390,120,30);
        unknown_married.setBounds(600,390,120,30);
        married.setBackground(Color.WHITE);
        unmarried.setBackground(Color.WHITE);
        unknown_married.setBackground(Color.WHITE);
        add(unknown_married);
        add(married);
        add(unmarried);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(unknown_married);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Rale way",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        address_t = new JTextField();
        address_t.setFont(new Font("Rale way", Font.BOLD, 14));
        address_t.setBounds(300,440,400,30);
        add(address_t);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Rale way",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        city_t = new JTextField();
        city_t.setFont(new Font("Rale way", Font.BOLD, 14));
        city_t.setBounds(300,490,400,30);
        add(city_t);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Rale way",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        state_t = new JTextField();
        state_t.setFont(new Font("Rale way", Font.BOLD, 14));
        state_t.setBounds(300,540,400,30);
        add(state_t);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Rale way",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pin_t = new JTextField();
        pin_t.setFont(new Font("Rale way", Font.BOLD, 14));
        pin_t.setBounds(300,590,400,30);
        add(pin_t);

        next = new JButton("Next");
        next.setFont(new Font("Rale way", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String sformno = "" + random; // converts to string to store in mySQL
        String sname = name_t.getText(); //gets value
        String sfname = fname_t.getText();
        String sdob = ((JTextField)dob_t.getDateEditor().getUiComponent()).getText();
        String sgender = null;
        if(male.isSelected()){
            sgender = "male";
        }else if(female.isSelected()){
            sgender = "female";
        }
        String semail = email_t.getText();
        String smarital = null;
        if(married.isSelected()){
            smarital = "Married";
        }else if(unmarried.isSelected()){
            smarital = "Unmarried";
        }else if(unknown_married.isSelected()){
            smarital = "other";
        }
        String saddress = address_t.getText();
        String scity = city_t.getText();
        String sstate = state_t.getText();
        String spin = pin_t.getText();


        try{
            if(sname.equals("") || sfname.equals("") || sdob.equals("") || sgender == null || semail.equals("") || smarital == null || saddress.equals("") || scity.equals("") || sstate.equals("") || spin.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+sformno+"','"+sname+"','"+sfname+"','"+sdob+"','"+sgender+"','"+semail+"','"+smarital+"','"+saddress+"','"+scity+"','"+sstate+"','"+spin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signuptwo(sformno).setVisible(true);
            }
        }catch(Exception ea){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signupOne();
    }
}

