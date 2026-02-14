package com.lpu.main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.lpu.dao.BookingDAO;
import com.lpu.entity.Booking;

public class App {

    private static int getPricePerDay(String roomType) {
        return switch (roomType) {
            case "Standard" -> 2000;
            case "Deluxe" -> 3500;
            case "Suite" -> 5000;
            default -> -1;
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingDAO dao = new BookingDAO();

        int choice;

        do {
            System.out.println("\n===== HOTEL BOOKING MENU =====");
            System.out.println("1. Add Booking");
            System.out.println("2. View All Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= ADD =================
                case 1:
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();

                    System.out.println("\nRoom Prices:");
                    System.out.println("Standard → ₹2000/day");
                    System.out.println("Deluxe   → ₹3500/day");
                    System.out.println("Suite    → ₹5000/day");

                    System.out.print("Enter Room Type: ");
                    String room = sc.nextLine();

                    int price = getPricePerDay(room);
                    if (price == -1) {
                        System.out.println("Invalid room type!");
                        break;
                    }

                    try {
                        System.out.print("Check-in Date (YYYY-MM-DD): ");
                        LocalDate in = LocalDate.parse(sc.nextLine());

                        System.out.print("Check-out Date (YYYY-MM-DD): ");
                        LocalDate out = LocalDate.parse(sc.nextLine());

                        long days = ChronoUnit.DAYS.between(in, out);

                        if (days <= 0) {
                            System.out.println("Check-out must be after check-in.");
                            break;
                        }

                        double total = days * price;

                        System.out.println("\nPreview → Days: " + days + ", Amount: ₹" + total);

                        System.out.print("Confirm booking? (yes/no): ");
                        if (!sc.nextLine().equalsIgnoreCase("yes")) {
                            System.out.println("Booking cancelled.");
                            break;
                        }

                        dao.saveBooking(new Booking(name, room, in, out));
                        System.out.println("Booking added!");

                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }
                    break;

                // ================= VIEW =================
                case 2:
                    List<Booking> list = dao.getAllBookings();

                    System.out.println("\n--- All Bookings ---");
                    for (Booking b : list) {
                        System.out.println(
                                b.getBookingId() + " | " +
                                b.getCustomerName() + " | " +
                                b.getRoomType() + " | " +
                                b.getCheckInDate() + " → " +
                                b.getCheckOutDate() + " | ₹" +
                                b.getTotalAmount()
                        );
                    }
                    break;

                // ================= UPDATE =================
                case 3:
                    System.out.print("Enter Booking ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Room Type: ");
                    String newRoom = sc.nextLine();

                    if (dao.updateRoomType(id, newRoom))
                        System.out.println("Updated successfully!");
                    else
                        System.out.println("Booking not found.");
                    break;

                // ================= DELETE =================
                case 4:
                    System.out.print("Enter Booking ID: ");
                    int delId = sc.nextInt();

                    if (dao.deleteBooking(delId))
                        System.out.println("Deleted successfully!");
                    else
                        System.out.println("Booking not found.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        dao.closeFactory();
        sc.close();
    }
}
