import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
public class addNewDonor extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ll,im;
	JTextField t1,t2,t3,t4,t5,t7,t9;
	JTextArea ta1;
	ImageIcon im1,im2,im3,im4,im5;
	JComboBox c1,c2;
	String s1[]={"Male","Female","Other"};
	String s2[]={"a+","a-","b+","b-","o+","o-","ab+","ab-"};
	JButton b1,b2,b3;
	
	public addNewDonor()
	{
		setLayout(null);
		setVisible(true);
    		
		setTitle("Add New Donor");
		
		im2=new ImageIcon("add-user.png");
		im=new JLabel(im2);
		im.setBounds(280,40,80,80);
		add(im);
		
		ll=new JLabel("Add New Donor");
		ll.setFont(new Font("Tahoma", Font.BOLD, 60));
		ll.setBounds(350,30,500,100);
		add(ll);
		
		im3=new ImageIcon("save.png");
		b1=new JButton("Save",im3);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBounds(200,500,150,50);
		
		im4=new ImageIcon("reset.png");
		b2=new JButton("Reset",im4);
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBounds(400,500,150,50);
		
		im5=new ImageIcon("cancel.png");
		b3=new JButton("Cancel",im5);
		b3.setFont(new Font("Tahoma", Font.BOLD, 15));
		b3.setBounds(600,500,150,50);
		
		l1=new JLabel("Donor ID");
		l1.setFont(new Font("Tahoma", Font.BOLD, 17));
		l1.setBounds(60,150,100,50);
		
		t1=new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 15));
		t1.setBounds(200,150,300,40);		
		//Random rd = new Random();
		//t1.setText("" + rd.nextInt(5 + 1));
		
		l2=new JLabel("Full Name");
		l2.setFont(new Font("Tahoma", Font.BOLD, 17));
		l2.setBounds(60,200,150,50);
		
		t2=new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 15));
		t2.setBounds(200,200,300,40);
		
		l3=new JLabel("Father Name");
		l3.setFont(new Font("Tahoma", Font.BOLD, 17));
		l3.setBounds(60,250,150,50);
		
		t3=new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 15));
		t3.setBounds(200,250,300,40);
		
		l4=new JLabel("Date of Birth");
		l4.setFont(new Font("Tahoma", Font.BOLD, 17));
		l4.setBounds(60,300,150,50);
		
		t4=new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 15));
		t4.setBounds(200,300,300,40);
		
		l5=new JLabel("Mobile NO.");
		l5.setFont(new Font("Tahoma", Font.BOLD, 17));
		l5.setBounds(60,350,150,50);
		
		t5=new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 15));
		t5.setBounds(200,350,300,40);
		
		l6=new JLabel("gender");
		l6.setFont(new Font("Tahoma", Font.BOLD, 17));
		l6.setBounds(60,400,150,50);
		
		c1=new JComboBox(s1);
		c1.setFont(new Font("Tahoma", Font.BOLD, 15));
		c1.setBounds(200,400,300,40);
		
		l7=new JLabel("Email ID");
		l7.setFont(new Font("Tahoma", Font.BOLD, 17));
		l7.setBounds(570,150,100,50);
		
		t7=new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 15));
		t7.setBounds(700,150,300,40);
		
		l8=new JLabel("Blood Group");
		l8.setFont(new Font("Tahoma", Font.BOLD, 17));
		l8.setBounds(570,400,150,50);
		
		c2= new JComboBox(s2);
		c2.setFont(new Font("Tahoma", Font.BOLD, 15));
		c2.setBounds(700,400,300,40);
		
		l9=new JLabel("City");
		l9.setFont(new Font("Tahoma", Font.BOLD, 17));
		l9.setBounds(570,200,100,50);
		
		t9=new JTextField();
		t9.setFont(new Font("Tahoma", Font.BOLD, 15));
		t9.setBounds(700,200,300,40);
		
		l10=new JLabel("Adresss");
		l10.setFont(new Font("Tahoma", Font.BOLD, 17));
		l10.setBounds(570,250,100,50);
		
		ta1=new JTextArea();
		ta1.setFont(new Font("Tahoma", Font.BOLD, 15));
		ta1.setBounds(700,250,300,130);
		
		im1=new ImageIcon("bg3.jpg");
		l11=new JLabel(im1);
		l11.setBounds(0,0,1200,800);
		l12=new JLabel();
		l12.setBounds(150,00,100,50);
		
		
		add(c1);add(c2);
		
		add(b1);add(b2);add(b3);
		
		add(ta1);
		
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
		add(l7);add(l8);add(l9);add(l10);add(l11);
		
		add(t1);add(t2);add(t3);add(t4);add(t5);
		add(t7);add(t9);
		
		add(l12);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setSize(1200,800);
		setLocation(300,100);
		validate();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try
		{
			String s=ae.getActionCommand();
			 
			if(s.equals("Cancel"))
			{
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to exit window", "Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					
					setVisible(false);
					new home().setVisible(true);
				}
				
			} 
			if(s.equals("Save"))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//JOptionPane.showMessageDialog(this,"Driver Registered");

				Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
				//JOptionPane.showMessageDialog(this,"Connection Created");

	
        				//PreparedStatement p1=co.prepareStatement("Select max(ID) from donor");
				//ResultSet rs =p1.executeQuery();
				/*if(rs.first())
				{
					int id=rs.getInt(1);
					id=id+1;
					String st=String.valueOf(id);
					t1.setText(st);
				}
				else
				{
					t1.setText("1");
				}*/
    	

				String name,fnm,dob,mobile,gender,email,bg,city,add;
				int id=Integer.parseInt(t1.getText());
				name=t2.getText();
				fnm=t3.getText();
				dob=t4.getText();
				mobile=t5.getText();
				gender=(String)c1.getSelectedItem();
				bg=(String)c2.getSelectedItem();
				email=t7.getText();
				city=t9.getText();
				add=ta1.getText();
				

				PreparedStatement ps=co.prepareStatement("insert into donor values(?,?,?,?,?,?,?,?,?,?)");
				
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setString(3,fnm);
				ps.setString(4,dob);
				ps.setString(5,mobile);
				ps.setString(6,gender);
				ps.setString(7,email);
				ps.setString(8,bg);
				ps.setString(9,city);
				ps.setString(10,add);
				
				ps.executeUpdate();
			
				co.close();
				//p1.close();
				JOptionPane.showMessageDialog(this,"Data Insreted Successfully");
				setVisible(false);
				new addNewDonor().setVisible(true);
			}
			
			if(s.equals("Reset"))
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t7.setText("");
				t9.setText("");
				ta1.setText("");
				
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Enter valid ID");
		}
	}
	
	public static void main(String args[])
	{
		new addNewDonor();
	}
}