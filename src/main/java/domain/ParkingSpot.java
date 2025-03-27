package domain;

/*
Rumbidzai Moyo Chaka
Parking Spot Domain
230098789
 */

public class ParkingSpot {

    // Attributes
    private int spotNumber;
    private String status; //open,reserved,occupied
    private String type; // compact,disabled,electric
    private ParkingLot parkingLot;


    public ParkingSpot() {

    }

    public ParkingSpot(int spotNumber, String status, String type, ParkingLot parkingLot) {
        this.spotNumber = spotNumber;
        this.type = type;
        this.status = status;
        this.parkingLot = parkingLot;
    }

    // Getters and Setters

    public int getSpotNumber() {
        return spotNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber='" + spotNumber + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", parkingLot=" + parkingLot +
                '}';
    }

    // Builder class
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