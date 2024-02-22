import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname,tfemail,tfage,tfsalary,tfphone,tfadhaar;
    JRadioButton rbmale,rbfemale;
    JButton Submit;
    JComboBox cbjob;

    AddEmployee()
    {
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);

        JLabel lbage = new JLabel("AGE");
        lbage.setBounds(60,80,120,30);
        lbage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbage);

        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lbgender = new JLabel("GENDER");
        lbgender.setBounds(60,130,120,30);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbgender);

        rbmale =new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale =new JRadioButton("Female");
        rbfemale.setBounds(270,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbjob = new JLabel("JOB");
        lbjob.setBounds(60,180,120,30);
        lbjob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbjob);

        String str[] = {"Front_Desk_Clerk","Manager","Cleaner","room_service","Cook","Waiter"};
        cbjob =new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lbsalary = new JLabel("SALARY");
        lbsalary.setBounds(60,230,120,30);
        lbsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lbphone = new JLabel("PHONE");
        lbphone.setBounds(60,280,120,30);
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        JLabel lbemail = new JLabel("EMAIL");
        lbemail.setBounds(60,330,120,30);
        lbemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        JLabel lbadhaar = new JLabel("AADHAR");
        lbadhaar.setBounds(60,380,120,30);
        lbadhaar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbadhaar);

        tfadhaar = new JTextField();
        tfadhaar.setBounds(200,380,150,30);
        add(tfadhaar);

        Submit = new JButton("Submit");
        Submit.setForeground(Color.WHITE);
        Submit.setBackground(Color.BLACK);
        Submit.setBounds(200,430,80,30);
        Submit.addActionListener(this);
        add(Submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(380,60,450,380);
        add(Image);


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);



    }
    /*public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfadhaar.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender="Male";
        }else if(rbfemale.isSelected()){
            gender="Female";
        }
        String job = (String) cbjob.getSelectedItem();*/

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String ageStr = tfage.getText();
        String salaryStr = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfadhaar.getText();
        String gender = null;
        String job = (String) cbjob.getSelectedItem();

        // Validate and parse age and salary
        int age = 0;
        double salary = 0.0;

        try {
            age = Integer.parseInt(ageStr);
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException ex) {
            // Handle invalid input for age or salary
            JOptionPane.showMessageDialog(null, "Invalid input for age or salary.");
            return; // Exit the method without proceeding
        }

        // Validate other input fields as needed

        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        } else {
            // Handle the case where no gender is selected
            JOptionPane.showMessageDialog(null, "Please select a gender.");
            return; // Exit the method without proceeding
        }

        try{
            Conn conn = new Conn();
            String query = "INSERT INTO employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);

        } catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String []args)
    {
        new AddEmployee();
    }
}
