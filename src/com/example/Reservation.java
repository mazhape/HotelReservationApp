package com.example;

import java.util.*;

public class Reservation {
    private String userName;
    private Hotel hotel;
    private Room room;
    private Date checkIn;
    private Date checkOut;

    public Reservation(String userName, Hotel hotel, Room room, Date checkIn, Date checkOut) {
        this.userName = userName;
        this.hotel = hotel;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return String.format("Reservation by %s at %s, Room: %s, From: %s to %s",
                userName, hotel.getName(), room.getType(), checkIn, checkOut);
    }
}
