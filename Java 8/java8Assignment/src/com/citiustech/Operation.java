package com.citiustech;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;



public class Operation {

	List<ComplaintPojo> complaints = Complaints.getCsvFile();

	
	public List<ComplaintPojo> getComplaintById(int complaintId) {
		return complaints.stream().filter(c -> c.getComplaintId().equals(Integer.toString(complaintId))).collect(Collectors.toList());
	}

	public List<ComplaintPojo> getComplaintByYear(int year) {
		return complaints.stream().filter(c -> c.getDateReceived().getYear() == year).collect(Collectors.toList());
	}

	public List<ComplaintPojo> getComplaintByBankName(String bankName) {
		return complaints.stream().filter(c -> c.getCompany().equals(bankName)).collect(Collectors.toList());
	}

	public long getComplaintResolutionPeriod(int complaintId) {
		ComplaintPojo complaint = complaints.stream().filter(c -> c.getComplaintId().equals(Integer.toString(complaintId))).findFirst().get();
		long days = ChronoUnit.DAYS.between(complaint.getDateReceived(), complaint.getDateClosed());
		return days;
		
	}
	
}
