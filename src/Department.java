import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel ("Department");
        l1.setBounds (180, 10, 100, 20);
        add (l1);

        JLabel l2 = new JLabel ("Budget");
        l2.setBounds (370, 10, 100, 20);
        add (l2);

        back= new JButton("Back");
        back.setBackground (Color. BLACK);
        back.setForeground (Color. WHITE);
        back.addActionListener (this);
        back.setBounds (200, 500, 120, 30);
        add (back);

        table = new JTable();
        table.setBounds (0, 40, 500, 400);
        add (table);

        try {
            Conn c = new Conn ();

            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            e.printStackTrace();
        }

        setBounds(300,200,500,600);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae) {

        setVisible(false);
    }
    public static void main(String[] args){
        new Department();
    }

}


