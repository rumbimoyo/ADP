package domain;

/*
domain.ParkingLot
ParkingLot entity class
Author: Thulani Lunyawo(222828250)
Date: 17/03/2025
 */

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {

    private String lotId;
    private String location;
    private String openTime;
    private String closingTime;
    private double pricePerHour;
    private Set<ParkingSpot> parkingSpots;
    private Set<Ticket> tickets;

    // Private constructor to be used by the Builder
    private ParkingLot(Builder builder) {
        this.lotId = builder.lotId;
        this.location = builder.location;
        this.openTime = builder.openTime;
        this.closingTime = builder.closingTime;
        this.pricePerHour = builder.pricePerHour;
        this.parkingSpots = builder.parkingSpots;
        this.tickets = builder.tickets;
    }

    // Getters
    public String getLotId() { return lotId; }
    public String getLocation() { return location; }
    public String getOpenTime() { return openTime; }
    public String getClosingTime() { return closingTime; }
    public double getPricePerHour() { return pricePerHour; }
    public Set<ParkingSpot> getParkingSpots() { return parkingSpots; }
    public Set<Ticket> getTickets() { return tickets; }

    // Ticket generation logic
//    public Ticket generateTicket(ParkingSpot spot) {
//        Ticket ticket = new Ticket(spot);
//        tickets.add(ticket);
//        return ticket;
//    }

    // ParkingSpot management methods
    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpots.remove(spot);
    }

    public void editParkingSpot(ParkingSpot oldSpot, ParkingSpot newSpot) {
        removeParkingSpot(oldSpot);
        addParkingSpot(newSpot);
    }

    public static class Builder {
        private String lotId;
        private String location;
        private String openTime;
        private String closingTime;
        private double pricePerHour;
        private Set<ParkingSpot> parkingSpots = new HashSet<>();
        private Set<Ticket> tickets = new HashSet<>();

        public Builder setLotId(String lotId) {
            this.lotId = lotId;
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

        public Builder setParkingSpots(Set<ParkingSpot> parkingSpots) {
            this.parkingSpots = parkingSpots;
            return this;
        }

        public Builder setTickets(Set<Ticket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public ParkingLot build() {
            return new ParkingLot(this);
        }
    }
}
