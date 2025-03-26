package repository;

/*
 * repository.ReservationRepository
 * Reservation Repository Implementation
 * Author: Avela Bonakali
 * Date: 20/03/2025
 */

import domain.Reservation;

import java.util.HashSet;
import java.util.Set;

public class ReservationRepository {
    private static ReservationRepository instance;
    private Set<Reservation> reservationRepositoryDB = new HashSet<>();

    // Private constructor to prevent instantiation
    private ReservationRepository() {}

    // Singleton pattern to ensure a single instance
    public static synchronized ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }
        return instance;
    }

    // Create a new reservation
    public Reservation create(Reservation reservation) {
        reservationRepositoryDB.add(reservation);
        return reservation;
    }

    // Read a reservation by its ID
    public Reservation read(String reservationId) {
        return reservationRepositoryDB.stream()
                .filter(reservation -> reservation.getReservationID().equals(reservationId))
                .findFirst()
                .orElse(null);
    }

    // Update an existing reservation
    public Reservation update(Reservation newReservation) {
        Reservation oldReservation = this.read(newReservation.getReservationID());
        if (oldReservation != null) {
            reservationRepositoryDB.remove(oldReservation);
            reservationRepositoryDB.add(newReservation);
            return newReservation;
        }
        return null;
    }

    // Delete a reservation by its ID
    public boolean delete(String reservationId) {
        return reservationRepositoryDB.removeIf(reservation -> reservation.getReservationID().equals(reservationId));
    }

    // Retrieve all reservations
    public Set<Reservation> getAll() {
        return new HashSet<>(reservationRepositoryDB);
    }
}
