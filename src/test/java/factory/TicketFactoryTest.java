package factory;

/*
test.factory.TicketFactoryTest
TicketFactoryTest class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */
import domain.ParkingLot;
import domain.Ticket;
import domain.User;
import domain.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
public class TicketFactoryTest {

    private User user1 = UserFactory.createUser("811", "Sean Bailey", LocalDate.of(2001, 9,9), "male", "081-222-1111", "sean@gmail.com");
    private User user2 = UserFactory.createUser("2673", "John", LocalDate.of(2004,9, 9), "male", "081-234-0192", "john@gmail.com");

    Set<User> users = new HashSet<>();

    ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL001", "Test Lot", "Test Location", "08:00 AM", "06:00 PM", 10.0);
    Vehicle vehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000", users);

    @Test
    @DisplayName("Ticket with all paramters")
    void createTicket() {
        Ticket ticket = TicketFactory.createTicket("12345", "10:10", "11:31",50.00, LocalDate.of(2025,02,02), parkingLot, vehicle);

        assertNotNull(ticket);
        assertEquals("12345",ticket.getTicketID());
        assertEquals(parkingLot, ticket.getParkingLot());
        assertEquals(vehicle, ticket.getVehicle());
        assertNotNull(ticket.getEntryTime());
        assertNotNull(ticket.getExitTime());
        assertEquals(50.00, ticket.getPrice());
    }

    @Test
    @DisplayName("Ticket with no vehicle")
    void testCreateTicket1() {
        Ticket ticket = TicketFactory.createTicket("12345", "10:10", "11:31",50.00, LocalDate.of(2025,02,02), parkingLot);

        assertNotNull(ticket);
        assertEquals("12345", ticket.getTicketID());
        assertEquals(parkingLot, ticket.getParkingLot());
        assertNull(vehicle, "should be null");
        assertNotNull(ticket.getEntryTime());
        assertNotNull(ticket.getExitTime());
        assertEquals(50.00, ticket.getPrice());
    }

    @Test
    @DisplayName("Ticket with no date")
    void testCreateTicket2() {
        Ticket ticket = TicketFactory.createTicket("12345", "10:10", "11:31",50.00, parkingLot, vehicle);

        assertNotNull(ticket);
        assertEquals("12345", ticket.getTicketID());
        assertEquals(parkingLot, ticket.getParkingLot());
        assertEquals(vehicle, ticket.getVehicle());
        assertNull(ticket.getDate(), "should be null" );
        assertNotNull(ticket.getEntryTime());
        assertNotNull(ticket.getExitTime());
        assertEquals(50.00, ticket.getPrice());
    }

    @Test
    @DisplayName("Ticket with no price")
    void testCreateTicket3() {
        Ticket ticket = TicketFactory.createTicket("12345", "10:10", "11:31",LocalDate.of(2025,02,02), parkingLot, vehicle);

        assertNotNull(ticket);
        assertEquals("12345", ticket.getTicketID());
        assertEquals(parkingLot, ticket.getParkingLot());
        assertEquals(vehicle, ticket.getVehicle());
        assertNotNull(ticket.getEntryTime());
        assertNotNull(ticket.getExitTime());
        assertNull(ticket.getPrice(), "should be null");
    }

    @Test
    @DisplayName("Ticket with no price or date")
    void testCreateTicket4() {
        Ticket ticket = TicketFactory.createTicket("12345", "10:10", "11:31", parkingLot, vehicle);

        assertNotNull(ticket);
        assertEquals("12345",ticket.getTicketID());
        assertEquals(parkingLot, ticket.getParkingLot());
        assertEquals(vehicle, ticket.getVehicle());
        assertNotNull(ticket.getEntryTime());
        assertNotNull(ticket.getExitTime());
        assertNull(ticket.getDate());
        assertNull(ticket.getPrice());
    }

}

