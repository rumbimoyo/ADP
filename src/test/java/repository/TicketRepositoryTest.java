package repository;

/*
test.repository.TicketRepositoryTest
TicketRepositoryTest class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */

import domain.ParkingLot;
import domain.Ticket;
import domain.Vehicle;
import factory.TicketFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {
    @Test
    @DisplayName("Test   reading a ticket from the repository")
    public void testCreateAndRead() {
        // Arrange
        TicketRepository repository = TicketRepository.getRepository();
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();
        Ticket ticket = TicketFactory.createTicket(1, parkingLot, vehicle);

        // Act
        repository.create(ticket);
        Ticket retrievedTicket = repository.read(1);

        // Assert
        assertNotNull(retrievedTicket);
        assertEquals(ticket, retrievedTicket);
    }

    @Test
    @DisplayName("Test updating a ticket in the repository")
    public void testUpdate() {

        TicketRepository repository = TicketRepository.getRepository();
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();
        Ticket ticket = TicketFactory.createTicket(1L, parkingLot, vehicle);
        repository.create(ticket);


        Ticket updatedTicket = new Ticket.Builder()
                .ticketID(1L)
                .entryTime(ticket.getEntryTime())
                .exitTime("10-03-2025 14:00:00") // Updated exit time
                .parkingLot(parkingLot)
                .vehicle(vehicle)
                .price(20.0) // Updated price
                .build();


        repository.update(updatedTicket);
        Ticket retrievedTicket = repository.read(1);


        assertNotNull(retrievedTicket);
        assertEquals(updatedTicket, retrievedTicket);
    }

    @Test
    @DisplayName("Test deleting a ticket from the repository")
    public void testDelete() {

        TicketRepository repository = TicketRepository.getRepository();
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();
        Ticket ticket = TicketFactory.createTicket(1L, parkingLot, vehicle);
        repository.create(ticket);


        boolean isDeleted = repository.delete(1);
        Ticket retrievedTicket = repository.read(1);


        assertTrue(isDeleted);
        assertNull(retrievedTicket);
    }

    @Test
    @DisplayName("Test retrieving all tickets from the repository")
    public void testGetAll() {

        TicketRepository repository = TicketRepository.getRepository();
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle();
        Ticket ticket1 = TicketFactory.createTicket(1L, parkingLot, vehicle);
        Ticket ticket2 = TicketFactory.createTicket(2L, parkingLot, vehicle);
        repository.create(ticket1);
        repository.create(ticket2);


       // Set<Ticket> allTickets = repository.getAll();


       // assertNotNull(allTickets);
       // assertEquals(2, allTickets.size());
       // assertTrue(allTickets.contains(ticket1));
       // assertTrue(allTickets.contains(ticket2));
    }

}
