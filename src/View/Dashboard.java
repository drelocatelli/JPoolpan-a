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
import javax.swing.ScrollPaneConstants;
import java.awt.Frame;

import View.Dashboard;

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
		sl_contentPane.putConstraint(SpringLayout.NORTH, header, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, header, 38, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, header, 127, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, header, 526, SpringLayout.WEST, contentPane);
		contentPane.add(header);
		header.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238, 70));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, header);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -28, SpringLayout.WEST, header);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -15, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -8, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, -337, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(255,255,255,0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 48, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRecarregar = new JButton("Recarregar");
		btnRecarregar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("refresh.png")));
		btnRecarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				Dashboard dashboard = new Dashboard(email, password);
				dashboard.setVisible(true);
			}
		});
		btnRecarregar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRecarregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecarregar.setBounds(162, 0, 165, 38);
		panel_1.add(btnRecarregar);
		
		JButton saldoBtn = new JButton("Definir saldo");
		saldoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newSaldo = Integer.valueOf(JOptionPane.showInputDialog(null, "Defina um saldo (sem pontuação|apenas números):", "Definir saldo", JOptionPane.DEFAULT_OPTION));
				if(newSaldo >= 0) {
					if(money.setMoney(email, password, newSaldo)) {
						JOptionPane.showMessageDialog(null, "Saldo atualizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
						btnRecarregar.doClick();
					}else {
						JOptionPane.showMessageDialog(null, "Não foi possível atualizar saldo!", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		saldoBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		saldoBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("money_transfer.png")));
		saldoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saldoBtn.setBounds(0, 0, 154, 38);
		panel_1.add(saldoBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,0,0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, -54, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, -204, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton logoutBtn = new JButton("<html>&nbsp;&nbsp;Encerrar sess\u00E3o</html>");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				Main main = new Main();
				main.setVisible(true);
			}
		});
		logoutBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		logoutBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("logout-icon.png")));
		logoutBtn.setBounds(12, 12, 182, 32);
		panel_2.add(logoutBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0,0,0,0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, 91, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, -6, SpringLayout.WEST, panel_1);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setText(user.getUserInfo(email, password)[0]);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 12, 445, 16);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setText("Saldo atual: R$ "+ user.getUserInfo(email, password)[1]);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 50, 445, 16);
		panel_3.add(lblNewLabel_1);
		
		
		
	}
}
