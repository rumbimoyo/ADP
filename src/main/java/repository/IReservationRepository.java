package repository;

/*
IReservationRepository
Interface for Reservation Repository
Author: Avela Bonakali
Date: 20/03/2025
 */

import domain.Reservation;
import java.util.Set;

public interface IReservationRepository<T, ID> {

    // Create a new reservation
    T create(T reservation);

    // Read (find) a reservation by its ID
    T read(ID reservationId);

    // Update an existing reservation
    T update(T newReservation);

    // Delete a reservation by its ID
    boolean delete(ID reservationId);

    // Get all reservations
    Set<T> getAll();
}
