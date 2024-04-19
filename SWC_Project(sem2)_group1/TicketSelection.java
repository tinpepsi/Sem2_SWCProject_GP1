/* 
 * STUDENT NAME: NURAIN NADZIRAH BINTI RAZIMEE
 * STUDENT ID: AM2307013956
 * LECTURER NAME: MADAM SITI ROBAYA BINTI JANTAN
 * PROGRAM DESCRIPTION: TO CALCULATE TOTAL AMOUNT BUGGAGE AND DISPLAY RECEIPT
 * SUB PROGRAM DESCRIPTION: USER SELECT TICKET TYPE AND INPUT FOR PASSENGER QUANTITY 
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TicketSelection extends JFrame {
    private JLabel lblAdult, lblChild, lblInfant, lblCountAdl, lblCountChd, lblCountInf;
    private JComboBox<String> TicketTypeBox;
    private JButton btnB, btnC, btnN;
    private JPanel pnlN, pnlC, pnlX, pnlE, pnlTicketType, pnlPsg;
    private int adultQTY = 0, childQTY = 0, infantQTY = 0;

    public TicketSelection(String placeBox, String place2Box, String dateBox, String date2Box, String monthBox, String month2Box, String time) {
        super("TICKET SELECTION");
        Container cont = getContentPane();
        cont.setLayout(new BorderLayout());

        // Set up Font
        Font myFont = new Font("SansSerif", Font.BOLD, 16);

        // Set up JLabel
        lblAdult = new JLabel("Adult (18+ y)");
        lblCountAdl = new JLabel(Integer.toString(adultQTY));
        lblChild = new JLabel("Child (6 - 17 y)");
        lblCountChd = new JLabel(Integer.toString(childQTY));
        lblInfant = new JLabel("Infant (under 6 y)");
        lblCountInf = new JLabel(Integer.toString(infantQTY));
        lblAdult.setFont(myFont);
        lblCountAdl.setFont(myFont);
        lblChild.setFont(myFont);
        lblCountChd.setFont(myFont);
        lblInfant.setFont(myFont);
        lblCountInf.setFont(myFont);

        // Set up ComboBox
        String[] TicketType = {"---Choose---", "Economy", "Standard", "Business"};
        TicketTypeBox = new JComboBox<>(TicketType);
        TicketTypeBox.setFont(myFont);

        // Set up button
        btnB = new JButton("Back");
        btnC = new JButton("Clear");
        btnN = new JButton("Next");
        btnB.setFont(myFont);
        btnC.setFont(myFont);
        btnN.setFont(myFont);

        // Set up buttons for quantity adjustment
        JButton adultMinusBtn = new JButton("-");
        JButton adultPlusBtn = new JButton("+");
        JButton childMinusBtn = new JButton("-");
        JButton childPlusBtn = new JButton("+");
        JButton infantMinusBtn = new JButton("-");
        JButton infantPlusBtn = new JButton("+");
        adultMinusBtn.setFont(myFont);

        adultMinusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (adultQTY > 0) {
                    adultQTY--;
                    lblCountAdl.setText(Integer.toString(adultQTY));
                }
            }
        });

        adultPlusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adultQTY++;
                lblCountAdl.setText(Integer.toString(adultQTY));
            }
        });

        childMinusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (childQTY > 0) {
                    childQTY--;
                    lblCountChd.setText(Integer.toString(childQTY));
                }
            }
        });

        childPlusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                childQTY++;
                lblCountChd.setText(Integer.toString(childQTY));
            }
        });

        infantMinusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (infantQTY > 0) {
                    infantQTY--;
                    lblCountInf.setText(Integer.toString(infantQTY));
                }
            }
        });

        infantPlusBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                infantQTY++;
                lblCountInf.setText(Integer.toString(infantQTY));
            }
        });

        pnlTicketType = new JPanel();
        pnlTicketType.setLayout(new GridLayout(2, 0));
        pnlTicketType.setBorder(new TitledBorder(new EtchedBorder(), "Ticket type"));
        pnlTicketType.setFont(myFont);

        pnlN = new JPanel();
        pnlN.setLayout(new GridLayout(2, 2));

        pnlPsg = new JPanel();
        pnlPsg.setLayout(new GridLayout(3, 2)); 
        pnlPsg.setBorder(new TitledBorder(new EtchedBorder(), "Passenger"));
        pnlPsg.setFont(myFont);

        pnlE = new JPanel();
        pnlE.setLayout(new GridLayout(3, 2)); 

        pnlC = new JPanel();
        pnlC.setLayout(new GridLayout(1, 3));

        pnlTicketType.add(pnlN);
        pnlPsg.add(pnlE); 

        pnlN.add(TicketTypeBox);

        pnlE.add(lblAdult);
        pnlE.add(adultMinusBtn);
        pnlE.add(lblCountAdl);
        pnlE.add(adultPlusBtn);
        pnlE.add(lblChild);
        pnlE.add(childMinusBtn);
        pnlE.add(lblCountChd);
        pnlE.add(childPlusBtn);
        pnlE.add(lblInfant);
        pnlE.add(infantMinusBtn);
        pnlE.add(lblCountInf);
        pnlE.add(infantPlusBtn);

        pnlX = new JPanel();
        pnlX.setLayout(new GridLayout(1, 3));
        pnlX.add(btnC);
        pnlX.add(btnN);

        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblCountAdl.setText(Integer.toString(adultQTY));
                lblCountChd.setText(Integer.toString(childQTY));
                lblCountInf.setText(Integer.toString(infantQTY));
                TicketTypeBox.setSelectedIndex(0);
            }
        });

        btnN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if TicketType is selected
                if (TicketTypeBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(TicketTypeBox, "Please select a ticket type.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if at least one adult ticket is selected
                if (adultQTY == 0 && (childQTY > 0 || infantQTY > 0)) {
                    JOptionPane.showMessageDialog(TicketTypeBox, "Please select at least one adult ticket.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (e.getSource() == btnN) {
                    // Proceed to next frame
                    UserDetail userDetailFrame = new UserDetail(placeBox, place2Box, dateBox, date2Box, monthBox,
                            month2Box, time, TicketTypeBox.getSelectedItem().toString(), adultQTY, childQTY,
                            infantQTY);
                    dispose();
                }
            }
        });

        cont.add(pnlTicketType, BorderLayout.NORTH);
        cont.add(pnlPsg, BorderLayout.CENTER);
        cont.add(pnlX, BorderLayout.SOUTH);

        pnlN.setPreferredSize(new Dimension(70, 70));
        pnlPsg.setPreferredSize(new Dimension(800, 150)); 
        pnlC.setPreferredSize(new Dimension(700, 150));
        pnlX.setPreferredSize(new Dimension(30, 50));

        setSize(700, 500);
        setVisible(true);
    }
}