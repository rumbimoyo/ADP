package factory;

/*
test.factory.TicketFactoryTest
TicketFactoryTest class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */
import domain.ParkingLot;
import domain.Ticket;
import domain.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
public class TicketFactoryTest {
    @Test
    @DisplayName("Test creating a new ticket with valid parameters that will give no price at the beginning")
    public void testCreateTicket() {

        long ticketID = 1L;
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();


        Ticket ticket = TicketFactory.createTicket(ticketID, parkingLot, vehicle);


        assertNotNull(ticket);
        assertEquals(ticketID, ticket.getTicketID());
        assertEquals(parkingLot, ticket.getParkingLot());
        assertEquals(vehicle, ticket.getVehicle());
        assertNotNull(ticket.getEntryTime());
        assertNull(ticket.getExitTime());
        assertEquals(0.0, ticket.getPrice());
    }

    @Test
    @DisplayName("Test creating a completed  ticket with valid parameters that will display final price at the end")
    public void testCreateCompletedTicket() {

        long ticketID = 2L;
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();
        String exitTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));


        Ticket ticket = TicketFactory.createCompletedTicket(ticketID, parkingLot, vehicle, exitTime);


        assertNotNull(ticket);
        assertEquals(ticketID, ticket.getTicketID());
        assertEquals(parkingLot, ticket.getParkingLot());
        assertEquals(vehicle, ticket.getVehicle());
        assertNotNull(ticket.getEntryTime());
        assertEquals(exitTime, ticket.getExitTime());
        assertEquals(0.0, ticket.getPrice());
    }

    @Test
    @DisplayName("Test creating a ticket with invalid parameters (should throw IllegalArgumentException)")
    public void testCreateTicketWithInvalidParameters() {

        long ticketID = 0L; // Invalid ticketID
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();


        assertThrows(IllegalArgumentException.class, () -> {
            TicketFactory.createTicket(ticketID, parkingLot, vehicle);
        });
    }

    @Test
    @DisplayName("Test creating a completed ticket with invalid parameters (should throw IllegalArgumentException)")
    public void testCreateCompletedTicketWithInvalidParameters() {

        long ticketID = 3L;
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();
        String exitTime = "";


        assertThrows(IllegalArgumentException.class, () -> {
            TicketFactory.createCompletedTicket(ticketID, parkingLot, vehicle, exitTime);
        });
    }
}

