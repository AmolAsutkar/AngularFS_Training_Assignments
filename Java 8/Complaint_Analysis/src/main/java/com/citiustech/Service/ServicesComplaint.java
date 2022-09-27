package com.citiustech.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.citiustech.entity.Complaint;
import com.citiustech.fileparser.CsvLoader;

public class ServicesComplaint {

	CsvLoader csv=new CsvLoader();
	List<Complaint> complist=csv.loadFile();
	
	public List<Complaint> fetchComplaintById(int complaint_id) {
		
		
	return complist.stream().filter(c -> c.getComplaintId().equals(Integer.toString(complaint_id))).collect(Collectors.toList());
		
		
	}

}
