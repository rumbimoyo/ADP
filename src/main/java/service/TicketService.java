package service;

/*
service.TicketService
Ticket Service class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */
import domain.Ticket;
import repository.TicketRepository;
import java.util.Set;
public class TicketService {

    private static TicketService service = null;
    private final TicketRepository repository;

    private TicketService() {
        this.repository = TicketRepository.getRepository();
    }


    public static TicketService getService() {
        if (service == null) {
            service = new TicketService();
        }
        return service;
    }

    public Ticket create(Ticket ticket) {
        return repository.create(ticket);
    }

    public Ticket read(Integer ticketID) {
        return repository.read(ticketID);
    }

    public Ticket update(Ticket ticket) {
        return repository.update(ticket);
    }

    public boolean delete(Integer ticketID) {
        return repository.delete(ticketID);
    }

    public Set<Ticket> getAll() {
        return repository.getAll();
    }

}
