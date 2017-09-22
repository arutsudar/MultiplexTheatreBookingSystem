package dbmsProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class book {

	private JFrame frame;
	Integer x;
	static Connection con;
	static String s1,s2,s3,us;
	static int s4,s5;
	public static void main(String s11,String s12,String s13,int s14,int s15,String username) {
		s1=s11;
		s2=s12;
		s3=s13;
		s4=s14;
		s5=s15;
		us=username;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book window = new book();
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
	public book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		x=80;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(200, 74, 36, 20);
		frame.getContentPane().add(spinner);
		
		
		JLabel lblNoOfTickets = new JLabel("No. of tickets :");
		lblNoOfTickets.setBounds(72, 77, 98, 14);
		frame.getContentPane().add(lblNoOfTickets);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(72, 120, 82, 14);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblRs = new JLabel("Rs. 80");
		lblRs.setBounds(200, 120, 82, 14);
		frame.getContentPane().add(lblRs);
		
		JLabel lblMovie = new JLabel("Movie :");
		lblMovie.setBounds(72, 38, 46, 14);
		frame.getContentPane().add(lblMovie);
		
		JLabel moviename = new JLabel("New label");
		moviename.setBounds(200, 38, 155, 14);
		frame.getContentPane().add(moviename);
		
		
		JLabel lblShowTime = new JLabel("Show Time:");
		lblShowTime.setBounds(72, 160, 98, 14);
		frame.getContentPane().add(lblShowTime);
		
		JLabel showtime = new JLabel("New label");
		showtime.setBounds(200, 160, 170, 14);
		frame.getContentPane().add(showtime);

		JLabel log = new JLabel("Logged in as ");
		log.setBounds(22, 11, 228, 14);
		frame.getContentPane().add(log);

		log.setText("Logged in as "+us);
		moviename.setText(s1);
		showtime.setText(s2+"HRS");
		
		JButton confirm = new JButton("Confirm");
		confirm.setBounds(106, 210, 115, 23);
		frame.getContentPane().add(confirm);
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      frame.setVisible(false);
				String[] arguments = new String[] {"123"};
			      MultiplexTheatreManagementSystem.main(arguments);
			      }
		});
		btnNewButton.setBounds(294, 11, 115, 23);
		frame.getContentPane().add(btnNewButton);

		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				x = (Integer)spinner.getValue();
				lblRs.setText("Rs."+x*80);
			}
		});
		

		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{					
					Statement stmt=con.createStatement();
					stmt.executeUpdate("insert into payment values ("+x*80+")");
					stmt.executeUpdate("insert into book_ticket_confirmation values ("+x+")");
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				frame.setVisible(false);
				dialogbox obj = new dialogbox();
				obj.main(x,us);
			}
		});
		
	}
}
