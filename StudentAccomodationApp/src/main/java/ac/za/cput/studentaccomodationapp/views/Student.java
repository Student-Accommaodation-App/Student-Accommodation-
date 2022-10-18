/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ac.za.cput.studentaccomodationapp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Precious
 */
public class Student {
      public static void main(String[] args) {
                  Student student = new Student();
         }
         
         Connection con = null;
    
         JFrame frame;
         String[] gender = new String[] {"Male", "Female"};
         JLabel label1 = new JLabel("NAME: ");
         JLabel label2 = new JLabel("SURNAME: ");
         JLabel label3 = new JLabel("GENDER: ");
         JLabel label4 = new JLabel("CITY/TOWN: ");
         JLabel label5 = new JLabel("CELL NO.: ");
         JLabel label6 = new JLabel("STUDENT EMAIL: ");
         JLabel label7 = new JLabel("PASSWORD.: ");
         JTextField text1 = new JTextField();
         JTextField text2 = new JTextField();         
         JComboBox<String> box = new JComboBox<>(gender);
         JTextField text3 = new JTextField();
         JTextField text4 = new JTextField();
         JTextField text5 = new JTextField();
         JTextField text6 = new JTextField();
         JButton reset = new JButton("RESET");
         JButton save = new JButton("SAVE");
         JButton exit = new JButton("EXIT");
         
         JButton update = new JButton("UPDATE");
         JButton view = new JButton("VIEW");
         JButton delete = new JButton("DELETE");
         
         Student () {
                  createWindow();
                  setLocationAndSize();
                  addComponentsToFrame();
                  actionEvent();
         }
         
         public void createWindow() {
                  frame = new JFrame();
                  frame.setTitle("STUDENT FORM:");
                  frame.setBounds(40, 40, 380, 600);
                  frame.getContentPane().setBackground(Color.white);
                  frame.getContentPane().setLayout(null);
                  frame.setVisible(true);
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  frame.setResizable(false);
         }
         
         public void setLocationAndSize() {
                  label1.setBounds(20, 20, 40, 70);
                  label2.setBounds(20, 70, 80, 70);
                  label3.setBounds(20, 120, 100, 70);
                  label4.setBounds(20, 170, 100, 70);
                  label5.setBounds(20, 220, 140, 70);
                  label6.setBounds(20, 270, 100, 70);
                  label7.setBounds(20, 320, 100, 70);
                  text1.setBounds(180, 43, 165, 23);
                  text2.setBounds(180, 93, 165, 23);
                  box.setBounds(180, 143, 165, 23);
                  text3.setBounds(180, 193, 165, 23);
                  text4.setBounds(180, 243, 165, 23);
                  text5.setBounds(180, 293, 165, 23);
                  text6.setBounds(180, 343, 165, 23);
                  reset.setBounds(10, 400, 100, 35);
                  save.setBounds(130, 400, 100, 35);
                  exit.setBounds(250, 400, 100, 35);
                  
                  update.setBounds(10, 450, 100, 35);
                  view.setBounds(130, 450, 100, 35);
                  delete.setBounds(250,450,100,35);
         }
         
         public void addComponentsToFrame() {
                  frame.add(label1);
                  frame.add(label2);
                  frame.add(label3);
                  frame.add(label4);
                  frame.add(label5);
                  frame.add(label6);
                  frame.add(label7);
                  frame.add(text1);
                  frame.add(text2);
                  frame.add(box, BorderLayout.CENTER);
                  frame.add(text3);
                  frame.add(text4);
                  frame.add(text5);
                  frame.add(text6);
                  frame.add(reset);
                  frame.add(save);
                  frame.add(exit);
                  
                  frame.add(update);
                  frame.add(view);
                  frame.add(delete);
         }
         
         public void actionEvent() {
                  reset.addActionListener((ActionListener) this);
                  save.addActionListener((ActionListener) this);
                  exit.addActionListener((ActionListener) this);
                  
                  update.addActionListener((ActionListener) this);
                  view.addActionListener((ActionListener) this);
                  delete.addActionListener((ActionListener) this);
         }
         
         public void actionPerformed(ActionEvent action) {
                  if (action.getSource() == reset) {
                           text1.setText(" ");
                           text2.setText(" ");
                           box.setSelectedItem(" ");
                           text3.setText(" ");
                           text4.setText(" ");
                           text5.setText(" ");
                           text6.setText(" ");
                  }
                  
                  if(action.getSource() == save) {
         
                           try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/STUDENT");
                                    PreparedStatement statement = con.prepareStatement("instert into student values (?,?,?,?,?,?,?)");
                                    statement.setString(1, text1.getText());
                                    statement.setString(2, text2.getText());
                                    statement.setString(3, box.getSelectedItem().toString());
                                    statement.setString(4, text3.getText());
                                    statement.setString(5, text4.getText());
                                    statement.setString(6, text5.getText());
                                    statement.setString(7, text6.getText());
                                    
                                    if (text6.getText().equalsIgnoreCase("12345")) {
                                             statement.executeUpdate();
                                             JOptionPane.showMessageDialog(null, "Data Successfully Registered!");
                                    }
                                    else {
                                             JOptionPane.showMessageDialog(null, "Password Invalid!");
                                    }
                           }
                           
                           catch(ClassNotFoundException | SQLException e) {
                                    JOptionPane.showMessageDialog(null, e);
                           }
                  }
                  
                  if (action.getSource() == exit) {
                           System.exit(1);
                  }
                  
                  /*if (action.getSource() == update) {
                           String sql = "UPDATE Student"
                                                      + " SET txtName = ?"
                                                      + ", txtSurname = ?"
                                                      + ", boxGender = ?"
                                                      + ", txtCity/Town = ?"
                                                      + ", txtCell = ?"
                                                      + ", txtEmail = ?"
                                                      + "WHERE txtPassword = ?";
                           
                           try {
                                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:1527/Student","sinalo","sinalo");
                                    PreparedStatement statement = connection.prepareStatement("instert into student values(?,?,?,?,?,?,?)");
                                    statement.setString(1, text1.getText());
                                    statement.setString(2, text2.getText());
                                    statement.setString(3, box.getSelectedItem().toString());
                                    statement.setString(4, text3.getText());
                                    statement.setString(5, text4.getText());
                                    statement.setString(6, text5.getText());
                                    statement.setString(7, text6.getText());
                               
                           }
                  }*/
         }

    void starter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
