package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(0, 0, 900, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelSignUp panelSignUp = new PanelSignUp(); 
		panelSignUp.setVisible(true);
		panelSignUp.setBounds(0, 0, 900, 600);;
		contentPane.add(panelSignUp); 
		
		ListButton listButton = new ListButton(); 
		listButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		listButton.setVisible(false);
		contentPane.add(listButton); 
		listButton.setBounds(0, 0, 200, 600);
		
		
	}

}
