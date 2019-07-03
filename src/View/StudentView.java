package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Course;
import Model.Grades;
import Model.User;
import action.CourseDao;
import action.GradesDao;

import javax.swing.JScrollPane;

public class StudentView {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private String Sno=null;

	public StudentView(User user) {
		Sno=user.getName();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentView2(Sno);
			}
		});
		btnNewButton_2.setBounds(361, 0, 113, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 40, 532, 212);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		String[] biaoge= {"课程编号","课程名","学时","学分"};
		DefaultTableModel tablePatient=new DefaultTableModel(null,biaoge);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 45, 532, 175);
		panel.add(scrollPane);
		table = new JTable(tablePatient);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(14, 0, 82, 24);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 40, 532, 212);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 13, 532, 207);
		panel_1.add(scrollPane_1);
		String[] biaoge1= {"学号","课程号","课程名","成绩","补考成绩"};
		DefaultTableModel tablePatient1=new DefaultTableModel(null,biaoge1);
		
		table_1 = new JTable(tablePatient1);
		scrollPane_1.setViewportView(table_1);
		
		
		JButton btnNewButton_1 = new JButton("\u6210\u7EE9\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.hide();
				panel_1.show();
				GradesDao gradesDao=new GradesDao();
				List<Grades> Gname=gradesDao.queryGrades();
				tablePatient1.setRowCount(0);
				
				for(int i=0;i<Gname.size();i++){
					String sno=Gname.get(i).getSno();
					String cno=Gname.get(i).getCno();
					String cname=String.valueOf(Gname.get(i).getCname());
					String score=String.valueOf(Gname.get(i).getScore());
					String rescore=String.valueOf(Gname.get(i).getRescore());
					String[] c= {sno,cno,cname,score,rescore};
					tablePatient1.addRow(c);
					
				}
				
				
			}
		});
		btnNewButton_1.setBounds(195, 0, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname=String.valueOf(comboBox.getSelectedItem());
				CourseDao courseDao=new CourseDao();
				if(cname.equals("all")){
					tablePatient.setRowCount(0);
					List<Course> cou=courseDao.queryCourse();
					for(int i=0;i<cou.size();i++){
						String cno=cou.get(i).getCno();
						String cname1=cou.get(i).getCname();
						String ltime=String.valueOf(cou.get(i).getLtime());
						String lscore=String.valueOf(cou.get(i).getLscore());
						String[] c= {cno,cname1,ltime,lscore};
						tablePatient.addRow(c);
						
					}
				}else{
					List<Course> cou1=courseDao.queryCourseByCname(cname);
					tablePatient.setRowCount(0);
					int i=0;
						String cno=cou1.get(i).getCno();
						String cname1=cou1.get(i).getCname();
						String ltime=String.valueOf(cou1.get(i).getLtime());
						String lscore=String.valueOf(cou1.get(i).getLscore());
						System.out.println(cname1);
						String[] c= {cno,cname1,ltime,lscore};
						tablePatient.addRow(c);
						
			}
			}
		});
		button.setBounds(141, 0, 113, 27);
		panel.add(button);
		
		
		JButton btnNewButton = new JButton("\u8BFE\u7A0B\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				panel_1.hide();
				panel.show();
				CourseDao courseDao=new CourseDao();
				comboBox.removeAllItems();
				List<Course> Cname=courseDao.queryCourse();
				for(int i=0;i<Cname.size();i++){
					comboBox.addItem(Cname.get(i).getCname());
				}
				comboBox.addItem("all");
				
				
			}
		});
		btnNewButton.setBounds(43, 0, 113, 27);
		frame.getContentPane().add(btnNewButton);
		panel_1.hide();
		panel.hide();
		
		frame.setVisible(true);
	}
}
