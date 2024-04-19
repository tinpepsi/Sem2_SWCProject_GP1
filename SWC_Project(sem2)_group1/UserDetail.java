/* 
 * STUEDNT NAME: NUR ATHIRAH BINTI HILALLUDDIN 
 * STUDENT ID: AM2307013911
 * LECTURER NAME: MADAM SITI ROBAYA BINTI JANTAN
 * PROGRAM DESCRIPTION: TO KEY IN USER DETAIL INFORMATION FROM TICKET SELECTION FRAME, THEN WILL BE PASSED TO RECEIPT FRAME. 
 * SUB PROGRAM DESCRIPTION: DISPLAY AND CALCULATE TICKET PRICE BASED ON USER SELECTION CLASS
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class UserDetail extends JFrame  
{
    private JLabel lblName, lblPhoneNum, lblEmail, lblAddress; 
    private JTextField txtName, txtPhoneNum, txtEmail, txtAddress;
    private JButton confirmButton, clearButton, nextButton;
    private JTextArea displayTextArea;

    double price_adult, price_child, price_infant;
    double total_ticket_price;
    public UserDetail(String placeBox, String place2Box,String dateBox, String date2Box, String monthBox, String month2Box, String time,    
    String TicketTypeBox,int adultQTY, int childQTY, int infantQTY)
    {
        setTitle("USER DETAIL AND TICKET PRICE"); // title for frame
        setSize(980,600); // set size for frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        //creating main panel to place sub-panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS)); // place panel in X-axis

        //user detail and display user detail panel
        JPanel Leftpnl = new JPanel(); //left panel
        Leftpnl.setLayout(new BoxLayout(Leftpnl, BoxLayout.Y_AXIS)); // place panel in y-axis
        Leftpnl.setPreferredSize(new Dimension(490, 120)); // resize the panel

        //Start panel user detail information
        JPanel pnl1 = new JPanel(new BorderLayout()); // panel for price
        pnl1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        pnl1.setPreferredSize(new Dimension(0, 120)); // resize the panel
        pnl1.setBorder(BorderFactory.createTitledBorder("ENTER YOUR DETAIL")); // Setting border for panel3

        //creating grid panel inside detail information panel
        JPanel userDetail = new JPanel(new GridLayout(5,2));  // set grid 5 rows, 2 columns

        //component
        lblName = new JLabel("NAME:");
        lblPhoneNum = new JLabel("PHONE NUMBER:");
        lblEmail = new JLabel("EMAIL:");
        lblAddress = new JLabel("ADDRESS:");

        //20 width of the text field
        txtName = new JTextField(20);
        txtPhoneNum = new JTextField(20);
        txtEmail = new JTextField(20);
        txtAddress = new JTextField(20);

        //adding component to the frame
        userDetail.add(lblName);
        userDetail.add(txtName);
        userDetail.add(lblPhoneNum);
        userDetail.add(txtPhoneNum);
        userDetail.add(lblEmail);
        userDetail.add(txtEmail);
        userDetail.add(lblAddress);
        userDetail.add(txtAddress);

        // Adding Clear button inside userDetail
        clearButton = new JButton("Clear");
        userDetail.add(clearButton);

        // Adding Confirm button inside userDetail
        confirmButton = new JButton("Confirm");
        userDetail.add(confirmButton);

        pnl1.add(userDetail); // Adding the userDetail inside panel 1
        //end panel user detail information

        //panel display user information
        JPanel pnl2 = new JPanel(new BorderLayout()); // panel for price
        pnl2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        pnl2.setPreferredSize(new Dimension(0, 120)); // resize the panel
        pnl2.setBorder(BorderFactory.createTitledBorder("DETAIL")); // Setting border for panel3

        // Creating display text area
        displayTextArea = new JTextArea();
        displayTextArea.setEditable(false); // Make it read-only
        JScrollPane scrollPane = new JScrollPane(displayTextArea); // scroll bar 
        pnl2.add(scrollPane);// adding scroll bar on the text area
        //end panel display user information

        //ading userDetail and userDisplay inside right panel 
        Leftpnl.add(pnl1);
        Leftpnl.add(pnl2);
        //end right panel 

        //right panel to be put inside main panel
        //price panel
        JPanel Rightpnl = new JPanel(); // right panel
        Rightpnl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        Rightpnl.setBorder(BorderFactory.createTitledBorder("PRICE")); // Setting border forprice panel 
        Rightpnl.setLayout(new BoxLayout(Rightpnl, BoxLayout.Y_AXIS)); // place panel in X-axis
        Rightpnl.setPreferredSize(new Dimension(490, 120)); // resize the panel

        // Adding the GridLayout panel to the NORTH position of panel2
        JPanel NorthPnl = new JPanel(new GridLayout(2,4)); // (2 rows, 4 columns)
        NorthPnl.setPreferredSize(new Dimension(0, 100)); // resize the panel

        //display label at north
        JLabel clazzlbl = new JLabel ("CLASS", SwingConstants.CENTER);
        clazzlbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        JLabel adultlbl = new JLabel ("ADULT", SwingConstants.CENTER);
        adultlbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        JLabel childlbl = new JLabel ("CHILD", SwingConstants.CENTER);
        childlbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        JLabel infantlbl = new JLabel ("INFANT", SwingConstants.CENTER);
        infantlbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        // Creating labels for displaying user Choice from ticket selection frame
        String ticketType = TicketTypeBox.toUpperCase(); // Convert text to uppercase
        JLabel lblTicketType = new JLabel(ticketType, SwingConstants.CENTER); 
        lblTicketType.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        JLabel lblAdult = new JLabel(String.valueOf(adultQTY), SwingConstants.CENTER);
        lblAdult.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        JLabel lblChild = new JLabel(String.valueOf(childQTY), SwingConstants.CENTER);
        lblChild.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        JLabel lblInfant = new JLabel(String.valueOf(infantQTY), SwingConstants.CENTER);
        lblInfant.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        // Add labels to the northPanel
        NorthPnl.add(clazzlbl);
        NorthPnl.add(adultlbl);
        NorthPnl.add(childlbl);
        NorthPnl.add(infantlbl);
        NorthPnl.add(lblTicketType);
        NorthPnl.add(lblAdult);
        NorthPnl.add(lblChild);
        NorthPnl.add(lblInfant);

        //panel for price (center)
        JPanel CenterPnl = new JPanel(new GridLayout(3,2)); // (2 rows, 4 columns)
        CenterPnl.setPreferredSize(new Dimension(0, 130)); // resize the panel

        // display total price for adult, child and infant
        price_adult = CalculationAdult( TicketTypeBox,adultQTY);
        price_child = CalculationChild( TicketTypeBox,childQTY);
        price_infant = CalculationInfant( TicketTypeBox,infantQTY);

        //component
        JLabel lblAdultPrice = new JLabel(String.valueOf("RM"+ price_adult), SwingConstants.CENTER); // display adult price for economy, standard and business 
        lblAdultPrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        JLabel lblChildPrice = new JLabel(String.valueOf("RM"+ price_child), SwingConstants.CENTER); // display child price for economy, standard and business
        lblChildPrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        JLabel lblInfantPrice = new JLabel(String.valueOf("RM"+ price_infant), SwingConstants.CENTER); // display infant price for economy, standard and business
        lblInfantPrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        JLabel lbl_Adult = new JLabel ("ADULT PRICE", SwingConstants.CENTER);
        lbl_Adult.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        JLabel lbl_Child = new JLabel("CHILD PRICE", SwingConstants.CENTER);
        lbl_Child.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        JLabel lbl_Infant = new JLabel("INFANT PRICE", SwingConstants.CENTER);
        lbl_Infant.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        //adding component
        CenterPnl.add(lbl_Adult);
        CenterPnl.add(lblAdultPrice);
        CenterPnl.add(lbl_Child);
        CenterPnl.add(lblChildPrice);
        CenterPnl.add(lbl_Infant);
        CenterPnl.add(lblInfantPrice);

        //south panel (price panel)      
        //Sum all price ticket for south panel
        total_ticket_price = price_adult + price_child + price_infant; // calculation for ticket price for different class

        //component
        JPanel SouthPnl = new JPanel(new GridLayout(1,2)); // (2 rows, 4 columns)
        SouthPnl.setPreferredSize(new Dimension(0, 90)); // resize the panel

        JLabel lbl_Total = new JLabel ("TOTAL :", SwingConstants.CENTER);
        lbl_Total.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        JLabel lbl_Ticket_Price = new JLabel(String.valueOf("RM"+ total_ticket_price), SwingConstants.CENTER); // display adult price for economy, standard and business
        lbl_Ticket_Price.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        //adding component
        SouthPnl.add(lbl_Total);
        SouthPnl.add(lbl_Ticket_Price);

        //adding all panel inside right panel
        Rightpnl.add(NorthPnl); // place panel at NORTH
        Rightpnl.add(CenterPnl); // place panel at CENTER
        Rightpnl.add(SouthPnl); // place panel at SOUTH

        // adding main panel to frame
        add(mainPanel);
        mainPanel.add(Leftpnl);
        mainPanel.add(Rightpnl);

        // end for main panel to place sub-panel

        //image panel on south frame
        ImageIcon image = new ImageIcon("train.png"); // input png file
        JLabel lblSouthImage = new JLabel(image); //create a label to place image
        lblSouthImage.setPreferredSize(new Dimension(0,155)); // resize the label
        add(lblSouthImage, BorderLayout.NORTH); // place label at north

        // Adding next button to the frame
        nextButton = new JButton("NEXT");
        add(nextButton, BorderLayout.SOUTH); // place panel at north
        nextButton.setPreferredSize(new Dimension(0, 20)); // resize the panel

        setVisible(true); // making frame visible 

        // Adding action listener to the confirm button
        confirmButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Get user input
                    String name = txtName.getText().trim(); // trim() removes leading and trailing spaces
                    String phoneNum = txtPhoneNum.getText().trim();
                    String email = txtEmail.getText().trim();
                    String address = txtAddress.getText().trim();

                    // Check if any of the fields are empty
                    if (name.isEmpty() || phoneNum.isEmpty() || email.isEmpty() || address.isEmpty()) 
                    {
                        // Display error message if any field is empty
                        JOptionPane.showMessageDialog(UserDetail.this, "Please enter your details.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit method
                    }

                    // Validate phone number input
                    if (!phoneNum.matches("\\d+")) 
                    {
                        // Show error message if phone number contains non-numeric characters
                        JOptionPane.showMessageDialog(UserDetail.this, "Phone number must be numeric.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit method
                    }

                    // Display user input in the JTextArea
                    displayTextArea.setText("                \t*CUSTOMER DETAIL INFORMATION*\n\nNAME: " + name + "\n\nPHONE NUMBER: " 
                        + phoneNum + "\n\nEMAIL: " + email + "\n\nADDRESS: " + address);

                }
            });

        // Adding action listener to the clear button
        clearButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    // Clear all text fields
                    txtName.setText("");
                    txtPhoneNum.setText("");
                    txtEmail.setText("");
                    txtAddress.setText("");

                    // Clear display JTextArea
                    displayTextArea.setText("");
                }
            });
        // REGISTER LISTENER
        nextButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == nextButton) {            
                        String name = txtName.getText();
                        String phoneNum = txtPhoneNum.getText();
                        String email = txtEmail.getText();
                        String address = txtAddress.getText();

                        BaggageBooking baggageBooking = new BaggageBooking(placeBox, place2Box, dateBox, date2Box, monthBox, month2Box, time,
                                                                            TicketTypeBox, adultQTY, childQTY, infantQTY,
                                                                            name, phoneNum, email, address, total_ticket_price);
                        dispose();
                    }
                }
            });

    }

    static double CalculationAdult(String TicketTypeBox, int adultQTY) {
        //cost for adult for all class
        double economy = 30.0;
        double standard = 45.0;
        double business = 65.0;
        double totalCost;

        if(TicketTypeBox.equalsIgnoreCase("economy")){
            totalCost = adultQTY * economy;
        }
        else if(TicketTypeBox.equalsIgnoreCase("standard")){
            totalCost = adultQTY * standard;
        }
        else{
            totalCost = adultQTY * business;
        }
        return totalCost;
    }

    static double CalculationChild(String TicketTypeBox, int childQTY) {
        //cost for adult for all class
        double economy = 20.0;
        double standard = 35.0;
        double business = 55.0;
        double totalCost;

        if(TicketTypeBox.equalsIgnoreCase("economy")){
            totalCost = childQTY * economy;
        }
        else if(TicketTypeBox.equalsIgnoreCase("standard")){
            totalCost = childQTY * standard;
        }
        else{
            totalCost = childQTY * business;
        }
        return totalCost;
    }

    static double CalculationInfant(String TicketTypeBox, int infantQTY) {
        //cost for adult for all class
        double economy = 10.0;
        double standard = 25.0;
        double business = 45.0;
        double totalCost;

        if(TicketTypeBox.equalsIgnoreCase("economy")){
            totalCost = infantQTY * economy;
        }
        else if(TicketTypeBox.equalsIgnoreCase("standard")){
            totalCost = infantQTY * standard;
        }
        else{
            totalCost = infantQTY * business;
        }
        return totalCost;
    }
}