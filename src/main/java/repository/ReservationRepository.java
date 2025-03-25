package repository;

import domain.Reservation;
import java.util.HashSet;
import java.util.Set;
/*
repository.ReservationRepository
Reservation Repository Implementation
Author: Avela Bonakali
Date: 20/03/2025
 */
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

    public Reservation create(Reservation reservation) {
        reservationRepositoryDB.add(reservation);
        return reservation;
    }

    public Reservation read(String reservationId) {
        return reservationRepositoryDB.stream()
                .filter(reservation -> reservation.getReservationID().equals(reservationId))
                .findFirst()
                .orElse(null);
    }

    public Reservation update(Reservation newReservation) {
        Reservation oldReservation = this.read(newReservation.getReservationID());
        if (oldReservation != null) {
            // Remove the old reservation and add the updated one
            reservationRepositoryDB.remove(oldReservation);
            reservationRepositoryDB.add(newReservation);
            return newReservation;
        }
        return null;
    }

    public boolean delete(String reservationId) {
        // Remove reservations matching the given ID and return true if any were removed
        return reservationRepositoryDB.removeIf(reservation -> reservation.getReservationID().equals(reservationId));
    }

    public Set<Reservation> getAll() {
        return reservationRepositoryDB;
    }
}
