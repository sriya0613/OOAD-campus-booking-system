package com.campus.booking.strategy;

import com.campus.booking.model.Booking;

public class ApproveStrategy implements BookingStrategy {

    @Override
    public void process(Booking booking) {
        booking.setStatus("APPROVED");
    }
}