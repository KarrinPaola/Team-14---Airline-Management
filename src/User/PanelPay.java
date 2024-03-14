package User;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
