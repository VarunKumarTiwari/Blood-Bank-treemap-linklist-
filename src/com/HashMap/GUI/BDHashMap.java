package com.HashMap.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BDHashMap {

	HashMap<Integer, DonorData> map = new HashMap<Integer, DonorData>();
	public DonorData dData = new DonorData();

	public HashMap<Integer, DonorData> insertRec(int AutoID, String name, String bGroup, String Gender, int age) {

		dData.setName(name);
		dData.setbGroup(bGroup);
		dData.setGender(Gender);
		dData.setAge(age);

		map.put(AutoID, dData);
		return map;
	}

	public boolean ifExist(int id) {
		Iterator<Map.Entry<Integer, DonorData>> iterator = map.entrySet().iterator();
		boolean isKeyPresent = false;
		while (iterator.hasNext()) {
			Map.Entry<Integer, DonorData> entry = iterator.next();
			if (id == entry.getKey()) {

				isKeyPresent = true;
			}
		}
		return isKeyPresent;
	}

	public DonorData searchRec(int id) {
		boolean result = ifExist(id);
		if (result) {
			return map.get(id);
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Key Entered");
			return null;
		}
	}

	public void deleteRec(int id) {
		boolean result = ifExist(id);
		if (result) {
			map.remove(id);
			JOptionPane.showMessageDialog(null, "Record is Deleted");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Key Entered");

		}
	}

	public static TableModel toTableModel(Map<Integer, DonorData> map) {
		DefaultTableModel model = new DefaultTableModel(new Object[] { "Key", "Name", "Blood Group", "Gender", "Age" },
				0);
		for (Map.Entry<Integer, DonorData> entry : map.entrySet()) {
			model.addRow(new Object[] { entry.getKey(), entry.getValue().getName(), entry.getValue().getbGroup(),
					entry.getValue().getGender(), entry.getValue().getAge() });
		}

		return model;
	}

}
