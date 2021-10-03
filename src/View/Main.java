package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Insets;
import javax.swing.SwingConstants;

import Partials.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.ConfigController;
import Controller.UsersController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	JFrame currentFrame;

	private JPanel contentPane;
	private JTextField emailIn;
	private JPasswordField senhaIn;
	
	private ConfigController config = new ConfigController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setTitle(config.title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 557);
		contentPane = new JPanel();

		contentPane.setBackground(config.defaultColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
		contentPane.setLayout(null);

		Header header = new Header();
		header.setBounds(182, 23, 475, 107);
		contentPane.add(header);
		header.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(169, 148, 488, 310);
		panel.setBackground(config.transparency);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(79, 71, 265, 26);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		panel.add(lblNewLabel_1);

		emailIn = new JTextField();
		emailIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					try {
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_TAB);
					}catch(AWTException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		emailIn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailIn.selectAll();
			}
		});
		emailIn.setText("exemplo@email.com");
		emailIn.setBounds(79, 103, 341, 33);
		emailIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		panel.add(emailIn);
		emailIn.setColumns(10);

		senhaIn = new JPasswordField("*****");

		JButton logatBtn = new JButton("<html>&nbsp;&nbsp;Login</html>");
		logatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersController usersController = new UsersController();
				boolean checkUser = usersController.checkUser( emailIn.getText(), new String(senhaIn.getPassword()) );

				int delay = 700;

				if(checkUser) {
					new Thread(() -> {
						try {
							Thread.sleep(delay);
							currentFrame.dispose();
							Dashboard dashboard = new Dashboard( emailIn.getText(), new String(senhaIn.getPassword()) );
							dashboard.setVisible(true);
						}
						catch (Exception err){
							System.err.println(err);
						}}).start();
				}else {
					new Thread(() -> {
						try {
							Thread.sleep(delay);
							JOptionPane.showMessageDialog(null, "E-mail e senha não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
						}catch(Exception err) {
							err.printStackTrace();
						} }).start();
				}

			}
		});
		logatBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("keys-icon.png")));
		logatBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		logatBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(79, 164, 59, 26);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		panel.add(lblNewLabel_1_1);

		senhaIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					logatBtn.doClick();
				}
			}
		});
		senhaIn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				senhaIn.selectAll();
			}
		});
		senhaIn.setBounds(79, 196, 341, 33);
		senhaIn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		panel.add(senhaIn);

		logatBtn.setBounds(311, 255, 109, 33);
		logatBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		panel.add(logatBtn);

		JLabel lblNewLabel = new JLabel("Fa\u00E7a o loguin na plataforma.");
		lblNewLabel.setBounds(135, 21, 202, 19);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel criarAccEl = new JLabel("<html>Criar nova conta</html>");
		criarAccEl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register register = new Register();
				currentFrame.dispose();
				register.setVisible(true);
			}
		});
		criarAccEl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		criarAccEl.setForeground(Color.WHITE);
		criarAccEl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		criarAccEl.setBounds(79, 264, 136, 14);
		panel.add(criarAccEl);

		JLabel lblNewLabel_2 = new JLabel("V 1.0");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(370, 469, 93, 14);
		contentPane.add(lblNewLabel_2);


	}
}
