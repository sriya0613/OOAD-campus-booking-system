package com.campus.booking.strategy;

import com.campus.booking.model.Booking;

public class CancelStrategy implements BookingStrategy {

    @Override
    public void process(Booking booking) {
        booking.setStatus("CANCELLED");
        booking.getResource().setStatus("AVAILABLE");
    }
}
