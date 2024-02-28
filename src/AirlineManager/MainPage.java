package AirlineManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String userName = ""; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TableFlightBooked tableFlightBooked = new TableFlightBooked(); 
		contentPane.add(tableFlightBooked); 
		tableFlightBooked.setBounds(230, 7, 610, 445);
		tableFlightBooked.setVisible(false);
		
		BookingFlightPanel2 bookingFlightPanel2 = new BookingFlightPanel2(); 
		contentPane.add(bookingFlightPanel2); 
		bookingFlightPanel2.setBounds(230, 7, 610, 445);
		bookingFlightPanel2.setVisible(false);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		MainPanel.setBounds(230, 7, 610, 445);
		contentPane.add(MainPanel);
		MainPanel.setLayout(null);
		
		JPanel ListButtonPanel = new JPanel();
		ListButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ListButtonPanel.setBounds(6, 6, 215, 445);
		contentPane.add(ListButtonPanel);
		ListButtonPanel.setLayout(null);
		
		JButton BookingButton = new JButton("Đặt chuyến");
		BookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BookingButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		BookingButton.setBounds(35, 100, 150, 50);
		BookingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bookingFlightPanel2.setVisible(true);
				tableFlightBooked.setVisible(false);
				bookingFlightPanel2.setUserName(userName);
				
			}
		});
		ListButtonPanel.add(BookingButton);
		
		JButton ListFlightButton = new JButton("Các chuyến bay");
		ListFlightButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		ListFlightButton.setBounds(35, 200, 150, 50);
		ListFlightButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tableFlightBooked.setVisible(true);
				bookingFlightPanel2.setVisible(false);
				tableFlightBooked.setUserName(userName);
				
			}
		});
		ListButtonPanel.add(ListFlightButton);
		
		JButton AccountButton = new JButton("Tài khoản ");
		AccountButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		AccountButton.setBounds(35, 300, 150, 50);
		ListButtonPanel.add(AccountButton);
		
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
