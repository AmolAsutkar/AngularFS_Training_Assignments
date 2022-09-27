package com.citiustech.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import com.citiustech.entity.Complaints;
import com.citiustech.fileload.loadFile;


public class ServiceComplaint {
	
	loadFile loadfile=new loadFile();
	List<Complaints> complist=loadfile.loadCsvFile();
	

	public Complaints fetchComplaintById(int complaint_id) {
		
		
		return complist
				.stream()
				.filter(s-> s.getComplaintId().equals(Integer.toString(complaint_id))).findAny().orElse(null);
			
		}
	
	public List<Complaints> fetchAllComplaintYearBased(int year) {
		return complist
				.stream()
				.filter(s-> s.getDateReceived().getYear()==year).collect(Collectors.toList());
		
	}
	
	public List<Complaints> fetchAllComplaintBankNameBased(String bname){
		return complist
				.stream()
				.filter(s-> s.getCompany().equals(bname)).collect(Collectors.toList());
		
	}
	
	public long complaintOpenDuration(int compid) {
	Complaints complaint = complist.stream().filter(c -> c.getComplaintId().equals(Integer.toString(compid))).findAny().orElse(null);

		LocalDate dateReceived = complaint.getDateReceived();
		System.out.println(dateReceived);
		LocalDate dateClosed = complaint.getDateClosed();
		System.out.println(dateClosed);

		return ChronoUnit.DAYS.between(dateReceived, dateClosed);
	}
}
