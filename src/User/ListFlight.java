package User;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListFlight extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textFieldFlightCancellation;
	private String flightCancelled = ""; 

	/**
	 * Create the panel.
	 */
	public ListFlight() {
		this.setBounds(0, 0, 700, 600);
		setLayout(null);
		
		JLabel labelListFlight = new JLabel("Danh sách chuyến bay");
		labelListFlight.setFont(new Font("Arial", Font.BOLD, 22));
		labelListFlight.setBounds(200, 11, 250, 49);
		add(labelListFlight);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 680, 443);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3", "\u0110i\u1EC3m \u0111i", "\u0110i\u1EC3m \u0111\u1EBFn", "Ng\u00E0y bay", "H\u1EA1ng v\u00E9", "Lo\u1EA1i v\u00E9", "Tr\u1EA1ng th\u00E1i"
			}
		));
		
		JLabel labelFlightCalcellation = new JLabel("Nhập chuyến muốn hủy");
		labelFlightCalcellation.setFont(new Font("Arial", Font.BOLD, 20));
		labelFlightCalcellation.setBounds(10, 531, 233, 58);
		add(labelFlightCalcellation);
		
		textFieldFlightCancellation = new JTextField();
		textFieldFlightCancellation.setBounds(265, 545, 197, 36);
		add(textFieldFlightCancellation);
		textFieldFlightCancellation.setColumns(10);
		flightCancelled = textFieldFlightCancellation.getText(); 
		
		JButton buttonFlightCancellation = new JButton("Hủy chuyến");
		buttonFlightCancellation.setFont(new Font("Arial", Font.BOLD, 20));
		buttonFlightCancellation.setBounds(509, 545, 145, 36);
		add(buttonFlightCancellation);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);

	}

	public String getFlightCancelled() {
		return flightCancelled;
	}

	public void setFlightCancelled(String flightCancelled) {
		this.flightCancelled = flightCancelled;
	}
}
