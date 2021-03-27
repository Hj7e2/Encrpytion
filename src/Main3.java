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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Main3 extends JFrame {

	private JPanel contentPane;
	File selectedFile;
	AudioClip clip;
	private JTextField textField;
	private JTextField textField_1;
	Mydialog1 dialog;
	Mydialog3 dialog3;
	String [] a,b;
	char [] c;
	String Mingwen;
	String Miwen;
	int i,j,x,y,sum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main3 frame = new Main3();
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
	public Main3(AudioClip a) {
		init();
		clip = a;
		
	}
	
	public Main3() {
		init();
	}
	
	public String Jm2(String k) {
		sum=0;
		Mingwen="";
		Miwen=k;
		x=0;y=0;
		c=Miwen.toCharArray();
		for(i=0;i<Miwen.length();) {
			if(c[i]>='0'&&c[i]<='9') {
				sum++;
				i=i+2;
			}
			else {
				sum++;
				i++;
			}
		}
		if(sum%2==0) {
			a=new String[sum/2];
			b=new String[sum/2];
		}
		else {
			a=new String[sum/2];
			b=new String[sum/2+1];
		}
		//阑珊解密——分组
		for(i=0;x<a.length;) {
			if((c[i]>='0'&&c[i]<='9')) {
				a[x++]=String.valueOf(c[i])+String.valueOf(c[i+1]);
				i=i+2;
			}
			else
			{
				a[x++]=String.valueOf(c[i]);
				i++;
			}
		}
		for(;i<Miwen.length();) {
			if((c[i]>='0'&&c[i]<='9')) {
				b[y++]=String.valueOf(c[i])+String.valueOf(c[i+1]);
				i=i+2;
			}
			else
			{
				b[y++]=String.valueOf(c[i]);
				i++;
			}
		}
		//倒序栅栏解密
		for(i=b.length-1,j=a.length-1;i>=0&&j>=0;i--,j--) {
			Mingwen=Mingwen+Jm1(b[i])+Jm1(a[j]);
		}
		if(i>=0)
			Mingwen=Mingwen+Jm1(b[i]);
		return Mingwen;
	}
	
	//手机九宫格解密密+标准键盘代入解密
	public String Jm1(String a) {
		switch(a) {
		case "21": return "k";//a
		case "22": return "x";//b
		case "23": return "v";//c
		case "31": return "m";//d
		case "32": return "c";//e
		case "33": return "n";//f
		case "41": return "o";//g
		case "42": return "p";//h
		case "43": return "h";//i
		case "51": return "q";//j
		case "52": return "r";//k
		case "53": return "s";//l
		case "61": return "z";//m
		case "62": return "y";//n
		case "63": return "i";//o
		case "71": return "j";//p
		case "72": return "a";//q
		case "73": return "d";//r
		case "74": return "l";//s
		case "81": return "e";//t
		case "82": return "g";//u
		case "83": return "w";//v
		case "91": return "b";//w
		case "92": return "u";//x
		case "93": return "f";//y
		case "94": return "t";//z
		case "00": return "0";//0
		case "01": return "1";//1
		case "02": return "2";//2
		case "03": return "3";//3
		case "04": return "4";//4
		case "05": return "5";//5
		case "06": return "6";//6
		case "07": return "7";//7
		case "08": return "8";//8
		case "09": return "9";//9
		case " ": return String.valueOf(a);//空格
		case ",":
		case "，":return String.valueOf(a);//逗号
		case ".":
		case "。":return String.valueOf(a);//句号
		case "?":
		case "？":return String.valueOf(a);//问号
		case "!":
		case "！":return String.valueOf(a);//感叹号
		default:
			c=a.toCharArray();
			return String.valueOf((char)(c[0]^'A'));
		}
	}
	
	public void init() {
		setResizable(false);
		setTitle("二次元的加密器");
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\左上角图标1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 497);
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
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main1(clip).setVisible(true);//显示主界面
				dispose();
			}
		});
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
		
		JLabel lblNewLabel = new JLabel("BGM:雪融");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 105, 180));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		lblNewLabel.setBounds(23, 18, 230, 49);
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
		
		JLabel label = new JLabel("解密文本");
		label.setForeground(new Color(0, 255, 0));
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setBounds(416, 306, 132, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("解密图片");
		label_1.setForeground(new Color(0, 255, 0));
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		label_1.setBounds(572, 306, 136, 49);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("如果说真实是残酷的，");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(255, 255, 0));
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(41, 289, 357, 36);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("谎言绝对是温柔的吧，");
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(255, 255, 0));
		label_4.setBounds(41, 326, 357, 36);
		contentPane.add(label_4);
		
		JLabel label_8 = new JLabel("所以说，温柔即是谎言");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.YELLOW);
		label_8.setFont(new Font("宋体", Font.BOLD, 25));
		label_8.setBounds(41, 364, 357, 36);
		contentPane.add(label_8);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String source;
				JFileChooser fileChooser=new JFileChooser();//创建文件选择器对象
				//设置文件过滤
				fileChooser.setFileFilter(new FileNameExtensionFilter("支持的文本格式(*.txt)","txt"));
				fileChooser.showOpenDialog(null);//显示文件选择对话框
				selectedFile=fileChooser.getSelectedFile();//获取选择的对象文件
				String str=fileChooser.getName(selectedFile);//获取对象的名称
				if(selectedFile != null) {
					File file =new File(""+selectedFile.getParent()+"",""+str+"解密.txt");
					FileReader in = null;
					FileWriter out = null;
					BufferedReader read;
					BufferedWriter write;
					try
					{
						in = new FileReader(selectedFile);
						out = new FileWriter(file);
						//字节字符转换流  文本文件的编码是ASNI 通用的编码是UTF-8  为了让中文不乱码
						//InputStreamReader isr = new InputStreamReader(new FileInputStream(selectedFile), "GBK"); //或GB2312,GB18030
						read = new BufferedReader(in);
						write = new BufferedWriter(out);

						while((source = read.readLine()) != null)
						{
							write.write(Jm2(source));
							write.newLine();
							write.flush();
						}
						dialog3=new Mydialog3();
						dialog3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog3.setLocationRelativeTo(null);
						dialog3.setVisible(true);
						read.close();
						write.close();
					}
					catch (FileNotFoundException e1)
					{
						System.out.println("未找到文件");
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		});
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon("lib\\解密文本.png"));
		button.setToolTipText("");
		button.setOpaque(false);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setForeground(Color.MAGENTA);
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBackground(Color.WHITE);
		button.setBounds(412, 157, 136, 147);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dateofFile;
				JFileChooser fileChooser=new JFileChooser();//创建文件选择器对象
				//设置文件过滤
				fileChooser.setFileFilter(new FileNameExtensionFilter("支持的图片格式(*.jpg、*.png)","jpg","png"));
				fileChooser.showOpenDialog(null);//显示文件选择对话框
				selectedFile=fileChooser.getSelectedFile();//获取选择的对象文件
				String str=fileChooser.getName(selectedFile);//获取对象的名称
				if(selectedFile != null) {
					File file =new File(""+selectedFile.getParent()+"",""+str+"解密.png");
					InputStream in = null;
					OutputStream out = null;
					try
					{
						in = new FileInputStream(selectedFile);
						out = new FileOutputStream(file);

						while((dateofFile = in.read()) > -1)
						{
							out.write(dateofFile^'A');
						}
						dialog3=new Mydialog3();
						dialog3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog3.setLocationRelativeTo(null);
						dialog3.setVisible(true);
						out.flush();
						in.close();
						out.close();
					}
					catch (FileNotFoundException e1)
					{
						dialog=new Mydialog1("未找到文件");
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
						//System.out.println("未找到文件");
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		});
		button_1.setIcon(new ImageIcon("lib\\解密图片.png"));
		button_1.setToolTipText("");
		button_1.setOpaque(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.MAGENTA);
		button_1.setFont(new Font("宋体", Font.PLAIN, 30));
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(572, 157, 136, 147);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
			}
		});
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str =Jm2(textField.getText());
				dialog3=new Mydialog3();
				dialog3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog3.setLocationRelativeTo(null);
				dialog3.setVisible(true);
				textField_1.setForeground(SystemColor.black);
				textField_1.setText(str);
			}
		});
		textField.setBackground(Color.WHITE);
		textField.setForeground(SystemColor.controlShadow);
		textField.setText("在此输入密文！");
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBounds(41, 179, 357, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("在此显示明文！");
		textField_1.setForeground(SystemColor.controlShadow);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(41, 244, 357, 36);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("lib\\蒙版.png"));
		lblNewLabel_1.setBounds(41, 286, 357, 124);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_5.setBounds(412, 306, 138, 49);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_6.setBounds(570, 306, 138, 49);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("lib\\蒙版.png"));
		label_7.setBounds(17, 17, 239, 49);
		contentPane.add(label_7);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("lib\\主界面3.png"));
		label_2.setBounds(-35, -2, 777, 439);
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
						label_2.setBounds(319-sourceImg.getWidth()/2,220-sourceImg.getHeight()/2,sourceImg.getWidth(),sourceImg.getHeight());
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
				label_2.setIcon(new ImageIcon("lib\\主界面3.png"));
				label_2.setBounds(-35, -2, 777, 439);
			}
		});
	}
}
