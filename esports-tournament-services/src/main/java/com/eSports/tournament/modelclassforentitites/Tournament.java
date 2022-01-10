package com.eSports.tournament.modelclassforentitites;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="tournaments")

public class Tournament {
	
	@Id
	private String id;
	
	private String name;
	
	private String tournamentLink;
	
	private String facebookLink;
	
	private String twitterLink;
	
	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournament( String name, String tournamentLink, String facebookLink, String twitterLink, Game game,
			ContestDetails contestDetails, PayoutSchemes payoutSchemes, Date createdAt, Date updatedAt) {
		super();
		
		this.name = name;
		this.tournamentLink = tournamentLink;
		this.facebookLink = facebookLink;
		this.twitterLink = twitterLink;
		this.game = game;
		this.contestDetails = contestDetails;
		this.payoutSchemes = payoutSchemes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private Game game;
	
	private ContestDetails contestDetails;
	
	private PayoutSchemes payoutSchemes; 
	
	private Date createdAt;
	
	private Date updatedAt;

	public String getTournamentLink() {
		return tournamentLink;
	}

	public void setTournamentLink(String tournamentLink) {
		this.tournamentLink = tournamentLink;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTwitterLink() {
		return twitterLink;
	}

	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public PayoutSchemes getPayoutSchemes() {
		return payoutSchemes;
	}

	public void setPayoutSchemes(PayoutSchemes payoutSchemes) {
		this.payoutSchemes = payoutSchemes;
	}

	public ContestDetails getContestDetails() {
		return contestDetails;
	}

	public void setContestDetails(ContestDetails contestDetails) {
		this.contestDetails = contestDetails;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
}
