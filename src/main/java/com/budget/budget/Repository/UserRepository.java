package com.budget.budget.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budget.budget.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}