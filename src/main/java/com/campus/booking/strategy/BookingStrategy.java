package com.campus.booking.strategy;

import com.campus.booking.model.Booking;

public interface BookingStrategy {
    void process(Booking booking);
}