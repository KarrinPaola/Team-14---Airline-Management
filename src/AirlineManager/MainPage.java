package AirlineManager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import User.LoginPage;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static String username;
    static PanelAccount panelAccount = new PanelAccount();
    static PanelAddNewFlight panelAddNewFlight = new PanelAddNewFlight();
    static PanelConfirm panelConfirm = new PanelConfirm();
    static PanelListFlight panelListFlight = new PanelListFlight();
    static JPanel emptyJPanel = new JPanel();

    /**
     * Phương thức main để khởi tạo ứng dụng
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainPage frame = new MainPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Phương thức khởi tạo của frame
     */
    public MainPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 900, 628);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Nút đăng xuất
        JButton button_SignOut = new JButton("Đăng xuất");
        button_SignOut.setFont(new Font("Arial", Font.BOLD, 20));
        button_SignOut.setBounds(724, 554, 170, 40);
        contentPane.add(button_SignOut);
        button_SignOut.setVisible(false);
        button_SignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainPage.setUsername(""); 
                LoginPage loginPage = new LoginPage(); 
                loginPage.setVisible(true);
                dispose();
            }
        });
        contentPane.add(button_SignOut); 
        emptyJPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

        emptyJPanel.setBounds(200, 0, 700, 600);
        emptyJPanel.setVisible(true);
        emptyJPanel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 39));
        lblNewLabel_1.setBounds(101, 187, 500, 242);
        emptyJPanel.add(lblNewLabel_1);
        contentPane.add(emptyJPanel); 

        panelAddNewFlight.setBorder(new LineBorder(new Color(0, 0, 0)));

        // Panel thêm chuyến bay
        panelAddNewFlight.setBounds(200, 0, 700, 600);
        panelAddNewFlight.setVisible(false);
        contentPane.add(panelAddNewFlight); 
        panelAccount.setBorder(new LineBorder(new Color(0, 0, 0)));

        // Panel tài khoản
        panelAccount.setBounds(200, 0, 700, 600);
        panelAccount.setVisible(false);
        contentPane.add(panelAccount); 
        panelListFlight.setBorder(new LineBorder(new Color(0, 0, 0)));

        // Panel hiện danh sách chuyến bay
        panelListFlight.setBounds(200, 0, 700, 600);
        panelListFlight.setVisible(false);
        contentPane.add(panelListFlight); 

        // Panel xác nhận
        panelConfirm.setBounds(200, 0, 700, 600);
        panelConfirm.setVisible(false);
        contentPane.add(panelConfirm); 

        // Button Thêm chuyến
        JButton btnNewButton = new JButton("Thêm chuyến");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emptyJPanel.setVisible(false);
                panelAddNewFlight.setVisible(true);
                panelAccount.setVisible(false);
                panelConfirm.setVisible(false);
                panelListFlight.setVisible(false);
            }
        });
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 25));
        btnNewButton.setBounds(6, 100, 182, 50);
        contentPane.add(btnNewButton);

        // Button Xem chuyến
        JButton btnXemChuyn = new JButton("Xem chuyến");
        btnXemChuyn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emptyJPanel.setVisible(false);
                panelAddNewFlight.setVisible(false);
                panelAccount.setVisible(false);
                panelConfirm.setVisible(false);
                panelListFlight.setVisible(true);
                panelListFlight.showAllFlight();
            }
        });
        btnXemChuyn.setFont(new Font("Arial", Font.BOLD, 25));
        btnXemChuyn.setBounds(6, 280, 182, 50);
        contentPane.add(btnXemChuyn);

        // Button Tài khoản
        JButton btnTaiKhoan = new JButton("Tài khoản");
        btnTaiKhoan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emptyJPanel.setVisible(false);
                panelAddNewFlight.setVisible(false);
                panelAccount.setVisible(false);
                panelConfirm.setVisible(true);
                panelListFlight.setVisible(false);
            }
        });
        btnTaiKhoan.setFont(new Font("Arial", Font.BOLD, 25));
        btnTaiKhoan.setBounds(6, 450, 182, 50);
        contentPane.add(btnTaiKhoan);
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MainPage.username = username;
    }
}
