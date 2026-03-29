package com.budget.budget.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.budget.budget.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
