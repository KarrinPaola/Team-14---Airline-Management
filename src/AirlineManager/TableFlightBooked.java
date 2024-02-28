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

public class TableFlightBooked extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;

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
        
        JLabel lblNewLabel = new JLabel("Chuyến bay muốn huỷ:");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblNewLabel.setBounds(80, 414, 171, 20);
        add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(248, 409, 130, 30);
        add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Huỷ chuyến");
        btnNewButton.setBounds(388, 409, 117, 30);
        add(btnNewButton);
    }
}
