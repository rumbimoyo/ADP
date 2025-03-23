
package repository;

/*
repository.ReservationRepository
Reservation Repository Implementation
Author: Avela Bonakali
Date: 20/03/2025
 */

import domain.Reservation;
import java.util.HashSet;
import java.util.Set;

public class ReservationRepository implements IReservationRepository {
    private static ReservationRepository repository = null;
    private Set<Reservation> reservationDB = null;

    private ReservationRepository() {
        reservationDB = new HashSet<Reservation>();
    }

    public static ReservationRepository getRepository() {
        if (repository == null) {
            repository = new ReservationRepository();
        }
        return repository;
    }

    public static ReservationRepository getInstance() {
        return null;
    }

    @Override
    public Reservation create(Reservation reservation) {
        boolean success = reservationDB.add(reservation);
        return success ? reservation : null;
    }

    @Override
    public Reservation read(String reservationID) {
        for (Reservation r : reservationDB) {
            if (r.getReservationID().equals(reservationID)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Reservation update(Reservation reservation) {
        Reservation oldReservation = read(reservation.getReservationID());
        if (oldReservation != null) {
            reservationDB.remove(oldReservation);
            reservationDB.add(reservation);
            return reservation;
        }
        return null;
    }

    @Override
    public boolean delete(String reservationID) {
        Reservation reservationToDelete = read(reservationID);
        if (reservationToDelete == null) {
            return false;
        }
        return reservationDB.remove(reservationToDelete);
    }

    @Override
    public Set<Reservation> getAll() {
        return reservationDB;
    }
}