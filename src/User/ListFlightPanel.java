package User;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ListFlightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableListFlight;

	/**
	 * Create the panel.
	 */
	public ListFlightPanel() {
		this.setBounds(0, 0, 700, 600);
		setLayout(null);
		
		JComboBox comboBox_StartingPoint = new JComboBox();
		comboBox_StartingPoint.setBounds(50, 70, 150, 40);
		add(comboBox_StartingPoint);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.setFont(new Font("Arial", Font.BOLD, 15));
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonSearch.setBounds(555, 70, 105, 40);
		add(buttonSearch);
		
		JComboBox comboBox_EndingPoint = new JComboBox();
		comboBox_EndingPoint.setBounds(270, 70, 150, 40);
		add(comboBox_EndingPoint);
		
		JLabel labelEndingPoint = new JLabel("Điểm đến");
		labelEndingPoint.setFont(new Font("Arial", Font.BOLD, 22));
		labelEndingPoint.setBounds(55, 35, 150, 35);
		add(labelEndingPoint);
		
		JLabel labelStartingPoint = new JLabel("Điểm đi");
		labelStartingPoint.setFont(new Font("Arial", Font.BOLD, 22));
		labelStartingPoint.setBounds(275, 35, 150, 35);
		add(labelStartingPoint);
		
		JScrollPane scrollPaneListFlight = new JScrollPane();
		scrollPaneListFlight.setBounds(50, 160, 610, 339);
		add(scrollPaneListFlight);
		
		tableListFlight = new JTable();
		scrollPaneListFlight.setViewportView(tableListFlight);
		tableListFlight.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3", "Ng\u00E0y bay", "\u0110i\u1EC3m \u0111i", "\u0110i\u1EC3m \u0111\u1EBFn", "S\u1ED1 gh\u1EBF c\u00F2n l\u1EA1i", "Gi\u00E1"
			}
		));
		tableListFlight.getColumnModel().getColumn(0).setPreferredWidth(34);
		tableListFlight.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableListFlight.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableListFlight.getColumnModel().getColumn(4).setPreferredWidth(77);
		
//		JButton buttonSelectFlight = new JButton("Chọn chuyến");
//		buttonSelectFlight.setFont(new Font("Arial", Font.BOLD, 15));
//		buttonSelectFlight.setBounds(529, 549, 131, 40);
//		add(buttonSelectFlight);
	}
}
