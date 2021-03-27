import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;

public class Mydialog1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JLabel label_1 = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mydialog1 dialog = new Mydialog1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mydialog1(String str) {
		init();
		label_1.setText(str);
	}
	
	public Mydialog1() {
		init();
	}
	
	public void init() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\左上角图标2.png"));
		setTitle("春学家的提示");
		setLocation(500,500);
		setModal(true);
		setBounds(100, 100, 390, 167);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("确定");
		label.setForeground(new Color(255, 0, 255));
		label.setFont(new Font("宋体", Font.BOLD, 25));
		label.setBounds(210, 81, 55, 30);
		contentPanel.add(label);
		
		JButton button_1 = new JButton("");
		button_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER) {
					setVisible(false);
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon("lib\\自定义对话框图标2.png"));
		button_1.setToolTipText("");
		button_1.setOpaque(false);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setForeground(Color.MAGENTA);
		button_1.setFont(new Font("宋体", Font.PLAIN, 30));
		button_1.setBorderPainted(false);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(275, 17, 95, 94);
		contentPanel.add(button_1);
		
        label_1.setText("账号或密码错误！");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		label_1.setBounds(14, 34, 259, 46);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("lib\\对话框背景.jpg"));
		label_2.setBounds(-61, -38, 464, 182);
		contentPanel.add(label_2);
	}
}
