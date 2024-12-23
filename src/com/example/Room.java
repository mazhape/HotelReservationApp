package com.example;

import java.util.*;

public class Room {
    private String type;
    private double price;
    private Map<Date, Boolean> availability;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
        this.availability = new HashMap<>();
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable(Date checkIn, Date checkOut) {
        for (Date date = checkIn; !date.after(checkOut); date = new Date(date.getTime() + 24 * 60 * 60 * 1000)) {
            if (availability.getOrDefault(date, true) == false) {
                return false;
            }
        }
        return true;
    }

    public void reserve(Date checkIn, Date checkOut) {
        for (Date date = checkIn; !date.after(checkOut); date = new Date(date.getTime() + 24 * 60 * 60 * 1000)) {
            availability.put(date, false);
        }
    }

    public void cancelReservation(Date checkIn, Date checkOut) {
        for (Date date = checkIn; !date.after(checkOut); date = new Date(date.getTime() + 24 * 60 * 60 * 1000)) {
            availability.put(date, true);
        }
    }
}
