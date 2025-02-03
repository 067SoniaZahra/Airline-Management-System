package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr;
    JButton show;

    public JourneyDetails() {
        
        // Set background color and layout
        getContentPane().setBackground(new Color(245, 245, 245)); // Light grey background
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("JOURNEY DETAILS");
        heading.setFont(new Font("time new roman", Font.BOLD, 24));
        heading.setForeground(new Color(0, 51, 102)); // Dark Blue
        heading.setBounds(300, 10, 300, 40);
        add(heading);

        // PNR Label
        JLabel lblpnr = new JLabel("PNR Details:");
        lblpnr.setFont(new Font("time new roman", Font.BOLD, 16));
        lblpnr.setBounds(50, 70, 100, 25);
        lblpnr.setForeground(new Color(0, 51, 102)); // Dark Blue
        add(lblpnr);

        // PNR Text Field
        pnr = new JTextField();
        pnr.setBounds(160, 70, 150, 30);
        pnr.setFont(new Font("Time new roman", Font.BOLD, 14));
        pnr.setBackground(Color.WHITE);
        pnr.setForeground(Color.BLACK);
        add(pnr);

        // Show Details Button
        show = new JButton("Show Details");
        show.setBackground(new Color(0, 51, 102)); // Dark Blue
        show.setForeground(Color.WHITE);
        show.setBounds(330, 70, 150, 30);
        show.setFont(new Font("Segoe UI", Font.BOLD, 14));
        show.setBorderPainted(false);
        show.setFocusPainted(false);
        show.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        show.addActionListener(this);
        add(show);

        // Table for displaying results
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(0, 51, 102)); // Dark Blue when selected
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);

        // Add table to scroll pane
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 120, 700, 400);
        add(jsp);

        // Set the frame properties
        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
        setTitle("Journey Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");

            // If no record found
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            // Populate the table with data from database
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
