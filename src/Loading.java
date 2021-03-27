import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	public JProgressBar progressBar;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
					new Thread(frame).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\左上角图标1.png"));
		setTitle("二次元的加密器");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label_1 = new JLabel("只有弱者才喜欢扎堆");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(255, 255, 0));
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 30));
		label_1.setBounds(0, 70, 501, 34);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("lib\\蒙版2.png"));
		label_2.setBounds(0, 70, 500, 34);
		contentPane.add(label_2);
		
		label_4 = new JLabel("问题是绝大部分人都是弱者");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("华文行楷", Font.PLAIN, 30));
		label_4.setBounds(0, 137, 501, 34);
		contentPane.add(label_4);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("lib\\蒙版2.png"));
		label_3.setBounds(0, 137, 500, 34);
		contentPane.add(label_3);
		
		label_5 = new JLabel("青春是谎言，是邪恶");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("华文行楷", Font.PLAIN, 30));
		label_5.setBounds(0, 0, 501, 34);
		contentPane.add(label_5);
		
		label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("lib\\蒙版2.png"));
		label_6.setBounds(0, 0, 500, 34);
		contentPane.add(label_6);
		
		label_7 = new JLabel("没有期待就没有失望");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.YELLOW);
		label_7.setFont(new Font("华文行楷", Font.PLAIN, 30));
		label_7.setBounds(0, 204, 501, 34);
		contentPane.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("lib\\蒙版2.png"));
		label_8.setBounds(0, 204, 500, 34);
		contentPane.add(label_8);
		
		label_9 = new JLabel("没有羁绊就不会受伤");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.YELLOW);
		label_9.setFont(new Font("华文行楷", Font.PLAIN, 30));
		label_9.setBounds(0, 275, 501, 34);
		contentPane.add(label_9);
		
		label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("lib\\蒙版2.png"));
		label_10.setBounds(0, 275, 500, 34);
		contentPane.add(label_10);
		
		progressBar = new JProgressBar(0,1000);
		progressBar.setFont(new Font("宋体", Font.BOLD, 30));
		progressBar.setForeground(new Color(0, 191, 255));
		progressBar.setBackground(SystemColor.control);
		progressBar.setBorderPainted(false);
		progressBar.setBounds(0, 308, 500, 34);
		progressBar.setStringPainted(true); 
		contentPane.add(progressBar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("lib\\加载界面.png"));
		label.setBounds(0, 0, 500, 309);
		contentPane.add(label);
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		for(int i=0;i<1000;i +=(int)(Math.random() * 10)){
			try{
				Thread.sleep(30);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			progressBar.setValue(i);
			progressBar.setString("Loading... "+progressBar.getValue()/10+"%");  
		}
		dispose();
		new Land().setVisible(true);//显示主界面
	}
}
