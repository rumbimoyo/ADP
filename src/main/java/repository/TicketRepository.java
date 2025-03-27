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
public class TicketRepository implements IRepository<Ticket, String>{
    private static TicketRepository instance;
    private Set<Ticket> ticketDB;

    private TicketRepository() {
        this.ticketDB = new HashSet<>();
    }


    public static TicketRepository getInstance() {
        if (instance == null) {
            instance = new TicketRepository();
        }
        return instance;
    }

    public boolean create(Ticket ticket) {
        return ticketDB.add(ticket);
    }

    public Ticket read(String ticketID) {
        for(Ticket ticket : ticketDB){
            if(ticket.getTicketID().equals(ticketID)){
                return ticket;
            }
        }
        return null;
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

    public void delete(String ticketID) {
        Ticket ticket = read(ticketID);
        if (ticket != null) {
            ticketDB.remove(ticket);
        }
    }

    public Set<Ticket> getAll() {
        return ticketDB;
    }
}
