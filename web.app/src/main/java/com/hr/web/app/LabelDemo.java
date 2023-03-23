package com.hr.web.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.SwingConstants;

public class LabelDemo extends JFrame {
	private JDesktopPane desktopPane;
	private JTextField txtEmployeeScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelDemo frame = new LabelDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LabelDemo() {
		setUndecorated(true);
		setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		
		desktopPane = new JDesktopPane();
		desktopPane.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		desktopPane.setForeground(new Color(0, 0, 0));
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Application");
		btnNewButton.setBackground(new Color(214, 217, 223));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(239, 182, 218, 43);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton_2.setBounds(590, 111, 119, 43);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Evaluation");
		btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(239, 295, 218, 43);
		desktopPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Pending Applications");
		btnNewButton_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(239, 406, 218, 43);
		desktopPane.add(btnNewButton_4);
		
		txtEmployeeScreen = new JTextField();
		txtEmployeeScreen.setBackground(new Color(255, 255, 255));
		txtEmployeeScreen.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmployeeScreen.setText("Employee Screen");
		txtEmployeeScreen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		txtEmployeeScreen.setBounds(0, 0, 715, 83);
		desktopPane.add(txtEmployeeScreen);
		txtEmployeeScreen.setColumns(10);
	}
}
