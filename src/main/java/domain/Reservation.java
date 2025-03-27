package domain;

import java.time.LocalDate;
import java.util.Date;

/*
 * domain.Reservation
 * Reservation entity class
 * Author: Avela Bonakali
 * Date: 20/03/2025
 *
 * This class represents a parking reservation and follows the Builder pattern.
 * It contains a private no-arg constructor and a private all-arg constructor used only by the Builder.
 */
public class Reservation {

    private String reservationID;
    private String startTime;
    private String endTime;
    private LocalDate localDate;
    private double price;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private User user;

    // Private no-argument constructor
    private Reservation() { }

    // Private constructor used by the Builder
    private Reservation(String reservationID, String startTime, String endTime,
                        LocalDate localDate, double price, Vehicle vehicle,
                        ParkingSpot parkingSpot, User user) {
        this.reservationID = reservationID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.localDate =localDate;
        this.price = price;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.user = user;
    }

    // Getters (no public setters, ensuring immutability)
    public String getReservationID() { return reservationID; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public LocalDate getDate() { return localDate; }
    public double getPrice() { return price; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getParkingSpot() { return parkingSpot; }
    public User getUser() { return user; }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID='" + reservationID + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", localDate=" + localDate +
                ", price=" + price +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                ", user=" + user +
                '}';
    }

    // Nested static Builder class
    public static class Builder {
        private String reservationID;
        private String startTime;
        private String endTime;
        private LocalDate localDate;
        private double price;
        private Vehicle vehicle;
        private ParkingSpot parkingSpot;
        private User user;

        public Builder setReservationID(String reservationID) {
            this.reservationID = reservationID;
            return this;
        }

        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder setParkingSpot(ParkingSpot parkingSpot) {
            this.parkingSpot = parkingSpot;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Reservation build() {
            return new Reservation(reservationID, startTime, endTime, localDate, price, vehicle, parkingSpot, user);
        }
    }
}
