package AirlineManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUpPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField_reInputPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
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
	public SignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 850, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(200, 58, 450, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel SignUpLabel = new JLabel("Đăng ký tài khoản mới");
		SignUpLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		SignUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SignUpLabel.setBounds(100, 25, 250, 20);
		panel.add(SignUpLabel);
		
		JLabel InputUserName = new JLabel("Tên đăng nhập");
		InputUserName.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		InputUserName.setBounds(45, 80, 250, 20);
		panel.add(InputUserName);
		
		JLabel InputPassword = new JLabel("Mật khẩu");
		InputPassword.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		InputPassword.setBounds(45, 150, 250, 20);
		panel.add(InputPassword);
		
		JLabel ReInputPassword = new JLabel("Nhập lại mật khẩu");
		ReInputPassword.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		ReInputPassword.setBounds(45, 220, 250, 20);
		panel.add(ReInputPassword);
		
		JLabel NoteForUsername = new JLabel("( Tên đăng nhập chỉ bao gồm các ký tự và chữ thường )");
		NoteForUsername.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		NoteForUsername.setBounds(45, 130, 362, 11);
		panel.add(NoteForUsername);
		
		JLabel NoteForPassword = new JLabel("( Mật khẩu phải bao gồm 6 ký tự trở lên, chỉ bao gồm chữ thường và ký tự )");
		NoteForPassword.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		NoteForPassword.setBounds(45, 200, 362, 11);
		panel.add(NoteForPassword);
		
		textField_username = new JTextField();
		textField_username.setBounds(40, 100, 370, 30);
		panel.add(textField_username);
		textField_username.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(40, 170, 370, 30);
		panel.add(textField_password);
		
		textField_reInputPassword = new JTextField();
		textField_reInputPassword.setColumns(10);
		textField_reInputPassword.setBounds(40, 240, 370, 30);
		panel.add(textField_reInputPassword);
		
		JButton SignUpButton = new JButton("Đăng ký");
		SignUpButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		SignUpButton.setBounds(160, 285, 117, 35);
		SignUpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection connection = null;
				PreparedStatement statement = null; 
				java.sql.Statement statement2 = null; 
				List<User> users = new ArrayList<>(); 
				
				String UserName = textField_username.getText(); 
				String UserPassword = textField_password.getText();
				String reInputPassword = textField_reInputPassword.getText(); 
				String UserID = ""; 
				
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/AirlineManagement","root", "");
					
					statement2 = connection.createStatement(); 
					String sqlString = "select * from User_Password"; 
					ResultSet resultset = statement2.executeQuery(sqlString); 
					
					while (resultset.next()) {
						User user = new User(
								resultset.getString("UserName"), 
								resultset.getString("UserPassword"), 
								resultset.getString("UserID")
						); 
						users.add(user);
					}
					
					UserID = String.format("%03d", users.size());
					
					String sql = "insert into User_Password(UserName, UserPassword, UserID)" + "values(?,?,?)"; 
					
					statement = connection.prepareStatement(sql); 
					
					statement.setString(1, UserName.toLowerCase()); 
					statement.setString(2, UserPassword); 
					statement.setString(3, UserID); 
					
					
					if(UserPassword.length() >= 6 && UserPassword.equals(reInputPassword)) {
						try {
							statement.execute();
							int option = JOptionPane.showOptionDialog(null, "Đăng ký thành công!", "Thông báo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Quay lại đăng nhập"}, "Quay lại đăng nhập");
							if (option == 0) {
							    LoginPage loginPage = new LoginPage(); 
							    loginPage.setVisible(true); 
							}

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!", "title", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!", "title", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if (statement2 != null) {
						try {
							statement2.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
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
		panel.add(SignUpButton);
	}
}
