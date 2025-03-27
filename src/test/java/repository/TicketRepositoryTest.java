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

    TicketRepository repository = TicketRepository.getInstance();
    ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL001", "Test Lot", "Test Location", "08:00 AM", "06:00 AM", 10.0);
    Vehicle vehicle = VehicleFactory.createVehicle("001211", "Honda", "Civic", "black", "1F87A123456789000");

    @Test
    @DisplayName("Test   reading a ticket from the repository")
    public void testCreateAndRead() {

        Ticket ticket = TicketFactory.createTicket("12345", "10:10 AM", "11:31 PM",50.00, LocalDate.of(2025,02,02), parkingLot, vehicle);

        repository.create(ticket);
        Ticket retrievedTicket = repository.read("12345");

        assertNotNull(retrievedTicket);
        assertEquals(ticket, retrievedTicket);
    }

    @Test
    @DisplayName("Test updating a ticket in the repository")
    public void testUpdate() {

        Ticket ticket = TicketFactory.createTicket("12345", "10:10 AM", "11:31 PM",30.00, LocalDate.of(2025,02,02), parkingLot, vehicle);
        Ticket updatedTicket = TicketFactory.createTicket("12345", "11:11 PM", "12:12 AM",50.00, LocalDate.of(2025,02,02), parkingLot, vehicle);

        repository.create(ticket);
        repository.update(updatedTicket);
        Ticket retrievedTicket = repository.read("12345");


        assertNotNull(retrievedTicket);
        assertEquals(retrievedTicket.getEntryTime(), updatedTicket.getEntryTime());
    }

    @Test
    @DisplayName("Test deleting a ticket from the repository")
    public void testDelete() {

        repository.delete("12345");
        Ticket retrievedTicket = repository.read("12345");

        assertNull(retrievedTicket);
    }

    @Test
    @DisplayName("Test retrieving all tickets from the repository")
    public void testGetAll() {


        Ticket ticket1 = TicketFactory.createTicket("16666", "13:10 AM", "11:31 AM",40.00, LocalDate.of(2025,02,02), parkingLot, vehicle);
        Ticket ticket2 = TicketFactory.createTicket("11111", "11:00 AM", "10:31 AM",50.00, LocalDate.of(2024,01,04), parkingLot, vehicle);

        repository.create(ticket1);
        repository.create(ticket2);


       Set<Ticket> allTickets = repository.getAll();


       assertNotNull(allTickets);
       assertEquals(2, allTickets.size());
       assertTrue(allTickets.contains(ticket1));
       assertTrue(allTickets.contains(ticket2));
    }

}
