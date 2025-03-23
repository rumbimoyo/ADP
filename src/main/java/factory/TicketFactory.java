package factory;

/*
factory.TicketFactory
Ticket Factory class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */
import domain.ParkingLot;
import domain.Ticket;
import domain.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class TicketFactory {

    // create a Ticket
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static Ticket createTicket(long ticketID, ParkingLot parkingLot, Vehicle vehicle) {
        if (ticketID <= 0 || parkingLot == null || vehicle == null) {
            throw new IllegalArgumentException("Invalid ticket parameters.");
        }

        String entryTime = LocalDateTime.now().format(formatter);

        return new Ticket.Builder()
                .ticketID(ticketID)
                .entryTime(entryTime)
                .parkingLot(parkingLot)
                .vehicle(vehicle)
                .price(0.0)
                .build();
    }

    /**
     * Creates a Ticket with a custom exit time (for completed transactions).
     */
    public static Ticket createCompletedTicket(long ticketID, ParkingLot parkingLot, Vehicle vehicle, String exitTime) {
        if (ticketID <= 0 || parkingLot == null || vehicle == null || exitTime == null || exitTime.isEmpty()) {
            throw new IllegalArgumentException("Invalid ticket parameters.");
        }

        String entryTime = LocalDateTime.now().format(formatter);

        return new Ticket.Builder()
                .ticketID(ticketID)
                .entryTime(entryTime)
                .exitTime(exitTime)
                .parkingLot(parkingLot)
                .vehicle(vehicle)
                .price(0.0)
                .build();
    }

}

