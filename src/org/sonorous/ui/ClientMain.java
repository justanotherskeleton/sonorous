package org.sonorous.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class ClientMain extends JPanel {
	private JTextField tf_input;

	/**
	 * Create the panel.
	 */
	public ClientMain() {
		setLayout(null);
		
		JLabel label_head = new JLabel("Sonorous Client");
		label_head.setBounds(126, 11, 87, 14);
		add(label_head);
		
		JTextArea ta_chat = new JTextArea();
		ta_chat.setBounds(10, 172, 319, 176);
		add(ta_chat);
		
		JLabel label_log = new JLabel("Chat Log");
		label_log.setBounds(10, 152, 46, 14);
		add(label_log);
		
		JLabel label_version = new JLabel("version");
		label_version.setHorizontalAlignment(SwingConstants.TRAILING);
		label_version.setBounds(283, 359, 46, 14);
		add(label_version);
		
		JLabel label_rn = new JLabel("Room:");
		label_rn.setBounds(10, 44, 138, 14);
		add(label_rn);
		
		JLabel label_ns = new JLabel("Name Server:");
		label_ns.setBounds(10, 64, 138, 14);
		add(label_ns);
		
		JLabel label_name = new JLabel("Logged as:");
		label_name.setBounds(10, 82, 138, 14);
		add(label_name);
		
		JLabel label_conTime = new JLabel("Initial connection:");
		label_conTime.setBounds(10, 102, 138, 14);
		add(label_conTime);
		
		JLabel label_trans = new JLabel("Total transfer");
		label_trans.setHorizontalAlignment(SwingConstants.TRAILING);
		label_trans.setBounds(180, 44, 138, 14);
		add(label_trans);
		
		JLabel label_dl = new JLabel("Download");
		label_dl.setHorizontalAlignment(SwingConstants.TRAILING);
		label_dl.setBounds(180, 64, 138, 14);
		add(label_dl);
		
		JLabel label_ul = new JLabel("Upload");
		label_ul.setHorizontalAlignment(SwingConstants.TRAILING);
		label_ul.setBounds(180, 82, 138, 14);
		add(label_ul);
		
		JLabel label_usersCon = new JLabel("x users connected");
		label_usersCon.setHorizontalAlignment(SwingConstants.TRAILING);
		label_usersCon.setBounds(190, 102, 128, 14);
		add(label_usersCon);
		
		tf_input = new JTextField();
		tf_input.setBounds(10, 359, 232, 75);
		add(tf_input);
		tf_input.setColumns(10);
		
		JButton btn_send = new JButton("Send");
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_send.setBounds(252, 411, 77, 23);
		add(btn_send);
		
		JButton btn_file = new JButton("Add file");
		btn_file.setBounds(252, 385, 77, 23);
		add(btn_file);
		
		JButton btn_disconnect = new JButton("Disconnect");
		btn_disconnect.setBounds(240, 138, 89, 23);
		add(btn_disconnect);

	}
}
