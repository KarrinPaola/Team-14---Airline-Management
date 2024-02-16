package AirlineManager;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class SignUp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp frame = new SignUp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SignUp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel nameLabel = new JLabel("Họ và tên:");
        nameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JTextField nameField = new JTextField(30);

        JLabel dayLabel = new JLabel("Ngày:");
        dayLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        String[] days = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        dayComboBox.setMaximumRowCount(5);

        JLabel monthLabel = new JLabel("Tháng:");
        monthLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        String[] months = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setMaximumRowCount(5);

        JLabel yearLabel = new JLabel("Năm:");
        yearLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        String[] years = {"", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930"};
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        yearComboBox.setMaximumRowCount(5);

        JLabel idLabel = new JLabel("CMND/CCCD:");
        idLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JTextField TextField_ID_SignUp = new JTextField(30);
        TextField_ID_SignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

        JLabel phoneNumberLabel = new JLabel("Số điện thoại:");
        phoneNumberLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JTextField TextField_PhoneNumber = new JTextField(30);
        TextField_PhoneNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

        JLabel genderLabel = new JLabel("Giới tính:");
        genderLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton maleButton = new JRadioButton("Nam");
        maleButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JRadioButton femaleButton = new JRadioButton("Nữ");
        femaleButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel nationalityLabel = new JLabel("Dân tộc:");
        nationalityLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        String[] nationalities = {"Vietnamese", "Other"};
        JComboBox<String> nationalityComboBox = new JComboBox<>(nationalities);
        nationalityComboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

        JLabel addressLabel = new JLabel("Địa chỉ:");
        addressLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JTextField textField_Address = new JTextField(30);
        textField_Address.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

        JLabel usernameLabel = new JLabel("Tài khoản:");
        usernameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JTextField textField_username = new JTextField(30);

        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JPasswordField passwordField = new JPasswordField(30);

        JLabel RePasswordLabel = new JLabel("Nhập lại mật khẩu:");
        RePasswordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        JPasswordField RePasswordField = new JPasswordField(30);

        JButton registerButton =  new JButton("Đăng ký");
        registerButton.setFont(new Font("Lucida Grande", Font.BOLD, 17));

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Registration logic here
                String name = nameField.getText();
                String day = (String) dayComboBox.getSelectedItem();
                String month = (String) monthComboBox.getSelectedItem();
                String year = (String) yearComboBox.getSelectedItem();
                String dob = day + " " + month + " " + year;
                String gender = maleButton.isSelected() ? "Nam" : "Nữ";
                String nationality = (String) nationalityComboBox.getSelectedItem();
                String address = textField_Address.getText();
                String username = textField_username.getText();
                String password = new String(passwordField.getPassword());
                String rePassword = new String(RePasswordField.getPassword());
                String idNumber = TextField_ID_SignUp.getText(); // Chứng minh nhân dân
                String phoneNumber = TextField_PhoneNumber.getText(); // Số điện thoại
                
                // Process registration data
            }
        });

        nameLabel.setBounds(55, 10, 80, 25);
        nameField.setBounds(50, 35, 320, 30);
        dayLabel.setBounds(55, 85, 45, 25);
        dayComboBox.setBounds(100, 82, 45, 30);
        monthLabel.setBounds(150, 85, 55, 25);
        monthComboBox.setBounds(205, 82, 45, 30);
        yearLabel.setBounds(255, 85, 40, 25);
        yearComboBox.setBounds(295, 82, 75, 30);
        idLabel.setBounds(57, 130, 108, 25);
        TextField_ID_SignUp.setBounds(50, 155, 315, 30);
        phoneNumberLabel.setBounds(55, 205, 108, 25);
        TextField_PhoneNumber.setBounds(50, 230, 315, 30);
        addressLabel.setBounds(55, 280, 79, 25);
        textField_Address.setBounds(50, 305, 315, 30);
        nationalityLabel.setBounds(55, 355, 70, 25);
        nationalityComboBox.setBounds(129, 352, 200, 30);
        genderLabel.setBounds(55, 400, 79, 25);
        maleButton.setBounds(142, 398, 80, 30);
        femaleButton.setBounds(227, 398, 80, 30);
        usernameLabel.setBounds(485, 85, 110, 30);
        textField_username.setBounds(480, 115, 300, 30);
        passwordLabel.setBounds(485, 165, 110, 25);
        passwordField.setBounds(480, 190, 300, 30);
        RePasswordLabel.setBounds(485, 240, 170, 30);
        RePasswordField.setBounds(480, 270, 300, 30);
        registerButton.setBounds(565, 335, 120, 35);

        contentPane.add(nameLabel);
        contentPane.add(nameField);
        contentPane.add(dayLabel);
        contentPane.add(dayComboBox);
        contentPane.add(monthLabel);
        contentPane.add(monthComboBox);
        contentPane.add(yearLabel);
        contentPane.add(yearComboBox);
        contentPane.add(idLabel);
        contentPane.add(TextField_ID_SignUp);
        contentPane.add(phoneNumberLabel);
        contentPane.add(TextField_PhoneNumber);
        contentPane.add(addressLabel);
        contentPane.add(textField_Address);
        contentPane.add(nationalityLabel);
        contentPane.add(nationalityComboBox);
        contentPane.add(genderLabel);
        contentPane.add(maleButton);
        contentPane.add(femaleButton);
        contentPane.add(usernameLabel);
        contentPane.add(textField_username);
        contentPane.add(passwordLabel);
        contentPane.add(passwordField);
        contentPane.add(RePasswordLabel);
        contentPane.add(RePasswordField);
        contentPane.add(registerButton);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.setBounds(416, 0, 1, 462);
        contentPane.add(panel);
        panel.setLayout(null);
    }
}
