package Partials;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import Controller.ConfigController;
public class Header extends JPanel {
	
	private ConfigController config = new ConfigController();

	/**
	 * Create the panel.
	 */
	public Header() {
		// set transparent
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(config.title);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 35));
		lblNewLabel.setBounds(0, 11, 303, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A plataforma que gerencia seu dinheiro.");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 62, 419, 36);
		add(lblNewLabel_1);

	}

}
