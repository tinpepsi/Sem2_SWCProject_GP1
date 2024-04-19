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

public class BaggageBooking extends JFrame {
    private JLabel carryOnLabel, checkedLabel, extraSpaceLabel, totalLabel;
    private JTextField carryOnField, checkedField, totalField;
    private JButton bookButton, clearButton, nextButton; // Added nextButton
    private JRadioButton yesRadioButton, noRadioButton;
    private ButtonGroup extraSpaceGroup;
    private JTextArea summaryArea;

    // Constructor
    public BaggageBooking(String placeBox, String place2Box,String dateBox, String date2Box, String monthBox, String month2Box, String time,
                        String TicketTypeBox,int adultQTY, int childQTY, int infantQTY,
                        String Name, String PhoneNum, String Email, String Address, double total_ticket_price) 
    {

        super("Flight Baggage Booking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addComponents();
        addActionListeners();
        setSize(400, 350); // Increased height to accommodate the "Next" button
        setLocationRelativeTo(null);
        setVisible(true);
                
        
                nextButton.addActionListener(new ActionListener() { // Added action listener for nextButton
                public void actionPerformed(ActionEvent e) {
                    // Perform action when "Next" button is clicked
                    if (e.getSource() == nextButton) {
                        // Retrieve necessary information for the receipt
                        String carryOn = carryOnField.getText();
                        String checked = checkedField.getText();
                        String totalCost = totalField.getText();
                        

                        // Open the ReceiptFrame window with necessary information
                        BaggageReceiptFrame baggageReceiptFrame = new BaggageReceiptFrame(placeBox, place2Box,dateBox, date2Box, monthBox, month2Box, time,
                                TicketTypeBox, adultQTY,  childQTY,  infantQTY,
                                Name, PhoneNum, Email, Address, total_ticket_price,
                                carryOn.toString(), checked.toString(), totalCost.toString());
                        dispose(); // Close the current window
                    }
                    // Open the next window or perform any other action here
                }
            });
    }

    // Initialize components
    private void initComponents() {
        carryOnLabel = new JLabel("Carry-On Bags:");
        checkedLabel = new JLabel("Checked Bags:");
        totalLabel = new JLabel("Total to Pay:");
        carryOnField = new JTextField(10);
        checkedField = new JTextField(10);
        totalField = new JTextField(10);
        totalField.setEditable(false);
        bookButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        nextButton = new JButton("Next"); // Added nextButton
        extraSpaceLabel = new JLabel("Extra Space Available for Purchase");
        yesRadioButton = new JRadioButton("Yes");
        noRadioButton = new JRadioButton("No");
        extraSpaceGroup = new ButtonGroup();
        extraSpaceGroup.add(yesRadioButton);
        extraSpaceGroup.add(noRadioButton);
        summaryArea = new JTextArea(10, 30);
        summaryArea.setEditable(false);
    }

    // Add components to the frame
    private void addComponents() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.add(carryOnLabel);
        inputPanel.add(carryOnField);
        inputPanel.add(checkedLabel);
        inputPanel.add(checkedField);
        inputPanel.add(extraSpaceLabel);
        JPanel extraSpacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        extraSpacePanel.add(yesRadioButton);
        extraSpacePanel.add(noRadioButton);
        inputPanel.add(extraSpacePanel);
        inputPanel.add(totalLabel);
        inputPanel.add(totalField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(bookButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(nextButton); // Added nextButton

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(new JScrollPane(summaryArea));

        Container contentPane = getContentPane();
        contentPane.add(mainPanel);
    }

    // Add action listeners to buttons
    private void addActionListeners() {
        bookButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    calculateTotal();
                }
            });

        clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearInputs();
                }
            });


    }

    // Calculate total cost and display summary
    private void calculateTotal() {
        // Parse input values from text fields
        int carryOnBags = Integer.parseInt(carryOnField.getText());
        int checkedBags = Integer.parseInt(checkedField.getText());
        boolean extraSpaceNeeded = yesRadioButton.isSelected();

        // Calculate base cost for carry-on and checked bags
        double baseCost = carryOnBags + checkedBags * 30;

        // Calculate additional cost for overweight checked bags
        double overweightCost = 0;
        if (checkedBags > 0) {
            // Assuming overweight fee applies only if checked bags are present
            if (checkedBags * 8 > 30) {
                overweightCost = (checkedBags * 8 - 30) * 5;
            }
        }

        // Calculate additional cost for extra space
        double extraSpaceCost = 0;
        if (extraSpaceNeeded) {
            extraSpaceCost = 20;
        }

        // Calculate total cost
        double totalCost = baseCost + overweightCost + extraSpaceCost;

        // Update totalField with the calculated total
        totalField.setText(String.format("%.2f", totalCost));
    }

    // Display summary
    public void displaySummary(int carryOn, int checked, double totalCost) {
        // Add your summary display logic here
    }

    // Clear input fields
    private void clearInputs() {
        carryOnField.setText("");
        checkedField.setText("");
        totalField.setText("");
        summaryArea.setText("");
        extraSpaceGroup.clearSelection();
    }

}