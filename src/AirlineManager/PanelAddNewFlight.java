package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class PanelAddNewFlight extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_theNumberOfSeat;
	private String startPoint = ""; 
	private String endPoint = "";
	private Date dateStart; 
	private String day, month, year; 
	private int NumberOfSeat; 
	private String ID; 
	private String status = "Sẵn sàng";
	private int Price; 
	private Flight flight;
	
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
		
		String[] departureLocations = {"", "Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Hải Phòng", "Cần Thơ", "Quảng Ninh"};
		JComboBox<String> comboBoxSelectPointStarting = new JComboBox<String>(departureLocations);
		comboBoxSelectPointStarting.setBounds(275, 91, 200, 42);
		add(comboBoxSelectPointStarting);
		
		
		String[] destinationLocations = {"", "Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Hải Phòng", "Cần Thơ", "Quảng Ninh"};
		JComboBox<String> comboBoxSelectPointEnding = new JComboBox<String>(destinationLocations);
		comboBoxSelectPointEnding.setBounds(275, 172, 200, 44);
		add(comboBoxSelectPointEnding);
		
		comboBoxSelectPointStarting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startPoint = comboBoxSelectPointStarting.getSelectedItem().toString(); 
				
				switch (startPoint){
					case "Hà Nội": {
	                    String[] destinationLocations = {"Hồ Chí Minh", "Đà Nẵng", "Cần Thơ"};
	                    comboBoxSelectPointEnding.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "Hồ Chí Minh": {
	                    String[] destinationLocations = {"Hà Nội", "Đà Nẵng", "Hải Phòng", "Quảng Ninh"};
	                    comboBoxSelectPointEnding.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "Đà Nẵng": {
	                    String[] destinationLocations = {"Hà Nội", "Hồ Chí Minh", "Hải Phòng", "Cần Thơ", "Quảng Ninh"};
	                    comboBoxSelectPointEnding.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "Hải Phòng": {
	                    String[] destinationLocations = {"Hồ Chí Minh", "Đà Nẵng", "Cần Thơ"};
	                    comboBoxSelectPointEnding.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "Cần Thơ": {
	                    String[] destinationLocations = {"Hà Nội", "Đà Nẵng", "Hải Phòng", "Quảng Ninh"};
	                    comboBoxSelectPointEnding.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "Quảng Ninh": {
	                    String[] destinationLocations = {"Hồ Chí Minh", "Đà Nẵng", "Cần Thơ"};
	                    comboBoxSelectPointEnding.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                default:
	                    throw new IllegalArgumentException("Unexpected value: " + endPoint);
				}
			}
		});
		
		comboBoxSelectPointEnding.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				endPoint = comboBoxSelectPointEnding.getSelectedItem().toString(); 
			}
		});
		
		JComboBox<String> comboBoxDay = new JComboBox<String>();
		comboBoxDay.setBounds(80, 335, 135, 40);
		add(comboBoxDay);
		for (int i = 1; i <= 31; i++) {
		    comboBoxDay.addItem(String.valueOf(i));
		}
		day = (String) comboBoxDay.getSelectedItem(); 
		
		JComboBox<String> comboBoxMonth = new JComboBox<String>();
		comboBoxMonth.setBounds(315, 335, 135, 40);
		add(comboBoxMonth);
		for (int i = 1; i <= 12; i++) {
		    comboBoxMonth.addItem(String.valueOf(i));
		}
		month = (String) comboBoxMonth.getSelectedItem(); 
		
		JComboBox<String> comboBoxYear = new JComboBox<String>();
		comboBoxYear.setToolTipText("");
		comboBoxYear.setBounds(525, 335, 135, 40);
		add(comboBoxYear);
		int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		for (int i = currentYear; i <= 2030; i++) {
		    comboBoxYear.addItem(String.valueOf(i));
		}
		year = (String) comboBoxYear.getSelectedItem();
		
		textField_theNumberOfSeat = new JTextField();
		textField_theNumberOfSeat.setBounds(320, 421, 130, 37);
		add(textField_theNumberOfSeat);
		textField_theNumberOfSeat.setColumns(10);
		
		JButton buttonAddNewFlight = new JButton("Thêm chuyến");
		buttonAddNewFlight.setFont(new Font("Arial", Font.BOLD, 20));
		buttonAddNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = getID(startPoint, endPoint); 
				creatID();
				Price = getPrice(startPoint, endPoint); 
				year = comboBoxYear.getSelectedItem().toString(); 
				month = comboBoxMonth.getSelectedItem().toString(); 
				day = comboBoxDay.getSelectedItem().toString(); 
				NumberOfSeat = Integer.parseInt(textField_theNumberOfSeat.getText()); 
				try {
					dateStart = convertToDate(year, month, day);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				flight = new Flight(ID, startPoint, endPoint, dateStart, NumberOfSeat, status, Price);
				MainPage.panelAccount.setFlight(flight);
				MainPage.panelAccount.setVisible(true);
				MainPage.panelAccount.setTextField();
				setVisible(false);
			}
		});
		buttonAddNewFlight.setBounds(503, 529, 165, 36);
		add(buttonAddNewFlight);

	}
	
	public String getID(String startPoint, String endPoint) {
		Connection connection = null; 
		PreparedStatement statement = null; 
		String IDtemp = null; 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", "");
			String getID = "SELECT * FROM Price WHERE StartPoint = ? AND EndPoint = ?"; 
			statement = connection.prepareStatement(getID); 
			statement.setString(1, startPoint); 
			statement.setString(2, endPoint); 
			ResultSet resultSet = statement.executeQuery(); 
			
			if (resultSet.next()) {
				IDtemp = resultSet.getString("ID"); 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		return IDtemp; 
	}
	
	public int getPrice(String startPoint, String endPoint) {
		Connection connection = null; 
		PreparedStatement statement = null; 
		int price = 0; ; 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", "");
			String getPrice = "SELECT * FROM Price WHERE StartPoint = ? AND EndPoint = ?"; 
			statement = connection.prepareStatement(getPrice); 
			statement.setString(1, startPoint); 
			statement.setString(2, endPoint); 
			ResultSet resultSet = statement.executeQuery(); 
			
			if (resultSet.next()) {
				price = resultSet.getInt("Price"); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		return price;  
	}

	public void creatID() {
		Connection connection = null; 
		PreparedStatement statement = null; 
		try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", "");
	        String sql = "SELECT COUNT(*) AS numFlights FROM ListFlight";
	        statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int numFlights = resultSet.getInt("numFlights");
	            ID = generateTripCode(ID, numFlights + 1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		
	}
	
	public static java.sql.Date convertToDate(String year, String month, String day) throws ParseException {
	    String dateString = year + "-" + month + "-" + day;
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    java.util.Date utilDate = dateFormat.parse(dateString);
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    return sqlDate;
	}
	
	public static String generateTripCode(String ID, int tripNumber) {
        String tripNumberString = String.format("%03d", tripNumber); // Đảm bảo có 3 chữ số
        return ID + tripNumberString;
    }
}
