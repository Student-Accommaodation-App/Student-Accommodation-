/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ac.za.cput.studentaccomodationapp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Precious
 */
public class HomeGui {
    private JButton btnStudent;
    private JButton btnLandlord;
    private JButton btnUniversity;

    public JFrame welcomeWindow() {

        JFrame welcome = new JFrame("Student Life");

        JLabel lblNewUserRegister = new JLabel("Student Life Registration");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        lblNewUserRegister.setBounds(50, 100, 500, 50);

        btnStudent = new JButton("Student");
        btnLandlord = new JButton("Landlord");
        btnUniversity = new JButton("University");
        welcome.setResizable(false);
        btnUniversity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Student vr = new Student();
                welcome.setVisible(false);
                vr.starter();
            }
        });
       btnLandlord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                welcome.setVisible(false);
                LandlordRegistration rg = new LandlordRegistration();
                welcome.setVisible(false);
                rg.setVisible(true);
            }
        });

        btnStudent.addActionListener(new ActionListener() {
            

            @Override
            public void actionPerformed(ActionEvent ae) {
                welcome.setVisible(false);
                University rg = new University();
                welcome.setVisible(false);
                rg.starter();
            }
        });

        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setSize(500, 600);
        welcome.setLocationRelativeTo(null);
        welcome.setVisible(true);
        welcome.getContentPane().setLayout(null);

        btnStudent.setFont(new Font("roman", Font.BOLD, 14));
        btnStudent.setBounds(130, 300, 210, 37);
        
        btnLandlord.setFont(new Font("roman", Font.BOLD, 14));
        btnLandlord.setBounds(130, 350, 210, 37);

        btnUniversity.setFont(new Font("roman", Font.BOLD, 14));
        btnUniversity.setBounds(130, 400, 210, 37);

        welcome.add(lblNewUserRegister);
        welcome.add(btnStudent);
        welcome.add(btnLandlord);
        welcome.add(btnUniversity);

        return welcome;
    }

    public void startProgram() {
        

        new HomeGui().welcomeWindow();

    }

    public static void main(String[] args) {
        
        HomeGui st = new HomeGui();
        st.startProgram();
    }
}
