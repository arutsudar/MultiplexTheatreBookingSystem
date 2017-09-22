package dbmsProject;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dialogbox {

	private JFrame frame;
	static int x;
	static Connection con;
	static String us;
	public static void main(int s,String username) {
		us=username;
		x=s*80;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogbox window = new dialogbox();
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

	/**
	 * Create the application.
	 */
	public dialogbox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lk1 = new JLabel("Your total cost is ");
		lk1.setBounds(85, 52, 109, 23);
		frame.getContentPane().add(lk1);
		
		JLabel lk5 = new JLabel("New label");
		lk5.setBounds(191, 56, 46, 14);
		frame.getContentPane().add(lk5);
	
		lk5.setText(x+"");
		
		JLabel lk2 = new JLabel("Proceed to pay ?");
		lk2.setBounds(85, 89, 142, 14);
		frame.getContentPane().add(lk2);
		
		JButton lk3 = new JButton("YES");
		lk3.setBounds(61, 140, 96, 23);
		frame.getContentPane().add(lk3);
		
		JButton lk4 = new JButton("No");
		lk4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbms_movie ob = new dbms_movie();
				frame.setVisible(false);
				ob.main(us);
			}
		});
		lk4.setBounds(184, 140, 96, 23);
		frame.getContentPane().add(lk4);
		
		JLabel ll1 = new JLabel("PAYMENT SUCCESFULL !!!");
		ll1.setBounds(141, 103, 198, 14);
		frame.getContentPane().add(ll1);
		
		JButton ll2 = new JButton("LOG OUT");
		ll2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			      frame.setVisible(false);
				String[] arguments = new String[] {"123"};
			      MultiplexTheatreManagementSystem.main(arguments);
			      
			}
		});
		ll2.setBounds(302, 18, 109, 23);
		frame.getContentPane().add(ll2);
		
		JButton ll3 = new JButton("HOME");
		ll3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbms_movie ob = new dbms_movie();
				frame.setVisible(false);
				ob.main(us);
			}
		});
		ll3.setBounds(29, 18, 109, 23);
		frame.getContentPane().add(ll3);

		lk3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lk1.setVisible(false);
				lk2.setVisible(false);
				lk3.setVisible(false);
				lk4.setVisible(false);
				lk5.setVisible(false);
				lk3.setEnabled(false);
				lk4.setEnabled(false);
				
				ll1.setVisible(true);
				ll2.setVisible(true);
				ll3.setVisible(true);
				ll1.setEnabled(true);
				ll2.setEnabled(true);
				ll3.setEnabled(true);
				
			}
		});
		
		ll1.setVisible(false);
		ll2.setVisible(false);
		ll3.setVisible(false);
		ll1.setEnabled(false);
		ll2.setEnabled(false);
		ll3.setEnabled(false);
	}

}
