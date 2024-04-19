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
import java.util.*;

public class FoodSelection implements ActionListener {
    private JFrame frame;
    private JComboBox<String> BreakfastBox, LunchBox, DinnerBox, KidsMealsBox;
    private JCheckBox chkDrink;
    private JButton btnNext, btnCalculate, btnExit;
    private JLabel lblTotalPrice, lblOverallTotal;
    private JLabel lblBreakfast, lblLunch, lblDinner, lblKidsMeals;
    private JTextField txtBreakfastQty, txtLunchQty, txtDinnerQty, txtKidsMealsQty, txtTotalPrice;
    private double totalPrice;

    // Define prices for each item
    private final Map<String, Double> prices = new HashMap<>();
    private final String[] beverageNames = {"Tea (RM2.50)", "Coffee (RM2.00)", "Bottled Water (RM1.50)", "Watermelon Juice (RM5.00)", "Lemonade (RM4.00)", "Cocoa (RM3.50)"};
    private final double[] beveragePrices = {2.50, 2.00, 1.50, 5.00, 4.00, 3.50};
    private final String[] breakfastNames = {"Parathas (RM6.00)", "Nasi Lemak (RM2.00)", "Yogurt with Granola (RM4.50)"};
    private final double[] breakfastPrices = {6.00, 2.00, 4.50};
    private final String[] lunchNames = {"Biriyani (RM11.20)", "Chicken curry + rice (RM9.00)", "Nasi Ayam (RM7.50)"};
    private final double[] lunchPrices = {11.20, 9.00, 7.50};
    private final String[] dinnerNames = {"Paneer curry + rice (RM9.00)", "Thali (RM8.40)", "Vegetable curry + bread (RM6.00)"};
    private final double[] dinnerPrices = {9.00, 8.40, 6.00};
    private final String[] kidsMealsNames = {"Chicken nuggets (RM4.50)", "Mini pizza (RM6.00)", "Mini pancakes (RM6.00)"};
    private final double[] kidsMealsPrices = {4.50, 6.00, 6.00};
    private JRadioButton[] radioBeverages;

