import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.applet.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.image.*;
import javax.imageio.*;

public class Main1 extends JFrame {

	private JPanel contentPane;
	File selectedFile;
	AudioClip clip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 frame = new Main1();
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
	public Main1(AudioClip a) {
		init();
		clip = a;
		
	}
	
	public Main1() {
		init();
	}
	
	public void init() {
		setResizable(false);
		setTitle("二次元的加密器");
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\左上角图标1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 486);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 250, 240));
		//menuBar.setOpaque(false);
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu menu_1 = new JMenu("编辑");
		menu_1.setBackground(new Color(255, 250, 240));
		menu_1.setFont(new Font("宋体", Font.PLAIN, 20));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("返回");
		menuItem_4.setEnabled(false);
		menuItem_4.setBackground(new Color(255, 250, 240));
		menuItem_4.setIcon(new ImageIcon("lib\\返回.png"));
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_6 = new JMenuItem("退出");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		menuItem_6.setIcon(new ImageIcon("lib\\退出.png"));
		menuItem_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_6.setBackground(new Color(255, 250, 240));
		menu_1.add(menuItem_6);
		
		JMenu mnNewMenu = new JMenu("音乐");
		mnNewMenu.setBackground(new Color(255, 250, 240));
		mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("选择音频");
		JMenuItem menuItem_3 = new JMenuItem("开始播放");
		menuItem_3.setBackground(new Color(255, 250, 240));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.loop();
			}
		});
		menuItem_3.setIcon(new ImageIcon("lib\\播放1.png"));
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(menuItem_3);
		menuItem.setBackground(new Color(255, 250, 240));
		menuItem.setIcon(new ImageIcon("lib\\选择音频.png"));
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("停止播放");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
			}
		});
		menuItem_1.setBackground(new Color(255, 250, 240));
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_1.setIcon(new ImageIcon("lib\\停止1.png"));
		mnNewMenu.add(menuItem_1);
		
		JMenu menu = new JMenu("背景");
		menu.setBackground(new Color(255, 250, 240));
		menu.setFont(new Font("宋体", Font.PLAIN, 20));
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("更换背景图片");
		menuItem_2.setBackground(new Color(255, 250, 240));
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_2.setIcon(new ImageIcon("lib\\更换背景1.png"));
		menu.add(menuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("恢复默认背景");
		mntmNewMenuItem.setIcon(new ImageIcon("lib\\恢复默认背景.png"));
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mntmNewMenuItem.setBackground(new Color(255, 250, 240));
		menu.add(mntmNewMenuItem);
		
		JMenu menu_2 = new JMenu("帮助");
		menu_2.setFont(new Font("宋体", Font.PLAIN, 20));
		menu_2.setBackground(new Color(255, 250, 240));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("用户手册");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main4().setVisible(true);//显示用户手册界面
			}
		});
		menuItem_5.setIcon(new ImageIcon("lib\\用户手册.png"));
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_5.setBackground(new Color(255, 250, 240));
		menu_2.add(menuItem_5);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("作者寄语");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main4("作者寄语","    我的第一个java程序，用以致敬《我的青春恋爱物语果然有问题》\r\n    这个界面仅用来感谢那些在我制作过程中提供帮助的人们。\r\n    首先是徐寅聪，他提供给了我圆形按钮的实现思路。\r\n    其次是杨浩宇，他帮我找了很多春物的图片（虽然最后只用了一张）。\r\n    再次是李子奇，他告诉了我怎么在花哨的背景上看清文字，给了我界面设计的建议。\r\n    最后是提供实时指导帮助的老师。没有他们就没有这次的作品，再次感谢他们。").setVisible(true);//显示作者寄语界面
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("lib\\作者寄语.png"));
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mntmNewMenuItem_1.setBackground(new Color(255, 250, 240));
		menu_2.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("加密");
		label.setForeground(new Color(255, 215, 0));
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setBounds(26, 227, 84, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("解密");
		label_1.setForeground(new Color(255, 215, 0));
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		label_1.setBounds(156, 353, 84, 49);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("BGM:雪融");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		lblNewLabel.setBounds(374, 28, 228, 49);
		contentPane.add(lblNewLabel);
		
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="选择音频") {
					JFileChooser fileChooser=new JFileChooser();//创建文件选择器对象
					//设置文件过滤
					fileChooser.setFileFilter(new FileNameExtensionFilter("支持的音频格式(*.mid、*.wav、*.au)","wav","au","mid"));
					fileChooser.showOpenDialog(null);//显示文件选择对话框
					selectedFile=fileChooser.getSelectedFile();//获取选择的对象文件
					String str=fileChooser.getName(selectedFile);
					if(selectedFile != null) {
						try {
							if(clip != null)
								clip.stop();
							clip=Applet.newAudioClip(selectedFile.toURI().toURL());
							clip.loop();
							lblNewLabel.setText("BGM:"+str);
						}catch(MalformedURLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main2(clip).setVisible(true);//显示主界面
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon("lib\\加密1.png"));
		button_1.setToolTipText("");
		button_1.setOpaque(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.MAGENTA);
		button_1.setFont(new Font("宋体", Font.PLAIN, 30));
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(69, 101, 142, 154);
		contentPane.add(button_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main3(clip).setVisible(true);//显示主界面
				dispose();
			}
		});
		button.setIcon(new ImageIcon("lib\\解密1.png"));
		button.setToolTipText("");
		button.setOpaque(false);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.MAGENTA);
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.setBounds(205, 227, 142, 154);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_3.setBounds(15, 233, 84, 37);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_4.setBounds(146, 359, 87, 37);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_5.setBounds(374, 28, 228, 49);
		contentPane.add(label_5);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("lib\\主界面1.jpg"));
		label_2.setBounds(-104, 0, 752, 469);
		contentPane.add(label_2);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser=new JFileChooser();//创建文件选择器对象
				//设置文件过滤
				fileChooser.setFileFilter(new FileNameExtensionFilter("支持的图片格式(*.jpg、*.png)","jpg","png"));
				fileChooser.showOpenDialog(null);//显示文件选择对话框
				selectedFile=fileChooser.getSelectedFile();//获取选择的对象文件
				BufferedImage sourceImg;
				if(selectedFile != null) {
					try {
						sourceImg = ImageIO.read(new FileInputStream(new File(selectedFile.toURI())));
						label_2.setIcon(new ImageIcon(selectedFile.toURI().toURL()));
						label_2.setBounds(319-sourceImg.getWidth()/2,243-sourceImg.getHeight()/2,sourceImg.getWidth(),sourceImg.getHeight());
					} catch (FileNotFoundException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
					}
				}
			}
		});
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_2.setIcon(new ImageIcon("lib\\主界面1.jpg"));
				label_2.setBounds(-104, 0, 752, 469);
			}
		});
	}
}
