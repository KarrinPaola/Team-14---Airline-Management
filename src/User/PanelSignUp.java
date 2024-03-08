package User;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelSignUp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public PanelSignUp() {
		this.setBounds(0, 0, 900, 600);
		setLayout(null);
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(null);
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0),3));
		panelMain.setBounds(200, 93, 500, 400);
		add(panelMain);
		
		JLabel labelUsername = new JLabel("Tên đăng nhập");
		labelUsername.setFont(new Font("Arial", Font.BOLD, 20));
		labelUsername.setBounds(50, 110, 150, 30);
		panelMain.add(labelUsername);
		
		JLabel labelUPassword = new JLabel("Mật khẩu");
		labelUPassword.setFont(new Font("Arial", Font.BOLD, 20));
		labelUPassword.setBounds(50, 210, 150, 30);
		panelMain.add(labelUPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(45, 140, 400, 40);
		panelMain.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(45, 240, 400, 40);
		panelMain.add(passwordField);
		
		JButton buttonLogin = new JButton("Đăng nhập");
		buttonLogin.setFont(new Font("Arial", Font.BOLD, 20));
		buttonLogin.setBounds(175, 300, 170, 40);
		panelMain.add(buttonLogin);
		
		JButton buttonSignUp = new JButton("Đăng ký");
		buttonSignUp.setFont(new Font("Arial", Font.ITALIC, 13));
		buttonSignUp.setBounds(344, 364, 150, 30);
		panelMain.add(buttonSignUp);
		
		JButton buttonSetPasswordAgain = new JButton("Lấy lại mật khẩu");
		buttonSetPasswordAgain.setFont(new Font("Arial", Font.PLAIN, 13));
		buttonSetPasswordAgain.setBounds(6, 364, 150, 30);
		panelMain.add(buttonSetPasswordAgain);
	}
}
