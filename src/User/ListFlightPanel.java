package User;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ListFlightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableListFlight;
	private String startPoint = ""; 
	private String endPoint = ""; 
	private String idFlight = ""; 

	/**
	 * Create the panel.
	 */
	public ListFlightPanel() {
		this.setBounds(0, 0, 700, 600);
		setLayout(null);
		
		String[] departureLocations = {"", "TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};
		JComboBox<String> comboBox_StartingPoint = new JComboBox<>(departureLocations);
		comboBox_StartingPoint.setBounds(50, 70, 150, 40);
		
		add(comboBox_StartingPoint);
		
		String[] destinationLocations = {"", "TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};
		JComboBox<String> comboBox_EndingPoint = new JComboBox<String>(destinationLocations);
		comboBox_EndingPoint.setBounds(270, 70, 150, 40);
		
		add(comboBox_EndingPoint);
		
		comboBox_StartingPoint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startPoint = (String) comboBox_StartingPoint.getSelectedItem(); 
				
				switch (startPoint){
					case "TP.Hà Nội": {
	                    String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
	                    comboBox_EndingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Hồ Chí Minh": {
	                    String[] destinationLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
	                    comboBox_EndingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Đà Nẵng": {
	                    String[] destinationLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};
	                    comboBox_EndingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Hải Phòng": {
	                    String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
	                    comboBox_EndingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Cần Thơ": {
	                    String[] destinationLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
	                    comboBox_EndingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Quảng Ninh": {
	                    String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
	                    comboBox_EndingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                default:
	                    throw new IllegalArgumentException("Unexpected value: " + endPoint);
				}
			}
		});
		comboBox_EndingPoint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				endPoint = (String) comboBox_EndingPoint.getSelectedItem(); 
				
				switch (endPoint){
					case "TP.Hà Nội": {
	                    String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
	                    comboBox_StartingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Hồ Chí Minh": {
	                    String[] destinationLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
	                    comboBox_StartingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Đà Nẵng": {
	                    String[] destinationLocations = {"TP.Hà Nội", "TP.Hồ Chí Minh", "TP.Hải Phòng", "TP.Cần Thơ", "TP.Quảng Ninh"};
	                    comboBox_StartingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Hải Phòng": {
	                    String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
	                    comboBox_StartingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Cần Thơ": {
	                    String[] destinationLocations = {"TP.Hà Nội", "TP.Đà Nẵng", "TP.Hải Phòng", "TP.Quảng Ninh"};
	                    comboBox_StartingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                case "TP.Quảng Ninh": {
	                    String[] destinationLocations = {"TP.Hồ Chí Minh", "TP.Đà Nẵng", "TP.Cần Thơ"};
	                    comboBox_StartingPoint.setModel(new DefaultComboBoxModel<>(destinationLocations));
	                    break;
	                }
	                default:
	                    throw new IllegalArgumentException("Unexpected value: " + endPoint);
				}
				
			}
		});
		
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
		
		//Cơ chế lấy mã chuyến bay người dùng đã chọn
		tableListFlight.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = tableListFlight.getSelectedRow(); 
				if(selectedRow != -1) {
					idFlight = tableListFlight.getValueAt(selectedRow, 0).toString(); 
				}
			}
		});
		
		JButton buttonSelectFlight = new JButton("Chọn chuyến");
		buttonSelectFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				MainPage.fillInformationPanel.setVisible(true); 
			}
		});
		buttonSelectFlight.setFont(new Font("Arial", Font.BOLD, 15));
		buttonSelectFlight.setBounds(529, 549, 131, 40);
		
		add(buttonSelectFlight);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.setFont(new Font("Arial", Font.BOLD, 15));
		buttonSearch.setBounds(555, 70, 105, 40);
		add(buttonSearch);
		
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(String idFlight) {
		this.idFlight = idFlight;
	}
}
