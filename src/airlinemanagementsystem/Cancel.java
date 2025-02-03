package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblfcode, lbldateoftravel;
    JButton fetchButton, flight;
    
    public Cancel() {
        getContentPane().setBackground(new Color(240, 240, 240)); // Light grey background
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(195, 30, 270, 45);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 32));
        heading.setForeground(new Color(0, 102, 204)); // Blue color for the title
        add(heading);
        
        // Add an attractive image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 120, 250, 250);
        add(image);
        
        // Input label and text field styling
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblaadhar.setForeground(new Color(60, 60, 60)); // Darker text color
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 30);
        tfpnr.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tfpnr.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 1));
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(new Color(0, 102, 204)); // Matching the title color
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 30);
        fetchButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        fetchButton.addActionListener(this);
        fetchButton.setFocusPainted(false); // Removing border around button when clicked
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblname.setForeground(new Color(60, 60, 60));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 250, 25);
        tfname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tfname.setForeground(new Color(0, 102, 204));
        add(tfname);
        
        JLabel lblnationality = new JLabel("Cancellation No");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblnationality.setForeground(new Color(60, 60, 60));
        add(lblnationality);
        
        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        cancellationno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cancellationno.setForeground(new Color(0, 102, 204));
        add(cancellationno);
        
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbladdress.setForeground(new Color(60, 60, 60));
        add(lbladdress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        lblfcode.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblfcode.setForeground(new Color(0, 102, 204));
        add(lblfcode);
        
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblgender.setForeground(new Color(60, 60, 60));
        add(lblgender);
        
        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220, 280, 150, 25);
        lbldateoftravel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lbldateoftravel.setForeground(new Color(0, 102, 204));
        add(lbldateoftravel);
        
        flight = new JButton("Cancel");
        flight.setBackground(new Color(255, 0, 0)); // Red button for cancellation
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 330, 120, 30);
        flight.setFont(new Font("Times New Roman", Font.BOLD, 14));
        flight.addActionListener(this);
        flight.setFocusPainted(false);
        add(flight);
        
        // Set window properties
        setSize(800, 450);
        setLocation(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Properly handle window close
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    lblfcode.setText(rs.getString("flightcode")); 
                    lbldateoftravel.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR", "Error", JOptionPane.ERROR_MESSAGE);                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldateoftravel.getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

    public static void main(String[] args) {
        new Cancel();
    }
}


