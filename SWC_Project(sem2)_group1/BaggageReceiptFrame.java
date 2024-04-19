/* 
 * STUDENT NAME: NAJIHAH HUSNA BINTI MOHD SOFIAN
 * STUDENT ID: AM2307013940
 * LECTURER NAME: MADAM SITI ROBAYA BINTI JANTAN
 * PROGRAM DESCRIPTION: TO CALCULATE TOTAL AMOUNT BUGGAGE AND DISPLAY RECEIPT
 * SUB PROGRAM DESCRIPTION: USER INPUT THE AMOUNT OF BAG AND DISPLAY THE TOTAL PRICE
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaggageReceiptFrame extends JFrame {
    // Constructor
    private JButton closeButton;
    public BaggageReceiptFrame(String placeBox, String place2Box,String dateBox, String date2Box, String monthBox, String month2Box, String time,
    String TicketTypeBox,int adultQTY, int childQTY, int infantQTY,
    String name, String phoneNum, String email, String address, double total_ticket_price
    ,String carryOn, String checked, String totalCost) {
        super("Receipt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        // Create Label
        JLabel label = new JLabel(new ImageIcon("ticket.png"));
        panel.add(label, BorderLayout.NORTH);

        // Create receipt text area
        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.append("Carry-On Bags: " + carryOn + "\n");
        receiptTextArea.append("Checked Bags: " + checked + "\n");
        receiptTextArea.append("Total Cost: RM " + totalCost + "\n");

        receiptTextArea.setEditable(false);
        receiptTextArea.setBackground(Color.WHITE);
        receiptTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(receiptTextArea, BorderLayout.CENTER);

        receiptTextArea.append(String.format(" \n\n\n "));
        receiptTextArea.append(String.format("**** Enjoy your train! *****"));
        receiptTextArea.append(String.format(" \n "));
        receiptTextArea.append(String.format("**** Thank you for booking! ****"));

        // Create close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == closeButton) {
                    FoodSelection foodSelection = new FoodSelection(placeBox, place2Box,dateBox, date2Box, monthBox, month2Box, time,
                            TicketTypeBox, adultQTY,  childQTY,  infantQTY,
                            name, phoneNum, email, address, total_ticket_price,
                            carryOn,checked, totalCost);

                    dispose();
                }
            }
        });
        panel.add(closeButton, BorderLayout.SOUTH);
    }
}
