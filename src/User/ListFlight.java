package User;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		Connection connection2 = null; 
		PreparedStatement statement = null; 
		PreparedStatement statement2 = null; 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "");
			String sql = "DELETE FROM " + MainPage.getUsername() + " WHERE ID = ?"; 
		    statement = connection.prepareStatement(sql); 
		    statement.setString(1, iDFlight);
		    statement.executeUpdate(); 
			
		    connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", "");
		    String updateData3 = "UPDATE ListFlight SET NumberOfSeat = NumberOfSeat + 1 WHERE ID = ?";
			statement2 = connection2.prepareStatement(updateData3); 
			statement.setString(1, iDFlight);
			statement.execute(); 
			
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
		List<FlightxPassenger> flightxPassengers = new ArrayList<>(); 
		
		try {
			System.out.println(MainPage.getUsername());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "");
			String sql = "SELECT * FROM " + MainPage.getUsername(); 
			
			statement = connection.prepareStatement(sql); 
			ResultSet resultSet = statement.executeQuery(); 
			
			while (resultSet.next()) {
				FlightxPassenger flightxPassenger = new FlightxPassenger(
						resultSet.getString("ID"),
                        resultSet.getString("StartPoint"),
                        resultSet.getString("EndPoint"),
                        resultSet.getDate("DateStart"),
                        resultSet.getString("ClassSeat"),
                        resultSet.getString("TypeTicket"),
                        resultSet.getString("Status")
						); 
				flightxPassengers.add(flightxPassenger); 
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
		
		for(FlightxPassenger flightxPassenger : flightxPassengers) {
			tableModel.addRow(new Object[] {
					flightxPassenger.getID(), 
					flightxPassenger.getStartPoint(), 
					flightxPassenger.getEndPoint(), 
					flightxPassenger.getDateStart(), 
					flightxPassenger.getClassSeat(), 
					flightxPassenger.getTypeTicket(), 
					flightxPassenger.getStatus()
			}); 
		}
	}
}
