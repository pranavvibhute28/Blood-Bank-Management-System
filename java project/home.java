import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class home extends JFrame implements ActionListener
{
	JLabel l1;
	MenuBar mbr;
	Menu m1,m2,m3,m4,m5;
	ImageIcon im1,im2,im3,im4;
	public home()
	{
		setLayout(null);
		
		im1=new ImageIcon("bg.jpg");
		l1=new JLabel(im1);
		l1.setBounds(0,0,1200,900);
		mbr=new MenuBar();
		setMenuBar(mbr);

		
		m1=new Menu("Donor");
		m1.setFont(new Font("Tahoma", Font.BOLD, 20));
		MenuItem i1=new MenuItem("Add New Donor");
		MenuItem i2=new MenuItem("Update Donor Details");
		MenuItem i3=new MenuItem("All Donor Detaills");
		m1.add(i1);
		m1.add(i2);
		m1.add(i3);
		mbr.add(m1);
		
		m2=new Menu("Search Donor");
		m2.setFont(new Font("Tahoma", Font.BOLD, 20));
		MenuItem i4=new MenuItem("By Location");
		MenuItem i5=new MenuItem("By Blood Group");
		m2.add(i4);
		m2.add(i5);
		mbr.add(m2);
		
		m3=new Menu("Stock");
		m3.setFont(new Font("Tahoma", Font.BOLD, 20));
		MenuItem i6=new MenuItem("Update Stock");
		
		MenuItem i11=new MenuItem("All Stock Details");
		m3.add(i6);
		m3.add(i11);
		mbr.add(m3);
		
		m4=new Menu("Delete Donor");
		m4.setFont(new Font("Tahoma", Font.BOLD, 20));
		MenuItem i8=new MenuItem("Delete Donor");
		m4.add(i8);
		mbr.add(m4);
		
		m5=new Menu("Exit");
		m5.setFont(new Font("Tahoma", Font.BOLD, 20));
		MenuItem i9=new MenuItem("Logout");
		MenuItem i10=new MenuItem("Exit Application");
		m5.add(i9);
		m5.add(i10);
		mbr.add(m5);
		
		
		setVisible(true);
		setSize(1200,900);
		setLocation(300,100);
		add(l1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			String s=ae.getActionCommand();
			 
			if(s.equals("Add New Donor"))
			{
				setVisible(false);
				new addNewDonor().setVisible(true);
			}
			if(s.equals("Update Donor Details"))
			{
				setVisible(false);
				new updateDonorDetails().setVisible(true);
			}
			if(s.equals("All Donor Detaills"))
			{
				setVisible(false);
				new allDonorDetails().setVisible(true);
			}
			
			
			if(s.equals("By Location"))
			{
				setVisible(false);
				new location().setVisible(true);
			}
			if(s.equals("By Blood Group"))
			{
				setVisible(false);
				new bloodGroup().setVisible(true);
			}
			
			
			if(s.equals("Update Stock"))
			{
				setVisible(false);
				new increaseStock().setVisible(true);
			}
			
			if(s.equals("All Stock Details"))
			{
				setVisible(false);
				new allStockDetails().setVisible(true);
			}
			
			
			if(s.equals("Delete Donor"))
			{
				setVisible(false);
				new deleteDonor().setVisible(true);
			}
			
			
			if(s.equals("Logout"))
			{
				setVisible(false);
				new bloodbank1().setVisible(true);
			}
			if(s.equals("Exit Application"))
			{
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to exit application", "Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
			}
			
		}
		catch(Exception e)
		{
			
		}
	}
	public static void main(String args[])
	{
		new home();
	}
}