package com.citiustech.entity;

import com.opencsv.bean.CsvBindByName;

public class Complaint {

	@CsvBindByName(column = "Received date")
	private String dateReceived;
	
	@CsvBindByName(column = "Product")
		private String product;
		
		@CsvBindByName(column = "Sub-product")
		private String subProduct;
		
		@CsvBindByName(column = "Issue")
		private String issue;
		
		@CsvBindByName(column = "Sub-issue")
		private String subIssue;
		
		@CsvBindByName(column = "Company")
		private String company;
		
		
		@CsvBindByName(column = "Date closed")
		private String dateClosed;
		
		
		@CsvBindByName(column = "Complaint ID")
		private String complaintId;
	
		


	public String getComplaintId() {
			return complaintId;
		}


		public void setComplaintId(String complaintId) {
			this.complaintId = complaintId;
		}


	public String getDateReceived() {
		return dateReceived;
	}


	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getSubProduct() {
		return subProduct;
	}


	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}


	public String getIssue() {
		return issue;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}


	public String getSubIssue() {
		return subIssue;
	}


	public void setSubIssue(String subIssue) {
		this.subIssue = subIssue;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getDateClosed() {
		return dateClosed;
	}


	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}


}
