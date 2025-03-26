package repository;

/*
repository.TicketRepository
Ticket Repository class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */

import domain.Ticket;
import java.util.HashSet;
import java.util.Set;
public class TicketRepository {
    private static TicketRepository repository = null;
    private Set<Ticket> ticketDB;

    private TicketRepository() {
        this.ticketDB = new HashSet<>();
    }


    public static TicketRepository getRepository() {
        if (repository == null) {
            repository = new TicketRepository();
        }
        return repository;
    }

    public Ticket create(Ticket ticket) {
        ticketDB.add(ticket);
        return ticket;
    }

    public Ticket read(String ticketID) {
        return ticketDB.stream()
                .filter(ticket -> ticket.getTicketID() .equals(ticketID))
                .findFirst()
                .orElse(null);
    }

    public Ticket update(Ticket updatedTicket) {
        Ticket existingTicket = read(updatedTicket.getTicketID());
        if (existingTicket != null) {
            ticketDB.remove(existingTicket);
            ticketDB.add(updatedTicket);
            return updatedTicket;
        }
        return null;
    }

    public boolean delete(String ticketID) {
        Ticket ticket = read(ticketID);
        if (ticket != null) {
            ticketDB.remove(ticket);
            return true;
        }
        return false;
    }

    public Set<Ticket> getAll() {
        return ticketDB;
    }
}
