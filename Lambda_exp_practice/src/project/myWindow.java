package project;

import javax.swing.*;
import java.awt.*;

public class myWindow {
    public static void main(String[] args) {
        //window object of Jframe
        JFrame frame = new JFrame("My Window");
        frame.setSize(400,400);
        frame.setLayout(new FlowLayout());

        //buttons
        JButton button = new JButton("Click me");
        frame.add(button);

        //Action listener is a functional interface
        button.addActionListener(e-> JOptionPane.showMessageDialog(null, "Button is pressed"));



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
