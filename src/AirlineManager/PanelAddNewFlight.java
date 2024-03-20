package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAddNewFlight extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelAddNewFlight() {
		this.setBounds(0, 0, 700,600 );
		setLayout(null);
		
		JLabel lebelAddNewFlight = new JLabel("Thêm chuyến bay mới");
		lebelAddNewFlight.setFont(new Font("Arial", Font.BOLD, 30));
		lebelAddNewFlight.setBounds(190, 30, 320, 36);
		add(lebelAddNewFlight);
		
		JLabel labelSelectPointStarting = new JLabel("Chọn điểm khởi đầu");
		labelSelectPointStarting.setFont(new Font("Arial", Font.BOLD, 22));
		labelSelectPointStarting.setBounds(10, 90, 290, 50);
		add(labelSelectPointStarting);
		
		JLabel labelSelectPointEnding = new JLabel("Chọn điểm đến");
		labelSelectPointEnding.setFont(new Font("Arial", Font.BOLD, 22));
		labelSelectPointEnding.setBounds(10, 170, 290, 50);
		add(labelSelectPointEnding);
		
		JLabel labelSelectDayDeparture = new JLabel("Chọn ngày khởi hành");
		labelSelectDayDeparture.setFont(new Font("Arial", Font.BOLD, 22));
		labelSelectDayDeparture.setBounds(10, 250, 290, 50);
		add(labelSelectDayDeparture);
		
		JLabel labelDay = new JLabel("Ngày");
		labelDay.setFont(new Font("Arial", Font.BOLD, 22));
		labelDay.setBounds(10, 330, 70, 50);
		add(labelDay);
		
		JLabel labelMaxPassenger = new JLabel("Nhập số hành khách tối đa");
		labelMaxPassenger.setFont(new Font("Arial", Font.BOLD, 22));
		labelMaxPassenger.setBounds(10, 421, 293, 44);
		add(labelMaxPassenger);
		
		JLabel labelMonth = new JLabel("Tháng");
		labelMonth.setFont(new Font("Arial", Font.BOLD, 22));
		labelMonth.setBounds(230, 330, 70, 50);
		add(labelMonth);
		
		JLabel labelYear = new JLabel("Năm");
		labelYear.setFont(new Font("Arial", Font.BOLD, 22));
		labelYear.setBounds(460, 332, 70, 44);
		add(labelYear);
		
		JComboBox comboBoxSelectPointStarting = new JComboBox();
		comboBoxSelectPointStarting.setBounds(275, 91, 200, 42);
		add(comboBoxSelectPointStarting);
		
		JComboBox comboBoxSelectPointEnding = new JComboBox();
		comboBoxSelectPointEnding.setBounds(275, 172, 200, 44);
		add(comboBoxSelectPointEnding);
		
		JComboBox comboBoxDay = new JComboBox();
		comboBoxDay.setBounds(80, 335, 135, 40);
		add(comboBoxDay);
		
		JButton buttonAddNewFlight = new JButton("Thêm chuyến");
		buttonAddNewFlight.setFont(new Font("Arial", Font.BOLD, 20));
		buttonAddNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAddNewFlight.setBounds(503, 529, 165, 36);
		add(buttonAddNewFlight);
		
		JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setBounds(315, 335, 135, 40);
		add(comboBoxMonth);
		
		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setBounds(525, 335, 135, 40);
		add(comboBoxYear);
		
		JComboBox comboBoxMaxPassenger = new JComboBox();
		comboBoxMaxPassenger.setBounds(313, 421, 135, 40);
		add(comboBoxMaxPassenger);

	}
}
