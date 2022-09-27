package com.citiustech.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.citiustech.entity.Complaint;
import com.citiustech.fileparser.CsvLoader;

public class ComplaintServices {
	CsvLoader csvloader=new CsvLoader();
	
	List<Complaint> complist=csvloader.loadFile();
	
	public List<Complaint> fetchComplaintById(int complaint_id) {
		return complist
				.stream().filter(s->s.getComplaintId().equals(Integer.toString(complaint_id))).collect(Collectors.toList());
	
				
}
}