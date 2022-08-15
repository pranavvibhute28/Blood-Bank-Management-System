import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class location extends JFrame implements ActionListener
{
	JTable tb1;
	JButton b1,b2;
	JLabel l1,l2,l3;
	ImageIcon im1;
	JTextField t1;
	int count=0;
	
	public location()
	{
		setLayout(null);
		setVisible(true);
		
		l1=new JLabel("Search Donor By Location");
		l1.setFont(new Font("Tahoma", Font.BOLD, 60));
		l1.setBounds(150,50,1000,100);
		add(l1);
		
		l2=new JLabel("Enter Name Of City");
		l2.setBounds(150,200,250,40);
		l2.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(l2);
		
		t1=new JTextField();
		t1.setBounds(370,200,250,40);
		t1.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(t1);
		
		b1=new JButton("Search");
		b1.setBounds(650,200,200,40);
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Close");
		b2.setBounds(890,200,200,40);
		b2.setFont(new Font("Tahoma", Font.BOLD, 20));
		b2.addActionListener(this);
		add(b2);
		
		
		String colHeads[]={"ID","FUlLNAME","FATHER NAME","DATE OF BIRTH","MOBILE","GENDER","EMAIL","BLOOD GROUP","CITY","ADDRESS"};
		String data[][]={
					{"","","","","","","","","",""},
					{"","","","","","","","","",""},
					{"","","","","","","","","",""},
					{"","","","","","","","","",""},
					{"","","","","","","","","",""},
					{"","","","","","","","","",""},
					{"","","","","","","","","",""},
					{"","","","","","","","","",""}};
					
		tb1 = new JTable(data,colHeads);
		tb1.setFont(new Font("Tahoma", Font.BOLD, 18));
			
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			
		JScrollPane scrollPane = new JScrollPane(tb1, v, h);
		scrollPane.setBounds(0, 300, 1200, 150);
		add(scrollPane);
		
		im1=new ImageIcon("bg.jpg");
		l3=new JLabel(im1);
		l3.setBounds(0,0,1200,800);
		setTitle("All Stock Details");
		setSize(1200,800);
		add(l3);
		
		setTitle("Search By Location");
		setSize(1200,800);
		setLocation(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("Search"))
		{
			
			try
			{
				String tt1=t1.getText();
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
				//String sql = ;						
				PreparedStatement ps = co.prepareStatement("select * from donor where city like ?");
				ps.setString(1,tt1);
				ResultSet rs =ps.executeQuery();
		
				
				while(rs.next())
				{
					tb1.setValueAt(rs.getString(1),count,0);
					tb1.setValueAt(rs.getString(2),count,1);
					tb1.setValueAt(rs.getString(3),count,2);
					tb1.setValueAt(rs.getString(4),count,3);
					tb1.setValueAt(rs.getString(5),count,4);
					tb1.setValueAt(rs.getString(6),count,5);
					tb1.setValueAt(rs.getString(7),count,6);
					tb1.setValueAt(rs.getString(8),count,7);
					tb1.setValueAt(rs.getString(9),count,8);
					tb1.setValueAt(rs.getString(10),count,9);
					count++;
				}
				ps.close();
				co.close();
				
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this,e);	
			}	
		}
		if(s.equals("Close"))
		{
			int a=JOptionPane.showConfirmDialog(null, "Do you really want to close window", "Select",JOptionPane.YES_NO_OPTION);
			if(a==0)
			{
				setVisible(false);
				new home().setVisible(true);
			}	
		}	
	}
	public static void main(String args[])
	{
		new location();
	}
}