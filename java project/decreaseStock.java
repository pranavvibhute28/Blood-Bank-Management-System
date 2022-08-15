import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
public class decreaseStock extends JFrame 
{
	public decreaseStock()
	{
		setLayout(null);
		setVisible(true);
		setTitle("Decrease Stock");
		setSize(1200,800);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new decreaseStock();
	}
}