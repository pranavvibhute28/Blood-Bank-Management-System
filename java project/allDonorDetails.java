import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class allDonorDetails extends JFrame implements ActionListener
{
	JTable tb1;
	JButton b1;
	JLabel l1,l2;
	ImageIcon im1;
	JTextArea t1;
	int count=0;
	public allDonorDetails()
	{
		setLayout(null);
		setVisible(true);
		
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		l1=new JLabel("All Donor Details");
		l1.setFont(new Font("Tahoma", Font.BOLD, 60));
		l1.setBounds(350,10,700,100);
		JPanel jp=new JPanel();
		b1=new JButton("Cancel");
		b1.setBounds(400,500,150,40);
		b1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		b1.addActionListener(this);
		add(b1);
		
		
		setLocation(300,100);
		add(l1);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
			String sql = "select * from donor";						
            PreparedStatement ps = co.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
			
			String colHeads[]={"ID","FULLNAME","FATHER NAME","DATE OF BIRTH","MOBILE","GENDER","EMAIL","BLOOD GROUP","CITY","ADDRESS"};
			String data[][]={
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""},
						{"","","","","","","","","",""}};
						
			tb1 = new JTable(data,colHeads);
			tb1.setFont(new Font("Tahoma", Font.BOLD, 15));
			
			
			int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;	
	
			JScrollPane scrollPane = new JScrollPane(tb1, v, h);
			scrollPane.setBounds(0,150,1290, 300);
			
			
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
			add(scrollPane);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,e);	
		}
		im1=new ImageIcon("bg.jpg");
		l2=new JLabel(im1);
		l2.setBounds(0,0,1300,800);
		
		setTitle("All Donor Details");
		setSize(1300,800);
		
		add(l2);
		validate();
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("Cancel"))
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
		new allDonorDetails();
	}
}