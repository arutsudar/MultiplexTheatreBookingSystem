package dbmsProject;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MultiplexTheatreManagementSystem {
	static Connection con;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String s1,s2,s3,s4,s5,s6;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiplexTheatreManagementSystem window = new MultiplexTheatreManagementSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try
		{			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:cse13414/cseamrita@oracle.amritanet.edu:1521/amrita2015.amritanet.edu");  			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	public MultiplexTheatreManagementSystem() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(153, 153, 255));
		frame.setBounds(0,0,400,500);
		//frame.setBounds(0,0,1680,720);
		frame.setTitle("Theatre");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnLogin = new JButton("Sign In");
		JButton btnNewButton_1 = new JButton("Sign Up");
		JLabel lblUsername = new JLabel("Username:");
		textField = new JTextField();
		passwordField = new JPasswordField();
		JLabel lblPassword = new JLabel("Password:");
		JButton btnSignIn = new JButton("Sign In");
		JLabel lblNewLabel = new JLabel("Confirm Password: ");
		JLabel lblNewLabel_1 = new JLabel("Name:");
		textField_1 = new JTextField();
		JLabel lblNewLabel_2 = new JLabel("E-Mail:");
		textField_2 = new JTextField();
		JLabel lblNewLabel_3 = new JLabel("Phone No.:");
		textField_3 = new JTextField();
		JButton btnNewButton = new JButton("Sign Up");
		JLabel lblNewLabel_4 = new JLabel("");
		JLabel lblNewLabel_5 = new JLabel("New label");
		passwordField_1 = new JPasswordField();
		JLabel err = new JLabel("ERROR");
		
		
		
		
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(57, 121, 100, 25);
		frame.getContentPane().add(lblUsername);
		lblUsername.setVisible(false);
		
		textField.setBounds(176, 123, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
				
		passwordField.setBounds(177, 168, 110, 20);
		frame.getContentPane().add(passwordField);
		passwordField.setVisible(false);
		
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(57, 167, 100, 25);
		frame.getContentPane().add(lblPassword);
		lblPassword.setVisible(false);
		
		
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(57, 208, 122, 25);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(57, 85, 100, 25);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		textField_1.setBounds(177, 87, 111, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(57, 244, 100, 25);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		textField_2.setBounds(176, 246, 111, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);

		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(57, 283, 100, 25);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		textField_3.setBounds(176, 285, 111, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(120, 365, 85, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setVisible(false);


		
		lblNewLabel_4.setBackground(new Color(102, 153, 51));
		lblNewLabel_4.setForeground(new Color(153, 153, 51));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\android\\eclipse\\wrong.png"));
		lblNewLabel_4.setBounds(298, 208, 29, 25);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		btnSignIn.setVisible(false);
		btnSignIn.setBorderPainted(false);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{					
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select username,password from login");  
					while(rs.next())  
					{	
						String s1=rs.getString(1);
						String s2=rs.getString(2);						
						if(s1.equals(textField.getText()) && s2.equals(passwordField.getText()))
						{
							con.close();
							dbms_movie obj= new dbms_movie();
							obj.main(s1);
							frame.setVisible(false);
						}
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnSignIn.setVisible(false);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSignIn.setBorderPainted(false);
		btnSignIn.setBackground(new Color(0, 0, 255));
		btnSignIn.setBounds(120, 244, 85, 25);
		frame.getContentPane().add(btnSignIn);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField_1.getText().equals(passwordField.getText()))
				{
					int flag=0;
					try {
						s1=textField_1.getText();
						s2=textField.getText();
						s3=passwordField.getText();
						s4=passwordField_1.getText();
						s5=textField_2.getText();
						s6=textField_3.getText();
						
						Statement stmt = con.createStatement();
						
						stmt.executeUpdate("insert into users values ('"+s1+"','"+s2+"','"+s3+"','"+s5+"','"+s6+"')");
						stmt.executeUpdate("insert into login values ('"+s2+"','"+s3+"')");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						if(e1.getErrorCode()==1)
						{
							flag=1;
							err.setText("This username is already taken. Try a new one.");
							err.setVisible(true);
						}
						else if(e1.getErrorCode()==1400)
						{
							flag=1;
							err.setText("Values cannot be NULL. Please enter values for all.");
							err.setVisible(true);
						}
						else
						{
							try {
								con.close();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							dbms_movie obj= new dbms_movie();
							obj.main(s2);
							frame.setVisible(false);
						}
					}
					if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals(""))
					{
						err.setText("Values cannot be NULL. Please enter values for all.");
						flag=1;
						err.setVisible(true);
					}
					if(flag==1)
					{
						err.setVisible(true);
					}
					else
					{
						try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dbms_movie obj= new dbms_movie();
						obj.main(s2);
						frame.setVisible(false);	
					}
				}
			}
		});
		
		

		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.setBounds(57, 50, 83, 23);
		btnLogin.setBorderPainted(false);
		frame.getContentPane().add(btnLogin);

		lblNewLabel_5.setIcon(new ImageIcon("C:\\android\\eclipse\\correct.png"));
		lblNewLabel_5.setBounds(298, 208, 29, 25);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				if(!(passwordField_1.getText().equals(passwordField.getText())))
				{
					lblNewLabel_5.setVisible(false);
					lblNewLabel_4.setVisible(true);
				}

				if(passwordField_1.getText().equals(passwordField.getText()))
				{	lblNewLabel_4.setVisible(false);
					lblNewLabel_5.setVisible(true);
				}
			}
		});
		passwordField_1.setBounds(177, 210, 111, 20);
		frame.getContentPane().add(passwordField_1);
		passwordField_1.setVisible(false);
		
		
		
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogin.setEnabled(true);
				btnNewButton_1.setEnabled(false);
				
				textField.setVisible(true);
				passwordField.setVisible(true);
				lblPassword.setVisible(true);
				btnSignIn.setVisible(true);
				lblUsername.setVisible(true);

				btnSignIn.setVisible(false);
				btnNewButton.setVisible(true);
				textField_3.setVisible(true);
				lblNewLabel_3.setVisible(true);
				textField_2.setVisible(true);
				lblNewLabel_2.setVisible(true);
				textField_1.setVisible(true);
				lblNewLabel_1.setVisible(true);
				passwordField_1.setVisible(true);
				btnNewButton.setVisible(true);
				lblNewLabel.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(216, 50, 85, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		err.setForeground(Color.WHITE);
		err.setBounds(10, 332, 374, 14);
		frame.getContentPane().add(err);
		err.setVisible(false);
		
		
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnLogin.setEnabled(false);
				btnNewButton_1.setEnabled(true);
				
				textField.setVisible(true);
				passwordField.setVisible(true);
				lblPassword.setVisible(true);
				btnSignIn.setVisible(true);
				lblUsername.setVisible(true);

				btnNewButton.setVisible(false);
				textField_3.setVisible(false);
				lblNewLabel_3.setVisible(false);
				textField_2.setVisible(false);
				lblNewLabel_2.setVisible(false);
				textField_1.setVisible(false);
				lblNewLabel_1.setVisible(false);
				passwordField_1.setVisible(false);
				btnNewButton.setVisible(false);
				lblNewLabel.setVisible(false);
			}
		});

		
		/*
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\android\\eclipse\\images.jpg"));
		lblNewLabel_4.setBounds(0,0,1680,720);
		frame.getContentPane().add(lblNewLabel_4);
		*/

	}
}