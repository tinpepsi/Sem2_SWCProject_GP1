/* 
 * STUEDNT NAME: NUR ATHIRAH BINTI HILALLUDDIN 
 * STUDENT ID: AM2307013911
 * LECTURER NAME: MADAM SITI ROBAYA BINTI JANTAN
 * PROGRAM DESCRIPTION: TO DISPLAY ALL THE VALUE RECEIVE FROM PREVIOUS FRAME
 * SUB PROGRAM DESCRIPTION: CALCULATE ALL TOTAL OF FEE
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptFrame extends JFrame {
    private JLabel lblPhoneNum, lblName, lblEmail, lblAddress, lblNameZ, lblPhoneNumZ, lblEmailZ, lblAddressZ ;
    private JLabel lblAdult, lblChild, lblInfant, lblAdultZ, lblChildZ , lblInfantZ;
    private JLabel lblFrom, lblDate, lblTo, lblTime,lblDepart, lblReturn, lblClazz, lblClazz2, lblFromZ, lblToZ, lblTimeZ, lblDateZ,  lblDepartZ, lblReturnZ;
    private JLabel lblFood, lblBag, lblPickMethod, lblFoodZ, lblBagZ, lblPickMethodZ;

    private JLabel lblTicketPrice, lblFoodPrice, lblBaggagePrice, lblServicePrice, lblTaxPrice, lblTotalPrice ;
    private JLabel lblTicketPriceZ, lblFoodPriceZ, lblBaggagePriceZ, lblServicePriceZ,lblTaxPriceZ, lblTotalPriceZ ;

    private JButton closeButton;

    double serviceCharge = 0.03;
    double tax = 0.06;
    double AlltotalCost;
    double taxAmount, serviceChargeAmount, finalTotal, totalCostDouble;

    public ReceiptFrame(String placeBox, String place2Box,String dateBox, String date2Box, String monthBox, String month2Box, String time,
    String TicketTypeBox,int adultQTY, int childQTY, int infantQTY,
    String name, String phoneNum, String email, String address, double total_ticket_price,
    String carryOn, String checked, String totalCost,
    double totalPrice) {
        setTitle("Receipt");
        setSize(1000, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //image panel south frame
        ImageIcon image = new ImageIcon("RECEIPT.png");
        JLabel lblSouthImage = new JLabel(); //create a label
        lblSouthImage.setIcon(image);
        lblSouthImage.setPreferredSize(new Dimension(0,60)); // resize the panel
        add(lblSouthImage, BorderLayout.NORTH); // place panel at north

        //BELAH KIRI
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

        //Start panel user detail information
        JPanel label1 = new JPanel(new BorderLayout()); // panel for price
        //label1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        label1.setPreferredSize(new Dimension(3, 120)); // resize the panel
        //creating grid panel inside detail information panel
        JPanel labelInfo = new JPanel(new GridLayout(4,4));        

        // Adding labels for displaying user info
        lblName = new JLabel("NAME:");
        lblName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblPhoneNum = new JLabel("PHONE NUMBER:");
        lblPhoneNum.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblEmail = new JLabel("EMAIL:");
        lblEmail.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblAddress = new JLabel("ADDRESS:");
        lblAddress.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        //massukkan value detail info
        lblNameZ = new JLabel(name.toUpperCase(), SwingConstants.CENTER);
        lblNameZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a LIGHT_GRAY line border
        lblPhoneNumZ = new JLabel(phoneNum, SwingConstants.CENTER);
        lblPhoneNumZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a LIGHT_GRAY line border
        lblEmailZ = new JLabel(email, SwingConstants.CENTER);
        lblEmailZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a LIGHT_GRAY line border
        lblAddressZ = new JLabel(address.toUpperCase(), SwingConstants.CENTER);
        lblAddressZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a LIGHT_GRAY line border

        label1.add(labelInfo);
        labelInfo.add(lblName);
        labelInfo.add(lblNameZ);
        labelInfo.add(lblPhoneNum);
        labelInfo.add(lblPhoneNumZ);
        labelInfo.add(lblEmail);
        labelInfo.add(lblEmailZ);
        labelInfo.add(lblAddress);
        labelInfo.add(lblAddressZ);
        //End panel user detail information

        //panel adult, child, infant
        JPanel label2 = new JPanel(new BorderLayout()); // panel for price
        //label2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        label2.setPreferredSize(new Dimension(300, 120)); // resize the panel
        //creating grid panel inside adult, child, infant panel
        JPanel CategoriesPnl = new JPanel(new GridLayout(2,3));    

        // Adding labels for displaying adult, child, infant
        lblAdult = new JLabel("ADULT", SwingConstants.CENTER);
        lblAdult.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblChild = new JLabel("CHILD", SwingConstants.CENTER);
        lblChild.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblInfant= new JLabel("INFANT", SwingConstants.CENTER);
        lblInfant.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        // Create JLabel with the text derived from adultQTY
        //insert value of adult, child, infant
        String convertAdult = String.valueOf(adultQTY);
        JLabel lblAdultZ = new JLabel(convertAdult, SwingConstants.CENTER);
        lblAdultZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        String convertChild = String.valueOf(childQTY);
        JLabel lblChildZ = new JLabel(convertChild, SwingConstants.CENTER);
        lblChildZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        String convertInfant = String.valueOf(infantQTY);
        JLabel lblInfantZ = new JLabel(convertInfant, SwingConstants.CENTER);
        lblInfantZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        label2.add(CategoriesPnl);
        CategoriesPnl.add(lblAdult);
        CategoriesPnl.add(lblChild);
        CategoriesPnl.add(lblInfant);
        CategoriesPnl.add(lblAdultZ);
        CategoriesPnl.add(lblChildZ);
        CategoriesPnl.add(lblInfantZ);

        westPanel.add(label1);
        westPanel.add(label2);
        //HABES BELAH KIRI

        //BELAH TENGAH
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        //start panel for, from, to, date, time, class
        JPanel label3 = new JPanel(new BorderLayout()); // panel for price
        //label3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        label3.setPreferredSize(new Dimension(400, 120)); // resize the panel
        //creating grid panel inside adult, child, infant panel
        JPanel DestinationPnl = new JPanel(new GridLayout(2,4));  
        DestinationPnl.setPreferredSize(new Dimension(700, 0));
        JPanel ClassPnl = new JPanel(new GridLayout(1,2));
        ClassPnl.setPreferredSize(new Dimension(0, 50));

        // Adding labels for displaying adult, child, infant
        // Adding labels for displaying adult, child, infant
        lblFrom = new JLabel("FROM :");
        lblFrom.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblTo= new JLabel("TO :");
        lblTo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblDepart = new JLabel("DEPART :");
        lblDepart.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblReturn = new JLabel("RETURN :");
        lblReturn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        //Adding value from, to, depart, return, time, class
        lblFromZ = new JLabel(placeBox, SwingConstants.CENTER);
        lblFromZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblToZ = new JLabel(place2Box, SwingConstants.CENTER);
        lblToZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblDepartZ = new JLabel((dateBox + "/" + monthBox), SwingConstants.CENTER);
        lblDepartZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblReturnZ = new JLabel((date2Box + "/" +  month2Box), SwingConstants.CENTER);
        lblReturnZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        label3.add(DestinationPnl);
        DestinationPnl.add(lblFrom);
        DestinationPnl.add(lblFromZ);
        DestinationPnl.add(lblTo);
        DestinationPnl.add(lblToZ);
        DestinationPnl.add(lblDepart); //depart
        DestinationPnl.add(lblDepartZ); //depart value 
        DestinationPnl.add(lblReturn); //return
        DestinationPnl.add(lblReturnZ); //return value 

        //end panel for, from, to, date, time, class
        //panel food, bagagge, pick up method
        JPanel label4 = new JPanel(new BorderLayout()); // panel for price
        //label4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        label4.setPreferredSize(new Dimension(400, 120)); // resize the panel
        JPanel ClassPanel = new JPanel(new GridLayout(1,2));  

        lblTime= new JLabel("TIME ", SwingConstants.CENTER);
        lblTime.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        lblTimeZ = new JLabel((time), SwingConstants.CENTER);
        lblTimeZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        lblClazz= new JLabel("CLASS ", SwingConstants.CENTER);
        lblClazz.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        //Adding ticket type value here
        lblClazz2= new JLabel((TicketTypeBox),SwingConstants.CENTER);
        lblClazz2.setText(lblClazz2.getText().toUpperCase()); // Convert text to uppercase
        lblClazz2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a light gray line border
        Font font = lblClazz2.getFont();
        lblClazz2.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize() + 3));

        label4.add(ClassPanel);
        ClassPanel.add(lblTime); 
        ClassPanel.add(lblTimeZ);
        ClassPanel.add(lblClazz);
        ClassPanel.add(lblClazz2);

        centerPanel.add(label3);
        centerPanel.add(label4);
        //end class panel

        //end for center

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));

        //panel price
        JPanel label5 = new JPanel(new BorderLayout()); // panel for price
        //label5.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // create a black line border
        label5.setPreferredSize(new Dimension(300, 120)); // resize the panel
        JPanel PricepPnl = new JPanel(new GridLayout(6,2));  

        // Adding labels for food, bagagge, pick up method
        lblTicketPrice = new JLabel("TICKET PRICE :");
        lblTicketPrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblFoodPrice = new JLabel("FOOD PRICE :");
        lblFoodPrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblBaggagePrice= new JLabel("BAGGAGE PRICE :");
        lblBaggagePrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblServicePrice= new JLabel("SERVICE CHARGE :");
        lblServicePrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblTaxPrice= new JLabel("TAX CHARGE :");
        lblTaxPrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border
        lblTotalPrice= new JLabel("TOTAL PRICE:");
        lblTotalPrice.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        totalCostDouble = Double.parseDouble(totalCost);
        // Calculate all price
        AlltotalCost = total_ticket_price + totalPrice + totalCostDouble;
        // Calculate tax charge amount
        taxAmount = AlltotalCost * tax;
        // Calculate service charge amount
        serviceChargeAmount = AlltotalCost * serviceCharge;
        // Add tax and service charge to the total cost
        finalTotal = AlltotalCost + taxAmount + serviceChargeAmount;

        String formattedPrice = String.format("RM%.2f", total_ticket_price);
        lblTicketPriceZ= new JLabel((formattedPrice), SwingConstants.CENTER );
        lblTicketPriceZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        String formattedtotalCostDouble = String.format("RM%.2f", totalCostDouble);
        lblFoodPriceZ = new JLabel((formattedtotalCostDouble), SwingConstants.CENTER);
        lblFoodPriceZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        String formattedtotalPrice = String.format("RM%.2f", totalPrice);
        lblBaggagePriceZ= new JLabel((formattedtotalPrice), SwingConstants.CENTER);
        lblBaggagePriceZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        String formattedserviceChargeAmount = String.format("RM%.2f", serviceChargeAmount);
        lblServicePriceZ= new JLabel((formattedserviceChargeAmount), SwingConstants.CENTER);
        lblServicePriceZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        String formattedtaxAmount = String.format("RM%.2f", taxAmount);
        lblTaxPriceZ= new JLabel((formattedtaxAmount), SwingConstants.CENTER);
        lblTaxPriceZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        String formattedfinalTotal = String.format("RM%.2f", finalTotal);
        lblTotalPriceZ= new JLabel((formattedfinalTotal), SwingConstants.CENTER);
        lblTotalPriceZ.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Adding a black line border

        label5.add(PricepPnl);
        PricepPnl.add(lblTicketPrice);
        PricepPnl.add(lblTicketPriceZ);
        PricepPnl.add(lblFoodPrice);
        PricepPnl.add(lblBaggagePriceZ);
        PricepPnl.add(lblBaggagePrice);
        PricepPnl.add(lblFoodPriceZ);
        PricepPnl.add(lblServicePrice);
        PricepPnl.add(lblServicePriceZ);
        PricepPnl.add(lblTaxPrice);
        PricepPnl.add(lblTaxPriceZ);
        PricepPnl.add(lblTotalPrice);
        PricepPnl.add(lblTotalPriceZ);
        // end for panel price

        eastPanel.add(label5);
        //BELAH KANAN
        //HABES BELAH KANAN
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        add(mainPanel);

        // Create close button
        closeButton = new JButton("Close"); // Assign the class-level variable here
        mainPanel.add(closeButton, BorderLayout.SOUTH);
        closeButton.setPreferredSize(new Dimension(0, 20)); // resize the panel


        closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == closeButton){
                        // Dispose the JFrame
                        dispose();
                    }
                }
            });
    }
}