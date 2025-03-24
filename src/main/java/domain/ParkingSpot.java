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
    private String spotId;
    private int spotNumber;
    private String status; //open,reserved,occupied
    private String type; // compact,disabled,electric
    private ParkingLot parkingLot;

    public ParkingSpot(int spotNumber,String spotId, String status, String type, ParkingLot parkingLot) {
        this.spotNumber = spotNumber;
        this.spotId=spotId;
        this.status = status;
        this.type = type;
        this.parkingLot = parkingLot;
    }

    // Getters and Setters
    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotID) {
        this.spotId = spotID;
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


    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotID=" + spotId +
                ", spotNumber=" + spotNumber +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", parkingLot=" + (parkingLot != null ? parkingLot.getLotId() : "null") +
                '}';
    }

    // Builder class
    public static class Builder {
        private String spotId;
        private int spotNumber;
        private String status;
        private String type;
        private ParkingLot parkingLot;

        public Builder setSpotID(String spotId) {
            this.spotId = spotId;
            return this;
        }

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
            ParkingSpot parkingSpot = new ParkingSpot(spotNumber, status, type,parkingLot);
            parkingSpot.setSpotId(spotId); // Set the spotID
            return parkingSpot;
        }
    }
}