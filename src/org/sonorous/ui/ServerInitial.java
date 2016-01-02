package org.sonorous.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerInitial extends JPanel {

	/**
	 * Create the panel.
	 */
	public ServerInitial() {
		setLayout(null);
		
		JLabel lblSonorousNameServer = new JLabel("Sonorous Name Server");
		lblSonorousNameServer.setBounds(59, 11, 125, 14);
		add(lblSonorousNameServer);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 150, 210, 171);
		add(textArea);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setBounds(10, 129, 46, 14);
		add(lblLog);
		
		JLabel lblIpXxxxxxxx = new JLabel("IP: xxx.xxx.xx");
		lblIpXxxxxxxx.setBounds(10, 36, 91, 14);
		add(lblIpXxxxxxxx);
		
		JLabel lblOnline = new JLabel("ONLINE");
		lblOnline.setBounds(159, 36, 46, 14);
		add(lblOnline);
		
		JButton btnStart = new JButton("Start ");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.setBounds(147, 125, 73, 23);
		add(btnStart);

	}
}
