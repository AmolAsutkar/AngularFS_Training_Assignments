package com.citiustech.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opencsv.bean.CsvBindByName;

public class Complaints {
	
	DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	
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
	
	@CsvBindByName(column = "State")
	private String state;
	
	@CsvBindByName(column = "ZIP code")
	private String zipCode;
	
	@CsvBindByName(column = "Submitted via")
	private String submittedVia;
	
	@CsvBindByName(column = "Date closed")
	private String dateClosed;
	
	@CsvBindByName(column = "Company response to consumer")
	private String companyResponse;

	@CsvBindByName(column = "Timely response?")
	private String timelyResponse;
	
	@CsvBindByName(column = "Consumer disputed?")
	private String consumerDisrupted;
	
	@CsvBindByName(column = "Complaint ID")
	private String complaintId;

	public LocalDate getDateReceived() {
		if(dateReceived.contains("/"))
			return LocalDate.parse(dateReceived, dateTimeFormatter1);
		return LocalDate.parse(dateReceived, dateTimeFormatter2);

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSubmittedVia() {
		return submittedVia;
	}

	public void setSubmittedVia(String submittedVia) {
		this.submittedVia = submittedVia;
	}

	public LocalDate getDateClosed() {
		if(dateClosed.contains("/"))
			return LocalDate.parse(dateClosed, dateTimeFormatter1);
		return LocalDate.parse(dateClosed, dateTimeFormatter2);
	}

	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getCompanyResponse() {
		return companyResponse;
	}

	public void setCompanyResponse(String companyResponse) {
		this.companyResponse = companyResponse;
	}

	public String getTimelyResponse() {
		return timelyResponse;
	}

	public void setTimelyResponse(String timelyResponse) {
		this.timelyResponse = timelyResponse;
	}

	public String getConsumerDisrupted() {
		return consumerDisrupted;
	}

	public void setConsumerDisrupted(String consumerDisrupted) {
		this.consumerDisrupted = consumerDisrupted;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	@Override
	public String toString() {
		return "Complaints [dateReceived=" + dateReceived + ", product=" + product + ", subProduct=" + subProduct
				+ ", issue=" + issue + ", subIssue=" + subIssue + ", company=" + company + ", state=" + state
				+ ", zipCode=" + zipCode + ", submittedVia=" + submittedVia + ", dateClosed=" + dateClosed
				+ ", companyResponse=" + companyResponse + ", timelyResponse=" + timelyResponse + ", consumerDisrupted="
				+ consumerDisrupted + ", complaintId=" + complaintId + "]";
	}	

}
