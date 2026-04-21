package com.campus.booking.controller;

import com.campus.booking.model.Booking;
import com.campus.booking.repository.BookingRepository;
import com.campus.booking.repository.UserRepository;
import com.campus.booking.repository.ResourceRepository;
import com.campus.booking.strategy.ApproveStrategy;
import com.campus.booking.strategy.RejectStrategy;
import com.campus.booking.strategy.CancelStrategy;
import com.campus.booking.strategy.BookingStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    // CREATE BOOKING
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {

        Long userId = booking.getUser().getId();
        booking.setUser(userRepository.findById(userId).orElseThrow());

        Long resourceId = booking.getResource().getId();
        booking.setResource(resourceRepository.findById(resourceId).orElseThrow());

        booking.setStatus("PENDING");

        return bookingRepository.save(booking);
    }

    // GET ALL BOOKINGS
    @GetMapping
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    // GET BOOKINGS BY USER
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingRepository.findAll()
                .stream()
                .filter(b -> b.getUser().getId().equals(userId))
                .toList();
    }

    // ✅ APPROVE BOOKING
    @PutMapping("/approve/{id}")
    public Booking approve(@PathVariable Long id) {

        Booking booking = bookingRepository.findById(id).orElseThrow();

        BookingStrategy strategy = new ApproveStrategy();
        strategy.process(booking);

        return bookingRepository.save(booking);
    }

    //REJECT BOOKING
    @PutMapping("/reject/{id}")
    public Booking reject(@PathVariable Long id) {

        Booking booking = bookingRepository.findById(id).orElseThrow();

        BookingStrategy strategy = new RejectStrategy();
        strategy.process(booking);

        return bookingRepository.save(booking);
    }

    //CANCEL BOOKING
    @PutMapping("/cancel/{id}")
    public Booking cancel(@PathVariable Long id) {

        Booking booking = bookingRepository.findById(id).orElseThrow();

        BookingStrategy strategy = new CancelStrategy();
        strategy.process(booking);

        return bookingRepository.save(booking);
    }
}
