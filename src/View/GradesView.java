package View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Course;
import Model.Grades;
import action.CourseDao;
import action.GradesDao;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GradesView {

	private JFrame frame;
	private JTable table;
	private JTextField snotext;
	private JTextField cnotext;
	private JTextField cnametext;
	private JTextField scoretext;
	private JTextField rescoretext;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;


	public GradesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 754, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] biaoge= {"学号","课程编号","课程名","成绩","补考成绩"};
		DefaultTableModel tablePatient=new DefaultTableModel(biaoge,0);
		GradesDao graDao=new GradesDao();
		List<Grades> graList=graDao.queryGrades();
			for(int i=0;i<graList.size();i++){
			String sno=graList.get(i).getSno();
			String cno=graList.get(i).getCno();
			String cname=graList.get(i).getCname();
			String score=String.valueOf(graList.get(i).getScore());
			String rescore=String.valueOf(graList.get(i).getRescore());
			String[] c= {sno,cno,cname,score,rescore};
			tablePatient.addRow(c);
			
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 32, 554, 310);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tablePatient);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();  
				Object sno = table.getValueAt(selectedRow, 0);  
				
                Object cno = table.getValueAt(selectedRow, 1);  
                
                Object cname = table.getValueAt(selectedRow, 2);  
                
                Object score = table.getValueAt(selectedRow, 3);  

                Object rescore = table.getValueAt(selectedRow, 4);  
              
                
                snotext.setText(sno.toString()); 
                cnotext.setText(cno.toString());  
                cnametext.setText(cname.toString()); 
                scoretext.setText(score.toString()); 
                rescoretext.setText(rescore.toString());
                
				
			}
		});
		scrollPane.setViewportView(table);
		
		snotext = new JTextField();
		snotext.setBounds(34, 378, 86, 24);
		frame.getContentPane().add(snotext);
		snotext.setColumns(10);
		
		cnotext = new JTextField();
		cnotext.setBounds(160, 378, 86, 24);
		frame.getContentPane().add(cnotext);
		cnotext.setColumns(10);
		
		cnametext = new JTextField();
		cnametext.setBounds(271, 378, 86, 24);
		frame.getContentPane().add(cnametext);
		cnametext.setColumns(10);
		
		scoretext = new JTextField();
		scoretext.setBounds(383, 378, 86, 24);
		frame.getContentPane().add(scoretext);
		scoretext.setColumns(10);
		
		rescoretext = new JTextField();
		rescoretext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(scoretext.getText())>60){
					System.out.println("大于60");
					rescoretext.setEnabled(false);
				}else{
					rescoretext.setText("-1");
					rescoretext.setEnabled(true);
				}
			}
		});
	
		rescoretext.setBounds(500, 378, 86, 24);
		frame.getContentPane().add(rescoretext);
		rescoretext.setColumns(10);
		
		button = new JButton("\u63D2\u5165");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno=snotext.getText();
				String cno=cnotext.getText();
				String relsno = "^[0-9]*[1-9][0-9]*$";
				String relcno = "^(([1-9]\\d?)|10000)$";//0~10000
				
				String reltimetext = "^(([1-9]\\d?)|100)$";//0~100
				
				String relscoretext = "^(([1-9]\\d?)|20)$";//0~20
				if(!sno.matches(relsno)){
					JOptionPane.showMessageDialog(frame, "学号需为正整数");
					return;
				}else if(!cno.matches(relcno)){
					JOptionPane.showMessageDialog(frame, "课程号需为0~10000正整数");
					return;
				}else if(!scoretext.getText().matches(reltimetext)){
					JOptionPane.showMessageDialog(frame, "成绩需为0~100正整数");
					return;
				}
				/*else if(Integer.parseInt(scoretext.getText())>60){
					rescoretext.setEditable(false);
					//JOptionPane.showMessageDialog(frame, "");
					//return;
				}
				*/
				else if(Integer.parseInt(scoretext.getText())<-2||Integer.parseInt(scoretext.getText())>101){
					JOptionPane.showMessageDialog(frame, "补考成绩需-1~100");
					return;
				}
				String cname=cnametext.getText();
				int score=Integer.parseInt(scoretext.getText());
				int rescore=Integer.parseInt(rescoretext.getText());

				GradesDao graDao=new GradesDao();
				Grades gra=new Grades(sno,cno,cname,score,rescore);
				
				if(graDao.queryGradesBySnoCno(sno, cno)!=null){
					JOptionPane.showMessageDialog(frame, "已有该课程成绩");
					return;
				}
				
				
				if(graDao.saveGrades(gra)==true){
					JOptionPane.showMessageDialog(frame, "添加成功");
				}else{
					JOptionPane.showMessageDialog(frame, "添加失败,学号或课程号不存在");
				}
			}
	
		});
		button.setBounds(609, 49, 113, 27);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String sno=snotext.getText();
				String cno=cnotext.getText();
				GradesDao graDao=new GradesDao();
				if(graDao.delGrades(cno, sno)==true){
					JOptionPane.showMessageDialog(frame, "删除成功");
				}else{
					JOptionPane.showMessageDialog(frame, "删除失败");
				}
			}
		});
		button_1.setBounds(609, 119, 113, 27);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String sno=snotext.getText();
				String cno=cnotext.getText();
				String relsno = "^[0-9]*[1-9][0-9]*$";
				String relcno = "^(([1-9]\\d?)|10000)$";//0~10000
				
				String reltimetext = "^(([1-9]\\d?)|100)$";//0~100
				
				String relscoretext = "^(([1-9]\\d?)|20)$";//0~20
				if(!sno.matches(relsno)){
					JOptionPane.showMessageDialog(frame, "学号需为正整数");
					return;
				}else if(!cno.matches(relcno)){
					JOptionPane.showMessageDialog(frame, "课程号需为0~10000正整数");
					return;
				}else if(!scoretext.getText().matches(reltimetext)){
					JOptionPane.showMessageDialog(frame, "成绩需为0~100正整数");
					return;
				}
				/*else if(Integer.parseInt(scoretext.getText())>60){
					rescoretext.setEditable(false);
					//JOptionPane.showMessageDialog(frame, "");
					//return;
				}
				*/
				else if(Integer.parseInt(scoretext.getText())<-2||Integer.parseInt(scoretext.getText())>101){
					JOptionPane.showMessageDialog(frame, "补考成绩需-1~100");
					return;
				}
				String cname=cnametext.getText();
				int score=Integer.parseInt(scoretext.getText());
				int rescore=Integer.parseInt(rescoretext.getText());
				GradesDao graDao=new GradesDao();
				if(graDao.updateGrades(score, rescore,cno,sno)==true){
					JOptionPane.showMessageDialog(frame, "修改成功");
				}else{
					JOptionPane.showMessageDialog(frame, "修改成功");
				}

			}
		});
		button_2.setBounds(609, 192, 113, 27);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("\u8FD4\u56DE");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button_3.setBounds(609, 328, 113, 27);
		frame.getContentPane().add(button_3);
		
		frame.setVisible(true);
	}

}
