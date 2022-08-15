import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class allStockDetails extends JFrame implements ActionListener
{
	JTable tb1;
	JButton b1;
	JLabel l1,l2;
	ImageIcon im1;
	JTextField search;
	int count=0;
	
	public allStockDetails()
	{
		setLayout(null);
		setVisible(true);
		
		l1=new JLabel("All Stock Details");
		l1.setFont(new Font("Tahoma", Font.BOLD, 60));
		
		l1.setBounds(300,50,700,100);
		
		b1=new JButton("Cancel");
		b1.setBounds(300,400,150,50);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.addActionListener(this);
		add(b1);
		
		setLocation(300,100);
		add(l1);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection co=DriverManager.getConnection("jdbc:odbc:bbms");
			String sql = "select * from blood";						
            PreparedStatement ps = co.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
			
			String colHeads[]={"Blood group","Quantity"};
			String data[][]={
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""},
						{"",""}};
						
			tb1 = new JTable(data,colHeads);
			tb1.setFont(new Font("Tahoma", Font.BOLD, 18));
			
			
			int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;	
	
			JScrollPane scrollPane = new JScrollPane(tb1, v, h);
			scrollPane.setBounds(200, 200, 700, 150);
			
			
			while(rs.next())
			{
				tb1.setValueAt(rs.getString(1),count,0);
				tb1.setValueAt(rs.getString(2),count,1);
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
		l2.setBounds(0,0,1200,800);
		setTitle("All Stock Details");
		setSize(1200,800);
		add(l2);
		//add(tb1);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
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
	}
	
	public static void main(String args[])
	{
		new allStockDetails();
	}
}