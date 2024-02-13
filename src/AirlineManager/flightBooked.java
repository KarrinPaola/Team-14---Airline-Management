package AirlineManager;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class flightBooked extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_FlightID;
	private JTextField textField_PlaceFrom;
	private JTextField textField_PlaceTo;
	private JTextField textField_flightTime;
	private JLabel typeTicketLabel;
	private JTextField textField_typeTicket;
	private JLabel classTicketLabel;
	private JTextField textField_classTicket;
	private JButton cancelFlight;

	/**
	 * Create the panel.
	 */
	public flightBooked() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel flightIDLabel = new JLabel("Mã chuyến bay: ");
		flightIDLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		flightIDLabel.setBounds(20, 15, 129, 20);
		add(flightIDLabel);
		
		textField_FlightID = new JTextField();
		textField_FlightID.setBounds(155, 10, 129, 30);
		add(textField_FlightID);
		textField_FlightID.setColumns(10);
		
		textField_PlaceFrom = new JTextField();
		textField_PlaceFrom.setColumns(10);
		textField_PlaceFrom.setBounds(354, 10, 130, 30);
		add(textField_PlaceFrom);
		
		textField_PlaceTo = new JTextField();
		textField_PlaceTo.setColumns(10);
		textField_PlaceTo.setBounds(505, 10, 130, 30);
		add(textField_PlaceTo);
		
		JLabel flightTimeLabel = new JLabel("Giờ bay: ");
		flightTimeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		flightTimeLabel.setBounds(20, 55, 77, 20);
		add(flightTimeLabel);
		
		textField_flightTime = new JTextField();
		textField_flightTime.setColumns(10);
		textField_flightTime.setBounds(95, 50, 241, 30);
		add(textField_flightTime);
		
		typeTicketLabel = new JLabel("Loại vé: ");
		typeTicketLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		typeTicketLabel.setBounds(20, 95, 70, 20);
		add(typeTicketLabel);
		
		textField_typeTicket = new JTextField();
		textField_typeTicket.setColumns(10);
		textField_typeTicket.setBounds(94, 90, 129, 30);
		add(textField_typeTicket);
		
		classTicketLabel = new JLabel("Hạng vé: ");
		classTicketLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		classTicketLabel.setBounds(260, 95, 78, 20);
		add(classTicketLabel);
		
		textField_classTicket = new JTextField();
		textField_classTicket.setColumns(10);
		textField_classTicket.setBounds(342, 90, 129, 30);
		add(textField_classTicket);
		
		cancelFlight = new JButton("Huỷ chuyến");
		cancelFlight.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		cancelFlight.setBounds(524, 109, 130, 35);
		add(cancelFlight);

	}

}
