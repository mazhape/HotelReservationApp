package com.example;

import java.util.*;

public class ReservationSystem {
    List<Hotel> hotels;
    private List<Reservation> reservations;

    public ReservationSystem() {
        this.hotels = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> searchHotels(String location) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getLocation().equalsIgnoreCase(location)) {
                result.add(hotel);
            }
        }
        return result;
    }

    public Reservation makeReservation(String userName, Hotel hotel, Room room, Date checkIn, Date checkOut) {
        if (room.isAvailable(checkIn, checkOut)) {
            room.reserve(checkIn, checkOut);
            Reservation reservation = new Reservation(userName, hotel, room, checkIn, checkOut);
            reservations.add(reservation);
            return reservation;
        }
        return null;
    }

    public void viewReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
