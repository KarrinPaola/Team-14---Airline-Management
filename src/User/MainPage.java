package User;

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

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static ListFlightPanel listFlightPanel = new ListFlightPanel(); 
	static fillInformationPanel fillInformationPanel = new fillInformationPanel(); 
	static ListFlight listFlight = new ListFlight(); 
	static PanelPay panelPay = new PanelPay(); 
	static Accountpanel accountpanel = new Accountpanel(); 
	
	private JPanel contentPane;
	private String username = ""; 
	private String typeAccount = ""; 
	
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
		
		//Nhập các Panel cần dùng vào đây 
		
		//Panel chọn chuyến bay
		listFlightPanel.setBounds(200, 0, 700, 600);
		listFlightPanel.setVisible(false);
		contentPane.add(listFlightPanel); 
		
		//Panel điều các thông tin cần thiết
		fillInformationPanel.setBounds(200, 0, 700, 600);
		fillInformationPanel.setVisible(false);
		contentPane.add(fillInformationPanel); 
		
		
		//Panel thanh toán tiền  
		panelPay.setBounds(200, 0, 700, 600);
		panelPay.setVisible(false);
		contentPane.add(panelPay); 

		
		//Xem danh sách các chuyến bay của mình
		listFlight.setBounds(200,0,700,600);
		listFlight.setVisible(false);
		contentPane.add(listFlight); 

		
		//Panel đổi mật khẩu 
		accountpanel.setBounds(200, 0, 700, 600);
		accountpanel.setVisible(false);
		contentPane.add(accountpanel); 

		
		
		
		
		//Chuyển các panel 
		JPanel PanelListButton = new JPanel();
		PanelListButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelListButton.setBounds(0, 0, 200, 600);
		contentPane.add(PanelListButton);
		PanelListButton.setLayout(null);
		
		JButton buttonBookFlight = new JButton("Đặt chuyến");
		buttonBookFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listFlightPanel.setVisible(true);
				listFlight.setVisible(false);
				accountpanel.setVisible(false);
				fillInformationPanel.setVisible(false);
				panelPay.setVisible(false);
			}
		});
		buttonBookFlight.setFont(new Font("Arial", Font.BOLD, 22));
		buttonBookFlight.setBounds(10, 61, 180, 80);
		PanelListButton.add(buttonBookFlight);
		
		JButton buttonListFlight = new JButton("Xem chuyến");
		buttonListFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listFlightPanel.setVisible(false);
				listFlight.setVisible(true);
				accountpanel.setVisible(false);
				fillInformationPanel.setVisible(false);
				panelPay.setVisible(false);
			}
		});
		buttonListFlight.setFont(new Font("Arial", Font.BOLD, 22));
		buttonListFlight.setBounds(10, 261, 180, 80);
		PanelListButton.add(buttonListFlight);
		
		JButton buttonAccount = new JButton("Tài khoản");
		buttonAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listFlightPanel.setVisible(false);
				listFlight.setVisible(false);
				accountpanel.setVisible(true);
				fillInformationPanel.setVisible(false);
				panelPay.setVisible(false);
			}
		});
		buttonAccount.setFont(new Font("Arial", Font.BOLD, 22));
		buttonAccount.setBounds(10, 461, 180, 80);
		PanelListButton.add(buttonAccount);
		
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

}
