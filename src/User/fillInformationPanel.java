package User;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fillInformationPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldName;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldEmail;
    private JTextField textFieldCMND;
    private Passenger passenger; 

    /**
     * Create the panel.
     */
    public fillInformationPanel() {
        this.setBounds(0, 0, 700, 600);
        setLayout(null);
        
        // Panel chứa thông tin cá nhân
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.setBounds(0, 0, 350, 600);
        add(panel);
        panel.setLayout(null);
        
        // Labels cho các trường thông tin cá nhân
        JLabel labelName = new JLabel("Họ và tên");
        labelName.setFont(new Font("Arial", Font.BOLD, 20));
        labelName.setBounds(10, 10, 128, 30);
        panel.add(labelName);
        
        // Labels và ComboBox cho ngày, tháng, năm sinh
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
        
        // Labels cho các trường thông tin cá nhân tiếp theo
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
        
        // TextFields cho các trường thông tin cá nhân
        textFieldName = new JTextField();
        textFieldName.setBounds(10, 40, 330, 40);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        // ComboBox cho ngày, tháng, năm sinh
        JComboBox<String> comboBoxDay = new JComboBox<String>();
        comboBoxDay.setBounds(45, 124, 60, 29);
        panel.add(comboBoxDay);
        for (int i = 1; i <= 31; i++) {
            comboBoxDay.addItem(String.valueOf(i));
        }

        JComboBox<String> comboBoxMonth = new JComboBox<String>();
        comboBoxMonth.setBounds(155, 124, 60, 29);
        panel.add(comboBoxMonth);
        for (int i = 1; i <= 12; i++) {
            comboBoxMonth.addItem(String.valueOf(i));
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
        
        // Panel chứa thông tin vé và hạng ghế
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel_1.setBounds(350, 0, 350, 600);
        add(panel_1);
        panel_1.setLayout(null);
        
        // Labels cho hạng ghế và loại vé
        JLabel labelSeatClass = new JLabel("Hạng ghế");
        labelSeatClass.setFont(new Font("Arial", Font.BOLD, 20));
        labelSeatClass.setBounds(10, 15, 128, 30);
        panel_1.add(labelSeatClass);
        
        JLabel labelTicketType = new JLabel("Loại vé");
        labelTicketType.setFont(new Font("Arial", Font.BOLD, 20));
        labelTicketType.setBounds(10, 125, 128, 30);
        panel_1.add(labelTicketType);
        
        // CheckBoxes cho hạng ghế và loại vé
        JCheckBox checkBoxNormal = new JCheckBox("Thường");
        checkBoxNormal.setFont(new Font("Arial", Font.BOLD, 20));
        checkBoxNormal.setBounds(10, 50, 132, 36);
        panel_1.add(checkBoxNormal);
        
        JCheckBox checkBoxMerchant = new JCheckBox("Thương gia");
        checkBoxMerchant.setFont(new Font("Arial", Font.BOLD, 20));
        checkBoxMerchant.setBounds(160, 50, 180, 36);
        panel_1.add(checkBoxMerchant);
        
        JCheckBox checkBoxOneWay = new JCheckBox("Một chiều");
        checkBoxOneWay.setFont(new Font("Arial", Font.BOLD, 20));
        checkBoxOneWay.setBounds(10, 162, 128, 36);
        panel_1.add(checkBoxOneWay);
        
        JCheckBox checkBoxRoundTrip = new JCheckBox("Khứ hồi");
        checkBoxRoundTrip.setFont(new Font("Arial", Font.BOLD, 20));
        checkBoxRoundTrip.setBounds(160, 162, 137, 36);
        panel_1.add(checkBoxRoundTrip);
        
        // Xác nhận thông
        // Button "Xác nhận"
        JButton buttonConfirm = new JButton("Xác nhận");
        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra xem các trường thông tin đã được điền đầy đủ chưa
                if (textFieldName.getText().isEmpty() || textFieldPhoneNumber.getText().isEmpty() ||
                        textFieldEmail.getText().isEmpty() || textFieldCMND.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                // Lấy giá trị từ các trường thông tin cá nhân
                String fullName = textFieldName.getText(); 
                Date birthDate; 
                // Lấy ngày sinh của hành khách từ các ComboBox
                try {
                    birthDate = convertToDate(
                            comboBoxDay.getSelectedItem().toString(),
                            comboBoxMonth.getSelectedItem().toString(), 
                            comboBoxYear.getSelectedItem().toString()
                    );
                } catch (ParseException e1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày tháng năm sinh hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                } 
                // Kiểm tra định dạng số điện thoại
                String phoneNumber = textFieldPhoneNumber.getText();
                if (!phoneNumber.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(null, "Số điện thoại phải gồm 10 số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Kiểm tra định dạng email
                String email = textFieldEmail.getText();
                if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com")) {
                    JOptionPane.showMessageDialog(null, "Email phải có định dạng ...@gmail.com!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Kiểm tra định dạng CMND
                String cmnd = textFieldCMND.getText();
                if (!cmnd.matches("\\d{12}")) {
                    JOptionPane.showMessageDialog(null, "CMND phải gồm 12 số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Lấy giá trị của hạng ghế
                String classSeat = null; 
                if(checkBoxNormal.isSelected() || checkBoxMerchant.isSelected()) {
                    if (checkBoxMerchant.isSelected()) {
                        classSeat = checkBoxMerchant.getText(); 
                    } else {
                        classSeat = checkBoxNormal.getText(); 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn hạng ghế!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return; 
                }
                // Lấy giá trị của loại vé 
                String typeTicket; 
                if (checkBoxOneWay.isSelected() || checkBoxRoundTrip.isSelected()) {
                    if(checkBoxOneWay.isSelected()) {
                        typeTicket = checkBoxOneWay.getText(); 
                    } else {
                        typeTicket = checkBoxRoundTrip.getText(); 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại vé!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                // Tạo đối tượng Passenger từ các thông tin đã nhập
                passenger = new Passenger(classSeat, typeTicket, fullName, birthDate, phoneNumber, email, cmnd); 
                // Chuyển panel hiện tại sang panel thanh toán và hiển thị thông tin hành khách
                MainPage.panelPay.setPassenger(passenger);
                setVisible(false);
                MainPage.panelPay.setVisible(true);
                MainPage.panelPay.setTextField();
            }
        });
        buttonConfirm.setFont(new Font("Arial", Font.BOLD, 20));
        buttonConfirm.setBounds(100, 250, 150, 41);
        panel_1.add(buttonConfirm);

    }
    
    // Phương thức chuyển đổi String thành java.sql.Date
    public static java.sql.Date convertToDate(String year, String month, String day) throws ParseException {
        String dateString = year + "-" + month + "-" + day;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = dateFormat.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }
}

