package com.Linklist.GUI;

import java.util.LinkedList;
import java.util.List;

public class LinkList {
	List<Object> listOfDonor = new LinkedList<Object>();
	List<Integer> DonorIDnAge = new LinkedList<Integer>();
	

	public void addToLinkList(int AutoID, String bsName, String bsGroup, String bsGender, int bsAge)
	{
		listOfDonor.add(new Integer(AutoID));
		listOfDonor.add(bsName);
		listOfDonor.add(bsGroup);
		listOfDonor.add(bsGender);
		listOfDonor.add(new Integer(bsAge));
		
		System.out.println(listOfDonor);

		for(Object o: listOfDonor) {
		    if (o instanceof Integer) {
		    	DonorIDnAge.add((Integer) o);
		    }
		}
		System.out.println(DonorIDnAge);
		
	}
}
