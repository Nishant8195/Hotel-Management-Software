import javax.swing.*; // for using frames
import java.awt.*;
import java.awt.event.*; //for actionlistner

public class HMS extends JFrame implements ActionListener{
    HMS(){
        setSize(1200,686); //size of frame
        //setLocation(100,100);

        //Image for the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Satkar.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1200,686); //location of image on frame , size of image
        add(image); //without this image will not come on the frame

        //Text on the frame
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,550,1000,90);
        text.setForeground(Color.WHITE);// foreground is used for text color
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text); //without this text will go behind the image

        //Button
        JButton next = new JButton("Next");
        next.setBounds(950,550,150,50);
        next.setBackground(Color.WHITE); //button color
        next.setForeground(Color.magenta); // button text color
        next.addActionListener(this); //action by the button
        next.setFont(new Font("serif",Font.PLAIN,25));
        image.add(next); //without this button will go behind the image

        setVisible(true); //without this frame will not visible to us

        /*while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);

            }catch (Exception e){
                e.printStackTrace();
            }
        }*/

    }
    // function for the button
    public void actionPerformed(ActionEvent ae){
        setVisible(false);  //this will close 1st frame
        new Login(); //login constructor will open Login frame

    }
    public static void main(String[] args){
        new HMS(); //this constructor will open the hms frame

    }
}
