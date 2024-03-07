package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListButton extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ListButton() {
		this.setBounds(0,0,200,600); 
		setLayout(null);
		
		JButton buttonBookFlight = new JButton("Đặt chuyến");
		buttonBookFlight.setFont(new Font("Arial", Font.BOLD, 22));
		buttonBookFlight.setBounds(10, 60, 180, 80);
		add(buttonBookFlight);
		
		JButton buttonListFlight = new JButton("Xem chuyến");
		buttonListFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonListFlight.setFont(new Font("Arial", Font.BOLD, 22));
		buttonListFlight.setBounds(10, 260, 180, 80);
		add(buttonListFlight);
		
		JButton buttonAccount = new JButton("Tài khoản");
		buttonAccount.setFont(new Font("Arial", Font.BOLD, 22));
		buttonAccount.setBounds(10, 460, 180, 80);
		add(buttonAccount);
	}
}
