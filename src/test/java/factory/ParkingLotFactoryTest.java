package factory;

/*
test.factory.ParkingLotFactoryTest
ParkingLotFactoryTest class
Author: Thulani Lunyawo (222828250)
Date: 18/03/2025
 */


import domain.ParkingLot;
import domain.ParkingSpot;
import domain.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotFactoryTest {

    private ParkingLot parkingLot;
    private ParkingSpot parkingSpot;
    private Ticket ticket;

    @Test
    @DisplayName("ParkingLotFactory test for creating ParkingLot")
    void createParkingLotFactory() {
        parkingLot = ParkingLotFactory.createParkingLot("PL001", "Downtown", "08:00", "20:00", 5.0);
        assertNotNull(parkingLot, "Should be an object of ParkingLot class");
        assertInstanceOf(ParkingLot.class, parkingLot, "Should be an instance of ParkingLot class");
        assertEquals("PL001", parkingLot.getLotId(), "Should be PL001");
        assertEquals("Downtown", parkingLot.getLocation(), "Should be Downtown");
        assertEquals(5.0, parkingLot.getPricePerHour(), "Should be 5.0 per hour");
    }

    @Test
    @DisplayName("ParkingLotFactory test for creating ParkingSpot")
    void createParkingSpotFactory() {
        parkingSpot = ParkingLotFactory.createParkingSpot("SP001");
        assertNotNull(parkingSpot, "Should be an object of ParkingSpot class");
        assertInstanceOf(ParkingSpot.class, parkingSpot, "Should be an instance of ParkingSpot class");
        assertEquals("SP001", parkingSpot.getSpotId(), "Should be SP001");
        assertEquals("Compact", parkingSpot.getType(), "Should be Compact");
    }

    @Test
    @DisplayName("ParkingLotFactory test for creating Ticket")
    void createTicketFactory() {
        parkingSpot = ParkingLotFactory.createParkingSpot("SP001");
        ticket = ParkingLotFactory.createTicket(parkingSpot);
        assertNotNull(ticket, "Should be an object of Ticket class");
        assertInstanceOf(Ticket.class, ticket, "Should be an instance of Ticket class");
        assertEquals(parkingSpot, ticket.getParkingSpot(), "Ticket should be associated with the correct parking spot");
    }

    @Test
    @DisplayName("ParkingLotFactory test, excludes parking spots for ParkingLot")
    void createParkingLotFactoryExcludesParkingSpots() {
        parkingLot = ParkingLotFactory.createParkingLot("PL002", "Uptown", "06:00", "22:00", 6.0);
        assertNotNull(parkingLot, "Should be an object of ParkingLot class");
        assertInstanceOf(ParkingLot.class, parkingLot, "Should be an instance of ParkingLot class");
        assertEquals("PL002", parkingLot.getLotId(), "Should be PL002");
        assertEquals("Uptown", parkingLot.getLocation(), "Should be Uptown");
        assertEquals(6.0, parkingLot.getPricePerHour(), "Should be 6.0 per hour");
    }
}
