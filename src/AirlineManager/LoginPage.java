package AirlineManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JButton LoginButton; 
	private JButton lossPasswordButton; 
	private JButton signUpButton; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 850, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(215, 84, 400, 267);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userNameLabel = new JLabel("Tên đăng nhập:");
		userNameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		userNameLabel.setBounds(52, 50, 139, 20);
		panel.add(userNameLabel);
		
		textField_Username = new JTextField();
		textField_Username.setColumns(10);
		textField_Username.setBounds(50, 70, 300, 35);
		panel.add(textField_Username);
		
		JLabel passWordLabel = new JLabel("Mật khẩu: ");
		passWordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		passWordLabel.setBounds(52, 120, 90, 20);
		panel.add(passWordLabel);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(50, 140, 300, 35);
		panel.add(textField_Password);
		
		//Các button xử lý
		LoginButton = new JButton("Đăng nhập");
		LoginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		LoginButton.setBounds(140, 185, 120, 35);
		LoginButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection connection = null; 
				java.sql.Statement statement = null; 
				List<User> users = new ArrayList<>(); 
				String userName = textField_Username.getText(); 
				String userPassword = textField_Password.getText(); 
				
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/AirlineManagement","root", "");
					statement = connection.createStatement(); 
					
					String sqlString = "select * from User_Password where UserName='"+userName+"' and UserPassword='"+userPassword+"'"; 
					ResultSet resultset = statement.executeQuery(sqlString); 
					
					if(resultset.next()) {
						dispose(); 
						JOptionPane.showMessageDialog(null, "Bạn đã đăng nhập thành công!", "title", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc tên đăng nhập!", "title", JOptionPane.INFORMATION_MESSAGE);
						textField_Username.setText(""); 
						textField_Password.setText(""); 
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if(statement != null) {
						try {
							statement.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
					if(connection != null) {
						try {
							connection.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				}
				
			}
		});
		panel.add(LoginButton);
		
		lossPasswordButton = new JButton("Quên mật khẩu");
		lossPasswordButton.setSelectedIcon(null);
		lossPasswordButton.setForeground(new Color(0, 0, 0));
		lossPasswordButton.setBounds(51, 230, 107, 20);
		panel.add(lossPasswordButton);
		
		signUpButton = new JButton("Đăng ký");
		signUpButton.setSelectedIcon(null);
		signUpButton.setForeground(Color.BLACK);
		signUpButton.setBounds(287, 230, 63, 20);
		signUpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignUpPage signUpPage = new SignUpPage(); 
				signUpPage.setVisible(true);
			}
		}); 
		panel.add(signUpButton);
	}
}
