package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.cj.callback.UsernameCallback;

import AirlineManager.MainPage;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * This class represents the login page of the application.
 * Users can enter their credentials and select their account type to log in.
 * They can also sign up for a new account or reset their password if needed.
 */
public class LoginPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_username;
    private JPasswordField passwordField_password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage frame = new LoginPage();
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
    public LoginPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 628);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panelMain = new JPanel();
        panelMain.setLayout(null);
        panelMain.setBorder(new LineBorder(new Color(0, 0, 0),3));
        panelMain.setBounds(207, 100, 500, 400);
        contentPane.add(panelMain);
        
        // Labels for username, password, and account type
        JLabel labelUsername = new JLabel("Tên đăng nhập");
        labelUsername.setFont(new Font("Arial", Font.BOLD, 20));
        labelUsername.setBounds(50, 110, 150, 30);
        panelMain.add(labelUsername);
        
        JLabel labelUPassword = new JLabel("Mật khẩu");
        labelUPassword.setFont(new Font("Arial", Font.BOLD, 20));
        labelUPassword.setBounds(50, 210, 150, 30);
        panelMain.add(labelUPassword);
        
        JLabel LabelWho = new JLabel("Bạn là...");
        LabelWho.setFont(new Font("Arial", Font.BOLD, 20));
        LabelWho.setBounds(50, 50, 150, 30);
        panelMain.add(LabelWho);
        
        // Text field for username input
        textField_username = new JTextField();
        textField_username.setColumns(10);
        textField_username.setBounds(45, 140, 400, 40);
        panelMain.add(textField_username);
        
        // Combo box for selecting account type
        String[] typeAccount = {"","Người dùng", "Nhà quản lý"};
        JComboBox<String> comboBox_typeAccount = new JComboBox<String>(typeAccount);
        comboBox_typeAccount.setBounds(133, 45, 170, 40);
        panelMain.add(comboBox_typeAccount);
        
        // Password field for password input
        passwordField_password = new JPasswordField();
        passwordField_password.setBounds(45, 240, 400, 40);
        panelMain.add(passwordField_password);
        
        // Button for login
        JButton buttonLogin = new JButton("Đăng nhập");
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve username, password, and account type
                String username = textField_username.getText(); 
                String password = String.valueOf(passwordField_password.getPassword()); 
                String typeAccount = comboBox_typeAccount.getSelectedItem().toString(); 
                boolean status = true; 
                
                // Validate username and password
                if(username.length() < 6 || password.length() < 6) {
                    status = false; 
                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                // Validate account type selection
                if(typeAccount.isEmpty()) {
                    status = false; 
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại tài khoản", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                // Proceed with login if all validations pass
                if (status) {
                    if (typeAccount.equals("Người dùng")) {
                        // Attempt login for user account
                        Connection connection = null; 
                        PreparedStatement statement = null; 
                        
                        try {
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "");
                            
                            String checkExit = "SELECT * FROM User_Password WHERE User = ? AND Password = ?"; 
                            statement = connection.prepareStatement(checkExit); 
                            statement.setString(1, username); 
                            statement.setString(2, password); 
                            ResultSet resultSet = statement.executeQuery(); 
                            
                            // If login successful, open user's main page
                            if(resultSet.next()) {
                                User.MainPage mainPage = new User.MainPage(); 
                                mainPage.setVisible(true); 
                                User.MainPage.setUsername(username); 
                                dispose(); 
                            } else {
                                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                            
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } finally {
                            try {
                                if(connection != null) connection.close();
                                if(statement != null) statement.close();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            } 
                        }
                    }
                    if (typeAccount.equals("Nhà quản lý")) {
                        // Attempt login for manager account
                        Connection connection = null; 
                        PreparedStatement statement = null; 
                        
                        try {
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Manager", "root", "");
                            
                            String checkExit = "SELECT * FROM Manager_Password WHERE ManagerName = ? AND Password = ?"; 
                            statement = connection.prepareStatement(checkExit); 
                            statement.setString(1, username); 
                            statement.setString(2, password); 
                            ResultSet resultSet = statement.executeQuery(); 
                            
                            // If login successful, open manager's main page
                            if(resultSet.next()) {
                                AirlineManager.MainPage mainPage = new MainPage(); 
                                mainPage.setVisible(true); 
                                AirlineManager.MainPage.setUsername(username); 
                                dispose(); 
                            } else {
                                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            }
                            
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } finally {
                            try {
                                if(connection != null) connection.close();
                                if(statement != null) statement.close();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            } 
                        }
                    }
                }
            }
        });
        buttonLogin.setFont(new Font("Arial", Font.BOLD, 20));
        buttonLogin.setBounds(175, 300, 170, 40);
        panelMain.add(buttonLogin);
        
        // Button for signing up
        JButton buttonSignUp = new JButton("Đăng ký");
        buttonSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open sign-up frame
                SignUpFrame signUpFrame = new SignUpFrame(); 
                signUpFrame.setVisible(true);
                dispose();
            }
        });
        buttonSignUp.setFont(new Font("Arial", Font.ITALIC, 13));
        buttonSignUp.setBounds(344, 364, 150, 30);
        panelMain.add(buttonSignUp);
        
        // Button for resetting password
        JButton buttonSetPasswordAgain = new JButton("Lấy lại mật khẩu");
        buttonSetPasswordAgain.setFont(new Font("Arial", Font.PLAIN, 13));
        buttonSetPasswordAgain.setBounds(6, 364, 150, 30);
        panelMain.add(buttonSetPasswordAgain);       
    }
}

