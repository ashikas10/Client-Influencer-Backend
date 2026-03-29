package com.budget.budget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budget.budget.Model.Influencer;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    Influencer findByEmail(String email);
}