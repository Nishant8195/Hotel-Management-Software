import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    JTextField tfroomno,tfprice;
    JComboBox cbavail,cbclean,cbbedtype;
    JButton addroom,cancel;

    AddRooms()
    {
        JLabel text = new JLabel("Add Rooms");
        text.setBounds(150,50,200,20);
        text.setForeground(Color.BLACK);// foreground is used for text color
        text.setFont(new Font("serif",Font.BOLD,20));
        add(text);

        JLabel lbroomno =new JLabel("Room Number");
        lbroomno.setBounds(60,90,200,20);
        lbroomno.setForeground(Color.BLACK);
        lbroomno.setFont(new Font("serif",Font.PLAIN,14));
        add(lbroomno);

        tfroomno = new JTextField();
        tfroomno.setBounds(200,90,150,30);
        add(tfroomno);

        JLabel lbavail =new JLabel("Available");
        lbavail.setBounds(60,130,200,20);
        lbavail.setForeground(Color.BLACK);
        lbavail.setFont(new Font("serif",Font.PLAIN,14));
        add(lbavail);

        String str[] = {"Available","Not Available"};
        cbavail =new JComboBox(str);
        cbavail.setBounds(200,130,150,30);
        cbavail.setBackground(Color.WHITE);
        add(cbavail);

        JLabel lbclean =new JLabel("Cleaning Status");
        lbclean.setBounds(60,170,200,20);
        lbclean.setForeground(Color.BLACK);
        lbclean.setFont(new Font("serif",Font.PLAIN,14));
        add(lbclean);

        String str2[] = {"Cleaned","Not Cleaned"};
        cbclean =new JComboBox(str2);
        cbclean.setBounds(200,170,150,30);
        cbclean.setBackground(Color.WHITE);
        add(cbclean);

        JLabel lbprice =new JLabel("Price");
        lbprice.setBounds(60,210,150,20);
        lbprice.setForeground(Color.BLACK);
        lbprice.setFont(new Font("serif",Font.PLAIN,14));
        add(lbprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,210,150,30);
        add(tfprice);

        JLabel lbbed =new JLabel("Bed Type");
        lbbed.setBounds(60,250,200,20);
        lbbed.setForeground(Color.BLACK);
        lbbed.setFont(new Font("serif",Font.PLAIN,14));
        add(lbbed);

        String str3[] = {"Single Bed","Double Bed"};
        cbbedtype =new JComboBox(str3);
        cbbedtype.setBounds(200,250,150,30);
        cbbedtype.setBackground(Color.WHITE);
        add(cbbedtype);

        addroom = new JButton("Add Room");
        addroom.setForeground(Color.WHITE);
        addroom.setBackground(Color.BLACK);
        addroom.setBounds(60,290,130,30);
        addroom.addActionListener(this);
        add(addroom);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,290,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(380,40,420,310);
        add(Image);


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,420);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== addroom)
        {
            String RoomNo = tfroomno.getText();
            String Availability = (String) cbavail.getSelectedItem();
            String Clean =(String) cbclean.getSelectedItem();
            String price = tfprice.getText();
            String Bedtype = (String) cbbedtype.getSelectedItem();

            try {
                Conn conn =new Conn();
                String query ="Insert into addroom values('"+RoomNo+"','"+Availability+"','"+Clean+"','"+price+"','"+Bedtype+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room added successfully");
                setVisible(false);


            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else{
            setVisible(false);
        }

    }

    public static void main(String []args){
        new AddRooms();
    }
}


