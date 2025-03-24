package domain;

/*
domain.ParkingLot
ParkingLot entity class
Author: Thulani Lunyawo(222828250)
Date: 17/03/2025
 */

public class ParkingLot {

    private String lotId;
    private String title;
    private String location;
    private String openTime;
    private String closingTime;
    private double pricePerHour;

    // Private constructor to be used by the Builder
    private ParkingLot(Builder builder) {
        this.lotId = builder.lotId;
        this.title = builder.title; // Assign title
        this.location = builder.location;
        this.openTime = builder.openTime;
        this.closingTime = builder.closingTime;
        this.pricePerHour = builder.pricePerHour;
    }

    // Getters
    public String getLotId() { return lotId; }
    public String getTitle() { return title; } // Getter for title
    public String getLocation() { return location; }
    public String getOpenTime() { return openTime; }
    public String getClosingTime() { return closingTime; }
    public double getPricePerHour() { return pricePerHour; }

    public static class Builder {
        private String lotId;
        private String title; // Added title in Builder
        private String location;
        private String openTime;
        private String closingTime;
        private double pricePerHour;

        public Builder setLotId(String lotId) {
            this.lotId = lotId;
            return this;
        }

        public Builder setTitle(String title) { // Setter for title
            this.title = title;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setOpenTime(String openTime) {
            this.openTime = openTime;
            return this;
        }

        public Builder setClosingTime(String closingTime) {
            this.closingTime = closingTime;
            return this;
        }

        public Builder setPricePerHour(double pricePerHour) {
            this.pricePerHour = pricePerHour;
            return this;
        }

        public ParkingLot build() {
            return new ParkingLot(this);
        }
    }
}
