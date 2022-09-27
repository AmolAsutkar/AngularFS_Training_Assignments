package com.assign1.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import com.assign1.entity.Complaints;
import com.assign1.repo.Repo;

public class Service implements ServiceImpl {
	
	List<Complaints> complaints = Repo.getCsvFile();

	@Override
	public List<Complaints> getComplaintById(int complaintId) {
		return complaints.stream().filter(c -> c.getComplaintId().equals(Integer.toString(complaintId))).collect(Collectors.toList());
	}

	@Override
	public List<Complaints> getComplaintByYear(int year) {
		return complaints.stream().filter(c -> c.getDateReceived().getYear() == year).collect(Collectors.toList());
	}

	@Override
	public List<Complaints> getComplaintByBankName(String bankName) {
		return complaints.stream().filter(c -> c.getCompany().equals(bankName)).collect(Collectors.toList());
	}

	@Override
	public long getComplaintResolutionPeriod(int complaintId) {
		Complaints complaint = complaints.stream().filter(c -> c.getComplaintId().equals(Integer.toString(complaintId))).findFirst().get();
		long days = ChronoUnit.DAYS.between(complaint.getDateReceived(), complaint.getDateClosed());
		return days;
		
	}
	
	

}
