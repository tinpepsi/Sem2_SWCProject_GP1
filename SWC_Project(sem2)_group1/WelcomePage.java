/* 
 * STUDENT NAME: NUR IZZAH BINTI BURHANUDDIN  
 * STUDENT ID: AM2307013907
 * LECTURER NAME: MADAM SITI ROBAYA BINTI JANTAN
 * PROGRAM DESCRIPTION: TO CREATE WELCOME PAGE FRAME AND SWICH TO DESTINATION SELECTION FRAME
 * SUB PROGRAM DESCRIPTION: USER SELECT INFORMATION REQUIRED IN DESTINATION SELECTION FRAME
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener
{
    JButton startButton;
    
    //constructor without parameter
    public WelcomePage()
    {
        //title for reservation
        setTitle("Welcome to Luxe Link Express!");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //image icon logo
        ImageIcon sign = new ImageIcon("train_blue.png");
        JLabel signlabel = new JLabel (sign);
        signlabel.setIcon(sign);
        
        //panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);
        
        //start button
        startButton = new JButton ("START");
        startButton.addActionListener(this); //register to a listener
        panel.add(startButton, BorderLayout.SOUTH);
        
        //set the bounds of the other stuf
        startButton.setBounds(200, 250, 100, 90);
        panel.add(signlabel);
        
        setVisible(true);
    }//end of constructorr
    
    //method overriding
    public void actionPerformed(ActionEvent z)
    {
        if (z.getSource() == startButton)
        {
            Destination destination = new Destination ();
            dispose();
        }//end of if
    }//end of method
    
}//end of class