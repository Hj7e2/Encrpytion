import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.applet.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.SystemColor;

public class Main4 extends JFrame {

	private JPanel contentPane;
	int i,j,x,y;
	JEditorPane editorPane = new JEditorPane();
	JLabel label_3 = new JLabel("用户手册");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main4 frame = new Main4();
					frame.setVisible(true);
					//frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main4(String a,String b) {
		init();
		label_3.setText(a);
		editorPane.setText(b);
	}
	
	public Main4() {
		init();
	}
	
	public void init() {
		setResizable(false);
		setTitle("二次元的加密器");
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\左上角图标1.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 614);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		editorPane.setEditable(false);
		editorPane.setForeground(Color.YELLOW);
		editorPane.setFont(new Font("宋体", Font.BOLD, 22));
		editorPane.setText("1.进入二次元加密器的主界面。\r\n2.输入用户名和密码，按回车或者点击按钮进行登录。\r\n3.如选择注册，同上操作即可注册成功（如账户已注册则需换个账户），按返回即可登录。\r\n4.登陆后进入下一个界面，点击按钮选择要进行的操作。在这个界面，你可以在菜单栏选择要更改的设置：更换壁纸或者背景音乐。\r\n5.加密界面有三个功能：（1）加密字符串（2）加密文本文件（3）加密图片。\r\n加密字符串，只需要在文本框里输入明文按回车即可。\r\n加密文本和图片，是在原文件旁生成一个加密文件。\r\n6.解密界面和加密界面操作相同\r\n");
		editorPane.setOpaque(false);
		editorPane.setBounds(26, 94, 358, 472);
		contentPane.add(editorPane);
		
		label_3.setForeground(new Color(255, 165, 0));
		label_3.setFont(new Font("宋体", Font.BOLD, 40));
		label_3.setBounds(118, 37, 200, 44);
		contentPane.add(label_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("lib\\蒙版2.png"));
		label_1.setBounds(0, 0, 414, 580);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("lib\\小图标2.png"));
		label.setBounds(14, 440, 79, 126);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("lib\\主界面4.png"));
		label_2.setBounds(0, 0, 414, 580);
		contentPane.add(label_2);
	}
}
