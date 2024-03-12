package User;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		button_ChangePassword.setFont(new Font("Arial", Font.BOLD, 20));
		button_ChangePassword.setBounds(175, 315, 170, 40);
		panelMain.add(button_ChangePassword);
		
		JButton button_SignOut = new JButton("Đăng xuất");
		button_SignOut.setFont(new Font("Arial", Font.BOLD, 20));
		button_SignOut.setBounds(524, 554, 170, 40);
		add(button_SignOut);

	}
}
