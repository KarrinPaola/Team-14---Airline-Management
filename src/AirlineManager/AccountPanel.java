package AirlineManager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AccountPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AccountPanel() {
		setLayout(null);
		JButton ChangeButton = new JButton("Đổi mật khẩu");
		ChangeButton.setForeground(new Color(0, 0, 0));
		ChangeButton.setBackground(new Color(240, 240, 240));
		ChangeButton.setBounds(227, 182, 149, 33);
		ChangeButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        add(ChangeButton);
        
        JButton LogOutButton = new JButton("Đăng xuất");
        LogOutButton.setForeground(new Color(0, 0, 0));
        LogOutButton.setBackground(new Color(240, 240, 240));
        LogOutButton.setBounds(227, 264, 149, 33);
        LogOutButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        add(LogOutButton);
	}

}
