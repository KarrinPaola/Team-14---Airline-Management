package User;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class fillInformationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public fillInformationPanel() {
		this.setBounds(0, 0, 700, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 350, 600);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 128, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 119, 50, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tháng");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(148, 119, 50, 36);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Năm");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(80, 178, 50, 36);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(10, 252, 128, 30);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(10, 442, 128, 30);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("New label");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_4.setBounds(10, 345, 128, 30);
		panel.add(lblNewLabel_2_4);
		
		textField = new JTextField();
		textField.setBounds(10, 40, 330, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(58, 120, 80, 36);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(208, 120, 80, 36);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 179, 80, 36);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(350, 0, 350, 600);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_5 = new JLabel("New label");
		lblNewLabel_2_5.setBounds(130, 7, 90, 24);
		lblNewLabel_2_5.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("New label");
		lblNewLabel_2_4_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_4_1.setBounds(65, 146, 128, 36);
		panel_1.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("New label");
		lblNewLabel_2_4_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_4_2.setBounds(65, 210, 128, 36);
		panel_1.add(lblNewLabel_2_4_2);
		
		JLabel lblNewLabel_2_4_3 = new JLabel("New label");
		lblNewLabel_2_4_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_4_3.setBounds(75, 257, 128, 36);
		panel_1.add(lblNewLabel_2_4_3);
		
		JLabel lblNewLabel_2_4_4 = new JLabel("New label");
		lblNewLabel_2_4_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_4_4.setBounds(37, 304, 128, 36);
		panel_1.add(lblNewLabel_2_4_4);
		
		JLabel lblNewLabel_2_4_5 = new JLabel("New label");
		lblNewLabel_2_4_5.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_4_5.setBounds(65, 365, 128, 36);
		panel_1.add(lblNewLabel_2_4_5);

	}
}
