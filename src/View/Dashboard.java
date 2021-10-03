package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Controller.ConfigController;
import Controller.UsersController;
import Partials.Header;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private UsersController user = new UsersController();
	private ConfigController config = new ConfigController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("admin", "009112sp");
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
	public Dashboard(String email, String password) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 539);
		contentPane = new JPanel();
		contentPane.setBackground(config.defaultColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
		currentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		contentPane.setLayout(null);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		Header header = new Header();
		sl_contentPane.putConstraint(SpringLayout.NORTH, header, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, header, 28, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, header, 117, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, header, 516, SpringLayout.WEST, contentPane);
		header.setBounds(169, 23, 488, 107);
		contentPane.add(header);
		header.setLayout(null);
		
		JButton logoutBtn = new JButton("Encerrar sess\u00E3o");
		logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				currentFrame.dispose();
				main.setVisible(true);
			}
		});
		logoutBtn.setForeground(Color.DARK_GRAY);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, logoutBtn, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, logoutBtn, -10, SpringLayout.EAST, contentPane);
		contentPane.add(logoutBtn);
		
		String[] userLoggedIn = user.getUserInfo(email, password);
		
		JLabel lblNewLabel = new JLabel(String.format("Bem-vindo(a), %s.", userLoggedIn[0]));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.SOUTH, header);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, header);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(config.transparency);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -23, SpringLayout.WEST, header);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, logoutBtn);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, logoutBtn);
		contentPane.add(panel);
		
	}
}
