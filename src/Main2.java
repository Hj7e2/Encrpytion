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

public class Main2 extends JFrame {

	private JPanel contentPane;
	File selectedFile;
	AudioClip clip;
	private JTextField textField;
	private JTextField textField_1;
	char [] a,b,c;
	String Mingwen;
	String Miwen;
	int i,j,x,y;
	Mydialog1 dialog;
	Mydialog2 dialog2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 frame = new Main2();
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
	public Main2(AudioClip a) {
		init();
		clip = a;
		
	}
	
	public Main2() {
		init();
	}
	
	public String Jm2(String k) {
		Mingwen=k;
		Miwen="";
		x=0;y=0;
		c=Mingwen.toCharArray();
		if(Mingwen.length()%2==0) {
			a=new char[Mingwen.length()/2];
			b=new char[Mingwen.length()/2];
		}
		else {
			a=new char[Mingwen.length()/2+1];
			b=new char[Mingwen.length()/2];
		}
		//栅栏加密
		for(i=0;i<Mingwen.length();i++) {
			if(i%2==0)
				a[x++]=c[i];
			else
				b[y++]=c[i];
		}
		//倒序加密
		for(i=b.length-1;i>=0;i--) {
			Miwen=Miwen+Jm1(b[i]);
		}
		for(i=a.length-1;i>=0;i--) {
			Miwen=Miwen+Jm1(a[i]);
		}
		return Miwen;
	}
	
	//手机九宫格加密+标准键盘代入加密
	public String Jm1(char a) {
		switch(a) {
		case 'a':
		case 'A': return "72";//q
		case 'b':
		case 'B': return "91";//w
		case 'c':
		case 'C': return "32";//e
		case 'd':
		case 'D': return "73";//r
		case 'e':
		case 'E': return "81";//t
		case 'f':
		case 'F': return "93";//y
		case 'g':
		case 'G': return "82";//u
		case 'h':
		case 'H': return "43";//i
		case 'i':
		case 'I': return "63";//o
		case 'j':
		case 'J': return "71";//p
		case 'k':
		case 'K': return "21";//a
		case 'l':
		case 'L': return "74";//s
		case 'm':
		case 'M': return "31";//d
		case 'n':
		case 'N': return "33";//f
		case 'o':
		case 'O': return "41";//g
		case 'p':
		case 'P': return "42";//h
		case 'q':
		case 'Q': return "51";//j
		case 'r':
		case 'R': return "52";//k
		case 's':
		case 'S': return "53";//l
		case 't':
		case 'T': return "94";//z
		case 'u':
		case 'U': return "92";//x
		case 'v':
		case 'V': return "23";//c
		case 'w':
		case 'W': return "83";//v
		case 'x':
		case 'X': return "22";//b
		case 'y':
		case 'Y': return "62";//n
		case 'z':
		case 'Z': return "61";//m
		case '0': return "00";//0
		case '1': return "01";//1
		case '2': return "02";//2
		case '3': return "03";//3
		case '4': return "04";//4
		case '5': return "05";//5
		case '6': return "06";//6
		case '7': return "07";//7
		case '8': return "08";//8
		case '9': return "09";//9
		case ' ': return String.valueOf(a);//空格
		case ',':
		case '，':return String.valueOf(a);//逗号
		case '.':
		case '。':return String.valueOf(a);//句号
		case '?':
		case '？':return String.valueOf(a);//问号
		case '!':
		case '！':return String.valueOf(a);//感叹号
		default: return String.valueOf((char)(a^'A'));
		}
	}
	
	public void init() {
		setResizable(false);
		setTitle("二次元的加密器");
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\左上角图标1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 509);
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
		
