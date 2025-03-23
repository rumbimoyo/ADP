
package domain;

/*
domain.Reservation
Reservation entity class
Author: Avela Bonakali
Date: 20/03/2025
 */

import java.util.Date;

public class Reservation {

    private String reservationID;
    private String startTime;
    private String endTime;
    private Date date;
    private double price;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private User user;

    public Reservation() {
    }

    public Reservation(String reservationID, String startTime, String endTime,
                       Date date, double price, Vehicle vehicle,
                       ParkingSpot parkingSpot, User user) {
        this.reservationID = reservationID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.price = price;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.user = user;
    }

    public String getReservationID() {
        return reservationID;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID='" + reservationID + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private String reservationID;
        private String startTime;
        private String endTime;
        private Date date;
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

        public Builder setDate(Date date) {
            this.date = date;
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
            return new Reservation(reservationID, startTime, endTime, date, price, vehicle, parkingSpot, user);
        }
    }
}