    public FoodSelection(String placeBox, String place2Box,String dateBox, String date2Box, String monthBox, String month2Box, String time,
    String TicketTypeBox,int adultQTY, int childQTY, int infantQTY,
    String name, String phoneNum, String email, String address, double total_ticket_price
    ,String carryOn, String checked, String totalCost) {
        initializeFrame();
        initializeComponents();
        addComponentsToFrame();
        frame.setVisible(true);

        // Initialize the prices
        initializePrices();

        btnNext.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == btnNext){
                        // Get selected food items
                        String selectedBreakfast = (String) BreakfastBox.getSelectedItem();
                        String selectedLunch = (String) LunchBox.getSelectedItem();
                        String selectedDinner = (String) DinnerBox.getSelectedItem();
                        String selectedKidsMeals = (String) KidsMealsBox.getSelectedItem();

                        // Create a new Receipt with the selected items and total price
                        FoodReceipt foodReceipt = new FoodReceipt(placeBox, place2Box,dateBox, date2Box, monthBox, month2Box, time,
                                TicketTypeBox, adultQTY,  childQTY,  infantQTY,
                                name, phoneNum, email, address, total_ticket_price,
                                carryOn,checked, totalCost,
                                selectedBreakfast, selectedLunch, selectedDinner, selectedKidsMeals, totalPrice);
                        // Dispose the JFrame
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                        frame.dispose();
                    }
                }

            });
    }

    private void initializePrices() {
        for (int i = 0; i < breakfastNames.length; i++) {
            prices.put(breakfastNames[i], breakfastPrices[i]);
        }
        for (int i = 0; i < lunchNames.length; i++) {
            prices.put(lunchNames[i], lunchPrices[i]);
        }
        for (int i = 0; i < dinnerNames.length; i++) {
            prices.put(dinnerNames[i], dinnerPrices[i]);
        }
        for (int i = 0; i < kidsMealsNames.length; i++) {
            prices.put(kidsMealsNames[i], kidsMealsPrices[i]);
        }
    }

    private void initializeFrame() {
        frame = new JFrame("Choose Food You LOVE");
        frame.setSize(1000, 500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        BreakfastBox = new JComboBox<>(breakfastNames);
        LunchBox = new JComboBox<>(lunchNames);
        DinnerBox = new JComboBox<>(dinnerNames);
        KidsMealsBox = new JComboBox<>(kidsMealsNames);

        chkDrink = new JCheckBox("Add Drink");
        btnNext = new JButton("Next");
        btnCalculate = new JButton("Calculate");
        btnExit = new JButton("Exit");

        // Initialize text fields for quantity
        txtBreakfastQty = new JTextField(3);
        txtLunchQty = new JTextField(3);
        txtDinnerQty = new JTextField(3);
        txtKidsMealsQty = new JTextField(3);
        txtTotalPrice = new JTextField(10);
        txtTotalPrice.setEditable(false); // Make total price text field read-only

        // Add Action Listeners
        btnNext.addActionListener(this);
        btnCalculate.addActionListener(this);
        btnExit.addActionListener(this);
        BreakfastBox.addActionListener(this);
        LunchBox.addActionListener(this);
        DinnerBox.addActionListener(this);
        KidsMealsBox.addActionListener(this);

        // Initialize labels
        lblBreakfast = new JLabel("Breakfast:");
        lblLunch = new JLabel("Lunch:");
        lblDinner = new JLabel("Dinner:");
        lblKidsMeals = new JLabel("Kids Meals:");
        lblTotalPrice = new JLabel("Total Price: RM 0.00");

        // Initialize overall total label
        lblOverallTotal = new JLabel("Overall Total: RM 0.00");
    }

    private void addComponentsToFrame() {
        JPanel panelBreakfast = new JPanel(new GridLayout(2, 3));
        panelBreakfast.add(lblBreakfast);
        panelBreakfast.add(BreakfastBox);
        panelBreakfast.add(new JLabel("Quantity:"));
        panelBreakfast.add(txtBreakfastQty);

        JPanel panelExtras = new JPanel(new FlowLayout());
        panelExtras.add(chkDrink);

        JPanel panelBeverages = new JPanel(new GridLayout(beverageNames.length, 1));
        panelBeverages.setBorder(BorderFactory.createTitledBorder("Beverages"));
        radioBeverages = new JRadioButton[beverageNames.length];
        ButtonGroup groupBeverages = new ButtonGroup();
        for (int i = 0; i < beverageNames.length; i++) {
            radioBeverages[i] = new JRadioButton(beverageNames[i]);
            panelBeverages.add(radioBeverages[i]);
            groupBeverages.add(radioBeverages[i]);
        }

        JPanel panelLunch = new JPanel(new GridLayout(2, 3));
        panelLunch.add(lblLunch);
        panelLunch.add(LunchBox);
        panelLunch.add(new JLabel("Quantity:"));
        panelLunch.add(txtLunchQty);

        JPanel panelDinner = new JPanel(new GridLayout(2, 3));
        panelDinner.add(lblDinner);
        panelDinner.add(DinnerBox);
        panelDinner.add(new JLabel("Quantity:"));
        panelDinner.add(txtDinnerQty);

        JPanel panelKidsMeals = new JPanel(new GridLayout(2, 3));
        panelKidsMeals.add(lblKidsMeals);
        panelKidsMeals.add(KidsMealsBox);
        panelKidsMeals.add(new JLabel("Quantity:"));
        panelKidsMeals.add(txtKidsMealsQty);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnNext);
        panelButtons.add(btnCalculate);
        panelButtons.add(btnExit);
        panelButtons.add(lblOverallTotal); // Add overall total label here

        // Add panels to the frame using BorderLayout
        JPanel panelLeft = new JPanel(new GridLayout(5, 1));
        panelLeft.add(panelLunch);
        panelLeft.add(panelDinner);
        panelLeft.add(panelKidsMeals);

        frame.add(panelBreakfast, BorderLayout.CENTER);
        frame.add(panelExtras, BorderLayout.SOUTH);
        frame.add(lblTotalPrice, BorderLayout.WEST);
        frame.add(panelBeverages, BorderLayout.EAST);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelButtons, BorderLayout.SOUTH);
        frame.add(txtTotalPrice, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCalculate) {
            totalPrice = calculateTotalPrice();
            lblTotalPrice.setText("Total Price: RM " + String.format("%.2f", totalPrice));
            txtTotalPrice.setText(String.format("%.2f", totalPrice)); // Update total price text field
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;

        // Calculate total price for breakfast
        double breakfastPrice = prices.getOrDefault(BreakfastBox.getSelectedItem().toString(), 0.00);
        int breakfastQty = parseQuantity(txtBreakfastQty.getText());
        totalPrice += breakfastPrice * breakfastQty;

        // Calculate total price for lunch
        double lunchPrice = prices.getOrDefault(LunchBox.getSelectedItem().toString(), 0.00);
        int lunchQty = parseQuantity(txtLunchQty.getText());
        totalPrice += lunchPrice * lunchQty;

        // Calculate total price for dinner
        double dinnerPrice = prices.getOrDefault(DinnerBox.getSelectedItem().toString(), 0.00);
        int dinnerQty = parseQuantity(txtDinnerQty.getText());
        totalPrice += dinnerPrice * dinnerQty;

        // Calculate total price for kids meals
        double kidsMealsPrice = prices.getOrDefault(KidsMealsBox.getSelectedItem().toString(), 0.00);
        int kidsMealsQty = parseQuantity(txtKidsMealsQty.getText());
        totalPrice += kidsMealsPrice * kidsMealsQty;

        // Calculate total price for selected beverage
        for (int i = 0; i < radioBeverages.length; i++) {
            if (radioBeverages[i].isSelected()) {
                totalPrice += beveragePrices[i];
                break; // Only one beverage can be selected
            }
        }

        // Add drink price if selected
        if (chkDrink.isSelected()) {
            totalPrice += 2.00; // Assuming a fixed drink price
        }

        // Update overall total label
        lblOverallTotal.setText("Overall Total: RM " + String.format("%.2f", totalPrice));

        return totalPrice;
    }

    private int parseQuantity(String text) {
        int quantity = 0;
        try {
            quantity = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return quantity;
    }
}