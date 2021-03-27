import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import sjkcz.*;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register extends JFrame {

	DBAccess db=new DBAccess();
	DBOperations dbo=new DBOperations();
	String sql;
	Mydialog1 dialog;
	Mydialog2 dialog1;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	AudioClip clip;
	int flag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
					//frame.setLocationRelativeTo(null);//设置窗体居中
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void zc() {
		db.dbconn();//连接数据库
		sql="select * from 用户";
		db.dbSelect(sql);
		int x=1;
		try {
			while(db.rs.next()) {
				//如果账号重复
				if(textField.getText().equals(db.rs.getString("账号")))
				{
					dialog=new Mydialog1("该账户已被注册！");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
					x=0;
					break;
				}
			}
			if(x==1) {
				sql="insert into 用户 values('"+textField.getText()+"','"+textField_1.getText()+"')";
				dbo.DBoperations(sql, 2);
				dialog1=new Mydialog2("注册成功！");
				dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog1.setLocationRelativeTo(null);
				dialog1.setVisible(true);
			}
		}
		catch(SQLException ex) {
			System.err.print(ex.toString());
		}
		db.dbclose();
	}
	
	public Register() {
		flag=1;
		init();
	}
	
	public Register(AudioClip a,int b) {
		clip=a;
		flag=b;
		init();
	}
	
	public void init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\左上角图标1.png"));
		setTitle("二次元的加密器");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JButton button_2 = new JButton("");
			
		if(flag==0) {
			button_2.setIcon(new ImageIcon("lib\\静音.png"));
		}
		else {
			button_2.setIcon(new ImageIcon("lib\\正在播放.png"));
		}
		
		JLabel label_3 = new JLabel("注册界面");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(255, 0, 255));
		label_3.setFont(new Font("华文新魏", Font.ITALIC, 60));
		label_3.setBounds(89, 32, 408, 65);
		contentPane.add(label_3);
		
		JLabel lblNewLabel = new JLabel("制作者： 韩俊 2019.1.3");
		lblNewLabel.setForeground(new Color(127, 255, 212));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel.setBounds(193, 352, 298, 26);
		contentPane.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("注册");
		label_4.setForeground(new Color(255, 215, 0));
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setBounds(77, 311, 55, 30);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("返回");
		label_5.setForeground(new Color(255, 215, 0));
		label_5.setFont(new Font("宋体", Font.BOLD, 25));
		label_5.setBounds(325, 311, 55, 30);
		contentPane.add(label_5);
		
		JLabel label = new JLabel("账户：");
		label.setForeground(new Color(102, 255, 0));
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setBounds(60, 110, 102, 48);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setForeground(new Color(102, 255, 0));
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		label_1.setBounds(60, 171, 102, 48);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBackground(new Color(255, 255, 240));
		textField.setBounds(166, 122, 317, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("");
		button.setBorderPainted(false);
		button.setBackground(new Color(255, 255, 255));
		button.setOpaque(false);
		button.setForeground(new Color(255, 0, 255));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setToolTipText("");
		button.setIcon(new ImageIcon("lib\\注册图标2.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zc();
			}
		});
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zc();
			}
		});
		textField_1.setFont(new Font("宋体", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 240));
		textField_1.setBounds(166, 183, 317, 27);
		contentPane.add(textField_1);
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBounds(120, 227, 95, 101);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setOpaque(false);
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setBorderPainted(false);
		button_1.setForeground(new Color(255, 0, 255));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setIcon(new ImageIcon("lib\\返回图标.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Land(clip,flag).setVisible(true);//显示主界面
				dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 30));
		button_1.setBounds(364, 227, 95, 101);
		contentPane.add(button_1);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==1) {
					clip.stop();
					flag=0;
					button_2.setIcon(new ImageIcon("lib\\静音.png"));
				}
				else {
					clip.loop();
					flag=1;
					button_2.setIcon(new ImageIcon("lib\\正在播放.png"));
				}
			}
		});
		button_2.setToolTipText("");
		button_2.setOpaque(false);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setForeground(Color.MAGENTA);
		button_2.setFont(new Font("宋体", Font.PLAIN, 30));
		button_2.setBorderPainted(false);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(456, 13, 41, 36);
		contentPane.add(button_2);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_6.setBounds(51, 110, 91, 49);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_7.setBounds(51, 170, 91, 49);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_8.setBounds(69, 311, 73, 30);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_9.setBounds(316, 311, 73, 30);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_10.setBounds(180, 348, 317, 30);
		contentPane.add(label_10);
		
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		label_2.setIcon(new ImageIcon("lib\\注册界面.png"));
		label_2.setBounds(0, 0, 559, 415);
		contentPane.add(label_2);
	}
}
