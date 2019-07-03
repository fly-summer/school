package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Model.Student;
import action.StudentDao;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class StudentView2 extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String Sno=null;

	public StudentView2(String sno) {
		Sno=sno;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		StudentDao stu=new StudentDao();
		stu.queryDocBySno(Sno);
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setBounds(37, 82, 72, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(37, 141, 72, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setBounds(37, 231, 72, 18);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u51FA\u751F\u65E5\u671F");
		label_3.setBounds(37, 306, 72, 18);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u73ED\u7EA7");
		label_4.setBounds(212, 82, 72, 18);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u4E13\u4E1A");
		label_5.setBounds(212, 141, 72, 18);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u7CFB\u522B");
		label_6.setBounds(212, 231, 72, 18);
		frame.getContentPane().add(label_6);
		
		
		
		JLabel SnoLabel = new JLabel(Sno);
		SnoLabel.setBounds(96, 82, 72, 18);
		frame.getContentPane().add(SnoLabel);
		
		textField = new JTextField(stu.queryDocBySno(Sno).get(0).getSname());
		textField.setBounds(82, 138, 86, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(104, 228, 37, 24);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"}));
		comboBox_1.setBounds(134, 303, 72, 24);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_2.setBounds(290, 303, 37, 24);
		frame.getContentPane().add(comboBox_2);
		
		textField_1 = new JTextField(stu.queryDocBySno(Sno).get(0).getSclass());
		textField_1.setBounds(279, 79, 86, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(stu.queryDocBySno(Sno).get(0).getMajor());
		textField_2.setBounds(279, 138, 86, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(stu.queryDocBySno(Sno).get(0).getDepartment());
		textField_3.setBounds(290, 228, 86, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5E74");
		label_7.setBounds(222, 306, 27, 18);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u6708");
		label_8.setBounds(349, 306, 27, 18);
		frame.getContentPane().add(label_8);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(350, 389, 113, 27);
		frame.getContentPane().add(button_1);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String birth=String.valueOf(comboBox_1.getSelectedItem())+"-"+String.valueOf(comboBox_2.getSelectedItem());
				Student newstu=new Student(Sno,textField.getText() , String.valueOf(comboBox.getSelectedItem()), birth,textField_1.getText() , textField_2.getText(), textField_3.getText());
				StudentDao stu=new StudentDao();
				if(stu.updateStu(newstu)==true){
					JOptionPane.showMessageDialog(StudentView2.this, "修改成功");
				}else{
					JOptionPane.showMessageDialog(StudentView2.this, "修改失败");
				}
				
			}
		});
		button.setBounds(214, 389, 113, 27);
		frame.getContentPane().add(button);
		
		
		
		this.frame.setVisible(true);
	}
}
