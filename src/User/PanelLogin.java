package User;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_username;
	private JPasswordField passwordField_password;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		this.setBounds(0, 0, 900, 600);
		setLayout(null);
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0),3));
		panelMain.setBounds(200, 93, 500, 400);
		add(panelMain);
		panelMain.setLayout(null);
		
		JLabel labelUsername = new JLabel("Tên đăng nhập");
		labelUsername.setFont(new Font("Arial", Font.BOLD, 20));
		labelUsername.setBounds(50, 110, 150, 30);
		panelMain.add(labelUsername);
		
		JLabel labelUPassword = new JLabel("Mật khẩu");
		labelUPassword.setFont(new Font("Arial", Font.BOLD, 20));
		labelUPassword.setBounds(50, 210, 150, 30);
		panelMain.add(labelUPassword);
		
		textField_username = new JTextField();
		textField_username.setBounds(45, 140, 400, 40);
		panelMain.add(textField_username);
		textField_username.setColumns(10);
		
		passwordField_password = new JPasswordField();
		passwordField_password.setBounds(45, 240, 400, 40);
		panelMain.add(passwordField_password);
		
		JButton buttonLogin = new JButton("Đăng nhập");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonLogin.setFont(new Font("Arial", Font.BOLD, 20));
		buttonLogin.setBounds(175, 300, 170, 40);
		panelMain.add(buttonLogin);
		
		JButton buttonSignUp = new JButton("Đăng ký");
		buttonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonSignUp.setFont(new Font("Arial", Font.ITALIC, 13));
		buttonSignUp.setBounds(344, 364, 150, 30);
		panelMain.add(buttonSignUp);
		
		JButton buttonSetPasswordAgain = new JButton("Lấy lại mật khẩu");
		buttonSetPasswordAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonSetPasswordAgain.setFont(new Font("Arial", Font.PLAIN, 13));
		buttonSetPasswordAgain.setBounds(6, 364, 150, 30);
		panelMain.add(buttonSetPasswordAgain);
		
		JLabel lblBnL = new JLabel("Bạn là...");
		lblBnL.setFont(new Font("Arial", Font.BOLD, 20));
		lblBnL.setBounds(50, 50, 150, 30);
		panelMain.add(lblBnL);
		
		JComboBox comboBox_typeAccount = new JComboBox();
		comboBox_typeAccount.setBounds(133, 45, 170, 40);
		panelMain.add(comboBox_typeAccount);
	}
}
