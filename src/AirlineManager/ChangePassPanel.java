package AirlineManager;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public ChangePassPanel() {
		setLayout(null);
		JLabel NameLabel = new JLabel("Đổi mật khẩu");
		NameLabel.setBounds(199, 46, 229, 39);
		NameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		add(NameLabel);
		
		JLabel OldPassLabel = new JLabel("Mật khẩu cũ:");
		OldPassLabel.setBounds(143, 114, 96, 20);
		OldPassLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(OldPassLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grandea", Font.PLAIN, 15));
		textField_1.setBounds(143, 144, 205, 30);
		add(textField_1);
		
		JLabel NewPassLabel = new JLabel("Mật khẩu mới:");
		NewPassLabel.setBounds(145, 194, 106, 20);
		NewPassLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(NewPassLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 215, 205, 30);
		add(textField_2);
		
		JLabel CheckPassLabel = new JLabel("Xác nhận mật khẩu mới:");
		CheckPassLabel.setBounds(143, 271, 180, 20);
		CheckPassLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(CheckPassLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(143, 296, 205, 30);
		add(textField_3);
		
		JButton ChangeButton = new JButton("Đổi mật khẩu");
		ChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ChangeButton.setForeground(Color.BLACK);
		ChangeButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		ChangeButton.setBackground(UIManager.getColor("Button.background"));
		ChangeButton.setBounds(169, 376, 149, 33);
		add(ChangeButton);
		
		JButton LogOutButton = new JButton("Hủy");
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LogOutButton.setForeground(Color.BLACK);
		LogOutButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		LogOutButton.setBackground(UIManager.getColor("Button.background"));
		LogOutButton.setBounds(347, 376, 149, 33);
		add(LogOutButton);
	}
}
