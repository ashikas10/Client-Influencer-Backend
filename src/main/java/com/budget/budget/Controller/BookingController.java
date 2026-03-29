package com.budget.budget.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.budget.budget.Model.Booking;
import com.budget.budget.Repository.BookingRepository;

@RestController
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingRepository repo;

    @PostMapping("/bookings")
    public Booking saveBooking(@RequestBody Booking booking) {
        booking.setStatus("PENDING"); 
        return repo.save(booking);
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return repo.findAll();
    }

    @PutMapping("/booking/{id}/status")
    public Booking updateStatus(@PathVariable Long id, @RequestParam String status) {

        Booking b = repo.findById(id).orElseThrow();

        b.setStatus(status);

        return repo.save(b);
    }
}
