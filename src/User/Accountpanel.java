package User;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Accountpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField_OldPassword;
	private JPasswordField passwordField_NewPassword;
	private JPasswordField passwordField_ReInputNewPassword;

	/**
	 * Create the panel.
	 */
	public Accountpanel() {
		setLayout(null);
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(null);
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0),3));
		panelMain.setBounds(100, 98, 500, 400);
		add(panelMain);
		
		JLabel OldPassword = new JLabel("Mật khẩu mới");
		OldPassword.setFont(new Font("Arial", Font.BOLD, 20));
		OldPassword.setBounds(50, 125, 150, 30);
		panelMain.add(OldPassword);
		
		JLabel NewPassword = new JLabel("Nhập lại mật khẩu mới ");
		NewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		NewPassword.setBounds(50, 225, 282, 30);
		panelMain.add(NewPassword);
		
		JLabel ReInputPassword = new JLabel("Mật khẩu cũ");
		ReInputPassword.setFont(new Font("Arial", Font.BOLD, 20));
		ReInputPassword.setBounds(50, 35, 150, 30);
		panelMain.add(ReInputPassword);
		
		passwordField_OldPassword = new JPasswordField();
		passwordField_OldPassword.setBounds(45, 255, 400, 40);
		panelMain.add(passwordField_OldPassword);
		
		passwordField_NewPassword = new JPasswordField();
		passwordField_NewPassword.setBounds(45, 65, 400, 40);
		panelMain.add(passwordField_NewPassword);
		
		passwordField_ReInputNewPassword = new JPasswordField();
		passwordField_ReInputNewPassword.setBounds(45, 155, 400, 40);
		panelMain.add(passwordField_ReInputNewPassword);
		
		JButton button_ChangePassword = new JButton("Đổi mật khẩu");
		button_ChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldPassword = String.valueOf(passwordField_OldPassword.getPassword());
				String newPassword = String.valueOf(passwordField_NewPassword.getPassword());
				String reInputPassword = String.valueOf(passwordField_ReInputNewPassword.getPassword()); 
				int error = checkPassWord(oldPassword, newPassword, reInputPassword); 
				
				if (error == 0) {
					updatePassword(newPassword); 
					JOptionPane.showMessageDialog(null, "Bạn đã đổi mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return; 
				} else if (error == 1) {
					JOptionPane.showMessageDialog(null, "Sai sai mật khẩu cũ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return; 
				} else if (error == 2){
					JOptionPane.showMessageDialog(null, "Mật khẩu mới không hợp lệ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return; 
				}
			}
		});
		button_ChangePassword.setFont(new Font("Arial", Font.BOLD, 20));
		button_ChangePassword.setBounds(175, 315, 170, 40);
		panelMain.add(button_ChangePassword);
		
//		JButton button_SignOut = new JButton("Đăng xuất");
		
//		button_SignOut.setFont(new Font("Arial", Font.BOLD, 20));
//		button_SignOut.setBounds(524, 554, 170, 40);
//		add(button_SignOut);
		
		
	}
	
	
	public int checkPassWord(String oldPassword, String newPassword, String reInputPassword) {  
		int error = 0; 
		
		Connection connection = null; 
		PreparedStatement statement = null; 
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "");
			String checkPassword = "SELECT * FROM User_Password WHERE User = ? AND Password = ?";
			statement = connection.prepareStatement(checkPassword); 
			statement.setString(1, MainPage.getUsername()); 
			statement.setString(2, oldPassword); 
			ResultSet resultSet = statement.executeQuery(); 
			
			if(resultSet.next()) {
				error = 0;
			}else {
				error = 1; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		if (newPassword.length() < 6 || reInputPassword.length() < 6) {
			
			error = 2; 
		}
		if (!(newPassword == reInputPassword)) {
			
			error = 2; 
		}

		return error; 
		
	}
	public void updatePassword(String newPassword) {

		Connection connection = null; 
		PreparedStatement statement = null; 
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "");
			String updateQuery = "UPDATE User_Password SET Password = ? WHERE User = ?";
	        statement = connection.prepareStatement(updateQuery);

	        // Thiết lập tham số cho câu lệnh UPDATE
	        statement.setString(1, newPassword);
	        statement.setString(2, MainPage.getUsername());
	        statement.executeUpdate(); 
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}
	
}
