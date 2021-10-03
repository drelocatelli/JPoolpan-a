package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ConfigController;
import Controller.UsersController;
import Partials.Header;

import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Register extends JFrame {

	JFrame currentFrame;
	private JPanel contentPane;
	private ConfigController config = new ConfigController();
	private UsersController usersController = new UsersController();
	private JTextField nomeIn;
	private JTextField emailIn;
	private JPasswordField senhaIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 536);
		setTitle(config.title);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(config.defaultColor);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 128, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 861, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(255,255,255, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 15, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Header header = new Header();
		header.setBounds(-1, 0, 373, 115);
		panel.add(header);
		header.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(config.transparency);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, -866, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -15, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 10, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, panel_2);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, -56, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, -299, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, -21, SpringLayout.EAST, panel_1);
		panel_2.setBackground(new Color(255,255,255,0));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton cadastrarBtn = new JButton("Cadastrar");
		cadastrarBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		cadastrarBtn.setBounds(147, 11, 127, 35);
		panel_2.add(cadastrarBtn);
		sl_panel_1.putConstraint(SpringLayout.WEST, cadastrarBtn, 235, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, cadastrarBtn, -508, SpringLayout.EAST, panel_1);
		cadastrarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.setVisible(true);
				currentFrame.dispose();
			}
		});
		btnVoltar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 11, 127, 35);
		panel_2.add(btnVoltar);
		
		JPanel panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panel_3);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 55, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 22, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -21, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, panel_3);
		panel_3.setBackground(new Color(255,255,255,0));
		panel_1.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Nome completo");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1, 145, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 24, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_1, -572, SpringLayout.EAST, panel_3);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1);
		
		nomeIn = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, nomeIn, 35, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, nomeIn, 145, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, nomeIn, 61, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, nomeIn, -126, SpringLayout.EAST, panel_3);
		nomeIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel_3.add(nomeIn);
		nomeIn.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("E-mail");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 15, SpringLayout.SOUTH, nomeIn);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 145, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -71, SpringLayout.EAST, panel_3);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1);
		
		emailIn = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, emailIn, 5, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_panel_3.putConstraint(SpringLayout.WEST, emailIn, 145, SpringLayout.WEST, panel_3);
		emailIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		emailIn.setColumns(10);
		panel_3.add(emailIn);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Senha");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 144, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 145, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, -71, SpringLayout.EAST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, emailIn, -18, SpringLayout.NORTH, lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_1);
		
		senhaIn = new JPasswordField();
		sl_panel_3.putConstraint(SpringLayout.WEST, senhaIn, 145, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, senhaIn, 31, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		sl_panel_3.putConstraint(SpringLayout.EAST, senhaIn, -126, SpringLayout.EAST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, emailIn, 0, SpringLayout.EAST, senhaIn);
		senhaIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		sl_panel_3.putConstraint(SpringLayout.NORTH, senhaIn, 6, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		panel_3.add(senhaIn);
		
	
		cadastrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// verifica campos vazios
				if(nomeIn.getText().isEmpty() || emailIn.getText().isEmpty() || senhaIn.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "Alguns campos estão vazios, preencha-os!", "Cadastro", JOptionPane.WARNING_MESSAGE);
				}else {					
					// cadastra usuario
					if(usersController.CadastraUser(nomeIn.getText(), emailIn.getText(), String.valueOf(senhaIn.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar, tente novamente.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					}
					
					Main main = new Main();
					currentFrame.dispose();
					main.setVisible(true);
					
				}
			}
		});
		
	}
}
