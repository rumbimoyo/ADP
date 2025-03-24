package factory;
import domain.Vehicle;
import domain.Ticket;
import domain.Reservation;
import domain.ParkingLot;
import domain.ParkingSpot;
import util.Helper;

import java.util.Set;
import java.util.HashSet;

/* Vehicle.java
   Vehicle Factory class
   Author: Casey Abigail Nolte (218275161)
   Date: 21 March 2025
*/

public class VehicleFactory {

    public static Vehicle createVehicle(String licensePlate, String vehicleMake, String vehicleModel,
                                        String vehicleColour, String vehicleVIN, ParkingLot parkingLot,
                                        ParkingSpot parkingSpot) {
        if (Helper.isNullorEmpty(licensePlate) || Helper.isNullorEmpty(vehicleMake) ||
                Helper.isNullorEmpty(vehicleModel) || Helper.isNullorEmpty(vehicleColour) ||
                Helper.isNullorEmpty(vehicleVIN) || parkingLot == null || parkingSpot == null) {
            throw new IllegalArgumentException("Invalid vehicle parameters.");
        }

        // Create an empty set of tickets and reservations
        Set<Ticket> tickets = new HashSet<>();
        Set<Reservation> reservations = new HashSet<>();

        // Generate a ticket for this vehicle
        Ticket ticket = TicketFactory.createTicket(System.currentTimeMillis(), parkingLot, new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .build());
        tickets.add(ticket);

        // Generate a reservation for this vehicle
        Reservation reservation = ReservationFactory.createBasicReservation(
                "RES-" + System.currentTimeMillis(), "08:00", "18:00", new java.util.Date(), parkingSpot);
        reservations.add(reservation);

        return new Vehicle.Builder()
                .setLicensePlate(licensePlate)
                .setVehicleMake(vehicleMake)
                .setVehicleModel(vehicleModel)
                .setVehicleColour(vehicleColour)
                .setVehicleVIN(vehicleVIN)
                .setTickets(tickets)
                .setReservations(reservations)
                .build();
    }
}
