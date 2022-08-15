import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class increaseStock extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l5;
	JButton b1,b2,b3;
	JComboBox c1;
	JTextField t1;
	ImageIcon im1;
	String s1[]={"a+","a-","b+","b-","o+","o-","ab+","ab-"};
	public increaseStock()
	{
		setLayout(null);
		setVisible(true);
		setTitle("Increase Stock");
		
		//im1=new ImageIcon("bg.jpg");
		l5=new JLabel("Update Stock");
		l5.setFont(new Font("Tahoma", Font.BOLD, 60));
		l5.setBounds(400,10,700,100);

		l1=new JLabel("Blood Group");
		l1.setBounds(200,200,150,40);
		l1.setFont(new Font("Tahoma", Font.BOLD, 16));
		c1=new JComboBox(s1);
		c1.setBounds(400,200,100,40);
		c1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		l2=new JLabel("Blood Quantity");
		l2.setBounds(200,250,150,40);
		l2.setFont(new Font("Tahoma", Font.BOLD, 16));
		t1=new JTextField();
		t1.setBounds(400,250,100,40);
		t1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		ImageIcon im1=new ImageIcon("bg3.jpg");
		l3=new JLabel(im1);
		l3.setBounds(0,0,1200,800);
		
		b1=new JButton("Increase");
		b1.setBounds(200,300,150,40);
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
		b2=new JButton("Decrease");;
		b2.setBounds(400,300,150,40);
		b2.setFont(new Font("Tahoma", Font.BOLD, 16));
		b3=new JButton("Cancel");;
		b3.setBounds(600,300,150,40);
		b3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		
		setSize(1200,800);
		
		add(l1);add(l5);add(l2);add(b1);add(b2);add(b3);add(c1);add(t1);add(l3);
		
		
		setLocation(300,100);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try
		{
			String s=ae.getActionCommand();
			if (s.equals("Increase"))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//JOptionPane.showMessageDialog(this,"Driver Registered");

				Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
				
				String bg=(String)c1.getSelectedItem();
				int qu=Integer.parseInt(t1.getText());
				
				PreparedStatement ps=co.prepareStatement("Update blood set quantity=?+quantity where bloodg=?");
				ps.setInt(1,qu);
				ps.setString(2,bg);
				ps.executeUpdate();
				
				co.close();
				JOptionPane.showMessageDialog(this,"Data Updated Successfully");
				setVisible(false);
				new increaseStock().setVisible(true);
			}
			if (s.equals("Decrease"))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//JOptionPane.showMessageDialog(this,"Driver Registered");

				Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
				
				String bg=(String)c1.getSelectedItem();
				int qu=Integer.parseInt(t1.getText());
				
				PreparedStatement ps=co.prepareStatement("Update blood set quantity=quantity-? where bloodg=?");
				ps.setInt(1,qu);
				ps.setString(2,bg);
				ps.executeUpdate();
				
				co.close();
				JOptionPane.showMessageDialog(this,"Data Updated Successfully");
				setVisible(false);
				new increaseStock().setVisible(true);
			}
			if(s.equals("Cancel"))
			{
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close window", "Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new home().setVisible(true);
				}
				new home().setVisible(true);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e);
		}
	}
	
	public static void main(String args[])
	{
		new increaseStock();
	}
}