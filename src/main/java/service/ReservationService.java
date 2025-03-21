package service;

/*
 * service.ReservationService
 * Reservation Service class
 * Author: Avela Bonakali
 * Date: 22/03/2025
 */

import domain.ParkingSpot;
import domain.Reservation;
import domain.User;
// import domain.Vehicle;
import repository.ParkingSpotRepository;
import repository.ReservationRepository;
import repository.UserRepository;
// import repository.VehicleRepository;
import util.Helper;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReservationService implements IReservationService {

    private static ReservationService service = null;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    // private final VehicleRepository vehicleRepository;
    private final ParkingSpotRepository parkingSpotRepository;

    private ReservationService() {
        this.reservationRepository = ReservationRepository.getInstance();
        this.userRepository = UserRepository.getInstance();
        // this.vehicleRepository = VehicleRepository.getInstance();
        this.parkingSpotRepository = ParkingSpotRepository.getInstance();
    }

    public static ReservationService getService() {
        if (service == null) {
            service = new ReservationService();
        }
        return service;
    }

    @Override
    public Reservation create(Reservation reservation) {
        if (reservation == null) {
            return null;
        }

        // Validate reservation details
        if (!Helper.isValidReservation(reservation)) {
            return null;
        }

        // Check if parking spot is available for this time
        if (reservation.getParkingSpot() != null) {
            String spotId = reservation.getParkingSpot().getSpotID();
            String dateStr = reservation.getDate().toString();

            if (!isParkingSpotAvailable(spotId, dateStr, reservation.getStartTime(), reservation.getEndTime())) {
                return null; // Spot not available
            }

            // Update parking spot status
            ParkingSpot spot = parkingSpotRepository.read(spotId);
            if (spot != null) {
                spot.setStatus("reserved");
                parkingSpotRepository.update(spot);
            }
        }

        // Create reservation
        Reservation created = reservationRepository.create(reservation);

        if (created != null) {
            // Update user if assigned
            if (reservation.getUser() != null) {
                User user = userRepository.read(reservation.getUser().getID());
                if (user != null) {
                    if (user.getReservations() == null) {
                        user.setReservations(new HashSet<>());
                    }
                    user.getReservations().add(created);
                    userRepository.update(user);
                }
            }

            /*
            // Update vehicle if assigned
            if (reservation.getVehicle() != null) {
                Vehicle vehicle = vehicleRepository.read(reservation.getVehicle().getLicencePlate());
                if (vehicle != null) {
                    if (vehicle.getReservations() == null) {
                        vehicle.setReservations(new HashSet<>());
                    }
                    vehicle.getReservations().add(created);
                    vehicleRepository.update(vehicle);
                }
            }
            */
        }

        return created;
    }

    @Override
    public Reservation read(String reservationId) {
        if (Helper.isNullOrEmpty(reservationId)) {
            return null;
        }
        return reservationRepository.read(reservationId);
    }

    @Override
    public Reservation update(Reservation reservation) {
        if (reservation == null || Helper.isNullOrEmpty(reservation.getReservationID())) {
            return null;
        }

        Reservation existing = reservationRepository.read(reservation.getReservationID());
        if (existing == null) {
            return null;
        }

        // Handle user assignments (if changed)
        if (!Helper.isNullOrEmpty(existing.getUser()) && !existing.getUser().equals(reservation.getUser())) {
            // Remove from old user
            User oldUser = userRepository.read(existing.getUser().getID());
            if (oldUser != null && oldUser.getReservations() != null) {
                oldUser.getReservations().remove(existing);
                userRepository.update(oldUser);
            }

            // Add to new user
            if (reservation.getUser() != null) {
                User newUser = userRepository.read(reservation.getUser().getID());
                if (newUser != null) {
                    if (newUser.getReservations() == null) {
                        newUser.setReservations(new HashSet<>());
                    }
                    newUser.getReservations().add(reservation);
                    userRepository.update(newUser);
                }
            }
        }

        /*
        // Handle vehicle assignments (if changed)
        if (!Helper.isNullOrEmpty(existing.getVehicle()) && !existing.getVehicle().equals(reservation.getVehicle())) {
            // Remove from old vehicle
            Vehicle oldVehicle = vehicleRepository.read(existing.getVehicle().getLicencePlate());
            if (oldVehicle != null && oldVehicle.getReservations() != null) {
                oldVehicle.getReservations().remove(existing);
                vehicleRepository.update(oldVehicle);
            }

            // Add to new vehicle
            if (reservation.getVehicle() != null) {
                Vehicle newVehicle = vehicleRepository.read(reservation.getVehicle().getLicencePlate());
                if (newVehicle != null) {
                    if (newVehicle.getReservations() == null) {
                        newVehicle.setReservations(new HashSet<>());
                    }
                    newVehicle.getReservations().add(reservation);
                    vehicleRepository.update(newVehicle);
                }
            }
        }
        */

        // Handle parking spot changes
        if (existing.getParkingSpot() != null && !existing.getParkingSpot().equals(reservation.getParkingSpot())) {
            // Free old spot
            ParkingSpot oldSpot = parkingSpotRepository.read(existing.getParkingSpot().getSpotID());
            if (oldSpot != null) {
                oldSpot.setStatus("open");
                parkingSpotRepository.update(oldSpot);
            }

            // Reserve new spot
            if (reservation.getParkingSpot() != null) {
                // Check availability first
                String spotId = reservation.getParkingSpot().getSpotID();
                String dateStr = reservation.getDate().toString();

                if (isParkingSpotAvailable(spotId, dateStr, reservation.getStartTime(), reservation.getEndTime())) {
                    ParkingSpot newSpot = parkingSpotRepository.read(spotId);
                    if (newSpot != null) {
                        newSpot.setStatus("reserved");
                        parkingSpotRepository.update(newSpot);
                    }
                } else {
                    // If spot not available, keep the old spot and don't update
                    reservation.setParkingSpot(existing.getParkingSpot());
                }
            }
        }

        return reservationRepository.update(reservation);
    }

    @Override
    public boolean delete(String reservationId) {
        if (Helper.isNullOrEmpty(reservationId)) {
            return false;
        }

        Reservation reservation = reservationRepository.read(reservationId);
        if (reservation == null) {
            return false;
        }

        // Remove from user's reservations
        if (reservation.getUser() != null) {
            User user = userRepository.read(reservation.getUser().getID());
            if (user != null && user.getReservations() != null) {
                user.getReservations().remove(reservation);
                userRepository.update(user);
            }
        }

        /*
        // Remove from vehicle's reservations
        if (reservation.getVehicle() != null) {
            Vehicle vehicle = vehicleRepository.read(reservation.getVehicle().getLicencePlate());
            if (vehicle != null && vehicle.getReservations() != null) {
                vehicle.getReservations().remove(reservation);
                vehicleRepository.update(vehicle);
            }
        }
        */

        // Update parking spot status
        if (reservation.getParkingSpot() != null) {
            ParkingSpot spot = parkingSpotRepository.read(reservation.getParkingSpot().getSpotID());
            if (spot != null) {
                spot.setStatus("open");
                parkingSpotRepository.update(spot);
            }
        }

        return reservationRepository.delete(reservationId);
    }

    @Override
    public Set<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    @Override
    public Set<Reservation> getUserReservations(String userId) {
        if (Helper.isNullOrEmpty(userId)) {
            return new HashSet<>();
        }

        User user = userRepository.read(userId);
        if (user == null || user.getReservations() == null) {
            return new HashSet<>();
        }

        return user.getReservations();
    }

    /*
    @Override
    public Set<Reservation> getVehicleReservations(String licencePlate) {
        if (Helper.isNullOrEmpty(licencePlate)) {
            return new HashSet<>();
        }

        Vehicle vehicle = vehicleRepository.read(licencePlate);
        if (vehicle == null || vehicle.getReservations() == null) {
            return new HashSet<>();
        }

        return vehicle.getReservations();
    }
    */

    @Override
    public Set<Reservation> getParkingSpotReservations(String spotId) {
        if (Helper.isNullOrEmpty(spotId)) {
            return new HashSet<>();
        }

        Set<Reservation> allReservations = reservationRepository.getAll();
        Set<Reservation> spotReservations = new HashSet<>();

        for (Reservation r : allReservations) {
            if (r.getParkingSpot() != null && r.getParkingSpot().getSpotID().equals(spotId)) {
                spotReservations.add(r);
            }
        }

        return spotReservations;
    }

    @Override
    public boolean isParkingSpotAvailable(String spotId, String dateStr, String startTime, String endTime) {
        if (Helper.isNullOrEmpty(spotId) || Helper.isNullOrEmpty(dateStr) ||
                !Helper.isValidTimeFormat(startTime) || !Helper.isValidTimeFormat(endTime)) {
            return false;
        }

        Set<Reservation> spotReservations = getParkingSpotReservations(spotId);

        for (Reservation r : spotReservations) {
            // Compare the date (assuming it's in the same format as dateStr)
            if (r.getDate().toString().equals(dateStr)) {
                // Check for time overlap
                if (Helper.doTimeRangesOverlap(startTime, endTime, r.getStartTime(), r.getEndTime())) {
                    return false; // Time periods overlap, spot not available
                }
            }
        }

        return true; // No conflicts found, spot is available
    }

    @Override
    public double calculateReservationPrice(String startTime, String endTime, double hourlyRate) {
        return Helper.calculatePrice(startTime, endTime, hourlyRate);
    }

    @Override
    public Set<Reservation> getReservationsForDate(Date date) {
        if (date == null) {
            return new HashSet<>();
        }

        Set<Reservation> allReservations = reservationRepository.getAll();
        Set<Reservation> dateReservations = new HashSet<>();

        String dateStr = date.toString();

        for (Reservation r : allReservations) {
            if (r.getDate().toString().equals(dateStr)) {
                dateReservations.add(r);
            }
        }

        return dateReservations;
    }

    @Override
    public void cancelReservation(String reservationId) {
        delete(reservationId);
    }
}