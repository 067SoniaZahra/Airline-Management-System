package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
    
    JTextField tfnumber;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookFlight() {
        // Set gradient background color
getContentPane().setBackground(new Color(169, 169, 169)); // Light grey background

        setLayout(null);
        
        // Heading
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Modern font
        heading.setForeground(new Color(0, 51, 102)); // Deep blue color
        add(heading);
        
        // Number Field
        JLabel lbno = new JLabel("Number");
        lbno.setBounds(60, 80, 150, 25);
        lbno.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbno.setForeground(new Color(60, 60, 60));
        add(lbno);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 80, 150, 30);
        tfnumber.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        tfnumber.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2)); // Blue border
        add(tfnumber);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(new Color(0, 102, 204)); // Button color
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 30);
        fetchButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        fetchButton.addActionListener(this);
        fetchButton.setFocusPainted(false);
        add(fetchButton);
        
        // Name Label
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblname.setForeground(new Color(60, 60, 60));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        add(tfname);
        
        // Nationality Label
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblnationality.setForeground(new Color(60, 60, 60));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        tfnationality.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        add(tfnationality);
        
        // Address Label
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbladdress.setForeground(new Color(60, 60, 60));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        tfaddress.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        add(tfaddress);
        
        // Gender Label
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblgender.setForeground(new Color(60, 60, 60));
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220, 280, 150, 25);
        labelgender.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        add(labelgender);
        
        // Source Dropdown
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblsource.setForeground(new Color(60, 60, 60));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 30);       
        add(source);
        
        // Destination Dropdown
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbldest.setForeground(new Color(60, 60, 60));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 30);       
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Fetch Flights Button
        flight = new JButton("Fetch Flights");
        flight.setBackground(new Color(0, 102, 204));
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 30);
        flight.setFont(new Font("Times New Roman", Font.BOLD, 14));
        flight.addActionListener(this);
        flight.setFocusPainted(false);
        add(flight);
        
        // Flight Name Label
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblfname.setForeground(new Color(60, 60, 60));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        labelfname.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        add(labelfname);
        
        // Flight Code Label
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblfcode.setForeground(new Color(60, 60, 60));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        labelfcode.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        add(labelfcode);
        
        // Date of Travel Label
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbldate.setForeground(new Color(60, 60, 60));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 30);
        dcdate.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Bold text for emphasis
        dcdate.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2)); // Blue border
        add(dcdate);
        
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        // Book Flight Button
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(new Color(0, 102, 204));
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 30);
        bookflight.setFont(new Font("Times New Roman", Font.BOLD, 14));
        bookflight.addActionListener(this);
        bookflight.setFocusPainted(false);
        add(bookflight);
        
        // Frame properties
        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String number = tfnumber.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from passenger where number = '"+number+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    tfnationality.setText(rs.getString("nationality")); 
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct number");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Conn conn = new Conn();

                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name")); 
                    labelfcode.setText(rs.getString("f_code")); 
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            
            String number = tfnumber.getText();
            String name = tfname.getText(); 
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); 
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+number+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";

                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookFlight();
    }
}
