package com.eSports.tournament.modelclassforentitites;



public class ContestDetails {
	
	public String getRegistrationLastDate() {
		return registrationLastDate;
	}

	public void setRegistrationLastDate(String registrationLastDate) {
		this.registrationLastDate = registrationLastDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public ContestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContestDetails(String registrationLastDate, String startDate, String endDate, String entryFee) {
		super();
		this.registrationLastDate = registrationLastDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.entryFee = entryFee;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(String entryFee) {
		this.entryFee = entryFee;
	}

	private String registrationLastDate;
	
	private String startDate;
	
	private String endDate;
	
	private String entryFee;

}
