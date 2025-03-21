package factory;

/*
factory.ParkingLotFactory
ParkingLot Factory class
Author: Thulani Lunyawo (222828250)
Date: 17/03/2025
 */




import domain.ParkingLot;
import domain.ParkingSpot;
import domain.Ticket;

import java.util.HashSet;
import java.util.Set;

public class ParkingLotFactory {

    // Factory method to create a ParkingLot instance
    public static ParkingLot createParkingLot(String lotId, String location, String openTime, String closingTime, double pricePerHour) {
        return new ParkingLot.Builder()
                .setLotId(lotId)
                .setLocation(location)
                .setOpenTime(openTime)
                .setClosingTime(closingTime)
                .setPricePerHour(pricePerHour)
                .setParkingSpots(new HashSet<>())  // Default empty set of parking spots
                .setTickets(new HashSet<>())  // Default empty set of tickets
                .build();
    }

    // Factory method to create a ParkingSpot instance
    public static ParkingSpot createParkingSpot(String spotId) {
        return new ParkingSpot(spotId);
    }

    // Factory method to create a Ticket instance
    public static Ticket createTicket(ParkingSpot spot) {
        return new Ticket(spot);
    }
}
