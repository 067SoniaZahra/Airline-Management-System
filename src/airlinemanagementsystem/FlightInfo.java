package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo() {
        
        // Set the background color of the content pane
        getContentPane().setBackground(new Color(245, 245, 245)); // Light grey background
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Flight Information");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 24));
        heading.setForeground(new Color(0, 51, 102)); // Dark Blue color
        heading.setBounds(300, 20, 300, 40);
        add(heading);
        
        // Create a JTable for displaying flight information
        JTable table = new JTable();
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Modern font for the table text
        table.setRowHeight(30); // Increase row height for better readability
        table.setSelectionBackground(new Color(0, 51, 102)); // Dark Blue when selected
        table.setSelectionForeground(Color.WHITE); // Text color when selected
        table.setBackground(Color.WHITE); // Table background color
        table.setForeground(Color.BLACK); // Table text color
        
        // Fetch flight data from the database
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add the table to a JScrollPane
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 80, 700, 350); // Set the position and size for the scroll pane
        add(jsp);

        // Set frame properties
        setSize(800, 500); // Set the size of the frame
        setLocation(400, 200); // Set the location of the frame
        setVisible(true); // Make the frame visible
        setTitle("Flight Information"); // Set the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the app closes when the window is closed
    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}
