package domain;

/*
domain.ParkingLot
ParkingLot entity class
Author: Thulani Lunyawo(222828250)
Date: 24/03/2025
 */

public class ParkingLot {

    private String lotId, title, location, openTime, closingTime;
    private double pricePerHour;

    public ParkingLot() {
    }

    public ParkingLot(String lotId, String title, String location, String openTime, String closingTime, double pricePerHour) {
        this.lotId = lotId;
        this.title = title;
        this.location = location;
        this.openTime = openTime;
        this.closingTime = closingTime;
        this.pricePerHour = pricePerHour;
    }

    public String getLotId() { return lotId; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public String getOpenTime() { return openTime; }
    public String getClosingTime() { return closingTime; }
    public double getPricePerHour() { return pricePerHour; }



    public static class Builder {
        private String lotId, title, location, openTime, closingTime;
        private double pricePerHour;

        public Builder setLotId(String lotId) {
            this.lotId = lotId;
            return this;
        }

        public Builder setTitle(String title) {
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
            return new ParkingLot(lotId, title, location, openTime, closingTime, pricePerHour);
        }
    }
}
