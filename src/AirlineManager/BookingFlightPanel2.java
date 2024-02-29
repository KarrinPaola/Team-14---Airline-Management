package AirlineManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BookingFlightPanel2 extends JPanel {

    private static final long serialVersionUID = 1L;

    private JComboBox<String> departureBox, destinationBox;
    private JComboBox<Integer> bookingDayBox, bookingMonthBox, bookingYearBox;

    private String userName;

    String typeTicket;
    String classTicket;

    public static Integer[] getRecentYears(int count) {
        int currentYear = Year.now().getValue();
        ArrayList<Integer> yearsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            yearsList.add(currentYear + i);
        }
        return yearsList.toArray(new Integer[0]);
    }

    public BookingFlightPanel2() {
        setBounds(0, 0, 610, 445); // Chỉnh sửa giá trị bounds từ setBounds(ALLBITS, ABORT, 610, 445)
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel classLabel = new JLabel("Hạng vé:");
        // Sửa tọa độ của classLabel
        classLabel.setBounds(50, 30, 110, 25);
        classLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        add(classLabel);

        JLabel typeLabel = new JLabel("Loại vé:");
        typeLabel.setBounds(50, 105, 98, 25);
        typeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        add(typeLabel);

        JLabel departureLabel = new JLabel("Nơi khởi hành:");
        departureLabel.setBounds(50, 190, 245, 25);
        departureLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        add(departureLabel);

        JLabel destinationLabel = new JLabel("Điểm đến:");
        destinationLabel.setBounds(320, 190, 200, 25);
        destinationLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        add(destinationLabel);

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

        String[] destinationLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};

        JCheckBox normalCheckBox = new JCheckBox("Thường");
        normalCheckBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        normalCheckBox.setBounds(105, 67, 128, 23);
        add(normalCheckBox);

        JCheckBox classicCheckBox = new JCheckBox("Thương gia");
        classicCheckBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        classicCheckBox.setBounds(342, 69, 188, 23);
        add(classicCheckBox);

        normalCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    classicCheckBox.setEnabled(false);
                    classTicket = normalCheckBox.getText();
                } else {
                    classicCheckBox.setEnabled(true);
                }
            }
        });

        classicCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    normalCheckBox.setEnabled(false);
                    classTicket = classicCheckBox.getText();
                } else {
                    normalCheckBox.setEnabled(true);
                }
            }
        });

        JCheckBox oneWayCheckBox = new JCheckBox("Một chiều ");
        oneWayCheckBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        oneWayCheckBox.setBounds(105, 142, 128, 23);
        add(oneWayCheckBox);

        JCheckBox twoWayCheckBox = new JCheckBox("Khứ hồi ");
        twoWayCheckBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        twoWayCheckBox.setBounds(342, 142, 128, 23);
        add(twoWayCheckBox);

        oneWayCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    twoWayCheckBox.setEnabled(false);
                    typeTicket = oneWayCheckBox.getText();
                } else {
                    twoWayCheckBox.setEnabled(true);
                }
            }
        });

        twoWayCheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    oneWayCheckBox.setEnabled(false);
                    typeTicket = twoWayCheckBox.getText();
                } else {
                    oneWayCheckBox.setEnabled(true);
                }
            }
        });

        destinationBox = new JComboBox<>(destinationLocations);
        destinationBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        destinationBox.setBounds(315, 225, 200, 35);
        add(destinationBox);

        String[] departureLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};
        departureBox = new JComboBox<>(departureLocations);
        departureBox.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        departureBox.setBounds(45, 225, 200, 35);
        add(departureBox);

        departureBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String endPoint = (String) departureBox.getSelectedItem();

                switch (endPoint) {
                    case "TP.Hà Nội": {
                        String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
                        destinationBox.setModel(new DefaultComboBoxModel<>(destinationLocations));
                        break;
                    }
                    case "TP.Hồ Chí Minh": {
                        String[] destinationLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
                        destinationBox.setModel(new DefaultComboBoxModel<>(destinationLocations));
                        break;
                    }
                    case "TP.Đà Nẵng": {
                        String[] destinationLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};
                        destinationBox.setModel(new DefaultComboBoxModel<>(destinationLocations));
                        break;
                    }
                    case "TP.Hải Phòng": {
                        String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
                        destinationBox.setModel(new DefaultComboBoxModel<>(destinationLocations));
                        break;
                    }
                    case "TP.Cần Thơ": {
                        String[] destinationLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
                        destinationBox.setModel(new DefaultComboBoxModel<>(destinationLocations));
                        break;
                    }
                    case "TP.Quảng Ninh": {
                        String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
                        destinationBox.setModel(new DefaultComboBoxModel<>(destinationLocations));
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Unexpected value: " + endPoint);
                }

            }
        });

        destinationBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startPoint = (String) destinationBox.getSelectedItem();

                switch (startPoint) {
                    case "TP.Hà Nội": {
                        String[] departureLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
                        departureBox.setModel(new DefaultComboBoxModel<>(departureLocations));
                        break;
                    }
                    case "TP.Hồ Chí Minh": {
                        String[] departureLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
                        departureBox.setModel(new DefaultComboBoxModel<>(departureLocations));
                        break;
                    }
                    case "TP.Đà Nẵng": {
                        String[] departureLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};
                        departureBox.setModel(new DefaultComboBoxModel<>(departureLocations));
                        break;
                    }
                    case "TP.Hải Phòng": {
                        String[] departureLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
                        departureBox.setModel(new DefaultComboBoxModel<>(departureLocations));
                        break;
                    }
                    case "TP.Cần Thơ": {
                        String[] departureLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
                        departureBox.setModel(new DefaultComboBoxModel<>(departureLocations));
                        break;
                    }
                    case "TP.Quảng Ninh": {
                        String[] departureLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
                        departureBox.setModel(new DefaultComboBoxModel<>(departureLocations));
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Unexpected value: " + startPoint);
                }

            }
        });

        Integer[] days = new Integer[32];
        for (int i = 1; i <= 31; i++) { // Sửa vòng lặp từ i = 0 thành i = 1
            days[i - 1] = i; // Điều chỉnh chỉ số của mảng từ 0 đến 30
        }

        bookingDayBox = new JComboBox<>(days);
        bookingDayBox.setBounds(105, 317, 80, 35);
        bookingDayBox.setMaximumRowCount(5);
        add(bookingDayBox);

        Integer[] months = new Integer[13];
        for (int i = 1; i <= 12; i++) { // Sửa vòng lặp từ i = 0 thành i = 1
            months[i - 1] = i; // Điều chỉnh chỉ số của mảng từ 0 đến 11
        }
        bookingMonthBox = new JComboBox<>(months);
        bookingMonthBox.setBounds(257, 317, 80, 35);
        bookingMonthBox.setMaximumRowCount(5);
        add(bookingMonthBox);

        bookingYearBox = new JComboBox<>(getRecentYears(3));
        bookingYearBox.setBounds(396, 317, 120, 35);
        bookingYearBox.setMaximumRowCount(5);
        add(bookingYearBox);

        JButton registerButton = new JButton("Đặt chuyến");
        registerButton.setBounds(234, 387, 140, 40);
        registerButton.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	System.out.println(userName);
            	
            	Connection connection = null;
				PreparedStatement statement = null; 
				java.sql.Statement countElementInTable = null; 
				List<Flight> flights = new ArrayList<>(); 
				
				//Lấy ra ngày tháng năm hiện tại
				LocalDate currentDate = LocalDate.now();
				int currentYear = currentDate.getYear(); 
				System.out.println(currentYear);
		        int currentMonth = currentDate.getMonthValue();
		        System.out.println(currentMonth);
		        int currentDay = currentDate.getDayOfMonth(); 
		        System.out.println(currentDay);
				
		        Integer selectedDay = (Integer) bookingDayBox.getSelectedItem();
		        System.out.println(selectedDay);
		        Integer selectedMonth = (Integer) bookingMonthBox.getSelectedItem();
		        System.out.println(selectedMonth);
		        Integer selectedYear = (Integer) bookingYearBox.getSelectedItem();
		        System.out.println(selectedYear);
		        
		        String selectedDate = null; 

		        // Kiểm tra null cho các giá trị
		        if (selectedDay != null && selectedMonth != null && selectedYear != null) {
		        	System.out.println("điều kiện đúng ngày ko rỗng đúng");
		        	if (selectedYear > currentYear ||
		        	   (selectedYear.equals(currentYear) && selectedMonth > currentMonth) ||
		        	   (selectedYear.equals(currentYear) && selectedMonth.equals(currentMonth) && selectedDay >= currentDay)) {
		        		System.out.println("điều kiện ngày lớn hơn hoặc bằng ngày hiện tại đúng");
		        		// Định dạng ngày tháng năm thành chuỗi với định dạng "dd/MM/yyyy"
		        		selectedDate = String.format("%02d/%02d/%d", selectedDay, selectedMonth, selectedYear);
		        		try {
							connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/AirlineManagement","root", "");
							String sql0 = "select * from " + userName.toLowerCase(); 
							countElementInTable = connection.prepareStatement(sql0); 
		                    ResultSet resultset = countElementInTable.executeQuery(sql0); 
		                    
		                    while (resultset.next()) {
		                        Flight flight = new Flight(
		                                resultset.getInt("ID"),
		                                resultset.getString("StartingPoint"),
		                                resultset.getString("Destination"),
		                                resultset.getString("DepartureTime"),
		                                resultset.getString("TicketClass"),
		                                resultset.getString("TicketType")
		                                ); 
		                        flights.add(flight); 
		                    }
							
		                    String sql = "insert into " + userName + " (ID, StartingPoint, Destination, DepartureTime, TicketClass, TicketType)" + " values(?,?,?,?,?,?)";

							statement = connection.prepareStatement(sql); 
							
							statement.setInt(1, flights.size() + 1); 
							statement.setString(2, (String)departureBox.getSelectedItem()); 
							statement.setString(3, (String)destinationBox.getSelectedItem());
							statement.setString(4, selectedDate);
							statement.setString(5, classTicket);
							statement.setString(6, typeTicket);

								try {
									statement.execute(); 
									
								} catch (Exception e2) {
									System.err.println("Lỗi lòi");
								}

						} catch (SQLException e1) {
							if(statement != null) {
								try {
									statement.close();
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} 
							}
							if(countElementInTable != null) {
								try {
									countElementInTable.close();
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} 
							}
							if(connection != null) {
								try {
									connection.close();
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								} 
							}
						}
					}
		        } else {
		            // Xử lý trường hợp không có giá trị được chọn
		        	JOptionPane.showMessageDialog(null, "Ngày đặt chuyến không hợp lệ!", "title", JOptionPane.INFORMATION_MESSAGE);
		        }
				
				
            }
        });
        add(registerButton);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
