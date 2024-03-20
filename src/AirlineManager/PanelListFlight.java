package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import User.ListFlight;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListFlight extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable tableListFlight;
    private JTextField textFieldFlightCancellation;
    private String flightCancelled = ""; 
    private DefaultTableModel tableModel;

    /**
     * Create the panel.
     */
    public PanelListFlight {
        this.setBounds(0, 0, 700, 600);
        setLayout(null);
        
        JLabel labelListFlight = new JLabel("Danh sách chuyến bay");
        labelListFlight.setFont(new Font("Arial", Font.BOLD, 22));
        labelListFlight.setBounds(200, 11, 250, 49);
        add(labelListFlight);
        
        String[] columnNames = {"ID", "Điểm đi", "Điểm đến", "Ngày khởi hành","Số lượng ghế", "Trạng thái", "Giá vé"};
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
        buttonFlightCancellation.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cancelFlight();
        		showAllFlight();
        		textFieldFlightCancellation.setText("");
        	}
        });
        buttonFlightCancellation.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFlightCancellation.setBounds(509, 545, 145, 36);
        add(buttonFlightCancellation);
        
        tableListFlight.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tableListFlight.getSelectedRow(); 
				if (selectedRow != -1 ) {
					String idFlight = tableListFlight.getValueAt(selectedRow, 0).toString(); 
					textFieldFlightCancellation.setText(idFlight); 
				}
				
			}
		});
    }

    public String getFlightCancelled() {
        return flightCancelled;
    }

    public void setFlightCancelled(String flightCancelled) {
        this.flightCancelled = flightCancelled;
    }
    
    public void cancelFlight() {
    	String iDFlight = textFieldFlightCancellation.getText(); 
		Connection connection = null; 
		PreparedStatement statement = null; 
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", "");
			 String sql = "DELETE FROM ListFlight WHERE ID = ?"; 
		        statement = connection.prepareStatement(sql); 
		        statement.setString(1, iDFlight);
		        statement.executeUpdate(); 
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null) {
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
    
    public void showAllFlight() {
		Connection connection = null; 
		PreparedStatement statement = null; 
		List<Flight> flights = new ArrayList<>(); 
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", "");
			String sql = "SELECT * FROM " + "ListFlight"; 
			statement = connection.prepareStatement(sql); 
			ResultSet resultSet = statement.executeQuery(); 
			
			while (resultSet.next()) {
				Flight flight = new Flight(
						resultSet.getString("ID"),
                        resultSet.getString("StartPoint"),
                        resultSet.getString("EndPoint"),
                        resultSet.getDate("DateStart"),
                        resultSet.getInt("NumberOfSeat"),
                        resultSet.getString("Status"),
                        resultSet.getInt("Price")
						); 
				flights.add(flight); 
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
		}
		tableModel.setRowCount(0); 
		
		for(Flight flight : flights) {
			tableModel.addRow(new Object[] {
					flight.getID(), 
					flight.getStartPoint(), 
					flight.getEndPoint(), 
					flight.getDateStart(), 
					flight.getNumberOfSeat(), 
					flight.getStatus(), 
					flight.getPrice()
			}); 
		}
	}
}
