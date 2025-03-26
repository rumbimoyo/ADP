//
//package service;
//
////domain.Reservation
////Reservation entity class
////Author: Avela Bonakali(1)
////Date: 20/03/2025
//// */
//
//import domain.Reservation;
//import domain.User;
//import domain.Vehicle;
//import domain.ParkingSpot;
//import factory.ReservationFactory;
//import repository.ReservationRepository;
//import repository.UserRepository;
//import repository.VehicleRepository;
//import java.util.Date;
//import java.util.Set;
//
//public class ReservationService {
//
//    private final ReservationRepository reservationRepository;
//    private final UserRepository userRepository;
//    private final VehicleRepository vehicleRepository;
//
//    // Private constructor to enforce the singleton pattern
//    private ReservationService() {
//        this.reservationRepository = ReservationRepository.getInstance();
//        this.userRepository = UserRepository.getInstance();
//        this.vehicleRepository = VehicleRepository.getInstance();
//    }
//
//    // Singleton instance
//    private static ReservationService instance;
//
//    // Synchronized access method to get the singleton instance
//    public static synchronized ReservationService getInstance() {
//        if (instance == null) {
//            instance = new ReservationService();
//        }
//        return instance;
//    }
//
//
//    public Reservation addReservation(Reservation reservation) {  // Added parkingSpot
//
//        // Validate user exists
//        if (userRepository.read(reservation.getUser().getUserID()) == null) return null;
//
//        // Validate vehicle exists
//        if (vehicleRepository.read(vehicle.getLicensePlate()) == null) return null;
//
//        // Create reservation
//        Reservation reservation = ReservationFactory.createReservation(
//                reservationID, startTime, endTime, date, price,
//                vehicle, parkingSpot, user);  // Use correct method
//
//        if (reservation != null) {
//            reservationRepository.create(reservation);
//        }
//        return reservation;
//    }
//
//
//    public Reservation editReservation(Reservation reservation) {
//        Reservation existingReservation = reservationRepository.read(reservation.getReservationID());
//        if (existingReservation != null) {
//            return reservationRepository.update(reservation);
//        }
//        return null;
//    }
//
//
//    public boolean deleteReservation(String reservationID) {
//        Reservation reservation = reservationRepository.read(reservationID);
//        if (reservation != null) {
//            return reservationRepository.delete(reservationID);
//        }
//        return false;
//    }
//
//
//    public Set<Reservation> viewReservations() {
//        return reservationRepository.getAll();
//    }
//
//    public void addReservation(String s, String time, String time1, User testUser) {
//    }
//}