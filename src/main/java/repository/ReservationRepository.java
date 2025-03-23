
package repository;

/*
repository.ReservationRepository
Reservation Repository Implementation
Author: Avela Bonakali
Date: 20/03/2025
 */

import domain.ParkingLot;
import domain.Reservation;
import domain.User;

import java.util.HashSet;
import java.util.Set;

public class ReservationRepository implements IReservationRepository {
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

    @Override
    public Reservation create(Reservation reservation) {
        reservationRepositoryDB.add(reservation);
        return reservation;
    }

    @Override
    public Reservation read(String reservationId) {
        return reservationRepositoryDB.stream()
                .filter(reservation -> reservation.getReservationID().equals(reservationId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reservation update(Reservation newReservation) {
        Reservation oldReservation = this.read(newReservation.getReservationID());
        if(oldReservation != null){
            reservationRepositoryDB.remove(oldReservation.getReservationID());
            reservationRepositoryDB.add(newReservation);
            return newReservation;
        }
        return null;
    }

    @Override
    public boolean delete(String reservationId) {
       reservationRepositoryDB.removeIf(reservation -> reservation.getReservationID().equals(reservationId));
        return reservationRepositoryDB.isEmpty();
    }


    @Override
    public Set getAll() {
        return reservationRepositoryDB;
    }
}