package com.tripEvaluator.s22868.tripEvaluators22868;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripEvaluatorRepo extends JpaRepository<Trip, Integer> {}
