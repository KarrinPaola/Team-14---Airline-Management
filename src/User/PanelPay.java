package User;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelPay extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldStart;
    private JTextField textFieldEnd;
    private JTextField textFieldTimeStart;
    private JTextField textFieldSeatClass;
    private JTextField textFieldTypeTicket;
    private JTextField textFieldPrice;
    private Flight flight; 
    private Passenger passenger; 

    /**
     * Create the panel.
     */
    public PanelPay() {
        this.setBounds(0, 0, 700, 600);
        setLayout(null);
        
        JLabel labelFlight = new JLabel("Chuyến bay");
        labelFlight.setFont(new Font("Arial", Font.BOLD, 20));
        labelFlight.setBounds(50, 11, 130, 41);
        add(labelFlight);
        
        JLabel labelStart = new JLabel("Từ");
        labelStart.setFont(new Font("Arial", Font.BOLD, 20));
        labelStart.setBounds(50, 60, 45, 33);
        add(labelStart);
        
        JLabel labelEnd = new JLabel("Đến");
        labelEnd.setFont(new Font("Arial", Font.BOLD, 20));
        labelEnd.setBounds(330, 60, 51, 33);
        add(labelEnd);
        
        JLabel panelTimeStart = new JLabel("Xuất phát:");
        panelTimeStart.setFont(new Font("Arial", Font.BOLD, 20));
        panelTimeStart.setBounds(50, 130, 130, 40);
        add(panelTimeStart);
        
        JLabel labelSeatClass = new JLabel("Hạng ghế:");
        labelSeatClass.setFont(new Font("Arial", Font.BOLD, 20));
        labelSeatClass.setBounds(50, 210, 130, 40);
        add(labelSeatClass);
        
        JLabel labelTypeTicket = new JLabel("Loại vé:");
        labelTypeTicket.setFont(new Font("Arial", Font.BOLD, 20));
        labelTypeTicket.setBounds(50, 290, 130, 40);
        add(labelTypeTicket);
        
        JLabel labelPrice = new JLabel("Giá:");
        labelPrice.setFont(new Font("Arial", Font.BOLD, 20));
        labelPrice.setBounds(300, 360, 51, 40);
        add(labelPrice);
        
        textFieldEnd = new JTextField();
        textFieldEnd.setColumns(10);
        textFieldEnd.setBounds(380, 60, 210, 33);
        add(textFieldEnd);
        
        textFieldStart = new JTextField();
        textFieldStart.setBounds(90, 60, 210, 33);
        add(textFieldStart);
        textFieldStart.setColumns(10);
        
        textFieldTimeStart = new JTextField();
        textFieldTimeStart.setColumns(10);
        textFieldTimeStart.setBounds(160, 130, 210, 33);
        add(textFieldTimeStart);
        
        textFieldSeatClass = new JTextField();
        textFieldSeatClass.setColumns(10);
        textFieldSeatClass.setBounds(160, 210, 210, 33);
        add(textFieldSeatClass);
        
        textFieldTypeTicket = new JTextField();
        textFieldTypeTicket.setColumns(10);
        textFieldTypeTicket.setBounds(160, 290, 210, 33);
        add(textFieldTypeTicket);
        
        textFieldPrice = new JTextField();
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(350, 362, 263, 33);
        add(textFieldPrice);
        
        
        JButton buttonPay = new JButton("Thanh toán");
        buttonPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mở kết nối đến cơ sở dữ liệu
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "");
                    Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", ""); 
                    
                    // Thực thi các câu lệnh SQL
                    String insertUserQuery = "INSERT INTO " + MainPage.getUsername()+ "(ID, StartPoint, EndPoint, DateStart, ClassSeat, TypeTicket, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(insertUserQuery); 
                    statement.setString(1, flight.getID()); 
                    statement.setString(2, flight.getStartPoint()); 
                    statement.setString(3, flight.getEndPoint()); 
                    statement.setDate(4,  flight.getDateStart()); 
                    statement.setString(5, passenger.getClassSeat()); 
                    statement.setString(6, passenger.getTypeTicket()); 
                    statement.setString(7, flight.getStatus()); 
                    statement.execute(); 
                    
                    String insertManagerQuery = "INSERT INTO " + flight.getID() + "(Name, BirthDate, PhoneNumber, Email, CCCD_CMND, ClassSeat, TypeTicket) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement2 = connection2.prepareStatement(insertManagerQuery); 
                    statement2.setString(1, passenger.getFullName()); 
                    statement2.setDate(2,  passenger.getBirthDate()); 
                    statement2.setString(3, passenger.getPhoneNumber()); 
                    statement2.setString(4, passenger.getEmail()); 
                    statement2.setString(5, passenger.getID()); 
                    statement2.setString(6, passenger.getClassSeat()); 
                    statement2.setString(7, passenger.getTypeTicket()); 
                    statement2.execute(); 
                    
                    String updateFlightQuery = "UPDATE ListFlight SET NumberOfSeat = NumberOfSeat - 1 WHERE ID = ?";
                    PreparedStatement statement3 = connection2.prepareStatement(updateFlightQuery); 
                    statement3.setString(1, flight.getID());
                    statement3.execute(); 
                    
                    // Hiển thị thông báo thành công
                    JOptionPane.showMessageDialog(null, "Bạn đã đăng ký thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    // Hiển thị hộp thoại hỏi người dùng có muốn tiếp tục hay không
                    int option = JOptionPane.showOptionDialog(null,
                            "Đặt chuyến thành công!",
                            "Xác nhận",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new String[]{"Đặt chuyến tiếp", "Quay về màn hình chính"},
                            "Đặt chuyến tiếp"); // Lựa chọn mặc định

                    // Xử lý lựa chọn của người dùng
                    if (option == JOptionPane.YES_OPTION) {
                        setVisible(false); 
                        flight = null; 
                        passenger = null; 
                        MainPage.listFlightPanel.setVisible(true); 
                    } else if (option == JOptionPane.NO_OPTION) {
                        setVisible(false); 
                        flight = null; 
                        passenger = null;
                        MainPage.emptyJPanel.setVisible(true); 
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buttonPay.setFont(new Font("Arial", Font.BOLD, 20));
		buttonPay.setBounds(50, 441, 152, 35);
		add(buttonPay);

	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	public int newPrice(String classSeat, String typeTicket, int price) {
	    if (classSeat != null && classSeat.equals("Thương gia")) {
	        price += price * 50 / 100; 
	    }
	    if (typeTicket != null && typeTicket.equals("Khứ hồi")) {
	        price = (int) (price * 2 * 0.85); // Giảm giá 15% cho vé khứ hồi
	    }
	    return price; 
	}
	
	public void setTextField() {
		textFieldEnd.setText(flight.getEndPoint());
		textFieldStart.setText(flight.getStartPoint());
		textFieldTimeStart.setText(flight.getDateStart().toString());
		String newPrice = String.format("%d", newPrice(passenger.getClassSeat(), passenger.getClassSeat(), flight.getPrice()));
		textFieldPrice.setText(newPrice);
		textFieldTypeTicket.setText(passenger.getTypeTicket());
		textFieldSeatClass.setText(passenger.getClassSeat());
	}
	
}
