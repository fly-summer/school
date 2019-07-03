package View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Student;
import action.StudentDao;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuView {

	private JFrame frame;
	private JTable table;
	private JTextField snotext;
	private JTextField snametext;
	private JTextField sextext;
	private JTextField birthtext;
	private JTextField sclasstext;
	private JTextField majortext;
	private JTextField departmenttext;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	public StuView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1023, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] biaoge1= {"学号","姓名","性别","出生日期","班级","专业","系别"};
		DefaultTableModel tablePatient=new DefaultTableModel(biaoge1,0);
		StudentDao studao=new StudentDao();
		List<Student> stuList=studao.queryStu();
		for(int i=0;i<stuList.size();i++){
			String sno=stuList.get(i).getSno();
			String sname=stuList.get(i).getSname();
			String sex=stuList.get(i).getSex();
			String birth=stuList.get(i).getBirth();
			String sclass=stuList.get(i).getSclass();
			String major=stuList.get(i).getMajor();
			String department=stuList.get(i).getDepartment();
			String[] c= {sno,sname,sex,birth,sclass,major,department};
			tablePatient.addRow(c);
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 45, 741, 354);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tablePatient);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();  
				
                Object sno = table.getValueAt(selectedRow, 0);  
                
                Object sname = table.getValueAt(selectedRow, 1);  
                
                Object sex = table.getValueAt(selectedRow, 2);  
                
                
                Object birth = table.getValueAt(selectedRow, 3);  
                Object sclass = table.getValueAt(selectedRow, 4);  
                Object major = table.getValueAt(selectedRow, 5);  
                Object department = table.getValueAt(selectedRow, 6);  

                snotext.setText(sno.toString());  
                snametext.setText(sname.toString()); 
                sextext.setText(sex.toString()); 
                birthtext.setText(birth.toString());
                sclasstext.setText(sclass.toString());
                majortext.setText(major.toString());
                departmenttext.setText(department.toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		snotext = new JTextField();
		snotext.setBounds(26, 425, 86, 24);
		frame.getContentPane().add(snotext);
		snotext.setColumns(10);
		
		snametext = new JTextField();
		snametext.setBounds(126, 425, 86, 24);
		frame.getContentPane().add(snametext);
		snametext.setColumns(10);
		
		sextext = new JTextField();
		sextext.setBounds(238, 425, 86, 24);
		frame.getContentPane().add(sextext);
		sextext.setColumns(10);
		
		birthtext = new JTextField();
		birthtext.setBounds(365, 425, 86, 24);
		frame.getContentPane().add(birthtext);
		birthtext.setColumns(10);
		
		sclasstext = new JTextField();
		sclasstext.setBounds(479, 425, 86, 24);
		frame.getContentPane().add(sclasstext);
		sclasstext.setColumns(10);
		
		majortext = new JTextField();
		majortext.setBounds(589, 425, 86, 24);
		frame.getContentPane().add(majortext);
		majortext.setColumns(10);
		
		departmenttext = new JTextField();
		departmenttext.setBounds(689, 425, 86, 24);
		frame.getContentPane().add(departmenttext);
		departmenttext.setColumns(10);
		
		button = new JButton("\u63D2\u5165");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sno=snotext.getText();
				String sname=snametext.getText();
				String sex=sextext.getText();
				String birth=birthtext.getText();
				String sclass=sclasstext.getText();
				String major=majortext.getText();
				String department=departmenttext.getText();
				Student stu=new Student(sno,sname,sex,birth,sclass,major,department);
				StudentDao studao=new StudentDao();
				
				if(studao.queryDocBySno(sno)!=null){
					JOptionPane.showMessageDialog(frame, "已有该学号");
					return;
				}
				
				
				if(studao.saveStu(stu)==true){
					JOptionPane.showMessageDialog(frame, "添加成功");
				}else{
					JOptionPane.showMessageDialog(frame, "添加失败");
				}
				
				
			}
		});
		button.setBounds(835, 49, 113, 27);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDao studao=new StudentDao();
				int selectedRow = table.getSelectedRow();  
				Object sno = table.getValueAt(selectedRow, 0);  
				if(studao.delStu(sno.toString())==true){
					JOptionPane.showMessageDialog(frame, "删除成功");
				}else{
					JOptionPane.showMessageDialog(frame, "删除失败");
				}
				
				
			}
		});
		button_1.setBounds(835, 124, 113, 27);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno=snotext.getText();
				String sname=snametext.getText();
				String sex=sextext.getText();
				String birth=birthtext.getText();
				String sclass=sclasstext.getText();
				String major=majortext.getText();
				String department=departmenttext.getText();
				Student stu=new Student(sno,sname,sex,birth,sclass,major,department);
				StudentDao studao=new StudentDao();
				if(studao.updateStu(stu)==true){
					JOptionPane.showMessageDialog(frame, "修改成功");
				}else{
					JOptionPane.showMessageDialog(frame, "修改失败");
				}
				
				
			}
		});
		button_2.setBounds(835, 202, 113, 27);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("\u8FD4\u56DE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_3.setBounds(835, 399, 113, 27);
		frame.getContentPane().add(button_3);
		
		frame.setVisible(true);
	}

}
