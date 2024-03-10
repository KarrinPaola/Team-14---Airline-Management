package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String username = ""; 
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
		setBounds(0, 0, 900, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 200, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton buttonBookFlight = new JButton("Đặt chuyến");
		buttonBookFlight.setFont(new Font("Arial", Font.BOLD, 22));
		buttonBookFlight.setBounds(10, 61, 180, 80);
		panel.add(buttonBookFlight);
		
		JButton buttonListFlight = new JButton("Xem chuyến");
		buttonListFlight.setFont(new Font("Arial", Font.BOLD, 22));
		buttonListFlight.setBounds(10, 261, 180, 80);
		panel.add(buttonListFlight);
		
		JButton buttonAccount = new JButton("Tài khoản");
		buttonAccount.setFont(new Font("Arial", Font.BOLD, 22));
		buttonAccount.setBounds(10, 461, 180, 80);
		panel.add(buttonAccount);
		
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
