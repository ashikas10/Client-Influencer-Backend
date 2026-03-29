package com.budget.budget.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.budget.budget.Model.AddClient;
public interface AddClientRepository extends JpaRepository<AddClient, Long> {
    
}
