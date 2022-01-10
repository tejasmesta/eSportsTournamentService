package com.eSports.tournament.modelclassforentitites;



public class PayoutSchemes {
	
	public PayoutSchemes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PayoutSchemes(int string, int string2) {
		super();
		this.totalWinners = string;
		this.prizePool = string2;
	}

	public int getTotalWinners() {
		return totalWinners;
	}

	public void setTotalWinners(int totalWinners) {
		this.totalWinners = totalWinners;
	}

	public int getPrizePool() {
		return prizePool;
	}

	public void setPrizePool(int prizePool) {
		this.prizePool = prizePool;
	}

	private int totalWinners;
	
	private int prizePool;  
}
