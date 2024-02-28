package AirlineManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TableFlightBooked extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField_InputFlightCancel;

    /**
     * Create the panel.
     */
    public TableFlightBooked() {
        String[] columnNames = {"Mã chuyến bay", "Điểm xuất phát", "Điểm đến", "Giờ bay", "Loại vé", "Hạng vé"};

        Object[][] data = {};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        setLayout(null);

        JTable table = new JTable(model);

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
        add(ShowAllButton);
    }
}
