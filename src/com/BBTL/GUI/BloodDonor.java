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
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class BloodDonor {

	JFrame frame;
	private JTextField no;
	private JTextField name;
	private JTextField age;
	private JTable table;
	// private TableFillData tfd = new TableFillData();

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

		JLabel lblDonorName = new JLabel("Donor No.");
		lblDonorName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDonorName.setBounds(23, 179, 86, 14);
		frame.getContentPane().add(lblDonorName);

		JLabel label_1 = new JLabel("Blood Donation");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Nirmala UI", Font.BOLD, 21));
		label_1.setBounds(149, 39, 167, 37);
		frame.getContentPane().add(label_1);

		JLabel lblDonorName_1 = new JLabel("Donor Name");
		lblDonorName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDonorName_1.setBounds(23, 216, 86, 14);
		frame.getContentPane().add(lblDonorName_1);

		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloodGroup.setBounds(23, 250, 86, 14);
		frame.getContentPane().add(lblBloodGroup);

		JLabel lblSex = new JLabel("Gender");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(23, 285, 86, 14);
		frame.getContentPane().add(lblSex);

		JComboBox bgroup = new JComboBox();
		bgroup.setFont(new Font("Tahoma", Font.BOLD, 11));
		bgroup.setModel(new DefaultComboBoxModel(
				new String[] { "Select Blood Group", "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
		bgroup.setBounds(135, 246, 132, 22);
		frame.getContentPane().add(bgroup);

		JComboBox gender = new JComboBox();
		gender.setFont(new Font("Tahoma", Font.BOLD, 11));
		gender.setModel(new DefaultComboBoxModel(new String[] { "Select Gender", "Male", "Female", "Rather Not Say" }));
		gender.setBounds(135, 281, 132, 22);
		frame.getContentPane().add(gender);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(23, 320, 86, 14);
		frame.getContentPane().add(lblAge);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(21, 140, 46, 14);
		frame.getContentPane().add(lblDate);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAdd.setBounds(23, 371, 89, 23);
		frame.getContentPane().add(btnAdd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 21, 442, 307);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		// table.setModel(tfd.refreshFromDB());
		scrollPane.setViewportView(table);
		table.setBackground(Color.PINK);

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

		no = new JTextField();
		no.setBounds(135, 176, 132, 20);
		frame.getContentPane().add(no);
		no.setColumns(10);

		name = new JTextField();
		name.setBounds(135, 213, 132, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setBounds(135, 317, 132, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);

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