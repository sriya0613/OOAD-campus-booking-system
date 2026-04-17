package com.campus.booking.strategy;

import com.campus.booking.model.Booking;

public class RejectStrategy implements BookingStrategy {

    @Override
    public void process(Booking booking) {
        booking.setStatus("REJECTED");
    }
}