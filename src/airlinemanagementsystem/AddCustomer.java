package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfphone, tfnumber, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer() {
        getContentPane(). setBackground(new Color(211,211,211));
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(200, 20, 500, 35);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        heading.setForeground(Color.black);
          heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(heading);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblname.setForeground(Color.black);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality :");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblnationality.setForeground(Color.black);
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        JLabel lbno = new JLabel(" Number :");
        lbno.setBounds(60, 180, 150, 25);
        lbno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
       lbno. setForeground(Color.black);
        add(lbno);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 180, 150, 25);
        add(tfnumber);
        
        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lbladdress.setForeground(Color.black);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
       lblgender.setForeground(Color.black);
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone :");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblphone.setForeground(Color.black);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.white);
        save.setForeground(Color.black);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String number = tfnumber.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        
        try {
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+number+"', '"+gender+"')";
        
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
        
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
