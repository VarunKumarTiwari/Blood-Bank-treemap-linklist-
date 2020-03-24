package com.Linklist.GUI;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.HashMap.GUI.DonorData;

public class LinkList {
	LinkedList<LLDonorData> allDonor = new LinkedList<LLDonorData>();
private int index = 0;
private LLDonorData dData;
	public LinkedList<LLDonorData> addToLinkList(int AutoID, String bsName, String bsGroup, String bsGender, int bsAge) {
		
		dData = new LLDonorData();

		dData.setAutoId(AutoID);
		dData.setName(bsName);
		dData.setbGroup(bsGroup);
		dData.setGender(bsGender);
		dData.setAge(bsAge);
		allDonor.add(dData);
		return allDonor;

	}

	public static TableModel toTableModel(LinkedList<LLDonorData> list) {
		DefaultTableModel model = new DefaultTableModel(new Object[] { "Key", "Name", "Blood Group", "Gender", "Age" },
				0);
		for (LLDonorData entry : list) {
			
			model.addRow(new Object[] { entry.getAutoId(), entry.getName(), entry.getbGroup(),
					entry.getGender(), entry.getAge() });
		}

		return model;
	}
	public boolean ifExist(int id) {
	
		Iterator<LLDonorData> iterator = allDonor.iterator();
		boolean isKeyPresent = false;
		while (iterator.hasNext()) {
			
			LLDonorData listt = iterator.next();
			if (id == listt.getAutoId()) {
				
				isKeyPresent = true;
			//	System.out.println(allDonor.indexOf(dData.getAutoId()==id));

			}
		}

		return isKeyPresent;
	}
	
//	public LLDonorData searchRec(int id) {
//		boolean result = ifExist(id);
//		if (result) {
//			return map.get(id);
//		} else {
//			JOptionPane.showMessageDialog(null, "Invalid Key Entered");
//			return null;
//		}
//	}

	public void deleteRec(int id) {
		boolean result = ifExist(id);
		if (result) {
			
			//allDonor.remove();
			JOptionPane.showMessageDialog(null, "Record is Deleted");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Key Entered");

		}
	}

}
