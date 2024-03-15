package User;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListFlight extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tableListFlight;
    private JTextField textFieldFlightCancellation;
    private String flightCancelled = ""; 
    private DefaultTableModel tableModel;

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
        
        String[] columnNames = {"ID", "Điểm đi", "Điểm đến", "Ngày khởi hành", "Hạng ghế", "Loại vé", "Trạng thái"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableListFlight = new JTable(tableModel);
        
        JScrollPane scrollPaneListFlight = new JScrollPane(tableListFlight);
        scrollPaneListFlight.setBounds(10, 69, 680, 443); // Đã thay đổi giới hạn kích thước
        add(scrollPaneListFlight);
        
        JLabel labelFlightCancellation = new JLabel("Nhập chuyến muốn hủy");
        labelFlightCancellation.setFont(new Font("Arial", Font.BOLD, 20));
        labelFlightCancellation.setBounds(10, 531, 233, 58);
        add(labelFlightCancellation);
        
        textFieldFlightCancellation = new JTextField();
        textFieldFlightCancellation.setBounds(265, 545, 197, 36);
        add(textFieldFlightCancellation);
        textFieldFlightCancellation.setColumns(10);
        flightCancelled = textFieldFlightCancellation.getText(); 
        
        JButton buttonFlightCancellation = new JButton("Hủy chuyến");
        buttonFlightCancellation.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFlightCancellation.setBounds(509, 545, 145, 36);
        add(buttonFlightCancellation);
    }

    public String getFlightCancelled() {
        return flightCancelled;
    }

    public void setFlightCancelled(String flightCancelled) {
        this.flightCancelled = flightCancelled;
    }
    
    public void showAllFlight() {
		Connection connection = null; 
		PreparedStatement statement = null; 
		List<FlightxPassenger> flightxPassengers = new ArrayList<>(); 
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
