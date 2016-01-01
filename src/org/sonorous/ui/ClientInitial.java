package org.sonorous.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ClientInitial extends JPanel {
	private JTextField tf_ns;
	private JTextField tf_rn;
	private JPasswordField tf_rp;

	/**
	 * Create the panel.
	 */
	public ClientInitial() {
		setLayout(null);
		
		JLabel lblSonorousClient = new JLabel("Sonorous Client");
		lblSonorousClient.setBounds(90, 11, 82, 14);
		add(lblSonorousClient);
		
		JTextArea ta_log = new JTextArea();
		ta_log.setBounds(21, 291, 214, 144);
		add(ta_log);
		
		JLabel label_log = new JLabel("Log");
		label_log.setBounds(21, 266, 46, 14);
		add(label_log);
		
		tf_ns = new JTextField();
		tf_ns.setBounds(21, 75, 214, 20);
		add(tf_ns);
		tf_ns.setColumns(10);
		
		JLabel label_ns = new JLabel("Name Server");
		label_ns.setBounds(21, 61, 82, 14);
		add(label_ns);
		
		JLabel label_rn = new JLabel("Room Name");
		label_rn.setBounds(21, 108, 82, 14);
		add(label_rn);
		
		tf_rn = new JTextField();
		tf_rn.setBounds(21, 123, 214, 20);
		add(tf_rn);
		tf_rn.setColumns(10);
		
		JLabel label_rp = new JLabel("Room Password");
		label_rp.setBounds(21, 153, 82, 14);
		add(label_rp);
		
		JButton btn_connect = new JButton("Connect");
		btn_connect.setBounds(21, 199, 82, 56);
		add(btn_connect);
		
		tf_rp = new JPasswordField();
		tf_rp.setBounds(21, 168, 214, 20);
		add(tf_rp);
		
		JButton btn_ipconnect = new JButton("Connect by IP");
		btn_ipconnect.setBounds(113, 199, 122, 29);
		add(btn_ipconnect);
		
		JLabel label_version = new JLabel("Version a0.1");
		label_version.setBounds(166, 266, 69, 14);
		add(label_version);
		
		JButton btn_settings = new JButton("Edit Settings");
		btn_settings.setBounds(113, 232, 122, 23);
		add(btn_settings);
		
	}
}
