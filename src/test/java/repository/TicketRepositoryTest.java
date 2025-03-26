package repository;

/*
test.repository.TicketRepositoryTest
TicketRepositoryTest class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */

import domain.ParkingLot;
import domain.Ticket;
import domain.User;
import domain.Vehicle;
import factory.ParkingLotFactory;
import factory.TicketFactory;
import factory.VehicleFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {

    Set<User> users = new HashSet<>();
    ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL001", "Test Lot", "Test Location", "08:00 AM", "06:00 PM", 10.0);
    Vehicle vehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000", users);
    TicketRepository repository = TicketRepository.getRepository();

    @Test
    @DisplayName("Test   reading a ticket from the repository")
    public void testCreateAndRead() {
        // Arrange

        Ticket ticket = TicketFactory.createTicket("12345", "10:10", "11:31",50.00, LocalDate.of(2025,02,02), parkingLot, vehicle);

        repository.create(ticket);
        Ticket retrievedTicket = repository.read("12345");

        assertNotNull(retrievedTicket);
        assertEquals(ticket, retrievedTicket);
    }

    @Test
    @DisplayName("Test updating a ticket in the repository")
    public void testUpdate() {

        Ticket updatedTicket = TicketFactory.createTicket("12345", "11:11", "12:12",50.00, LocalDate.of(2025,02,02), parkingLot, vehicle);

        repository.update(updatedTicket);
        Ticket retrievedTicket = repository.read("12345");


        assertNotNull(retrievedTicket);
        assertEquals(retrievedTicket.getEntryTime(), updatedTicket.getEntryTime());
    }

    @Test
    @DisplayName("Test deleting a ticket from the repository")
    public void testDelete() {

        boolean isDeleted = repository.delete("12345");
        Ticket retrievedTicket = repository.read("12345");

        assertTrue(isDeleted);
        assertNull(retrievedTicket);
    }

    @Test
    @DisplayName("Test retrieving all tickets from the repository")
    public void testGetAll() {


        Ticket ticket1 = TicketFactory.createTicket("16666", "13:10", "11:31",40.00, LocalDate.of(2025,02,02), parkingLot, vehicle);
        Ticket ticket2 = TicketFactory.createTicket("11111", "11:00", "10:31",50.00, LocalDate.of(2024,01,04), parkingLot, vehicle);

        repository.create(ticket1);
        repository.create(ticket2);


       Set<Ticket> allTickets = repository.getAll();


       assertNotNull(allTickets);
       assertEquals(2, allTickets.size());
       assertTrue(allTickets.contains(ticket1));
       assertTrue(allTickets.contains(ticket2));
    }

}
