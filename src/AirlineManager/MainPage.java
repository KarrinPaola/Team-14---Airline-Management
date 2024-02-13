package AirlineManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane bookingFlightLayeredPanel;
	private JLayeredPane managingFlightLayerPanel;
	private JLayeredPane accountLayerPanel;
	private JPanel menuPanel; 
    private JPanel contentPane;
    private JPanel welcomePanel;
    private JPanel paymentPanel;
    private JPanel successPanel;
    private JPanel fillInforPanel;
    private JPanel accountPanel; 
    private JPanel managementPanel;
    private JPanel changePasswordPanel;
    private JPanel changePasswordInnerPanel;
    private JTextField textField_Name;
    private JTextField textField_CMND;
    private JTextField textField_Phone;
    private JTextField textField_Address;
    private JTextField textField_Place_From;
    private JTextField textField_Place_To;
    private JTextField textField_Time_Start;
    private JTextField textField_Level_Ticket;
    private JTextField textField_Type_Ticket;
    private JTextField textField_ID;
    private JTextField textField_TotalPay;
    private JTextField textField_newPasswordAgain;
    private JTextField textField_newPassword;
    private JTextField textField_oldPassword;
    private JTextField textField_addressAccount;
    private JTextField textField_NameAccount;
    private JTextField textField_phoneNumberAccount;
    private JTextField textField_CCCDAccount;
    
    // Buttons
    private JButton bookFlightButton; 
    private JButton manageFlightButton;
    private JButton accountButton;
    private JButton bookAnotherButton;
    private JButton mainMenuButton;
    private JButton payButton;
    private JButton bookButton;
    private JButton confirmButton;
    private JButton changeInforButton;
    private JButton saveInforButton;
    private JButton changePasswordButton;
    private JButton signOutButton;
    
    // ComboBoxes
    private JComboBox<String> comboBox_Date;
    private JComboBox<String> comboBox_Month;
    private JComboBox<String> comboBox_Year;
    private JComboBox<String> comboBox_Nationality;
    private JComboBox<String> comboBox_Departure;
    private JComboBox<String> comboBox_Destination;
    private JComboBox<String> comboBox_NationalityAccount;
    private JComboBox comboBox_DateAccount;
    private JComboBox comboBox_MonthAccount;
    private JComboBox comboBox_YearAccount;

    // Checkboxes
    private JCheckBox maleCheckBox;
    private JCheckBox femaleCheckBox;
    private JCheckBox economyClassCheckBox;
    private JCheckBox businessClassCheckBox;
    private JCheckBox oneWayCheckBox;
    private JCheckBox roundTripCheckBox;
    
    //Label 
    private JLabel nameAccountLabel;
    private JLabel dateAccountLabel;
    private JLabel monthAccountLabel;
    private JLabel yearAccountLabel;
    private JLabel CCCDAccountLabel;
    private JLabel phoneNumberAccountLabel;
    private JLabel sexAccountLabel;
    private JLabel nationalityAccountLabel;
    private JLabel addressAccountLabel;
    private JLabel changePasswordLabel;
    private JLabel oldPasswordLabel;
    private JLabel newPassordLabel;
    private JLabel newPasswordAgainLabel;
    
    

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Bảng tuỳ chọn --------------------------------------------------
		menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPanel.setBounds(0, 0, 178, 457);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		bookFlightButton = new JButton("Đặt chuyến");
		bookFlightButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		bookFlightButton.setBounds(6, 115, 166, 50);
		menuPanel.add(bookFlightButton);
		
		manageFlightButton = new JButton("Quản lý chuyến bay");
		manageFlightButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		manageFlightButton.setBounds(6, 200, 166, 50);
		menuPanel.add(manageFlightButton);
		
		accountButton = new JButton("Tài khoản");
		accountButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		accountButton.setBounds(6, 285, 166, 50);
		menuPanel.add(accountButton);
		
		//Tài khoản --------------------------------------------------
		accountLayerPanel = new JLayeredPane();
		accountLayerPanel.setBounds(178, 0, 672, 457);
		contentPane.add(accountLayerPanel);
		
		changePasswordPanel = new JPanel();
		accountLayerPanel.setLayer(changePasswordPanel, 1);
		changePasswordPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		changePasswordPanel.setBounds(0, 0, 672, 457);
		accountLayerPanel.add(changePasswordPanel);
		changePasswordPanel.setLayout(null);
		
		changePasswordInnerPanel = new JPanel();
		changePasswordInnerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		changePasswordInnerPanel.setBounds(110, 70, 450, 305);
		changePasswordPanel.add(changePasswordInnerPanel);
		changePasswordInnerPanel.setLayout(null);
		
		changePasswordLabel = new JLabel("Đổi mật khẩu");
		changePasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		changePasswordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		changePasswordLabel.setBounds(95, 15, 265, 30);
		changePasswordInnerPanel.add(changePasswordLabel);
		
		oldPasswordLabel = new JLabel("Mật khẩu cũ:");
		oldPasswordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		oldPasswordLabel.setBounds(45, 60, 120, 20);
		changePasswordInnerPanel.add(oldPasswordLabel);
		
		textField_oldPassword = new JTextField();
		textField_oldPassword.setBounds(40, 80, 370, 30);
		changePasswordInnerPanel.add(textField_oldPassword);
		textField_oldPassword.setColumns(10);
		
		newPassordLabel = new JLabel("Mật khẩu mới:");
		newPassordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		newPassordLabel.setBounds(45, 130, 120, 20);
		changePasswordInnerPanel.add(newPassordLabel);
		
		textField_newPassword = new JTextField();
		textField_newPassword.setColumns(10);
		textField_newPassword.setBounds(40, 150, 370, 30);
		changePasswordInnerPanel.add(textField_newPassword);
		
		newPasswordAgainLabel = new JLabel("Nhập lại mật khẩu mới: ");
		newPasswordAgainLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		newPasswordAgainLabel.setBounds(45, 200, 208, 20);
		changePasswordInnerPanel.add(newPasswordAgainLabel);
		
		textField_newPasswordAgain = new JTextField();
		textField_newPasswordAgain.setColumns(10);
		textField_newPasswordAgain.setBounds(40, 220, 370, 30);
		changePasswordInnerPanel.add(textField_newPasswordAgain);
		
		confirmButton = new JButton("Xác nhận");
		confirmButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		confirmButton.setBounds(168, 262, 125, 35);
		changePasswordInnerPanel.add(confirmButton);
		
		accountPanel = new JPanel();
		accountPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		accountPanel.setBounds(0, 0, 672, 457);
		accountLayerPanel.add(accountPanel);
		accountPanel.setLayout(null);
		
		nameAccountLabel = new JLabel("Họ và tên:");
		nameAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		nameAccountLabel.setBounds(25, 10, 105, 20);
		accountPanel.add(nameAccountLabel);
		
		dateAccountLabel = new JLabel("Ngày:");
		dateAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		dateAccountLabel.setBounds(25, 75, 50, 20);
		accountPanel.add(dateAccountLabel);
		
		monthAccountLabel = new JLabel("Tháng:");
		monthAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		monthAccountLabel.setBounds(120, 75, 60, 20);
		accountPanel.add(monthAccountLabel);
		
		yearAccountLabel = new JLabel("Năm:");
		yearAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		yearAccountLabel.setBounds(225, 75, 50, 20);
		accountPanel.add(yearAccountLabel);
		
		CCCDAccountLabel = new JLabel("CMND/CCCD");
		CCCDAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		CCCDAccountLabel.setBounds(25, 115, 105, 20);
		accountPanel.add(CCCDAccountLabel);
		
		phoneNumberAccountLabel = new JLabel("Số điện thoại:");
		phoneNumberAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		phoneNumberAccountLabel.setBounds(25, 185, 148, 20);
		accountPanel.add(phoneNumberAccountLabel);
		
		sexAccountLabel = new JLabel("Giới tính: ");
		sexAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		sexAccountLabel.setBounds(25, 255, 88, 20);
		accountPanel.add(sexAccountLabel);
		
		nationalityAccountLabel = new JLabel("Dân tộc: ");
		nationalityAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		nationalityAccountLabel.setBounds(25, 300, 76, 20);
		accountPanel.add(nationalityAccountLabel);
		
		addressAccountLabel = new JLabel("Địa chỉ:");
		addressAccountLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		addressAccountLabel.setBounds(25, 345, 66, 20);
		accountPanel.add(addressAccountLabel);
		
		textField_addressAccount = new JTextField();
		textField_addressAccount.setBounds(20, 365, 311, 30);
		accountPanel.add(textField_addressAccount);
		textField_addressAccount.setColumns(10);
		
		comboBox_NationalityAccount = new JComboBox();
		comboBox_NationalityAccount.setMaximumRowCount(5);
		comboBox_NationalityAccount.setBounds(99, 295, 137, 30);
		accountPanel.add(comboBox_NationalityAccount);
		
		JCheckBox maleAccountCheckBox = new JCheckBox("Nam");
		maleAccountCheckBox.setBounds(110, 250, 70, 30);
		accountPanel.add(maleAccountCheckBox);
		
		JCheckBox femaleAccountCheckBox = new JCheckBox("Nữ");
		femaleAccountCheckBox.setBounds(170, 250, 70, 30);
		accountPanel.add(femaleAccountCheckBox);
		
		textField_phoneNumberAccount = new JTextField();
		textField_phoneNumberAccount.setColumns(10);
		textField_phoneNumberAccount.setBounds(20, 205, 311, 30);
		accountPanel.add(textField_phoneNumberAccount);
		
		textField_CCCDAccount = new JTextField();
		textField_CCCDAccount.setColumns(10);
		textField_CCCDAccount.setBounds(20, 135, 311, 30);
		accountPanel.add(textField_CCCDAccount);
		
		comboBox_DateAccount = new JComboBox();
		comboBox_DateAccount.setBounds(70, 70, 50, 30);
		accountPanel.add(comboBox_DateAccount);
		
		comboBox_MonthAccount = new JComboBox();
		comboBox_MonthAccount.setBounds(175, 70, 50, 30);
		accountPanel.add(comboBox_MonthAccount);
		
		comboBox_YearAccount = new JComboBox();
		comboBox_YearAccount.setBounds(265, 70, 65, 30);
		accountPanel.add(comboBox_YearAccount);
		
		textField_NameAccount = new JTextField();
		textField_NameAccount.setColumns(10);
		textField_NameAccount.setBounds(20, 30, 311, 30);
		accountPanel.add(textField_NameAccount);
		
		changeInforButton = new JButton("Sửa");
		changeInforButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		changeInforButton.setBounds(41, 410, 117, 35);
		accountPanel.add(changeInforButton);
		
		saveInforButton = new JButton("Lưu");
		saveInforButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		saveInforButton.setBounds(183, 410, 117, 35);
		accountPanel.add(saveInforButton);
		
		changePasswordButton = new JButton("Đổi mật khẩu");
		changePasswordButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		changePasswordButton.setBounds(485, 345, 155, 50);
		accountPanel.add(changePasswordButton);
		
		signOutButton = new JButton("Đăng xuất");
		signOutButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		signOutButton.setBounds(485, 395, 155, 50);
		accountPanel.add(signOutButton);
		
		accountLayerPanel.setVisible(false); 
		
		//Quản lý chuyến bay --------------------------------------------------------------------
		managingFlightLayerPanel = new JLayeredPane();
		managingFlightLayerPanel.setBounds(178, 0, 672, 457);
		contentPane.add(managingFlightLayerPanel);
		
		managementPanel = new JPanel();
		managementPanel.setBounds(0, 0, 672, 457);
		managingFlightLayerPanel.add(managementPanel);
		
		// Bảng hiển thị --------------------------------------------------------------------
		bookingFlightLayeredPanel = new JLayeredPane();
		bookingFlightLayeredPanel.setBounds(178, 0, 672, 457);
		contentPane.add(bookingFlightLayeredPanel);
		
		// Đặt chuyến thành công ------------------------------------------------------------
		successPanel = new JPanel();
		bookingFlightLayeredPanel.setLayer(successPanel, 3);
		successPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		successPanel.setBounds(0, 0, 672, 457);
		bookingFlightLayeredPanel.add(successPanel);
		successPanel.setLayout(null);
		
		JPanel successInnerPanel = new JPanel();
		successInnerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		successInnerPanel.setBounds(114, 93, 448, 275);
		successPanel.add(successInnerPanel);
		successInnerPanel.setLayout(null);
		
		JLabel successLabel = new JLabel("Quý khách đã đặt chuyến thành công");
		successLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		successLabel.setHorizontalAlignment(SwingConstants.CENTER);
		successLabel.setBounds(33, 45, 391, 30);
		successInnerPanel.add(successLabel);
		
		bookAnotherButton = new JButton("Đặt chuyến khác");
		bookAnotherButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		bookAnotherButton.setBounds(36, 195, 140, 45);
		successInnerPanel.add(bookAnotherButton);
		
		mainMenuButton = new JButton("Màn hình chính");
		mainMenuButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		mainMenuButton.setBounds(280, 195, 140, 45);
		successInnerPanel.add(mainMenuButton);
		
		successPanel.setEnabled(false);
		successPanel.setVisible(false);
		
		// Thanh toán tiền ----------------------------------------------------------
		paymentPanel = new JPanel();
		bookingFlightLayeredPanel.setLayer(paymentPanel, 2);
		paymentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		paymentPanel.setBounds(0, 0, 672, 457);
		bookingFlightLayeredPanel.add(paymentPanel);
		paymentPanel.setLayout(null);
		
		JPanel paymentInnerPanel = new JPanel();
		paymentInnerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		paymentInnerPanel.setBounds(125, 6, 415, 445);
		paymentPanel.add(paymentInnerPanel);
		paymentInnerPanel.setLayout(null);
		
		JLabel invoiceLabel = new JLabel("Hoá đơn");
		invoiceLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		invoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invoiceLabel.setBounds(119, 10, 174, 20);
		paymentInnerPanel.add(invoiceLabel);
		
		JLabel flightLabel = new JLabel("Chặng bay:");
		flightLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		flightLabel.setBounds(55, 50, 107, 20);
		paymentInnerPanel.add(flightLabel);
		
		textField_Place_From = new JTextField();
		textField_Place_From.setEditable(false);
		textField_Place_From.setBounds(50, 80, 140, 30);
		paymentInnerPanel.add(textField_Place_From);
		textField_Place_From.setColumns(10);
		
		textField_Place_To = new JTextField();
		textField_Place_To.setEditable(false);
		textField_Place_To.setColumns(10);
		textField_Place_To.setBounds(225, 80, 140, 30);
		paymentInnerPanel.add(textField_Place_To);
		
		JLabel toLabel = new JLabel("To");
		toLabel.setHorizontalAlignment(SwingConstants.CENTER);
		toLabel.setBounds(177, 87, 61, 16);
		paymentInnerPanel.add(toLabel);
		
		JLabel startTimeLabel = new JLabel("Thời gian khởi hành:");
		startTimeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		startTimeLabel.setBounds(55, 120, 226, 20);
		paymentInnerPanel.add(startTimeLabel);
		
		textField_Time_Start = new JTextField();
		textField_Time_Start.setEditable(false);
		textField_Time_Start.setColumns(10);
		textField_Time_Start.setBounds(50, 145, 315, 30);
		paymentInnerPanel.add(textField_Time_Start);
		
		JLabel ticketLevelLabel = new JLabel("Hạng vé:");
		ticketLevelLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		ticketLevelLabel.setBounds(55, 185, 77, 20);
		paymentInnerPanel.add(ticketLevelLabel);
		
		textField_Level_Ticket = new JTextField();
		textField_Level_Ticket.setEditable(false);
		textField_Level_Ticket.setBounds(50, 210, 130, 30);
		paymentInnerPanel.add(textField_Level_Ticket);
		textField_Level_Ticket.setColumns(10);
		
		JLabel ticketTypeLabel = new JLabel("Loại vé: ");
		ticketTypeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		ticketTypeLabel.setBounds(55, 250, 77, 20);
		paymentInnerPanel.add(ticketTypeLabel);
		
		textField_Type_Ticket = new JTextField();
		textField_Type_Ticket.setEditable(false);
		textField_Type_Ticket.setColumns(10);
		textField_Type_Ticket.setBounds(50, 275, 130, 30);
		paymentInnerPanel.add(textField_Type_Ticket);
		
		JLabel flightIDLabel = new JLabel("Mã chuyến: ");
		flightIDLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		flightIDLabel.setBounds(225, 200, 130, 20);
		paymentInnerPanel.add(flightIDLabel);
		
		textField_ID = new JTextField();
		textField_ID.setEditable(false);
		textField_ID.setColumns(10);
		textField_ID.setBounds(220, 225, 145, 30);
		paymentInnerPanel.add(textField_ID);
		
		JPanel paymentSeparatorPanel = new JPanel();
		paymentSeparatorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		paymentSeparatorPanel.setBounds(114, 353, 300, 1);
		paymentInnerPanel.add(paymentSeparatorPanel);
		
		JLabel totalPaymentLabel = new JLabel("Tổng tiền:");
		totalPaymentLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		totalPaymentLabel.setBounds(177, 334, 84, 16);
		paymentInnerPanel.add(totalPaymentLabel);
		
		textField_TotalPay = new JTextField();
		textField_TotalPay.setEditable(false);
		textField_TotalPay.setColumns(10);
		textField_TotalPay.setBounds(257, 358, 152, 30);
		paymentInnerPanel.add(textField_TotalPay);
		
		payButton = new JButton("Thanh toán");
		payButton.setFont(new Font("Lucida Grande", Font.BOLD, 17));
		payButton.setBounds(6, 388, 156, 51);
		paymentInnerPanel.add(payButton);
		
		paymentPanel.setVisible(false);
		paymentPanel.setEnabled(false);
		
		// Điền thông tin ----------------------------------------------------------
		fillInforPanel = new JPanel();
		bookingFlightLayeredPanel.setLayer(fillInforPanel, 1);
		fillInforPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		fillInforPanel.setBackground(UIManager.getColor("Panel.background"));
		fillInforPanel.setBounds(0, 0, 672, 457);
		bookingFlightLayeredPanel.add(fillInforPanel);
		fillInforPanel.setLayout(null);
		
		JLabel titleLable = new JLabel("Mời quý khách nhập các thông tin sau:");
		titleLable.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		titleLable.setBounds(127, 6, 402, 38);
		fillInforPanel.add(titleLable);
		
		JLabel nameLabel = new JLabel("Họ và tên:");
		nameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		nameLabel.setBounds(22, 53, 71, 20);
		fillInforPanel.add(nameLabel);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textField_Name.setBounds(20, 73, 292, 35);
		fillInforPanel.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel dateLabel = new JLabel("Ngày");
		dateLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		dateLabel.setBounds(22, 128, 35, 20);
		fillInforPanel.add(dateLabel);
		
		comboBox_Date = new JComboBox();
		comboBox_Date.setMaximumRowCount(31);
		comboBox_Date.setBounds(58, 126, 50, 25);
		fillInforPanel.add(comboBox_Date);
		
		JLabel monthLabel = new JLabel("Tháng");
		monthLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		monthLabel.setBounds(108, 128, 45, 20);
		fillInforPanel.add(monthLabel);
		
		comboBox_Month = new JComboBox();
		comboBox_Month.setMaximumRowCount(12);
		comboBox_Month.setBounds(155, 126, 50, 25);
		fillInforPanel.add(comboBox_Month);
		
		JLabel yearLabel = new JLabel("Năm");
		yearLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		yearLabel.setBounds(208, 128, 35, 20);
		fillInforPanel.add(yearLabel);
		
		comboBox_Year = new JComboBox();
		comboBox_Year.setMaximumRowCount(2024);
		comboBox_Year.setBounds(243, 126, 69, 25);
		fillInforPanel.add(comboBox_Year);
		
		JLabel idLabel = new JLabel("CMND/CCCD");
		idLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		idLabel.setBounds(22, 171, 131, 20);
		fillInforPanel.add(idLabel);
		
		textField_CMND = new JTextField();
		textField_CMND.setColumns(10);
		textField_CMND.setBounds(20, 191, 292, 35);
		fillInforPanel.add(textField_CMND);
		
		JLabel phoneLabel = new JLabel("Số điện thoại");
		phoneLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		phoneLabel.setBounds(22, 246, 131, 20);
		fillInforPanel.add(phoneLabel);
		
		textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(20, 266, 292, 35);
		fillInforPanel.add(textField_Phone);
		
		JLabel nationalityLabel = new JLabel("Dân tộc:");
		nationalityLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		nationalityLabel.setBounds(22, 321, 71, 20);
		fillInforPanel.add(nationalityLabel);
		
		JLabel addressLabel = new JLabel("Địa chỉ: ");
		addressLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		addressLabel.setBounds(22, 396, 131, 20);
		fillInforPanel.add(addressLabel);
		
		textField_Address = new JTextField();
		textField_Address.setColumns(10);
		textField_Address.setBounds(20, 416, 292, 35);
		fillInforPanel.add(textField_Address);
		
		comboBox_Nationality = new JComboBox();
		comboBox_Nationality.setMaximumRowCount(54);
		comboBox_Nationality.setBounds(88, 316, 116, 30);
		fillInforPanel.add(comboBox_Nationality);
		
		JLabel genderLabel = new JLabel("Giới tính: ");
		genderLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		genderLabel.setBounds(22, 353, 73, 20);
		fillInforPanel.add(genderLabel);
		
		maleCheckBox = new JCheckBox("Nam");
		maleCheckBox.setBounds(94, 353, 61, 20);
		fillInforPanel.add(maleCheckBox);
		
		femaleCheckBox = new JCheckBox("Nữ");
		femaleCheckBox.setBounds(157, 353, 61, 20);
		fillInforPanel.add(femaleCheckBox);
		
		JLabel departureLabel = new JLabel("Vị trí xuất phát:");
		departureLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		departureLabel.setBounds(365, 53, 116, 20);
		fillInforPanel.add(departureLabel);
		
		comboBox_Departure = new JComboBox();
		comboBox_Departure.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox_Departure.setBounds(360, 73, 175, 35);
		fillInforPanel.add(comboBox_Departure);
		
		JLabel destinationLabel = new JLabel("Điểm đến ");
		destinationLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		destinationLabel.setBounds(365, 128, 77, 20);
		fillInforPanel.add(destinationLabel);
		
		comboBox_Destination = new JComboBox();
		comboBox_Destination.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox_Destination.setBounds(360, 148, 175, 35);
		fillInforPanel.add(comboBox_Destination);
		
		JLabel ticketClassLabel = new JLabel("Hạng vé");
		ticketClassLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		ticketClassLabel.setBounds(365, 203, 77, 20);
		fillInforPanel.add(ticketClassLabel);
		
		economyClassCheckBox = new JCheckBox("Phổ thông");
		economyClassCheckBox.setBounds(360, 235, 128, 25);
		fillInforPanel.add(economyClassCheckBox);
		
		businessClassCheckBox = new JCheckBox("Thương gia");
		businessClassCheckBox.setBounds(500, 235, 128, 25);
		fillInforPanel.add(businessClassCheckBox);
		
		JLabel ticketTypeLabel_1 = new JLabel("Loại vé");
		ticketTypeLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		ticketTypeLabel_1.setBounds(365, 272, 77, 20);
		fillInforPanel.add(ticketTypeLabel_1);
		
		oneWayCheckBox = new JCheckBox("Một chiều ");
		oneWayCheckBox.setBounds(360, 304, 128, 25);
		fillInforPanel.add(oneWayCheckBox);
		
		roundTripCheckBox = new JCheckBox("Khứ hồi");
		roundTripCheckBox.setBounds(500, 304, 128, 25);
		fillInforPanel.add(roundTripCheckBox);
		
		bookButton = new JButton("Đặt chuyến");
		bookButton.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		bookButton.setBounds(415, 385, 131, 46);
		fillInforPanel.add(bookButton);
		
		fillInforPanel.setEnabled(false); 
		fillInforPanel.setVisible(false); 
		
		// Giao diện chào mừng ----------------------------------------------------
		welcomePanel = new JPanel();
		welcomePanel.setBounds(0, 0, 672, 457);
		bookingFlightLayeredPanel.add(welcomePanel);
		welcomePanel.setBackground(new Color(238, 238, 238));
		welcomePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		welcomePanel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Mời quý khách chọn chức năng...");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		welcomeLabel.setBounds(125, 124, 419, 196);
		welcomePanel.add(welcomeLabel);
	}
}