		JMenuItem menuItem_7 = new JMenuItem("作者寄语");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main4("作者寄语","    我的第一个java程序，用以致敬《我的青春恋爱物语果然有问题》\r\n    这个界面仅用来感谢那些在我制作过程中提供帮助的人们。\r\n    首先是徐寅聪，他提供给了我圆形按钮的实现思路。\r\n    其次是杨浩宇，他帮我找了很多春物的图片（虽然最后只用了一张）。\r\n    再次是李子奇，他告诉了我怎么在花哨的背景上看清文字，给了我界面设计的建议。\r\n    最后是提供实时指导帮助的老师。没有他们就没有这次的作品，再次感谢他们。").setVisible(true);//显示作者寄语界面			
				}
		});
		menuItem_7.setIcon(new ImageIcon("lib\\作者寄语.png"));
		menuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuItem_7.setBackground(new Color(255, 250, 240));
		menu_2.add(menuItem_7);
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
					String str=fileChooser.getName(selectedFile);//获取对象的名称
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
		
		JLabel label = new JLabel("加密文本");
		label.setForeground(new Color(0, 255, 0));
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setBounds(416, 306, 132, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("加密图片");
		label_1.setForeground(new Color(0, 255, 0));
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		label_1.setBounds(572, 306, 136, 49);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("温柔正确的人总是难以生存，");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(255, 255, 0));
		label_3.setFont(new Font("宋体", Font.BOLD, 25));
		label_3.setBounds(42, 315, 360, 36);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("因为这世界既不温柔也不正确");
		label_4.setFont(new Font("宋体", Font.BOLD, 25));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(255, 255, 0));
		label_4.setBounds(42, 361, 360, 36);
		contentPane.add(label_4);
		
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
					File file =new File(""+selectedFile.getParent()+"",""+str+"加密.txt");
					//FileReader in = null;
					FileWriter out = null;
					BufferedReader read;
					BufferedWriter write;
					try
					{
						//in = new FileReader(selectedFile);
						out = new FileWriter(file);
						//字节字符转换流 文本文件的编码是ASNI 通用的编码是UTF-8  为了让中文不乱码
						InputStreamReader isr = new InputStreamReader(new FileInputStream(selectedFile), "GBK"); //或GB2312,GB18030
						read = new BufferedReader(isr);
						write = new BufferedWriter(out);

						while((source = read.readLine()) != null)
						{
							write.write(Jm2(source));
							write.newLine();
							write.flush();
						}
						dialog2=new Mydialog2();
						dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog2.setLocationRelativeTo(null);
						dialog2.setVisible(true);
						read.close();
						write.close();
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
		button.setBorderPainted(false);
		button.setIcon(new ImageIcon("lib\\选择文本2.png"));
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
					File file =new File(""+selectedFile.getParent()+"",""+str+"加密.png");
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
						dialog2=new Mydialog2();
						dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog2.setLocationRelativeTo(null);
						dialog2.setVisible(true);
						out.flush();
						in.close();
						out.close();
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
		button_1.setIcon(new ImageIcon("lib\\选择图片2.png"));
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
		textField.setBackground(Color.WHITE);
		textField.setForeground(SystemColor.controlShadow);
		textField.setText("在此输入明文！");
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBounds(41, 179, 357, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("在此显示密文！");
		textField_1.setForeground(SystemColor.controlShadow);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(41, 244, 357, 36);
		contentPane.add(textField_1);
		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str =Jm2(textField.getText());
				dialog2=new Mydialog2();
				dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog2.setLocationRelativeTo(null);
				dialog2.setVisible(true);
				textField_1.setForeground(SystemColor.black);
				textField_1.setText(str);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("lib\\蒙版.png"));
		lblNewLabel_1.setBounds(41, 308, 357, 94);
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
		label_2.setIcon(new ImageIcon("lib\\主界面2.png"));
		label_2.setBounds(0, 0, 777, 450);
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
//						sourceImg = ImageIO.read(new FileInputStream(new File(selectedFile.toURI())));
						sourceImg = ImageIO.read(new FileInputStream(selectedFile));
						label_2.setIcon(new ImageIcon(selectedFile.toURI().toURL()));
						label_2.setBounds(389-sourceImg.getWidth()/2,225-sourceImg.getHeight()/2,sourceImg.getWidth(),sourceImg.getHeight());
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
				label_2.setIcon(new ImageIcon("lib\\主界面2.png"));
				label_2.setBounds(0, 0, 777, 450);
			}
		});
	}
}
