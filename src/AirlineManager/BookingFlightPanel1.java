package AirlineManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingFlightPanel1 extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
    private JComboBox<String> dayBox, monthBox, yearBox;
    private JTextField idField, idPhoneField, addressField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> nationalityBox;

    public BookingFlightPanel1() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel nameLabel = new JLabel("Họ và tên:");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        nameLabel.setBounds(57, 38, 79, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(57, 63, 200, 30);
        add(nameField);

        // Ngày tháng năm sinh
        JLabel dayBirthLabel = new JLabel("Ngày:");
        dayBirthLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        dayBirthLabel.setBounds(57, 103, 53, 25);
        add(dayBirthLabel);

        String[] days = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        dayBox = new JComboBox<>(days);
        dayBox.setMaximumRowCount(5);
        dayBox.setBounds(105, 103, 42, 30);
        add(dayBox);

        JLabel monthBirthLabel = new JLabel("Tháng:");
        monthBirthLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        monthBirthLabel.setBounds(162, 103, 53, 25);
        add(monthBirthLabel);

        String[] months = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        monthBox = new JComboBox<>(months);
        monthBox.setMaximumRowCount(5);
        monthBox.setBounds(215, 102, 42, 30);
        add(monthBox);

        JLabel yearBirthLabel = new JLabel("Năm:");
        yearBirthLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        yearBirthLabel.setBounds(278, 103, 42, 25);
        add(yearBirthLabel);

        String[] years = {"", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930"};
        yearBox = new JComboBox<>(years);
        yearBox.setMaximumRowCount(5);
        yearBox.setBounds(323, 102, 55, 30);
        add(yearBox);

        // Địa chỉ CMND/CCCD
        JLabel idLabel = new JLabel("CMND/CCCD:");
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        idLabel.setBounds(57, 138, 108, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(57, 163, 200, 30);
        add(idField);

        // Số điện thoại
        JLabel idPhoneLabel = new JLabel("Số điện thoại:");
        idPhoneLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        idPhoneLabel.setBounds(57, 203, 108, 25);
        add(idPhoneLabel);

        idPhoneField = new JTextField();
        idPhoneField.setBounds(57, 229, 200, 30);
        add(idPhoneField);

        // Giới tính
        JLabel genderLabel = new JLabel("Giới tính:");
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        genderLabel.setBounds(57, 269, 79, 25);
        add(genderLabel);

        maleButton = new JRadioButton("Nam");
        maleButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        maleButton.setBounds(135, 266, 80, 30);
        add(maleButton);

        femaleButton = new JRadioButton("Nữ");
        femaleButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        femaleButton.setBounds(214, 265, 80, 30);
        add(femaleButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        // Dân tộc
        JLabel nationalityLabel = new JLabel("Dân tộc:");
        nationalityLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        nationalityLabel.setBounds(57, 317, 70, 25);
        add(nationalityLabel);

        String[] nationalities = {"Kinh", "Tày", "Thái", "Mường", "Miên", "Hoa", "Nùng", "H'Mông", "Dao", "Gia Rai",
                "Ê Đê", "Ba Na", "Sán Chay", "Chăm", "Kơ ho", "Xơ Đăng", "Sán Dìu", "Hrê", "Ra Giai", "Mnông",
                "Thổ", "Stiêng", "Khơ mú", "Bru-Vân Kiều", "Cơ Tu", "Giày", "Tà Ôi", "Mạ", "Giẻ-Triêng", "Co",
                "Chơ Ro", "Xing Mun", "Hà Nhì", "Chu Ru", "Lào", "La Chí", "Kháng", "Phù Lá", "La Hủ", "La Ha",
                "Pà Thẻn", "Lự", "Ngái", "Chứt", "Lô Lô", "Mảng", "Cơ Lao", "Bố Y", "Cổng", "Si La", "Pu Péo",
                "Rơ Măm", "Brâu", "Ơ Đu"};
        nationalityBox = new JComboBox<>(nationalities);
        nationalityBox.setModel(new DefaultComboBoxModel(new String[] {"Kinh", "Tày", "Thái", "Mường", "Miên", "Hoa", "Nùng", "H'Mông", "Dao", "Gia Rai", "Ê Đê", "Ba Na", "Sán Chay", "Chăm", "Kơ ho", "Xơ Đăng", "Sán Dìu", "Hrê", "Ra Giai", "Mnông", "Thổ", "Stiêng", "Khơ mú", "Bru-Vân Kiều", "Cơ Tu", "Giày", "Tà Ôi", "Mạ", "Giẻ-Triêng", "Co", "Chơ Ro", "Xing Mun", "Hà Nhì", "Chu Ru", "Lào", "La Chí", "Kháng", "Phù Lá", "La Hủ", "La Ha", "Pà Thẻn", "Lự", "Ngái", "Chứt", "Lô Lô", "Mảng", "Cơ Lao", "Bố Y", "Cổng", "Si La", "Pu Péo", "Rơ Măm", "Brâu", "Ơ Đu"}));
        nationalityBox.setBounds(121, 312, 200, 30);
        add(nationalityBox);

        // Địa chỉ
        JLabel addressLabel = new JLabel("Địa chỉ:");
        addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        addressLabel.setBounds(57, 358, 79, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(57, 382, 200, 30);
        add(addressField);

        ButtonGroup classGroup = new ButtonGroup();

        ButtonGroup typeGroup = new ButtonGroup();

        String[] departureLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Huế", "TP.Cần Thơ", "TP.Quảng Ninh"};

        String[] destinationLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Huế", "TP.Cần Thơ", "TP.Quảng Ninh"};

        JButton registerButton = new JButton("Tiếp theo");
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        registerButton.setBounds(409, 364, 138, 51);
        add(registerButton);

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
                String idNumber = idField.getText(); // Chứng minh nhân dân
                String phoneNumber = idPhoneField.getText(); // Số điện thoại
                // Process registration data
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 485);
        frame.getContentPane().add(new BookingFlightPanel1());
        frame.setVisible(true);
    }
}
