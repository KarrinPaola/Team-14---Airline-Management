package User;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class fillInformationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldName;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldEmail;
	private JTextField textFieldCMND;

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
		
		JLabel labelName = new JLabel("Họ và tên");
		labelName.setFont(new Font("Arial", Font.BOLD, 20));
		labelName.setBounds(10, 10, 128, 30);
		panel.add(labelName);
		
		JLabel labelDay = new JLabel("Ngày");
		labelDay.setFont(new Font("Arial", Font.BOLD, 15));
		labelDay.setBounds(10, 120, 43, 35);
		panel.add(labelDay);
		
		JLabel labelMonth = new JLabel("Tháng");
		labelMonth.setFont(new Font("Arial", Font.BOLD, 15));
		labelMonth.setBounds(110, 120, 50, 35);
		panel.add(labelMonth);
		
		JLabel labelYear = new JLabel("Năm");
		labelYear.setFont(new Font("Arial", Font.BOLD, 15));
		labelYear.setBounds(220, 120, 50, 35);
		panel.add(labelYear);
		
		JLabel labelPhoneNumber = new JLabel("Số điện thoại");
		labelPhoneNumber.setFont(new Font("Arial", Font.BOLD, 20));
		labelPhoneNumber.setBounds(10, 195, 128, 30);
		panel.add(labelPhoneNumber);
		
		JLabel labelCMND = new JLabel("CMND/CCCD");
		labelCMND.setFont(new Font("Arial", Font.BOLD, 20));
		labelCMND.setBounds(10, 415, 128, 30);
		panel.add(labelCMND);
		
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setFont(new Font("Arial", Font.BOLD, 20));
		labelEmail.setBounds(10, 305, 128, 30);
		panel.add(labelEmail);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(10, 40, 330, 40);
		panel.add(textFieldName);
		textFieldName.setColumns(10);

		JComboBox<String> comboBoxDay = new JComboBox<String>();
		comboBoxDay.setBounds(45, 124, 60, 29);
		panel.add(comboBoxDay);
		for (int i = 1; i <= 31; i++) {
		    comboBoxDay.addItem(String.valueOf(i));
		}

		JComboBox<String> comboBoxMonth = new JComboBox<String>();
		comboBoxMonth.setBounds(155, 124, 60, 29);
		panel.add(comboBoxMonth);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for (String month : months) {
		    comboBoxMonth.addItem(month);
		}

		JComboBox<String> comboBoxYear = new JComboBox<String>();
		comboBoxYear.setToolTipText("");
		comboBoxYear.setBounds(252, 124, 90, 29);
		panel.add(comboBoxYear);
		int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		for (int i = 1900; i <= currentYear; i++) {
		    comboBoxYear.addItem(String.valueOf(i));
		}

		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setBounds(10, 225, 330, 40);
		panel.add(textFieldPhoneNumber);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(10, 335, 330, 40);
		panel.add(textFieldEmail);
		
		textFieldCMND = new JTextField();
		textFieldCMND.setColumns(10);
		textFieldCMND.setBounds(10, 445, 330, 40);
		panel.add(textFieldCMND);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(350, 0, 350, 600);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelSeatClass = new JLabel("Hạng ghế");
		labelSeatClass.setFont(new Font("Arial", Font.BOLD, 20));
		labelSeatClass.setBounds(10, 15, 128, 30);
		panel_1.add(labelSeatClass);
		
		JCheckBox checkBoxNormal = new JCheckBox("Thường");
		checkBoxNormal.setFont(new Font("Arial", Font.BOLD, 20));
		checkBoxNormal.setBounds(10, 50, 132, 36);
		panel_1.add(checkBoxNormal);
		
		JCheckBox checkBoxMerchant = new JCheckBox("Thương gia");
		checkBoxMerchant.setFont(new Font("Arial", Font.BOLD, 20));
		checkBoxMerchant.setBounds(160, 50, 180, 36);
		panel_1.add(checkBoxMerchant);
		
		checkBoxNormal.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            checkBoxMerchant.setEnabled(false);
		        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
		            checkBoxMerchant.setEnabled(true);
		        }
		    }
		});

		checkBoxMerchant.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            checkBoxNormal.setEnabled(false);
		        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
		            checkBoxNormal.setEnabled(true);
		        }
		    }
		});

		
		JLabel labelTicketType = new JLabel("Loại vé");
		labelTicketType.setFont(new Font("Arial", Font.BOLD, 20));
		labelTicketType.setBounds(10, 125, 128, 30);
		panel_1.add(labelTicketType);
		
		JCheckBox checkBoxOneWay = new JCheckBox("Một chiều");
		checkBoxOneWay.setFont(new Font("Arial", Font.BOLD, 20));
		checkBoxOneWay.setBounds(10, 162, 128, 36);
		panel_1.add(checkBoxOneWay);
		
		JCheckBox checkBoxRoundTrip = new JCheckBox("Khứ hồi");
		checkBoxRoundTrip.setFont(new Font("Arial", Font.BOLD, 20));
		checkBoxRoundTrip.setBounds(160, 162, 137, 36);
		panel_1.add(checkBoxRoundTrip);
		
		checkBoxOneWay.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            checkBoxRoundTrip.setEnabled(false);
		        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
		            checkBoxRoundTrip.setEnabled(true);
		        }
		    }
		});

		checkBoxRoundTrip.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            checkBoxOneWay.setEnabled(false);
		        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
		            checkBoxOneWay.setEnabled(true);
		        }
		    }
		});

		
		JButton buttonConfirm = new JButton("Xác nhận");
		buttonConfirm.setFont(new Font("Arial", Font.BOLD, 20));
		buttonConfirm.setBounds(100, 250, 150, 41);
		panel_1.add(buttonConfirm);

	}
}
