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

public class BloodDonor {

	JFrame frame;
	private JTextField name;
	private JTextField age;
	private IDGenerater idg = new IDGenerater();
	private BinarySearchTree tree = new BinarySearchTree();
	private static Nodes root;
	private static JTextArea textArea;
	
	// private int DonorId= idg.autoIDGenerate();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodDonor window = new BloodDonor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	public BloodDonor() {
		initialize();

	}

	
	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame("Donor Detail Form");
		frame.setBounds(100, 100, 796, 444);
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

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnUpdate.setBounds(149, 371, 89, 23);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//tree.printBinaryTree(root, 0);
			}
		});
		btnDelete.setBounds(269, 371, 89, 23);
		frame.getContentPane().add(btnDelete);

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
				}
				
			}
		});
		btnAdd.setBounds(23, 371, 89, 23);
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
		btnCancel.setBounds(679, 371, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		

		JLabel lblbloodIcon = new JLabel("");
		lblbloodIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")).getImage()
				.getScaledInstance(123, 99, Image.SCALE_SMOOTH)));
		lblbloodIcon.setBounds(10, 11, 123, 99);
		frame.getContentPane().add(lblbloodIcon);

		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("background.jpg")));
		lblbackground.setBounds(0, 0, 780, 405);
		frame.getContentPane().add(lblbackground);

	}
}
