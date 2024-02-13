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
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        JTextField nameField = new JTextField(30);

        JLabel dayLabel = new JLabel("Ngày:");
        dayLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        String[] days = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> dayBox = new JComboBox<>(days);
        dayBox.setMaximumRowCount(5);

        JLabel monthLabel = new JLabel("Tháng:");
        monthLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        String[] months = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setMaximumRowCount(5);

        JLabel yearLabel = new JLabel("Năm:");
        yearLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        String[] years = {"", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930"};
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setMaximumRowCount(5);

        JLabel idLabel = new JLabel("CMND/CCCD:");
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        JTextField idField = new JTextField(30);
        idField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel idPhoneLabel = new JLabel("Số điện thoại:");
        idPhoneLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        JTextField idPhoneField = new JTextField(30);
        idPhoneField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel genderLabel = new JLabel("Giới tính:");
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton maleButton = new JRadioButton("Nam");
        maleButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        JRadioButton femaleButton = new JRadioButton("Nữ");
        femaleButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel nationalityLabel = new JLabel("Dân tộc:");
        nationalityLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        String[] nationalities = {"Vietnamese", "Other"};
        JComboBox<String> nationalityBox = new JComboBox<>(nationalities);
        nationalityBox.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel addressLabel = new JLabel("Địa chỉ:");
        addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        JTextField addressField = new JTextField(30);
        addressField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel usernameLabel = new JLabel("Tài khoản:");
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        JTextField usernameField = new JTextField(30);

        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        JPasswordField passwordField = new JPasswordField(30);

        JLabel RePasswordLabel = new JLabel("Nhập lại mật khẩu:");
        RePasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        JPasswordField RePasswordField = new JPasswordField(30);

        JButton registerButton =  new JButton("Đăng ký");
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 17));

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Registration logic here
                String name = nameField.getText();
                String day = (String) dayBox.getSelectedItem();
                String month = (String) monthBox.getSelectedItem();
                String year = (String) yearBox.getSelectedItem();
                String dob = day + " " + month + " " + year;
                String gender = maleButton.isSelected() ? "Nam" : "Nữ";
                String nationality = (String) nationalityBox.getSelectedItem();
                String address = addressField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String rePassword = new String(RePasswordField.getPassword());
                String idNumber = idField.getText(); // Chứng minh nhân dân
                String phoneNumber = idPhoneField.getText(); // Số điện thoại
                
                // Process registration data
            }
        });

        nameLabel.setBounds(57, 38, 79, 25);
        nameField.setBounds(146, 38, 200, 30);
        dayLabel.setBounds(57, 87, 53, 25);
        dayBox.setBounds(104, 86, 42, 30);
        monthLabel.setBounds(165, 87, 53, 25);
        monthBox.setBounds(223, 87, 42, 30);
        yearLabel.setBounds(278, 87, 42, 25);
        yearBox.setBounds(323, 86, 55, 30);
        idLabel.setBounds(57, 140, 108, 25);
        idField.setBounds(165, 138, 200, 30);
        idPhoneLabel.setBounds(57, 180, 108, 25);
        idPhoneField.setBounds(165, 178, 200, 30);
        addressLabel.setBounds(57, 227, 79, 25);
        addressField.setBounds(120, 225, 200, 30);
        nationalityLabel.setBounds(57, 279, 70, 25);
        nationalityBox.setBounds(120, 276, 200, 30);
        genderLabel.setBounds(57, 328, 62, 25);
        maleButton.setBounds(147, 328, 80, 30);
        femaleButton.setBounds(223, 328, 80, 30);
        usernameLabel.setBounds(483, 84, 80, 30);
        usernameField.setBounds(483, 124, 200, 30);
        passwordLabel.setBounds(483, 164, 150, 25);
        passwordField.setBounds(483, 199, 200, 30);
        RePasswordLabel.setBounds(483, 232, 156, 30);
        RePasswordField.setBounds(483, 262, 200, 30);
        registerButton.setBounds(585, 322, 120, 35);

        contentPane.add(nameLabel);
        contentPane.add(nameField);
        contentPane.add(dayLabel);
        contentPane.add(dayBox);
        contentPane.add(monthLabel);
        contentPane.add(monthBox);
        contentPane.add(yearLabel);
        contentPane.add(yearBox);
        contentPane.add(idLabel);
        contentPane.add(idField);
        contentPane.add(idPhoneLabel);
        contentPane.add(idPhoneField);
        contentPane.add(addressLabel);
        contentPane.add(addressField);
        contentPane.add(nationalityLabel);
        contentPane.add(nationalityBox);
        contentPane.add(genderLabel);
        contentPane.add(maleButton);
        contentPane.add(femaleButton);
        contentPane.add(usernameLabel);
        contentPane.add(usernameField);
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
