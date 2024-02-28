package AirlineManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingFlightPanel2 extends JPanel {

    private static final long serialVersionUID = 1L;

    private JComboBox<String> departureBox, destinationBox, bookingDayBox, bookingMonthBox, bookingYearBox;

    public BookingFlightPanel2() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        // Hạng vé
        JLabel classLabel = new JLabel("Hạng vé:");
        classLabel.setBounds(57, 38, 79, 25);
        classLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(classLabel);

        JRadioButton normalButton = new JRadioButton("Thường");
        normalButton.setBounds(57, 63, 100, 30);
        normalButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(normalButton);

        JRadioButton classicButton = new JRadioButton("Thương gia");
        classicButton.setBounds(159, 63, 120, 30);
        classicButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(classicButton);

        ButtonGroup classGroup = new ButtonGroup();
        classGroup.add(normalButton);
        classGroup.add(classicButton);

        // Loại vé
        JLabel typeLabel = new JLabel("Loại vé:");
        typeLabel.setBounds(57, 103, 79, 25);
        typeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(typeLabel);

        JRadioButton oneWayButton = new JRadioButton("Một chiều");
        oneWayButton.setBounds(57, 128, 100, 30);
        oneWayButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(oneWayButton);

        JRadioButton returnButton = new JRadioButton("Khứ hồi");
        returnButton.setBounds(159, 128, 100, 30);
        returnButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(returnButton);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(oneWayButton);
        typeGroup.add(returnButton);

        // Nơi khởi hành
        JLabel departureLabel = new JLabel("Nơi khởi hành:");
        departureLabel.setBounds(57, 173, 120, 25);
        departureLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(departureLabel);

        String[] departureLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Huế", "TP.Cần Thơ", "TP.Quảng Ninh"};
        departureBox = new JComboBox<>(departureLocations);
        departureBox.setBounds(57, 200, 200, 30);
        add(departureBox);

        // Điểm đến
        JLabel destinationLabel = new JLabel("Điểm đến:");
        destinationLabel.setBounds(57, 240, 80, 25);
        destinationLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(destinationLabel);

        String[] destinationLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Huế", "TP.Cần Thơ", "TP.Quảng Ninh"};
        destinationBox = new JComboBox<>(destinationLocations);
        destinationBox.setBounds(57, 265, 200, 30);
        add(destinationBox);

        // Ngày đặt vé
        JLabel bookingDayLabel = new JLabel("Ngày đặt vé:");
        bookingDayLabel.setBounds(57, 305, 100, 25);
        bookingDayLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(bookingDayLabel);

        JLabel dayLabel = new JLabel("Ngày:");
        dayLabel.setBounds(57, 330, 53, 25);
        dayLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(dayLabel);

        String[] days = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        bookingDayBox = new JComboBox<>(days);
        bookingDayBox.setBounds(104, 330, 42, 30);
        bookingDayBox.setMaximumRowCount(5);
        add(bookingDayBox);

        JLabel monthLabel = new JLabel("Tháng:");
        monthLabel.setBounds(159, 330, 53, 25);
        monthLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(monthLabel);

        String[] months = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        bookingMonthBox = new JComboBox<>(months);
        bookingMonthBox.setBounds(214, 330, 42, 30);
        bookingMonthBox.setMaximumRowCount(5);
        add(bookingMonthBox);

        JLabel yearLabel = new JLabel("Năm:");
        yearLabel.setBounds(269, 330, 42, 25);
        yearLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(yearLabel);

        String[] years = {"", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930"};
        bookingYearBox = new JComboBox<>(years);
        bookingYearBox.setBounds(314, 330, 55, 30);
        bookingYearBox.setMaximumRowCount(5);
        add(bookingYearBox);

        JButton registerButton = new JButton("Đăng ký");
        registerButton.setBounds(159, 380, 120, 35);
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Registration logic here
                String departureLocation = (String) departureBox.getSelectedItem();
                String destinationLocation = (String) destinationBox.getSelectedItem();
                String bookingDay = (String) bookingDayBox.getSelectedItem();
                String bookingMonth = (String) bookingMonthBox.getSelectedItem();
                String bookingYear = (String) bookingYearBox.getSelectedItem();
                String bookingDate = bookingDay + " " + bookingMonth + " " + bookingYear;

                // Process registration data
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(new BookingFlightPanel2());
        frame.setVisible(true);
    }
}
