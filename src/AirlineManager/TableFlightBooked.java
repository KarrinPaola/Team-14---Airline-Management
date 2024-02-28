package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TableFlightBooked extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField_InputFlightCancel;
    private String userName = "";
    private JTable table; // Thêm biến table để sử dụng trong toàn bộ lớp

    /**
     * Create the panel.
     */
    public TableFlightBooked() {
        String[] columnNames = {"Mã chuyến bay", "Điểm xuất phát", "Điểm đến", "Giờ bay", "Loại vé", "Hạng vé"};

        Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        setLayout(null);

        table = new JTable(model); // Sử dụng biến table đã thêm

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(6, 78, 598, 309);

        this.add(scrollPane); 
        
        JLabel AnnoucementLabel = new JLabel("DANH SÁCH CÁC CHUYẾN BAY CỦA BẠN");
        AnnoucementLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
        AnnoucementLabel.setHorizontalAlignment(SwingConstants.CENTER);
        AnnoucementLabel.setBounds(46, 22, 516, 29);
        add(AnnoucementLabel);
        
        JLabel CancelLabel = new JLabel("Chuyến bay muốn huỷ:");
        CancelLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        CancelLabel.setBounds(11, 390, 171, 20);
        add(CancelLabel);
        
        textField_InputFlightCancel = new JTextField();
        textField_InputFlightCancel.setBounds(6, 410, 176, 30);
        add(textField_InputFlightCancel);
        textField_InputFlightCancel.setColumns(10);
        
        JButton CancelFlightButton = new JButton("Huỷ chuyến");
        CancelFlightButton.setBounds(180, 410, 117, 30);
        add(CancelFlightButton);
        
        JButton ShowAllButton = new JButton("Show All");
        ShowAllButton.setBounds(472, 395, 132, 42);
        ShowAllButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null; 
                java.sql.Statement statement = null; 
                List<Flight> flights = new ArrayList<>(); 
                
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/AirlineManagement","root", "");
                    statement = connection.createStatement(); 
                    
                    String sql = "select * from " + userName.toLowerCase(); 
                    ResultSet resultset = statement.executeQuery(sql); 
                    
                    while (resultset.next()) {
                        Flight flight = new Flight(
                                resultset.getInt("ID"),
                                resultset.getString("StartingPoint"),
                                resultset.getString("Destination"),
                                resultset.getString("DepartureTime"),
                                resultset.getString("TicketClass"),
                                resultset.getString("TicketType")
                                ); 
                        flights.add(flight); 
                    }

                    // Hiển thị dữ liệu lên bảng
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0); // Xóa các hàng cũ trong bảng

                    for (Flight flight : flights) {
                        Object[] row = { flight.getID(), flight.getStartingPoint(), flight.getDestination(), flight.getDepartureTime(), flight.getTicketClass(), flight.getTicketType() };
                        model.addRow(row);
                    }
                } catch (SQLException e1) {
                    if(statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                    }
                    if(connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                    }
                }
                
            }
        });
        add(ShowAllButton);
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
