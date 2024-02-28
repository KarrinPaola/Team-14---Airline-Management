package AirlineManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingFlightPanel2 extends JPanel {

    private static final long serialVersionUID = 1L;

    private JComboBox<String> departureBox, destinationBox, bookingDayBox, bookingMonthBox, bookingYearBox;
    
    private String userName;
    
    

    public BookingFlightPanel2() {
    	setBounds(ALLBITS, ABORT, 610, 445);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);
       

        // Hạng vé
        JLabel classLabel = new JLabel("Hạng vé:");
        classLabel.setBounds(50, 30, 110, 25);
        classLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        add(classLabel);
        
                // Loại vé
                JLabel typeLabel = new JLabel("Loại vé:");
                typeLabel.setBounds(50, 105, 98, 25);
                typeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
                add(typeLabel);
        
                // Nơi khởi hành
                JLabel departureLabel = new JLabel("Nơi khởi hành:");
                departureLabel.setBounds(50, 190, 245, 25);
                departureLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
                add(departureLabel);
        
                // Điểm đến
                JLabel destinationLabel = new JLabel("Điểm đến:");
                destinationLabel.setBounds(320, 190, 200, 25);
                destinationLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
                add(destinationLabel);
        
                // Ngày đặt vé
                JLabel bookingDayLabel = new JLabel("Ngày đặt vé:");
                bookingDayLabel.setBounds(50, 280, 200, 25);
                bookingDayLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
                add(bookingDayLabel);
        
                JLabel dayLabel = new JLabel("Ngày:");
                dayLabel.setBounds(50, 320, 50, 25);
                dayLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
                add(dayLabel);
        
                JLabel monthLabel = new JLabel("Tháng:");
                monthLabel.setBounds(190, 320, 62, 25);
                monthLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
                add(monthLabel);
        
                JLabel yearLabel = new JLabel("Năm:");
                yearLabel.setBounds(342, 320, 49, 25);
                yearLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
                add(yearLabel);

        JRadioButton normalButton = new JRadioButton("Thường");
        normalButton.setBounds(95, 65, 100, 30);
        normalButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        add(normalButton);

        JRadioButton classicButton = new JRadioButton("Thương gia");
        classicButton.setBounds(365, 65, 147, 30);
        classicButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        add(classicButton);

        ButtonGroup classGroup = new ButtonGroup();
        classGroup.add(normalButton);
        classGroup.add(classicButton);

        JRadioButton oneWayButton = new JRadioButton("Một chiều");
        oneWayButton.setBounds(95, 140, 180, 30);
        oneWayButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        add(oneWayButton);

        JRadioButton returnButton = new JRadioButton("Khứ hồi");
        returnButton.setBounds(365, 140, 100, 30);
        returnButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        add(returnButton);

        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(oneWayButton);
        typeGroup.add(returnButton);

        String[] departureLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Huế", "TP.Cần Thơ", "TP.Quảng Ninh"};
        departureBox = new JComboBox<>(departureLocations);
        departureBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        departureBox.setBounds(45, 225, 200, 35);
        add(departureBox);

        String[] destinationLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Huế", "TP.Cần Thơ", "TP.Quảng Ninh"};
        destinationBox = new JComboBox<>(destinationLocations);
        destinationBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        destinationBox.setBounds(315, 225, 200, 35);
        add(destinationBox);

        String[] days = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        bookingDayBox = new JComboBox<>(days);
        bookingDayBox.setBounds(105, 317, 80, 35);
        bookingDayBox.setMaximumRowCount(5);
        add(bookingDayBox);

        String[] months = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        bookingMonthBox = new JComboBox<>(months);
        bookingMonthBox.setBounds(257, 317, 80, 35);
        bookingMonthBox.setMaximumRowCount(5);
        add(bookingMonthBox);

        String[] years = {"", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930"};
        bookingYearBox = new JComboBox<>(years);
        bookingYearBox.setBounds(396, 317, 120, 35);
        bookingYearBox.setMaximumRowCount(5);
        add(bookingYearBox);

        JButton registerButton = new JButton("Đặt chuyến");
        registerButton.setBounds(234, 387, 140, 40);
        registerButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        add(registerButton);
    }
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
