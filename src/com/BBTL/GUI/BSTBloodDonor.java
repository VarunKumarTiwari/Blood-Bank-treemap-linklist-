package com.BBTL.GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class BSTBloodDonor {

	public JFrame frame;
	private JTextField name;
	private JTextField age;
	private IDGenerater idg = new IDGenerater();
	private BinarySearchTree tree = new BinarySearchTree();
	private static Nodes root;
	private static JTextArea textArea;
	private JTextField serchtf;
	private JTextField textField;
	
	// private int DonorId= idg.autoIDGenerate();

	/**
	 * Launch the application.
	 */
	
	public static void printBinaryTree(Nodes root, int level){
		
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	    	
	        for(int i=0;i<level-1;i++) {
	        	textArea.append("|\t");
	        }
	        textArea.append("|-------"+root.key+" "+root.bsName);
	        textArea.append("\n");
	    }
	    else {
	    	
	    	textArea.append(root.key+" "+root.bsName);
	    textArea.append("\n");
	    }
	    printBinaryTree(root.left, level+1);
	} 

	
	/**
	 * Create the application.
	 */
	public BSTBloodDonor() {
		initialize();

	}

	
	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame("Donor Detail Form");
		frame.setBounds(100, 100, 796, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label_1 = new JLabel("Blood Donation");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Nirmala UI", Font.BOLD, 21));
		label_1.setBounds(149, 39, 167, 37);
		frame.getContentPane().add(label_1);

		JLabel lblDonorName_1 = new JLabel("Donor Name");
		lblDonorName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDonorName_1.setBounds(23, 182, 86, 14);
		frame.getContentPane().add(lblDonorName_1);

		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloodGroup.setBounds(23, 224, 86, 14);
		frame.getContentPane().add(lblBloodGroup);

		JLabel lblSex = new JLabel("Gender");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(23, 266, 86, 14);
		frame.getContentPane().add(lblSex);

		JComboBox bgroup = new JComboBox();
		bgroup.setFont(new Font("Tahoma", Font.BOLD, 11));
		bgroup.setModel(new DefaultComboBoxModel(
				new String[] { "Select Blood Group", "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
		bgroup.setBounds(135, 220, 132, 22);
		frame.getContentPane().add(bgroup);

		JComboBox gender = new JComboBox();
		gender.setFont(new Font("Tahoma", Font.BOLD, 11));
		gender.setModel(new DefaultComboBoxModel(new String[] { "Select Gender", "Male", "Female", "Rather Not Say" }));
		gender.setBounds(135, 262, 132, 22);
		frame.getContentPane().add(gender);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(23, 304, 86, 14);
		frame.getContentPane().add(lblAge);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(21, 140, 46, 14);
		frame.getContentPane().add(lblDate);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(181, 402, 488, 49);
		frame.getContentPane().add(panel);
				panel.setLayout(null);
		
				serchtf = new JTextField();
				serchtf.setBounds(153, 21, 191, 20);
				panel.add(serchtf);
				serchtf.setColumns(10);
				
				JLabel lblByDonorId = new JLabel("Search by Donor ID");
				lblByDonorId.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblByDonorId.setBounds(10, 24, 139, 14);
				panel.add(lblByDonorId);
				
				JButton btnSearch = new JButton("Search");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Nodes roott;
						int key = Integer.parseInt(serchtf.getText());
						roott = tree.searchRec(root,key);
						
						name.setText(""+root.bsName);
						bgroup.setSelectedItem(root.bsGroup);
						gender.setSelectedItem(root.bsGender);
						age.setText(""+root.bsAge);
						
					}
				});
				btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnSearch.setBounds(368, 20, 89, 23);
				panel.add(btnSearch);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		JLabel label = new JLabel(formatter.format(date));
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(65, 140, 77, 14);
		frame.getContentPane().add(label);

		name = new JTextField();
		name.setBounds(135, 179, 132, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setBounds(135, 301, 132, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 22, 442, 312);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	

		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Dname = name.getText();
				String Dbgroup = bgroup.getSelectedItem().toString();
				String Dgender = gender.getSelectedItem().toString();
				int Dage = 0;
				Dage = Integer.parseInt(age.getText());
				int AutoID = idg.autoIDGenerate();
				idg.addToList(AutoID);
				boolean flag = true;
				if(Dname==null)
				{
					JOptionPane.showMessageDialog(null, "Donor's name Can not be empty");
					flag = false;
				}
				if(Dbgroup==null)
				{
					JOptionPane.showMessageDialog(null, "Select Donor's Blood Group");
					flag = false;
				}if(Dgender==null)
				{
					JOptionPane.showMessageDialog(null, "Select Donor's gender");
					flag = false;
				}if(Dage==0)
				{
					JOptionPane.showMessageDialog(null, "Donor's age Can not be empty");
					flag = false;
				}
				if(flag==true)
				{
					textArea.setText("");
					root = tree.insertRec(root, AutoID,Dname,Dbgroup,Dgender,Dage);
					printBinaryTree(root, 0);
					name.setText("");
					bgroup.setSelectedIndex(0);
					gender.setSelectedIndex(0);
					age.setText("");
				}
				
			}
		});
		btnAdd.setBounds(53, 428, 89, 23);
		frame.getContentPane().add(btnAdd);

		JButton btnCancel = new JButton("EXIT");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				// NavigationWindow b = new NavigationWindow();
				// b.frame.setVisible(true);
			}
		});
		btnCancel.setBounds(679, 428, 89, 23);
		frame.getContentPane().add(btnCancel);
		

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(181, 345, 488, 49);
		frame.getContentPane().add(panel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(154, 21, 184, 20);
		panel_1.add(textField);
		
		JLabel lblDeleteByDonor = new JLabel("Delete by Donor ID");
		lblDeleteByDonor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeleteByDonor.setBounds(10, 24, 133, 14);
		panel_1.add(lblDeleteByDonor);
		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				int key = Integer.parseInt(textField.getText());
				tree.deleteRec(root,key);
				printBinaryTree(root, 0);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(365, 20, 89, 23);
		panel_1.add(button);

		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage()
				.getScaledInstance(123, 99, Image.SCALE_SMOOTH)));
		lblbloodIcon.setBounds(10, 11, 123, 99);
		frame.getContentPane().add(lblbloodIcon);

		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblbackground.setBounds(0, 0, 780, 462);
		frame.getContentPane().add(lblbackground);
		
		
		
		

	}
}
