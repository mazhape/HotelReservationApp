package com.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ReservationSystem system = new ReservationSystem();

        // Sample Data
        Hotel hotel1 = new Hotel("Grand Hotel", "New York");
        hotel1.addRoom(new Room("Single", 100));
        hotel1.addRoom(new Room("Double", 200));
        system.addHotel(hotel1);

        Hotel hotel2 = new Hotel("Ocean View", "Miami");
        hotel2.addRoom(new Room("Suite", 300));
        system.addHotel(hotel2);

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\n1. Search Hotels");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    List<Hotel> hotels = system.searchHotels(location);
                    if (hotels.isEmpty()) {
                        System.out.println("No hotels found.");
                    } else {
                        for (Hotel hotel : hotels) {
                            System.out.println(hotel.getName());
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter hotel name: ");
                    String hotelName = scanner.nextLine();
                    Hotel selectedHotel = null;
                    for (Hotel hotel : system.hotels) {
                        if (hotel.getName().equalsIgnoreCase(hotelName)) {
                            selectedHotel = hotel;
                            break;
                        }
                    }
                    if (selectedHotel == null) {
                        System.out.println("Hotel not found.");
                        break;
                    }
                    System.out.print("Enter room type: ");
                    String roomType = scanner.nextLine();
                    Room selectedRoom = null;
                    for (Room room : selectedHotel.getRooms()) {
                        if (room.getType().equalsIgnoreCase(roomType)) {
                            selectedRoom = room;
                            break;
                        }
                    }
                    if (selectedRoom == null) {
                        System.out.println("Room not found.");
                        break;
                    }
                    System.out.print("Enter check-in date (yyyy-MM-dd): ");
                    Date checkIn = sdf.parse(scanner.nextLine());
                    System.out.print("Enter check-out date (yyyy-MM-dd): ");
                    Date checkOut = sdf.parse(scanner.nextLine());
                    Reservation reservation = system.makeReservation(userName, selectedHotel, selectedRoom, checkIn,
                            checkOut);
                    if (reservation == null) {
                        System.out.println("Room not available.");
                    } else {
                        System.out.println("Reservation successful!");
                    }
                }
                case 3 -> system.viewReservations();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
