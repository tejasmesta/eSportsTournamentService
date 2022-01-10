package com.eSports.tournament.repository.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.eSports.tournament.modelclassforentitites.ContestDetails;
import com.eSports.tournament.modelclassforentitites.Game;
import com.eSports.tournament.modelclassforentitites.PayoutSchemes;
import com.eSports.tournament.modelclassforentitites.Tournament;
import com.eSports.tournament.repository.TournamentsRepository;

@RestController
public class TournamentController {
	
	@Autowired
	private TournamentsRepository repo;
	
	
	
	@GetMapping("/tournaments")
	private ResponseEntity<?> getAllTournaments()
	{
		List<Tournament> tournaments = repo.findAll();
		
		if(tournaments.size()>0)
		{
			return new ResponseEntity<List<Tournament>>(tournaments,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("no data to show",HttpStatus.NOT_FOUND);
		}			
		
	}
	
	@PostMapping("/addTournament")
	public ResponseEntity<?> addTournament()
	{
		try
		{
			Game game = new Game("Valorant","4v4");
			
			ContestDetails cD = new ContestDetails("12-12-21","06-01-2022","02-02-2022","10000");
			
			PayoutSchemes payoutSchemes = new PayoutSchemes(3 ,100000);
			
			Tournament tournament = new Tournament(					
					"Valorant Asian ChampionShip",
					"www.valorant.com",
					"www.valorant.com",
					"www.valorant.com",
					game,
					cD,
					payoutSchemes,
					new Date(System.currentTimeMillis()),
					null
					);
			
			
			repo.save(tournament);
			return new ResponseEntity<Tournament>(tournament,HttpStatus.OK); 
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		
	}

	
	@PostMapping("/tournament")
	public ResponseEntity<?> createTournament(@RequestBody Tournament tournament)
	{
		try
		{
			tournament.setCreatedAt(new Date(System.currentTimeMillis()));
			repo.save(tournament);
			return new ResponseEntity<Tournament>(tournament,HttpStatus.OK); 
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		
	}
	
	@GetMapping("/tournament/{id}")
	private ResponseEntity<?> getTournament(@PathVariable("id")String id)
	{
		Optional<Tournament> tourOptional = repo.findById(id);	
		
		if(tourOptional.isPresent())
		{
			return new ResponseEntity<>(tourOptional.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Doesn't exist",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/tournament/{id}")
	private ResponseEntity<?> updateTournamentById(@PathVariable("id")String id, @RequestBody Tournament tour)
	{
		Optional<Tournament> tourOptional = repo.findById(id);	
		
		if(tourOptional.isPresent())
		{
			Tournament saveTour = tourOptional.get();
			saveTour.setName(tour.getName()!=null?tour.getName():saveTour.getName());
			saveTour.setGame(tour.getGame()!=null?tour.getGame():saveTour.getGame());
			saveTour.setPayoutSchemes(tour.getPayoutSchemes()!=null?tour.getPayoutSchemes():saveTour.getPayoutSchemes());
			saveTour.setContestDetails((tour.getContestDetails()!=null?tour.getContestDetails():saveTour.getContestDetails())); 
			saveTour.setFacebookLink(tour.getFacebookLink() !=null?tour.getFacebookLink() :saveTour.getFacebookLink());
			saveTour.setTournamentLink(tour.getTournamentLink() !=null?tour.getTournamentLink() :saveTour.getTournamentLink());
			saveTour.setTwitterLink(tour.getTwitterLink() !=null?tour.getTwitterLink() :saveTour.getTwitterLink()); 			
			saveTour.setUpdatedAt(new Date(System.currentTimeMillis()));		
			
			repo.save(saveTour);
			
			return new ResponseEntity<>(saveTour,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Doesn't exist",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@DeleteMapping("/tournament/{id}")
	private ResponseEntity<?> deleteTournamentById(@PathVariable("id")String id)
	{
		try
		{
			repo.deleteById(id);
			return new ResponseEntity<>("Successfully deleted",HttpStatus.OK); 
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}		
		
	}

}
