/* 
 * STUEDNT NAME: NUR ATHIRAH BINTI M.FASLEE
 * STUDENT ID: AM2307013952
 * LECTURER NAME: MADAM SITI ROBAYA BINTI JANTAN
 * PROGRAM DESCRIPTION: TO KEY IN FOOD SELECTION FRAME, THEN WILL BE PASSED TO RECEIPT FRAME. 
 * SUB PROGRAM DESCRIPTION: DISPLAY AND CALCULATE TOTAL PRICE FOOD BASED ON USER SELECTION CLASS
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodReceipt extends JFrame  {
    private String breakfast, lunch, dinner, kidsMeals;
    private double totalPrice;
    private JButton closeButton; // Declare the class-level variable here

    public FoodReceipt(String placeBox, String place2Box,String dateBox, String date2Box, String monthBox, String month2Box, String time,
    String TicketTypeBox,int adultQTY, int childQTY, int infantQTY,
    String name, String phoneNum, String email, String address, double total_ticket_price,
    String carryOn, String checked, String totalCost,
    String breakfast, String lunch, String dinner, String kidsMeals, double totalPrice) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.kidsMeals = kidsMeals;
        this.totalPrice = totalPrice;

        // Create receipt frame
        setTitle("Receipt");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        // Create Label
        JLabel label = new JLabel(new ImageIcon("ticket.png"));
        panel.add(label, BorderLayout.NORTH);

        // Create receipt text area
        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.append("Breakfast: " + breakfast + "\n");
        receiptTextArea.append("Lunch: " + lunch + "\n");
        receiptTextArea.append("Dinner: " + dinner + "\n");
        receiptTextArea.append("Kids Meals: " + kidsMeals + "\n");
        receiptTextArea.append("Total Price: RM " + String.format("%.2f", totalPrice) + "\n");

        receiptTextArea.setEditable(false);
        receiptTextArea.setBackground(Color.WHITE);
        receiptTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(receiptTextArea, BorderLayout.CENTER);

        receiptTextArea.append(String.format(" \n\n\n "));
        receiptTextArea.append(String.format("* Enjoy your Food! *"));
        receiptTextArea.append(String.format(" \n "));
        receiptTextArea.append(String.format("* Thank you for buying! *"));

        // Create close button
        closeButton = new JButton("Close"); // Assign the class-level variable here
        panel.add(closeButton, BorderLayout.SOUTH);

        setVisible(true);

        closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == closeButton){
                        ReceiptFrame receiptFrame = new ReceiptFrame(placeBox, place2Box,dateBox, date2Box, monthBox, month2Box, time,
                                TicketTypeBox, adultQTY,  childQTY,  infantQTY,
                                name, phoneNum, email, address, total_ticket_price,
                                carryOn,checked, totalCost,
                                totalPrice);

                        // Dispose the JFrame
                        dispose();
                    }
                }
            });
    }
}