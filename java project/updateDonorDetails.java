import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class updateDonorDetails extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ll;
	JTextField t1,t2,t3,t4,t5,t7,t9;
	JTextArea ta1;
	JComboBox c1,c2;
	String s1[]={"Male","Female","Other"};
	String s2[]={"a+","a-","b+","b-","o+","o-","ab+","ab-"};
	JButton b1,b2,b3;
	public updateDonorDetails()
	{
		setLayout(null);
		setVisible(true);
		setTitle("Update Donor Details");
		
		ImageIcon im2=new ImageIcon("add-user.png");
		JLabel im=new JLabel(im2);
		im.setBounds(220,40,80,80);
		add(im);
		
		ll=new JLabel("Update Donor Details");
		ll.setFont(new Font("Tahoma", Font.BOLD, 60));
		ll.setBounds(290,30,800,100);
		add(ll);
		
		b1=new JButton("Update");
		b1.setBounds(200,500,100,50);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		b2=new JButton("Reset");
		b2.setBounds(400,500,100,50);
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		b3=new JButton("Cancel");
		b3.setBounds(600,500,100,50);
		b3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l1=new JLabel("Donor ID");
		l1.setBounds(100,150,100,50);
		l1.setFont(new Font("Tahoma", Font.BOLD, 15));
		t1=new JTextField();
		t1.setBounds(200,150,300,40);
		t1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l2=new JLabel("Full Name");
		l2.setBounds(100,200,100,50);
		l2.setFont(new Font("Tahoma", Font.BOLD, 15));
		t2=new JTextField();
		t2.setBounds(200,200,300,40);
		t2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l3=new JLabel("Father Name");
		l3.setBounds(100,250,100,50);
		l3.setFont(new Font("Tahoma", Font.BOLD, 15));
		t3=new JTextField();
		t3.setBounds(200,250,300,40);
		t3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l4=new JLabel("Date of Birth");
		l4.setBounds(100,300,100,50);
		l4.setFont(new Font("Tahoma", Font.BOLD, 15));
		t4=new JTextField();
		t4.setBounds(200,300,300,40);
		t4.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l5=new JLabel("Mobile no.");
		l5.setBounds(100,350,100,50);
		l5.setFont(new Font("Tahoma", Font.BOLD, 15));
		t5=new JTextField();
		t5.setBounds(200,350,300,40);
		t5.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l6=new JLabel("gender");
		l6.setBounds(100,400,100,50);
		l6.setFont(new Font("Tahoma", Font.BOLD, 15));
		c1=new JComboBox(s1);
		c1.setBounds(200,400,300,40);
		c1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l7=new JLabel("Email ID");
		l7.setBounds(600,150,100,50);
		l7.setFont(new Font("Tahoma", Font.BOLD, 15));
		t7=new JTextField();
		t7.setBounds(700,150,300,40);
		t7.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l8=new JLabel("Blood Group");
		l8.setBounds(600,200,100,50);
		l8.setFont(new Font("Tahoma", Font.BOLD, 15));
		c2= new JComboBox(s2);
		c2.setBounds(700,200,300,40);
		c2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l9=new JLabel("City");
		l9.setBounds(600,250,100,50);
		l9.setFont(new Font("Tahoma", Font.BOLD, 15));
		t9=new JTextField();
		t9.setBounds(700,250,300,40);
		t9.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		l10=new JLabel("Adresss");
		l10.setBounds(600,300,100,50);
		l10.setFont(new Font("Tahoma", Font.BOLD, 15));
		ta1=new JTextArea();
		ta1.setBounds(700,300,300,150);
		ta1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		ImageIcon im1=new ImageIcon("bg3.jpg");
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
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		try
		{
			String s=ae.getActionCommand();
			if (s.equals("Update"))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//JOptionPane.showMessageDialog(this,"Driver Registered");

				Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
				//JOptionPane.showMessageDialog(this,"Connection Created");

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
				

				PreparedStatement ps=co.prepareStatement("Update donor set fullName=?,fatherName=?,dob=?,mobile=?,gender=?,Email=?,bloodg=?,city=?,address=? where ID=?");
				
				ps.setString(1,name);
				ps.setString(2,fnm);
				ps.setString(3,dob);
				ps.setString(4,mobile);
				ps.setString(5,gender);
				ps.setString(6,email);
				ps.setString(7,bg);
				ps.setString(8,city);
				ps.setString(9,add);
				ps.setInt(10,id);
				
				ps.executeUpdate();
			
				co.close();
				JOptionPane.showMessageDialog(this,"Data Updated Successfully");
				setVisible(false);
				new updateDonorDetails().setVisible(true);
			}
			if(s.equals("Cancel"))
			{
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close window", "Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false);
					new home().setVisible(true);
				}
				//new home().setVisible(true);
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
			JOptionPane.showMessageDialog(this,e);
		}
	}
	
	public static void main(String args[])
	{
		new updateDonorDetails();
	}
}