package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Admin {

	private JFrame frame;

	public Admin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 553, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_3 = new JButton("\u8FD4\u56DE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(228, 149, 113, 27);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton button = new JButton("\u8BFE\u7A0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CourseView();
			}
		});
		button.setBounds(48, 62, 113, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u6210\u7EE9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GradesView();
			}
		});
		button_1.setBounds(228, 62, 113, 27);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u5B66\u751F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StuView();
			}
		});
		button_2.setBounds(48, 149, 113, 27);
		frame.getContentPane().add(button_2);
		
		frame.setVisible(true);
	}
}
