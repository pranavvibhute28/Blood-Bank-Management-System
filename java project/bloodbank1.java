import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class bloodbank1 extends JFrame implements ActionListener
{
	JTextField t1;
	JButton b1,b2;
	JLabel l1,l2,l3,ll;
	ImageIcon i1,i2,i3,i4;
	JPasswordField t2;
	
	public bloodbank1()
	{
		setLayout(null);
		
		
		
		ll=new JLabel("BloodBank Management System");
		ll.setFont(new Font("Tahoma", Font.BOLD, 60));
		ll.setBounds(100,50,1200,100);
		add(ll);
		
		l1=new JLabel("username");
		l1.setBounds(350,300,200,40);
		l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		l2=new JLabel("password");
		l2.setBounds(350,400,200,40);
		l2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		i1=new ImageIcon("blood2.jpg");
		l3=new JLabel(i1);
		l3.setBounds(0,-50,1200,800);
		
		t1=new JTextField();
		t1.setBounds(500,300,200,40);
		t1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		t2=new JPasswordField();
		t2.setBounds(500,400,200,40);
		t2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		i2=new ImageIcon("login2.png");
		b1=new JButton("login",i2);
		b1.setBounds(400,500,150,50);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		i3=new ImageIcon("cancel.png");
		b2=new JButton("Cancel",i3);
		b2.setBounds(600,500,150,50);
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		add(b1);add(b2);
		add(t1);add(t2);
		add(l1);add(l2);
		add(l3);
		
		setVisible(true);
		setSize(1200,800);
		setLocation(300,100);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			String s=ae.getActionCommand();
			 
			if(s.equals("login"))
			{
				String un=t1.getText();
				String ps=t2.getText();
				if(un.equals("admin")&&ps.equals("1234"))
				{
					JOptionPane.showMessageDialog(this,"login successfull");
					setVisible(false);
					new home().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"incorrect username or password");
					t1.setText("");
					t2.setText("");
				}
			}
			if(s.equals("Cancel"))
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
			JOptionPane.showMessageDialog(this,e);
		}
	}
	public static void main(String args[])
	{
		new bloodbank1();
	}
}	