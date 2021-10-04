package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Controller.ConfigController;
import Controller.MoneyController;
import Controller.UsersController;
import Partials.Header;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private UsersController user = new UsersController();
	private ConfigController config = new ConfigController();
	private MoneyController money = new MoneyController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("", "");
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
		setBounds(100, 100, 866, 586);
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
		logoutBtn.setFont(new Font("Verdana", Font.PLAIN, 11));
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
		
		// get all user info
		String[] userLoggedIn = user.getUserInfo(email, password);
		
		JLabel lblNewLabel = new JLabel(String.format("Bem-vindo(a), %s.", userLoggedIn[0]));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.SOUTH, header);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, header);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -2, SpringLayout.WEST, header);
		panel.setBackground(new Color(255,255,255,0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 11, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 67, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, logoutBtn);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(String.format("Saldo (R$): %.2f", Double.valueOf(userLoggedIn[1]) ));
		lblNewLabel_1.setBounds(0, 11, 805, 41);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, logoutBtn);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, contentPane);
		panel_1.setBackground(config.transparency);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JButton refreshBtn = new JButton("Recarregar");
		refreshBtn.setFont(new Font("Verdana", Font.PLAIN, 11));
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				Dashboard dashboard = new Dashboard(email, password);
				dashboard.setVisible(true);
			}
		});
		sl_panel_1.putConstraint(SpringLayout.NORTH, refreshBtn, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, refreshBtn, -10, SpringLayout.EAST, panel_1);
		panel_1.add(refreshBtn);
		refreshBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, refreshBtn, -6, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, refreshBtn, -10, SpringLayout.EAST, contentPane);
		
		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 13, SpringLayout.SOUTH, refreshBtn);
		panel_2.setBackground(new Color(255,255,255,0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, -158, SpringLayout.WEST, refreshBtn);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, -6, SpringLayout.WEST, refreshBtn);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnDefinirSaldo = new JButton("Definir saldo");
		btnDefinirSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var num = JOptionPane.showInputDialog("Digite um número sem pontuação");
				
				if(!num.isEmpty()) {
					if(money.setMoney(email, password, num)) {
						JOptionPane.showMessageDialog(null, "Valor atualizado com sucesso.", "Status", JOptionPane.INFORMATION_MESSAGE);
						refreshBtn.doClick();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Número não pode ser nulo!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDefinirSaldo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDefinirSaldo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("money_transfer.png")));
		btnDefinirSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDefinirSaldo.setBounds(10, 0, 142, 25);
		btnDefinirSaldo.setFont(new Font("Verdana", Font.PLAIN, 11));
		panel_2.add(btnDefinirSaldo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.YELLOW);
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 38, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, 650, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, -56, SpringLayout.WEST, panel_2);
		panel_1.add(scrollPane);
		
	}
}
