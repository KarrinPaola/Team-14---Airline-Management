package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAccount extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldPointStarting;
	private JTextField textFieldPointEnding;
	private JTextField textFieldDayDeparture;
	private JTextField textFieldPassengerNumber;
	private JTextField textFieldPriceTicket;

	/**
	 * Create the panel.
	 */
	public PanelAccount() {
		this.setBounds(0, 0, 700, 600);
		setLayout(null);
		
		JLabel labelConfirm = new JLabel("Xác nhận thêm chuyến");
		labelConfirm.setFont(new Font("Arial", Font.BOLD, 30));
		labelConfirm.setBounds(157, 29, 402, 47);
		add(labelConfirm);
		
		JLabel labelPointStarting = new JLabel("Điểm bắt đầu");
		labelPointStarting.setFont(new Font("Arial", Font.BOLD, 20));
		labelPointStarting.setBounds(10, 103, 220, 40);
		add(labelPointStarting);
		
		JLabel labelPointEnding = new JLabel("Điểm đến");
		labelPointEnding.setFont(new Font("Arial", Font.BOLD, 20));
		labelPointEnding.setBounds(10, 183, 220, 40);
		add(labelPointEnding);
		
		JLabel lebelDayDeparture = new JLabel("Ngày khởi hành");
		lebelDayDeparture.setFont(new Font("Arial", Font.BOLD, 20));
		lebelDayDeparture.setBounds(10, 263, 220, 40);
		add(lebelDayDeparture);
		
		JLabel labelPassengerNumber = new JLabel("Số hành khách");
		labelPassengerNumber.setFont(new Font("Arial", Font.BOLD, 20));
		labelPassengerNumber.setBounds(10, 343, 220, 40);
		add(labelPassengerNumber);
		
		JLabel labelPriceTicket = new JLabel("Giá vé");
		labelPriceTicket.setFont(new Font("Arial", Font.BOLD, 20));
		labelPriceTicket.setBounds(10, 423, 220, 40);
		add(labelPriceTicket);
		
		textFieldPointStarting = new JTextField();
		textFieldPointStarting.setBounds(207, 103, 184, 40);
		add(textFieldPointStarting);
		textFieldPointStarting.setColumns(10);
		
		textFieldPointEnding = new JTextField();
		textFieldPointEnding.setColumns(10);
		textFieldPointEnding.setBounds(207, 183, 184, 40);
		add(textFieldPointEnding);
		
		textFieldDayDeparture = new JTextField();
		textFieldDayDeparture.setColumns(10);
		textFieldDayDeparture.setBounds(207, 263, 184, 40);
		add(textFieldDayDeparture);
		
		textFieldPassengerNumber = new JTextField();
		textFieldPassengerNumber.setColumns(10);
		textFieldPassengerNumber.setBounds(207, 343, 184, 40);
		add(textFieldPassengerNumber);
		
		textFieldPriceTicket = new JTextField();
		textFieldPriceTicket.setColumns(10);
		textFieldPriceTicket.setBounds(207, 423, 184, 40);
		add(textFieldPriceTicket);
		
		JButton buttonConfirm = new JButton("Xác nhận");
		buttonConfirm.setFont(new Font("Arial", Font.BOLD, 20));
		buttonConfirm.setBounds(493, 531, 144, 40);
		add(buttonConfirm);

	}

}
