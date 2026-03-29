package com.budget.budget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budget.budget.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
