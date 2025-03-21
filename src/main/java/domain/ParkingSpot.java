package domain;

import java.util.HashSet;
import java.util.Set;

/*
Rumbidzai Moyo Chaka
Parking Spot Domain
230098789
 */

public class ParkingSpot {

    // Attributes
    private Long spotID;
    private int spotNumber;
    private String status; //  open, reserved, occupied
    private String type; //  compact, disabled, electric
    private ParkingLot parkingLot;
    private Set<Reservation> reservations = new HashSet<>();


    public ParkingSpot(int spotNumber, String status, String type, ParkingLot parkingLot) {
        this.spotNumber = spotNumber;
        this.status = status;
        this.type = type;
        this.parkingLot = parkingLot;
    }
    public Long getSpotID() {
        return spotID;
    }

    public void setSpotID(Long spotID) {
        this.spotID = spotID;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotID=" + spotID +
                ", spotNumber=" + spotNumber +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", parkingLot=" + parkingLot +
                ", reservations=" + reservations +
                '}';
    }

    //  Builder class
    public static class Builder {
        private int spotNumber;
        private String status;
        private String type;
        private ParkingLot parkingLot;

        public Builder setSpotNumber(int spotNumber) {
            this.spotNumber = spotNumber;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setParkingLot(ParkingLot parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public ParkingSpot build() {
            return new ParkingSpot(spotNumber, status, type, parkingLot);
        }
    }
}