import java.awt.*;
/* 
 * STUDENT NAME: NUR IZZAH BINTI BURHANUDDIN  
 * STUDENT ID: AM2307013907
 * LECTURER NAME: MADAM SITI ROBAYA BINTI JANTAN
 * PROGRAM DESCRIPTION: TO CREATE WELCOME PAGE FRAME AND SWICH TO DESTINATION SELECTION FRAME
 * SUB PROGRAM DESCRIPTION: USER SELECT INFORMATION REQUIRED IN DESTINATION SELECTION FRAME
 */

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.io.*;

public class Destination extends JFrame implements ActionListener
{
    //declaration of variables
    private JFrame frame;
    private JComboBox placeBox, place2Box, dateBox, date2Box, monthBox, month2Box;
    private JRadioButton[] radioTime, radioMonth;
    private JButton btnNext, btnBack;
    private String time = "", month = "";
    
    public Destination()
    {
        //place
        String[] place = {"Kuala Lumpur", "Jb Sentral", "Ipoh", "Alor Setar", "Arau", "Bukit Bentong", "Nilai", "Rawang", "Bertam", "Butterworth"};
        //String[] place2 = {"Kuala Lumpur", "Jb Sentral", "Ipoh", "Alor Setar", "Arau", "Bukit Bentong", "Nilai", "Rawang", "Bertam", "Butterworth"};
        placeBox = new JComboBox<>(place);
        place2Box = new JComboBox<>(place);
        
        //date
        String[] date = {"1", "2", "3","4","5","6","7","8","9","10",
                         "11","12","13","14","15","16","17","18","19","20",
                         "21","22","23","24","25","26","27","28","29","30",
                         "31"};
        //String[] date2 = {"1", "2", "3","4","5","6"};
        dateBox = new JComboBox<>(date);
        date2Box = new JComboBox<>(date);
        //@
        /*String[] date = new String[31];
        for (int i = 0; i < 31; i++)
            date[i] = String.valueOf(i + 1);
        dateBox = new JComboBox<>(date);
        date2Box = new JComboBox<>(date); **/
        
        String[] month = {"Jan", "Feb", "Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        //String[] month2 = {"Jan", "Feb", "Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
        monthBox = new JComboBox<>(month);
        month2Box = new JComboBox<>(month);
                
        //time
        radioTime = new JRadioButton[11];
        radioTime[0] = new JRadioButton("12.00am");
        radioTime[1] = new JRadioButton("1.50pm");
        radioTime[2] = new JRadioButton("2.00pm");
        radioTime[3] = new JRadioButton("3.30pm");
        radioTime[4] = new JRadioButton("4.00pm");
        radioTime[5] = new JRadioButton("5.50pm");
        radioTime[6] = new JRadioButton("7.00pm");
        radioTime[7] = new JRadioButton("8.50pm");
        radioTime[8] = new JRadioButton("9.30pm");
        radioTime[9] = new JRadioButton("10.30pm");
        radioTime[10] = new JRadioButton("12.50pm");
        ButtonGroup groupTime = new ButtonGroup();
        
        for(int i = 0; i<11; i++)
            groupTime.add(radioTime[i]);
        
        //panel place
        JPanel panelPlace = new JPanel ();
        panelPlace.setLayout(new GridLayout(1,0));
        panelPlace.setBounds(0,0,500,50); //axis-x, axis-y, width,heigth
        panelPlace.setBorder(BorderFactory.createTitledBorder("DEPART FROM"));
        panelPlace.add(placeBox);
        
        //panel place2
        JPanel panelPlace2 = new JPanel ();
        panelPlace2.setLayout(new GridLayout(1, 0));
        panelPlace2.setBounds(0, 50, 500, 50);
        panelPlace2.setBorder(BorderFactory.createTitledBorder("RETURN TO"));
        panelPlace2.add(place2Box);
               
        //day as in date and month
        JPanel day = new JPanel();
        day.setLayout(new GridLayout(2, 1));
        day.setBounds(0, 100, 500, 100);
        JLabel label1 = new JLabel("Date");
        JLabel label2 = new JLabel("Month");
        day.add(label1);
        day.add(dateBox);
        day.add(label2);
        day.add(monthBox);
        day.setBorder(BorderFactory.createTitledBorder("DATE DEPART"));
        
        //day2 as in date and month
        JPanel day2 = new JPanel();
        day2.setLayout(new GridLayout(2, 1));
        day2.setBounds(0, 200, 500, 100);
        JLabel label3 = new JLabel("Date");
        JLabel label4 = new JLabel("Month");
        day2.add(label3);
        day2.add(date2Box);
        day2.add(label4);
        day2.add(month2Box);
        day2.setBorder(BorderFactory.createTitledBorder("DATE RETURN"));
        
        // panel time
        JPanel panelTime = new JPanel();
        panelTime.setBounds(0, 300, 500, 50);
        for (int i = 0; i<11; i++)
            panelTime.add(radioTime[i]);
        panelTime.setBorder(BorderFactory.createTitledBorder("TIME"));
        
        //next button
        btnNext = new JButton("NEXT");
        btnNext.setBounds(200, 360, 100, 40);
        
        //frame
        frame = new JFrame();
        frame.setSize(500,460);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panelPlace);
        frame.add(panelPlace2);
        frame.add(day);
        frame.add(day2);
        frame.add(panelTime);
        frame.add(btnNext);
        
        //register listener
        btnNext.addActionListener(this);
        for(int i = 0; i<11; i++)
            radioTime[i].addActionListener(this);
    }//end of constructor
    
    public void actionPerformed(ActionEvent z)
    {
        for (int i = 0; i<11; i++)
            if (z.getSource() == radioTime[i])
            time = radioTime[i].getText();
        
        if (z.getSource() == btnNext)
        {
            TicketSelection ticketSelection = new TicketSelection (placeBox.getSelectedItem().toString(), 
                                                 place2Box.getSelectedItem().toString(),
                                                 dateBox.getSelectedItem().toString(),
                                                 date2Box.getSelectedItem().toString(),
                                                 monthBox.getSelectedItem().toString(),
                                                 month2Box.getSelectedItem().toString(),time);
            frame.dispose();
        }
        
    }
}
