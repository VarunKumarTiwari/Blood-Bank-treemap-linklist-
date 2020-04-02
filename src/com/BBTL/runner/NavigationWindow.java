package com.BBTL.runner;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.BBTL.GUI.BSTBloodDonor;
import com.HashMap.GUI.HMBloodDonor;
import com.Linklist.GUI.LLBloodDonor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class NavigationWindow  {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public NavigationWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Blood Donation");
		frame.setBounds(100, 100, 617, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBloodDonation = new JLabel("Blood Donation");
		lblBloodDonation.setFont(new Font("Nirmala UI", Font.BOLD, 27));
		lblBloodDonation.setForeground(new Color(107, 142, 35));
		lblBloodDonation.setBounds(40, 28, 239, 37);
		frame.getContentPane().add(lblBloodDonation);
		
		JButton btnBloodDonor = new JButton("Binary Search Tree");
		btnBloodDonor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBloodDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BSTBloodDonor window = new BSTBloodDonor();
				window.frame.setVisible(true);
			}
		});
		btnBloodDonor.setBounds(67, 91, 146, 37);
		frame.getContentPane().add(btnBloodDonor);
		
		JButton btnSearch = new JButton("Hash Map");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HMBloodDonor b = new HMBloodDonor();
		        b.frame.setVisible(true);
			}
		});
		btnSearch.setBounds(67, 175, 146, 37);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExportD = new JButton("Linked List");
		btnExportD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LLBloodDonor b = new LLBloodDonor();
		        b.frame.setVisible(true);
			}
		});
		btnExportD.setBounds(67, 258, 146, 37);
		frame.getContentPane().add(btnExportD);
		
		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage().getScaledInstance(335, 275, Image.SCALE_SMOOTH)));
		//	lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("news.png")).getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH)));
			lblbloodIcon.setBounds(256, 28, 335, 275);
			frame.getContentPane().add(lblbloodIcon);
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblNewLabel.setBounds(0, 0, 601, 332);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}
	
	

}
