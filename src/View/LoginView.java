package View;


import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.User;
import action.UserDao;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
public class LoginView extends JFrame {

	private JPanel panel_main=null;//主面板
	private JPanel panel_left=null;//左侧面板
	private JPanel panel_right=null;//右侧面板
	
	private JLabel lb_uname=null;//用户标签
	private JLabel lb_upass=null;//密码标签
	private JLabel lb_type=null;//登录类型标签
	
	private JTextField tf_uname=null;//用户文本框
	private JPasswordField pf_pass=null;//密码文本框
	
	private JLabel lb_img=null;//显示图片标签
	
	private JButton btn_login=null;//登录按钮
	private JButton btn_register=null;//注册按钮
	//private JComboBox<String> cb_type=null;//登录类型下拉列表框
	private JComboBox comboBox =null;
	
	
	private UserDao userDao=null;
	//初始化控件的方法
	private void init(){
		this.setSize(320,220);//设置窗体大小
		this.setResizable(false);//设置窗体不可拖动大小
		this.setLocationRelativeTo(null);//居中显示
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体
		this.setTitle("学生信息管理系统登录窗口");//标题

		//初始化面板
		panel_main=new JPanel(new GridLayout(1,2));
		panel_left=new JPanel();
		panel_right=new JPanel(new GridLayout(4,2,0,10));
		//初始化控件
		tf_uname=new JTextField(8);
		pf_pass=new JPasswordField(8);
		lb_uname=new JLabel("用 户",JLabel.CENTER);
		lb_upass=new JLabel("密 码",JLabel.CENTER);
		
		panel_right.add(lb_uname);
		panel_right.add(tf_uname);
		panel_right.add(lb_upass);
		panel_right.add(pf_pass);
		
		//主面板中放左右两个面板
		panel_main.add(panel_left);
		panel_main.add(panel_right);
		
		lb_img=new JLabel(new ImageIcon(ClassLoader.getSystemResource("image/login.jpg")));
		//把相应控件放入面板
		panel_left.add(lb_img);
		
		JLabel label = new JLabel("\u7C7B \u578B");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_right.add(label);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u4E00\u822C\u7528\u6237"}));
		panel_right.add(comboBox);
		
		
		btn_login=new JButton("登录");
	
		panel_right.add(btn_login);
		
		//再把主面板放到窗体上
		this.getContentPane().add(panel_main);
		this.pack();
		
		this.setVisible(true);//窗体可见
		
		}
	
	//创建函数
	private void registerLinsener(){
		
		btn_login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//获取用户名和密码
				String uname=tf_uname.getText().trim();
				String upass=new String(pf_pass.getPassword());
				int type=comboBox.getSelectedIndex()+1;
				if(uname.equals("")){
					JOptionPane.showMessageDialog(LoginView.this, "用户名不能为空");
					return;
				}else if(upass.equals("")){
					JOptionPane.showMessageDialog(LoginView.this, "密码不能为空");
					return;
				}
				User user=new User(uname,upass,type);
				 userDao=new UserDao();
				 
				User flaguser=userDao.queryUser(user);
				if(flaguser!=null){
					if(type==1){
						
						new Admin();
						LoginView.this.dispose();
					}else{
						new StudentView(user);//进入管理员面板
						LoginView.this.dispose();
					}
					
				}else{
					JOptionPane.showMessageDialog(LoginView.this, "用户名或者密码出错");
				}
				
			}
			
		});
	}
		
		
	
	
	public LoginView() {
		
		init();
		registerLinsener();
		
		
	}

}
