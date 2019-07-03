package View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Course;
import action.CourseDao;


import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class CourseView {

	private JFrame frame;
	private JTable table;
	private JTextField cnotext;
	private JTextField cnametext;
	private JTextField ltimetext;
	private JTextField lscoretext;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	public CourseView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] biaoge1= {"课程号","课程名","学时","学分"};
		DefaultTableModel tablePatient=new DefaultTableModel(biaoge1,0);
		CourseDao courDao=new CourseDao();
		List<Course> couList=courDao.queryCourse();
		for(int i=0;i<couList.size();i++){
			
			String cno=couList.get(i).getCno();
			String cname=couList.get(i).getCname();
			String score=String.valueOf(couList.get(i).getLtime());
			String rescore=String.valueOf(couList.get(i).getLscore());
			String[] c= {cno,cname,score,rescore};
			tablePatient.addRow(c);
			
		}
		
		
		cnotext = new JTextField();
		cnotext.setBounds(32, 382, 86, 24);
		frame.getContentPane().add(cnotext);
		cnotext.setColumns(10);
		
		cnametext = new JTextField();
		cnametext.setBounds(183, 382, 86, 24);
		frame.getContentPane().add(cnametext);
		cnametext.setColumns(10);
		
		ltimetext = new JTextField();
		ltimetext.setBounds(329, 382, 86, 24);
		frame.getContentPane().add(ltimetext);
		ltimetext.setColumns(10);
		
		lscoretext = new JTextField();
		lscoretext.setBounds(474, 382, 86, 24);
		frame.getContentPane().add(lscoretext);
		lscoretext.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 25, 584, 328);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tablePatient);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();  
				  
                Object cno = table.getValueAt(selectedRow, 0);  
                
                Object cname = table.getValueAt(selectedRow, 1);  
                
                Object ltime = table.getValueAt(selectedRow, 2);  
                
                
                Object lscore = table.getValueAt(selectedRow, 3);  
              
                
  
                cnotext.setText(cno.toString());  
                cnametext.setText(cname.toString()); 
                ltimetext.setText(ltime.toString()); 
                lscoretext.setText(lscore.toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u63D2\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cno=cnotext.getText();
				String cname=cnametext.getText();
				
				String relcno = "^[0-9]*[1-9][0-9]*$　";//0~10000
				
				String reltimetext = "^(([1-9]\\d?)|100)$";//0~100
				
				String relscoretext = "^(([1-9]\\d?)|20)$";//0~20
				
				if(cno.matches(relcno)){
					JOptionPane.showMessageDialog(frame, "课程号需为0~10000正整数");
					return;
				}else if(!ltimetext.getText().matches(reltimetext)){
					JOptionPane.showMessageDialog(frame, "学时需为0~100正整数（大于0）");
					return;
				}else if(!lscoretext.getText().matches(relscoretext)){
					JOptionPane.showMessageDialog(frame, "学分需为0~20正整数（大于0）");
					return;
				}
				int ltime=Integer.parseInt(ltimetext.getText());
				int lscore=Integer.parseInt(lscoretext.getText());
				
				
				
				String regex = "^[1-9]*[1-9][0-9]*$";//正则
				String regex2="^[\u4e00-\u9fa5_a-zA-Z0-9]+$";
				
				
				if(!cno.matches(regex)){
					JOptionPane.showMessageDialog(frame, "课程号需为正整数");
					return;
				}
				
				else if(ltime<0||ltime>100){
					JOptionPane.showMessageDialog(frame, "学时需在0-100之间");
					return;
					
				}else if(lscore<0||lscore>20){
					JOptionPane.showMessageDialog(frame, "学分需在0-20之间");
					return;
				}
				
				
				
				CourseDao courDao=new CourseDao();
				Course cou=new Course(cno,cname,ltime,lscore);
				if(courDao.queryCourseByCno(cno)!=null){
					JOptionPane.showMessageDialog(frame, "已有该课程号");
					return;
				}else if(courDao.queryCourseByCname(cname)!=null){
					JOptionPane.showMessageDialog(frame, "已有该课程");
					return;
				}
				
				
				if(courDao.saveCourse(cou)==true){
					JOptionPane.showMessageDialog(frame, "添加成功");
				}else{
					JOptionPane.showMessageDialog(frame, "添加失败");
				}
			}
		});
		btnNewButton.setBounds(625, 56, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();  
				Object cno = table.getValueAt(selectedRow, 0);  
				System.out.println(cno.toString());
				CourseDao courDao=new CourseDao();
				if(courDao.delCourse(Integer.parseInt(cno.toString()))==true){
					JOptionPane.showMessageDialog(frame, "删除成功");
				}else{
					JOptionPane.showMessageDialog(frame, "删除失败");
				}
			}
		});
		button.setBounds(625, 131, 113, 27);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String cno=cnotext.getText();
				String cname=cnametext.getText();

			
				
				String relcno = "^(([1-9]\\d?)|10000)$";//0~10000
				
				String reltimetext = "^(([1-9]\\d?)|100)$";//0~100
				
				String relscoretext = "^(([1-9]\\d?)|20)$";//0~20
				
				if(!cno.matches(relcno)){
					JOptionPane.showMessageDialog(frame, "课程号需为0~10000正整数");
					return;
				}else if(!ltimetext.getText().matches(reltimetext)){
					JOptionPane.showMessageDialog(frame, "学时需为0~100正整数");
					return;
				}else if(!lscoretext.getText().matches(relscoretext)){
					JOptionPane.showMessageDialog(frame, "学分需为0~20正整数");
					return;
				}
				int ltime=Integer.parseInt(ltimetext.getText());
				int lscore=Integer.parseInt(lscoretext.getText());

				
				String regex = "^[1-9]*[1-9][0-9]*$";//正则
				String regex2="^[\u4e00-\u9fa5_a-zA-Z0-9]+$";
				
				
				if(!cno.matches(regex)){
					JOptionPane.showMessageDialog(frame, "课程号需为正整数");
					return;
				}else if(!cname.matches(regex2)){
					JOptionPane.showMessageDialog(frame, "课程名只能是英文、中文、数字的组合");
					return;
				}else if(ltime<0||ltime>100){
					JOptionPane.showMessageDialog(frame, "学时需在0-100之间");
					return;
					
				}else if(lscore<0||lscore>20){
					JOptionPane.showMessageDialog(frame, "学分需在0-20之间");
					return;
				}
				
				CourseDao courDao=new CourseDao();
				Course cou=new Course(cno,cname,ltime,lscore);
				if(courDao.updateCourse(cou)==true){
					JOptionPane.showMessageDialog(frame, "修改成功");
				}else{
					JOptionPane.showMessageDialog(frame, "修改失败");
				}
				
				
			}
		});
		button_1.setBounds(625, 195, 113, 27);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("\u5237\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("刷新");
			}
		});
		button_2.setBounds(625, 300, 113, 27);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("\u8FD4\u56DE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_3.setBounds(625, 366, 113, 27);
		frame.getContentPane().add(button_3);
		
		frame.setVisible(true);

	}
}
