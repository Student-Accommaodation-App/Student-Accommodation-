/**
 *
 * @author Precious
 */
package ac.za.cput.studentaccomodationapp.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class University extends JFrame  {
    
    
    private JPanel panelNorth;
    private JTextField txfName;
    private JLabel lblName;
    private JLabel lblUniversityName;

    private JPanel panelCenter;
    private JComboBox universityName;
    private JButton btnSearch, btnExit;  

    public University(){
    super();
    this.setLayout( new GridLayout(2,2));

    //panelNorth = new JPanel(new FlowLayout());
    //this.add(panelNorth, BorderLayout.NORTH);
    lblName = new JLabel("Search University Name: ");
    this.add(lblName);
    this.add(universityName);
    //panelCenter = new JPanel(new FlowLayout());
    //this.add(panelCenter, BorderLayout.CENTER);
    universityName = new JComboBox(new String[]{"UCT", "WITS", "UP", "CPUT"});
    

    btnSearch = new JButton("Search");
    
    btnExit = new JButton("Exit");
    

    btnSearch.addActionListener((ActionListener) this);
    btnExit.addActionListener((ActionListener) this);
    }

    public void setGui(){

//    panelNorth.add(lblName);
//    panelNorth.add(universityName);
    //panelNorth.add(btnSearch);
    //panelNorth.add(btnExit);

//panelCenter.add();
    }

    public void actionPerformed(ActionEvent e){ 

        if(e.getSource()== btnSearch){
          /* DAO search = new DAO();
           s.search();
           String email = txfEmail.getText();
           String password1 = password.getText();*/
String[] userValue={"UCT", "WITS", "UP", "CPUT"};
userValue[1] = "UCT";



        ArrayList<POJO> cputList= new ArrayList<>();
            
                cputList.add(new POJO("CPUT", "District 6", "Cape town campus"));
                cputList.add(new POJO("CPUT", "Bellville","Main Campus" ));                	
                cputList.add(new POJO("CPUT", "mowbray", "Mowbray Campus"));    
                
        ArrayList<POJO> uctList= new ArrayList<>();

                uctList.add(new POJO("UCT", "Rondebosch","Groote Schuur Campus" )); 
                uctList.add(new POJO("UCT", "Observatory","Medical Campus" ));  
        
        ArrayList<POJO> upList= new ArrayList<>();

                upList.add(new POJO("UP", "Rondebosch","Groote Schuur Campus" )); 
                upList.add(new POJO("Up", " Hatfield ","Campus Main" ));
                upList.add(new POJO("Up", "Mamelodi","Mamelodi Campus" ));
                upList.add(new POJO("Up", "Groenkloof,","Groenkloof Campus" ));

        ArrayList<POJO> witsList= new ArrayList<>();

                witsList.add(new POJO("WITS", "Braamfontein","Braamfontein Campus" )); 
        
        ArrayList<POJO> ujList= new ArrayList<>();
                 
                ujList.add(new POJO("UJ", "  Auckland Park Kingsway ","Auckland Park Bunting Road" ));
                ujList.add(new POJO("UJ", "Doornfontein Campus","Doornfontein " ));
           
 if ( userValue.equals("UCT")) JOptionPane.showMessageDialog(null, uctList.toString());

            else if ( userValue.equals("CPUT")) {
                JOptionPane.showMessageDialog(null, cputList.toString());
            }
 
           else if ( userValue.equals("UP")) {
                JOptionPane.showMessageDialog(null, upList.toString());
            }

            else if ( userValue.equals("WITS")) {
                JOptionPane.showMessageDialog(null, witsList.toString());
            }
            else if ( userValue.equals("UJ")) {
                JOptionPane.showMessageDialog(null, ujList.toString());
            }    

            else {JOptionPane.showMessageDialog(null,uctList.toString());}  


        }
        else if(e.getSource() == btnExit){
            System.exit(0);
        }
    }

    void starter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class POJO {

        public POJO() {
        }

        private POJO(String cput, String district_6, String cape_town_campus) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
