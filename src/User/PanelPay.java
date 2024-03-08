package User;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelPay extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldStart;
	private JTextField textFieldEnd;
	private JTextField textFieldTimeStart;
	private JTextField textFieldSeatClass;
	private JTextField textFieldTypeTicket;
	private JTextField textFieldPrice;

	/**
	 * Create the panel.
	 */
	public PanelPay() {
		this.setBounds(0, 0, 600, 500);
		setLayout(null);
		
		JLabel labelFlight = new JLabel("Chuyến bay");
		labelFlight.setFont(new Font("Arial", Font.BOLD, 20));
		labelFlight.setBounds(10, 11, 130, 41);
		add(labelFlight);
		
		JLabel labelStart = new JLabel("Từ");
		labelStart.setFont(new Font("Arial", Font.BOLD, 20));
		labelStart.setBounds(30, 60, 45, 33);
		add(labelStart);
		
		textFieldStart = new JTextField();
		textFieldStart.setBounds(70, 60, 210, 33);
		add(textFieldStart);
		textFieldStart.setColumns(10);
		
		JLabel labelEnd = new JLabel("Đến");
		labelEnd.setFont(new Font("Arial", Font.BOLD, 20));
		labelEnd.setBounds(310, 60, 51, 33);
		add(labelEnd);
		
		textFieldEnd = new JTextField();
		textFieldEnd.setColumns(10);
		textFieldEnd.setBounds(360, 60, 210, 33);
		add(textFieldEnd);
		
		JLabel panelTimeStart = new JLabel("Xuất phát");
		panelTimeStart.setFont(new Font("Arial", Font.BOLD, 20));
		panelTimeStart.setBounds(10, 130, 130, 40);
		add(panelTimeStart);
		
		JLabel labelSeatClass = new JLabel("Hạng ghế");
		labelSeatClass.setFont(new Font("Arial", Font.BOLD, 20));
		labelSeatClass.setBounds(10, 210, 130, 40);
		add(labelSeatClass);
		
		JLabel labelTypeTicket = new JLabel("Loại vé");
		labelTypeTicket.setFont(new Font("Arial", Font.BOLD, 20));
		labelTypeTicket.setBounds(10, 290, 130, 40);
		add(labelTypeTicket);
		
		JLabel labelPrice = new JLabel("Giá");
		labelPrice.setFont(new Font("Arial", Font.BOLD, 20));
		labelPrice.setBounds(295, 360, 51, 40);
		add(labelPrice);
		
		JButton buttonPay = new JButton("Thanh toán");
		buttonPay.setFont(new Font("Arial", Font.BOLD, 20));
		buttonPay.setBounds(29, 441, 152, 35);
		add(buttonPay);
		
		textFieldTimeStart = new JTextField();
		textFieldTimeStart.setColumns(10);
		textFieldTimeStart.setBounds(120, 130, 210, 33);
		add(textFieldTimeStart);
		
		textFieldSeatClass = new JTextField();
		textFieldSeatClass.setColumns(10);
		textFieldSeatClass.setBounds(120, 210, 210, 33);
		add(textFieldSeatClass);
		
		textFieldTypeTicket = new JTextField();
		textFieldTypeTicket.setColumns(10);
		textFieldTypeTicket.setBounds(120, 290, 210, 33);
		add(textFieldTypeTicket);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(344, 360, 167, 33);
		add(textFieldPrice);

	}
}
