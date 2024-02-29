package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PaymentPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PaymentPanel() {
		setLayout(null);
		
		JLabel flightLabel = new JLabel("Chặng bay:");
		flightLabel.setBounds(94, 37, 100, 19);
		flightLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(flightLabel);
		
		textField = new JTextField();
		textField.setBounds(307, 66, 137, 24);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 66, 137, 24);
		add(textField_1);
		
		JLabel TimeLabel = new JLabel("Thời gian khởi hành:");
		TimeLabel.setBounds(94, 105, 193, 19);
		TimeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(TimeLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 134, 193, 24);
		add(textField_2);
		
		JLabel classLabel = new JLabel("Hạng vé:");
		classLabel.setBounds(94, 170, 79, 19);
		classLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(classLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 194, 137, 24);
		add(textField_3);
		
		JLabel TypeLabel = new JLabel("Loại vé:");
		TypeLabel.setBounds(94, 228, 193, 19);
		TypeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(TypeLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(94, 257, 137, 24);
		add(textField_4);
		
		JLabel CodeLabel = new JLabel("Mã chuyến bay:");
		CodeLabel.setBounds(274, 209, 193, 19);
		CodeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(CodeLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(274, 230, 170, 19);
		add(textField_5);
		
		JLabel TotalLabel = new JLabel("Tổng tiền:");
		TotalLabel.setBounds(274, 311, 193, 19);
		TotalLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(TotalLabel);
		
		textField_6 = new JTextField();
		textField_6.setBounds(359, 331, 170, 26);
		add(textField_6);
		
        JButton registerButton = new JButton("Thanh toán");
        registerButton.setForeground(new Color(0, 0, 0));
        registerButton.setBackground(new Color(240, 240, 240));
        registerButton.setBounds(65, 370, 170, 47);
        registerButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        add(registerButton);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_3.setForeground(new Color(0, 0, 0));
        panel_3.setBounds(49, 10, 491, 1);
        add(panel_3);
        panel_3.setLayout(null);
        
        JPanel panel_3_1 = new JPanel();
        panel_3_1.setLayout(null);
        panel_3_1.setForeground(Color.BLACK);
        panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_3_1.setBounds(49, 10, 1, 426);
        add(panel_3_1);
        
        JPanel panel_3_2 = new JPanel();
        panel_3_2.setLayout(null);
        panel_3_2.setForeground(Color.BLACK);
        panel_3_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_3_2.setBounds(49, 435, 491, 1);
        add(panel_3_2);
        
        JPanel panel_3_3 = new JPanel();
        panel_3_3.setLayout(null);
        panel_3_3.setForeground(Color.BLACK);
        panel_3_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_3_3.setBounds(539, 10, 1, 426);
        add(panel_3_3);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(229, 77, 79, 1);
        add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(249, 329, 291, 1);
        add(panel_1);

	}
}
