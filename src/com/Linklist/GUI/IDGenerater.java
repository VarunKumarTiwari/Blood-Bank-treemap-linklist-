package com.Linklist.GUI;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class IDGenerater {
	private ArrayList<Integer> IDarr = new ArrayList<Integer>(30);
	private int counter = 0;
	private int autoID = 0;

	public int autoIDGenerate() {

		boolean flag = true;
		int id = (int) (Math.random() * (1 - 30) + 30);
		for (Integer number : IDarr) {
			if (number == id) {
				flag = false;
			}
		}

		if (flag == true) {
			if (counter <= 29) {
				autoID = id;

				counter++;
			} else {
				JOptionPane.showMessageDialog(null, "Memory full");
			}
		} else {
			if (counter <= 29) {
				autoIDGenerate();
				counter++;
			} else {
				JOptionPane.showMessageDialog(null, "Memory full");
			}
		}
		return autoID;
	}
	public void addToList(int id)
	{
		IDarr.add(id);
		
	}
	
	public void deleteToList(int id)
	{
		IDarr.remove(id);
		for(int number:IDarr)
		{
			System.out.println(IDarr);
		}
		
	}

}
