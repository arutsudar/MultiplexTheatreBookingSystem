package dbmsProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollBar;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dbms_movie {
	private JFrame frame;
	static Connection con;
	static String us;
	public void main(String username) {

		us=username;
		try
		{			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:cse13414/cseamrita@oracle.amritanet.edu:1521/amrita2015.amritanet.edu");  			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbms_movie window = new dbms_movie();
					window.frame.setVisible(true);
				} catch (Exception e) {
						System.out.println(e);
				}
			}
		});
	}
	public dbms_movie() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0,800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(90, 32, 252, 30);
		frame.getContentPane().add(lblUsername);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			      frame.setVisible(false);
				String[] arguments = new String[] {"123"};
			      MultiplexTheatreManagementSystem.main(arguments);
			}
		});
		btnLogout.setBounds(563, 22, 200, 50);
		frame.getContentPane().add(btnLogout);
		
		JLabel lbl11 = new JLabel("Movie Name: ");
		lbl11.setBounds(107, 110, 92, 30);
		frame.getContentPane().add(lbl11);
		
		JLabel lbl12 = new JLabel("Showtime: ");
		lbl12.setBounds(107, 167, 92, 22);
		frame.getContentPane().add(lbl12);
		
		JLabel lbl14 = new JLabel("Screen No.: ");
		lbl14.setBounds(107, 275, 92, 22);
		frame.getContentPane().add(lbl14);
		
		JLabel lbl13 = new JLabel("Movie description: ");
		lbl13.setBounds(107, 222, 123, 22);
		frame.getContentPane().add(lbl13);
		
		JLabel lbl21 = new JLabel("Movie Name. This will be changed.");
		lbl21.setBounds(281, 110, 290, 30);
		frame.getContentPane().add(lbl21);
		
		JLabel lbl22 = new JLabel("Movie Name. This will be changed.");
		lbl22.setBounds(281, 163, 290, 30);
		frame.getContentPane().add(lbl22);
		
		JLabel lbl23 = new JLabel("Movie Name. This will be changed.");
		lbl23.setBounds(281, 214, 453, 38);
		frame.getContentPane().add(lbl23);
		
		JLabel lbl24 = new JLabel("Movie Name. This will be changed.");
		lbl24.setBounds(281, 275, 290, 30);
		frame.getContentPane().add(lbl24);
		
		JLabel left = new JLabel("");
		left.setIcon(new ImageIcon("C:\\android\\eclipse\\left.jpg"));
		left.setBackground(new Color(0, 102, 51));
		left.setBounds(43, 416, 60, 50);
		frame.getContentPane().add(left);
		
		JLabel right = new JLabel("");
		right.setIcon(new ImageIcon("C:\\android\\eclipse\\right.jpg"));
		right.setBounds(445, 416, 60, 50);
		frame.getContentPane().add(right);
		
		lblUsername.setText("Logged in as "+us);
		
		
		try
		{					
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("select * from movie");
			stmt.setFetchSize(1);
			
			if(rs.next())
			{

				String s1=rs.getString(4);
				String s2=rs.getString(2);
				String s3=rs.getString(6);
				int s4=rs.getInt(3);
				int s5=rs.getInt(5);
				lbl21.setText(s1);
				lbl22.setText(s2+" HRS");
				lbl23.setText(s3);
				lbl24.setText(s4+" ");
			}
				right.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						try {
							if(rs.next())
							{
								String s1=rs.getString(4);
								String s2=rs.getString(2);
								String s3=rs.getString(6);
								int s4=rs.getInt(3);
								int s5=rs.getInt(5);
								lbl21.setText(s1);
								lbl22.setText(s2+" HRS");
								lbl23.setText(s3);
								lbl24.setText(s4+" ");
							}
							else
								rs.previous();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				left.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						try {
							if(rs.previous())
							{
								String s1=rs.getString(4);
								String s2=rs.getString(2);
								String s3=rs.getString(6);
								int s4=rs.getInt(3);
								int s5=rs.getInt(5);
								lbl21.setText(s1);
								lbl22.setText(s2+" HRS");
								lbl23.setText(s3);
								lbl24.setText(s4+" ");
							}
							else
								rs.next();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});

				JButton BOOK = new JButton("Book Now");
				BOOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						try{
						String s1=rs.getString(4);
						String s2=rs.getString(2);
						String s3=rs.getString(6);
						int s4=rs.getInt(3);
						int s5=rs.getInt(5);
						
						book b=new book();
						frame.setVisible(false);
						book.main(s1, s2, s3, s4, s5,us);
						
						
						}
						catch(Exception e){
							System.out.println(e);}
					}
				});
				BOOK.setBounds(218, 430, 133, 30);
				frame.getContentPane().add(BOOK);
				
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
}
