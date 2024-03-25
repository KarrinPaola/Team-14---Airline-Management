package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

// This class represents the main page of the user interface.
public class MainPage extends JFrame {

    private static final long serialVersionUID = 1L;
    
    // Panels for different functionalities
    static ListFlightPanel listFlightPanel = new ListFlightPanel(); 
    static fillInformationPanel fillInformationPanel = new fillInformationPanel(); 
    static ListFlight listFlight = new ListFlight(); 
    static PanelPay panelPay = new PanelPay(); 
    static Accountpanel accountpanel = new Accountpanel(); 
    static JPanel emptyJPanel = new JPanel();  
    
    // Variables to store username and account type
    private static String username = ""; 
    private String typeAccount = ""; 
    
    // Main method to launch the application
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
     * Create the frame.
     */
    public MainPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 900, 628);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Button for signing out
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
        
        // Panel to show welcome message or other information
        emptyJPanel.setBounds(200, 0, 700, 600);
        emptyJPanel.setVisible(true);
        contentPane.add(emptyJPanel); 
        emptyJPanel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Chào mừng quý khách ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 39));
        lblNewLabel_1.setBounds(101, 187, 500, 242);
        emptyJPanel.add(lblNewLabel_1);
        
        // Adding panels for different functionalities
        contentPane.add(listFlightPanel); 
        contentPane.add(fillInformationPanel); 
        contentPane.add(panelPay); 
        contentPane.add(listFlight); 
        contentPane.add(accountpanel); 
        
        // Panel for navigating between functionalities
        JPanel PanelListButton = new JPanel();
        PanelListButton.setBorder(new LineBorder(new Color(0, 0, 0)));
        PanelListButton.setBounds(0, 0, 200, 600);
        contentPane.add(PanelListButton);
        PanelListButton.setLayout(null);
        
        // Button to book flights
        JButton buttonBookFlight = new JButton("Đặt chuyến");
        buttonBookFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listFlightPanel.setVisible(true);
                listFlight.setVisible(false);
                accountpanel.setVisible(false);
                fillInformationPanel.setVisible(false);
                panelPay.setVisible(false);
                emptyJPanel.setVisible(false);
            }
        });
        buttonBookFlight.setFont(new Font("Arial", Font.BOLD, 22));
        buttonBookFlight.setBounds(10, 61, 180, 80);
        PanelListButton.add(buttonBookFlight);
        
        // Button to view booked flights
        JButton buttonListFlight = new JButton("Xem chuyến");
        buttonListFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emptyJPanel.setVisible(false);
                listFlightPanel.setVisible(false);
                listFlight.setVisible(true);
                accountpanel.setVisible(false);
                fillInformationPanel.setVisible(false);
                panelPay.setVisible(false);
                
                // Display all booked flights
                listFlight.showAllFlight();
            }
        });
        buttonListFlight.setFont(new Font("Arial", Font.BOLD, 22));
        buttonListFlight.setBounds(10, 261, 180, 80);
        PanelListButton.add(buttonListFlight);
        
        // Button to access account information
        JButton buttonAccount = new JButton("Tài khoản");
        buttonAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listFlightPanel.setVisible(false);
                listFlight.setVisible(false);
                accountpanel.setVisible(true);
                fillInformationPanel.setVisible(false);
                panelPay.setVisible(false);
                emptyJPanel.setVisible(false);
                button_SignOut.setVisible(true);
            }
        });
        buttonAccount.setFont(new Font("Arial", Font.BOLD, 22));
        buttonAccount.setBounds(10, 461, 180, 80);
        PanelListButton.add(buttonAccount);
    }

    // Getter for username
    public static String getUsername() {
        return username;
    }

    // Setter for username
    public static void setUsername(String username) {
        MainPage.username = username;
    }

    // Getter for account type
    public String getTypeAccount() {
        return typeAccount;
    }

    // Setter for account type
    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }
    
}
