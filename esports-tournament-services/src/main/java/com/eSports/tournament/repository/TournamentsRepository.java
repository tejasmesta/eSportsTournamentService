package com.eSports.tournament.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eSports.tournament.modelclassforentitites.Tournament;

@Repository
public interface TournamentsRepository extends MongoRepository<Tournament, String> {

}
