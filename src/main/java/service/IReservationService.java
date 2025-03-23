
package service;

import domain.Reservation;
// import domain.Vehicle;
import domain.User;

import java.util.Date;
import java.util.Set;

public interface IReservationService {

    /**
     * Creates a new reservation
     * @param reservation The reservation to create
     * @return The created reservation
     */
    Reservation create(Reservation reservation);

    /**
     * Reads a reservation by ID
     * @param reservationId The ID of the reservation
     * @return The reservation if found, null otherwise
     */
    Reservation read(String reservationId);

    /**
     * Updates an existing reservation
     * @param reservation The updated reservation
     * @return The updated reservation
     */
    Reservation update(Reservation reservation);

    /**
     * Deletes a reservation by ID
     * @param reservationId The ID of the reservation to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean delete(String reservationId);

    /**
     * Gets all reservations
     * @return A set of all reservations
     */
    Set<Reservation> getAll();

    /**
     * Gets all reservations for a user
     * @param userId The ID of the user
     * @return A set of reservations for the user
     */
    Set<Reservation> getUserReservations(String userId);

    /**
     * Gets all reservations for a vehicle
     * @param licencePlate The licence plate of the vehicle
     * @return A set of reservations for the vehicle
     */
    // Set<Reservation> getVehicleReservations(String licencePlate);

    /**
     * Gets all reservations for a parking spot
     * @param spotId The ID of the parking spot
     * @return A set of reservations for the parking spot
     */
    Set<Reservation> getParkingSpotReservations(String spotId);

    /**
     * Checks if a parking spot is available for a specific time period
     * @param spotId The ID of the parking spot
     * @param dateStr The date in string format
     * @param startTime The start time (HH:MM)
     * @param endTime The end time (HH:MM)
     * @return true if available, false otherwise
     */
    boolean isParkingSpotAvailable(String spotId, String dateStr, String startTime, String endTime);

    /**
     * Calculates the price of a reservation
     * @param startTime The start time (HH:MM)
     * @param endTime The end time (HH:MM)
     * @param hourlyRate The hourly rate
     * @return The calculated price
     */
    double calculateReservationPrice(String startTime, String endTime, double hourlyRate);

    /**
     * Gets all reservations for a specific date
     * @param date The date
     * @return A set of reservations for the date
     */
    Set<Reservation> getReservationsForDate(Date date);

    /**
     * Cancels a reservation
     * @param reservationId The ID of the reservation to cancel
     */
    void cancelReservation(String reservationId);
}