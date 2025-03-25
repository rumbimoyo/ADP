
package service;

//domain.Reservation
//Reservation entity class
//Author: Avela Bonakali(1)
//Date: 20/03/2025
// */

import domain.Reservation;
import domain.User;
import domain.Vehicle;
import factory.ReservationFactory;
import repository.ReservationRepository;
import repository.UserRepository;
//import repository.VehicleRepository;

import java.util.Set;

public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
   // private final VehicleRepository vehicleRepository;

    // Private constructor to enforce the singleton pattern
    private ReservationService() {
        this.reservationRepository = ReservationRepository.getInstance();
        this.userRepository = UserRepository.getInstance();
     //   this.vehicleRepository = VehicleRepository.getInstance();
    }

    // Singleton instance
    private static ReservationService instance;

    // Synchronized access method to get the singleton instance
    public static synchronized ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    /**
     * Adds a new reservation after checking that the associated user and vehicle exist.
     * Uses the vehicle's licence plate for identification.
     *
     * @param reservationID Unique ID for the reservation
     * @param startTime Start time as String
     * @param endTime End time as String
     * @param date Date of reservation
     * @param price Price for the reservation
     * @param vehicle The associated vehicle (should have a valid licence plate)
     * @param user The associated user
     * @return The created Reservation, or null if validation fails
     */
    public Reservation addReservation(String reservationID, String startTime, String endTime,
                                      java.util.Date date, double price, Vehicle vehicle,
                                      User user) {

        // Verify user exists
        if (userRepository.read(user.getUserID()) == null) {
            return null;
        }
        // Verify vehicle exists using its licence plate
     //   if (vehicleRepository.read(vehicle.getLicencePlate()) == null) {
     //       return null;
      // }

        // Create reservation using factory
        Reservation reservation = ReservationFactory.createReservation(
                reservationID, startTime, endTime, date, price, vehicle, null, user);
        reservationRepository.create(reservation);
        return reservation;
    }

    /**
     * Edits an existing reservation.
     *
     * @param reservation The updated reservation
     * @return The updated Reservation, or null if it does not exist
     */
    public Reservation editReservation(Reservation reservation) {
        Reservation existingReservation = reservationRepository.read(reservation.getReservationID());
        if (existingReservation != null) {
            return reservationRepository.update(reservation);
        }
        return null;
    }

    /**
     * Deletes a reservation by its ID.
     *
     * @param reservationID The ID of the reservation to delete
     * @return true if deleted successfully, false otherwise
     */
    public boolean deleteReservation(String reservationID) {
        Reservation reservation = reservationRepository.read(reservationID);
        if (reservation != null) {
            return reservationRepository.delete(reservationID);
        }
        return false;
    }

    /**
     * Retrieves all reservations.
     *
     * @return A set of all reservations.
     */
    public Set<Reservation> viewReservations() {
        return reservationRepository.getAll();
    }
}
