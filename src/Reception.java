import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    JButton new_customer_from,room,department,all_employees,customer_info,manager_info,checkout,update_status,update_room_status,pickup_service,search_room,logout;

    Reception()
    {
        new_customer_from= new JButton("New Customer Form");
        new_customer_from.setForeground(Color.WHITE);
        new_customer_from.setBackground(Color.BLACK);
        new_customer_from.setBounds(10,30,200,30);
        new_customer_from.addActionListener(this);
        add(new_customer_from);

        room= new JButton("Rooms");
        room.setForeground(Color.WHITE);
        room.setBackground(Color.BLACK);
        room.setBounds(10,70,200,30);
        room.addActionListener(this);
        add(room);

        department= new JButton("Department");
        department.setForeground(Color.WHITE);
        department.setBackground(Color.BLACK);
        department.setBounds(10,110,200,30);
        department.addActionListener(this);
        add(department);

        all_employees= new JButton("All Employees");
        all_employees.setForeground(Color.WHITE);
        all_employees.setBackground(Color.BLACK);
        all_employees.setBounds(10,150,200,30);
        all_employees.addActionListener(this);
        add(all_employees);

        customer_info= new JButton("Customer Info");
        customer_info.setForeground(Color.WHITE);
        customer_info.setBackground(Color.BLACK);
        customer_info.setBounds(10,190,200,30);
        customer_info.addActionListener(this);
        add(customer_info);

        manager_info= new JButton("Manager Info");
        manager_info.setForeground(Color.WHITE);
        manager_info.setBackground(Color.BLACK);
        manager_info.setBounds(10,230,200,30);
        manager_info.addActionListener(this);
        add(manager_info);

        checkout= new JButton("Checkout");
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(10,270,200,30);
        checkout.addActionListener(this);
        add(checkout);

        update_status= new JButton("Update Status");
        update_status.setForeground(Color.WHITE);
        update_status.setBackground(Color.BLACK);
        update_status.setBounds(10,310,200,30);
        update_status.addActionListener(this);
        add(update_status);

        update_room_status= new JButton("Update Room Status");
        update_room_status.setForeground(Color.WHITE);
        update_room_status.setBackground(Color.BLACK);
        update_room_status.setBounds(10,350,200,30);
        update_room_status.addActionListener(this);
        add(update_room_status);

        pickup_service= new JButton("Pickup Service");
        pickup_service.setForeground(Color.WHITE);
        pickup_service.setBackground(Color.BLACK);
        pickup_service.setBounds(10,390,200,30);
        pickup_service.addActionListener(this);
        add(pickup_service);

        search_room= new JButton("Search Room");
        search_room.setForeground(Color.WHITE);
        search_room.setBackground(Color.BLACK);
        search_room.setBounds(10,430,200,30);
        search_room.addActionListener(this);
        add(search_room);

        logout= new JButton("Logout");
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        logout.setBounds(10,470,200,30);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel Image = new JLabel(i1);
        Image.setBounds(240,30,500,470);
        add(Image);



        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,790,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == new_customer_from) {
            new NewCustmorForm();
        } else if (ae.getSource() == room) {
            new Rooms();
        } else if (ae.getSource() == department) {
            new Department();
        } else if (ae.getSource() == all_employees) {
            new EmployeeInfo();
        } else if (ae.getSource() == customer_info) {
            new CustomerInfo();
        } else if (ae.getSource() == manager_info) {
            new ManagerInfo();
        } else if (ae.getSource() == update_status) {
            new UpdateCheck();
        } else if (ae.getSource() == update_room_status) {
            new UpdateRoomStatus();
        }
    }

    public static void main(String[] args){
        new Reception();
    }


}
