package bankManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signuptwo extends JFrame implements ActionListener {
        String formno;
        JTextField aadhar_t, pan_t;
        JButton next;
        JRadioButton syes,sno,eyes,eno;
        JComboBox<String> religion_t, category_t, occupation_t, education_t,income_t;
        signuptwo(String formno){
            this.formno = formno ;
            setLayout(null);
            setTitle("NEW ACCOUNT APPLICATION PAGE 2:");

            JLabel additional_details = new JLabel("Page 2: Additional Details");
            additional_details.setFont(new Font("Rale way",Font.BOLD,22));
            additional_details.setBounds(290,80,400,30);
            add(additional_details);

            JLabel religion = new JLabel("Religion:");
            religion.setFont(new Font("Rale way",Font.BOLD,20));
            religion.setBounds(100,140,100,30);
            add(religion);

            String[] valReligion = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
            religion_t = new JComboBox<>(valReligion);
            religion_t.setFont(new Font("Rale way", Font.BOLD, 14));
            religion_t.setBackground(Color.WHITE);
            religion_t.setBounds(300,140,400,30);
            add(religion_t);

            JLabel category = new JLabel("Category:");
            category.setFont(new Font("Rale way",Font.BOLD,20));
            category.setBounds(100,190,200,30);
            add(category);

            String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
            category_t = new JComboBox<>(valCategory);
            category_t.setBackground(Color.WHITE);
            category_t.setFont(new Font("Rale way", Font.BOLD, 14));
            category_t.setBounds(300,190,400,30);
            add(category_t);

            JLabel income = new JLabel("Income:");
            income.setFont(new Font("Rale way",Font.BOLD,20));
            income.setBounds(100,240,200,30);
            add(income);

            String[] incomeCategory = {"Null", "< 1,50,000", "<2,50,000", "< 5,00,000", "upto 10,00,000"};
            income_t = new JComboBox<>(incomeCategory);
            income_t.setBounds(300,240,400,30);
            income_t.setBackground(Color.WHITE);
            add(income_t);

            JLabel education = new JLabel("Educational");
            education.setFont(new Font("Rale way",Font.BOLD,20));
            education.setBounds(100,290,200,30);
            add(education);

            JLabel qualification = new JLabel("Qualification:");
            qualification.setFont(new Font("Rale way",Font.BOLD,20));
            qualification.setBounds(100,310,200,30);
            add(qualification);

            String[] educationVal = {"Non-Graduate", "<Graduate", "<Post-Graduate", "Doctrate", "Other"};
            education_t = new JComboBox<>(educationVal);
            education_t.setBounds(300,310,400,30);
            education_t.setBackground(Color.WHITE);
            add(education_t);

            JLabel occupation = new JLabel("Occupation:");
            occupation.setFont(new Font("Rale way",Font.BOLD,20));
            occupation.setBounds(100,390,200,30);
            add(occupation);

            String[] occupationVal = {"Salaried", "Self-Employed", "Business", "Retired", "Other"};
            occupation_t = new JComboBox<>(occupationVal);
            occupation_t.setBounds(300,390,400,30);
            occupation_t.setBackground(Color.WHITE);
            add(occupation_t);


            JLabel pan_card = new JLabel("PAN CARD:");
            pan_card.setFont(new Font("Rale way",Font.BOLD,20));
            pan_card.setBounds(100,440,200,30);
            add(pan_card);

            pan_t = new JTextField();
            pan_t.setFont(new Font("Rale way", Font.BOLD, 14));
            pan_t.setBounds(300,440,400,30);
            add(pan_t);

            JLabel aadhar = new JLabel("Aadhar No:");
            aadhar.setFont(new Font("Rale way",Font.BOLD,20));
            aadhar.setBounds(100,490,200,30);
            add(aadhar);

            aadhar_t = new JTextField();
            aadhar_t.setFont(new Font("Rale way", Font.BOLD, 14));
            aadhar_t.setBounds(300,490,400,30);
            add(aadhar_t);

            JLabel senior_citizen = new JLabel("Senior Citizen:");
            senior_citizen.setFont(new Font("Rale way",Font.BOLD,20));
            senior_citizen.setBounds(100,540,200,30);
            add(senior_citizen);

            syes = new JRadioButton("YES");
            syes.setFont(new Font("Rale way", Font.BOLD, 14));
            syes.setBounds(300,540,100,30);
            add(syes);
            sno = new JRadioButton("NO");
            sno.setFont(new Font("Rale way", Font.BOLD, 14));
            sno.setBounds(500,540,100,30);
            add(sno);
            ButtonGroup senior_group = new ButtonGroup();
            senior_group.add(syes);
            senior_group.add(sno);

            JLabel existing_acc = new JLabel("Existing Account:");
            existing_acc.setFont(new Font("Rale way",Font.BOLD,20));
            existing_acc.setBounds(100,590,200,30);
            add(existing_acc);

            eyes = new JRadioButton("YES");
            eyes.setFont(new Font("Rale way", Font.BOLD, 14));
            eyes.setBounds(300,590,100,30);
            add(eyes);
            eno = new JRadioButton("NO");
            eno.setFont(new Font("Rale way", Font.BOLD, 14));
            eno.setBounds(500,590,100,30);
            add(eno);
            ButtonGroup account_group = new ButtonGroup();
            account_group.add(eyes);
            account_group.add(eno);

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
            String sReligion = (String)religion_t.getSelectedItem();
            String sCategory = (String)category_t.getSelectedItem();
            String sIncome = (String)income_t.getSelectedItem();
            String sEducation = (String)education_t.getSelectedItem();
            String sOccupation = (String)occupation_t.getSelectedItem();
            String sSenior_citizen = null;
            if(syes.isSelected()){
                sSenior_citizen = "YES";
            }else if(sno.isSelected()){
                sSenior_citizen = "NO";
            }
            String sAccount = null;
            if(eyes.isSelected()){
                sAccount = "YES";
            }else if(eno.isSelected()){
                sAccount = "NO";
            }
            String sPAN = pan_t.getText();
            String sAdhaar = aadhar_t.getText();

            try{
                Conn c = new Conn();
                    String query = "insert into signuptwo values('"+formno+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sEducation+"','"+sOccupation+"','"+sSenior_citizen+"','"+sAccount+"','"+sPAN+"','"+sAdhaar+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new signupThree(formno).setVisible(true);

            }catch(Exception ea){
                System.out.println(e);
            }
        }

        public static void main(String[] args) {
            new bankManagement.signuptwo("");
        }
}
