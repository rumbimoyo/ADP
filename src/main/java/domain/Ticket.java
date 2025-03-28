package domain;

/*
domain.Ticket entity class
Author: Affan Ebrahim(223109878)
Date: 19/03/2025
 */

import java.time.LocalDate;

public class Ticket {
    private  String ticketID;
    private  String entryTime;
    private  String exitTime;
    private  double price;
    private  LocalDate localDate;
    private  ParkingLot parkingLot;
    private  Vehicle vehicle;

    public Ticket() {

    }

    public Ticket(String ticketID, String entryTime, String exitTime,  double price, LocalDate localDate, ParkingLot parkingLot, Vehicle vehicle) {
        this.ticketID = ticketID;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.price = price;
        this.localDate = localDate;
        this.parkingLot = parkingLot;
        this.vehicle = vehicle;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {return localDate;}

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", entryTime='" + entryTime + '\'' +
                ", exitTime='" + exitTime + '\'' +
                ", price=" + price +
                ", localDate=" + localDate +
                ", parkingLot=" + parkingLot +
                ", vehicle=" + vehicle +
                '}';
    }

    // Builder Class
     public static class Builder {

        private String ticketID;
        private String entryTime;
        private String exitTime;
        private double price;
        private LocalDate localDate;
        private ParkingLot parkingLot;
        private Vehicle vehicle;

        public Builder ticketID(String ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder entryTime(String entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder exitTime(String exitTime) {
            this.exitTime = exitTime;
            return this;
        }

        public Builder localDate(LocalDate localDate){
            this.localDate = localDate;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder parkingLot(ParkingLot parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }


        public Ticket build() {
            return new Ticket(ticketID, entryTime, exitTime, price, localDate, parkingLot, vehicle);
        }
    }

}
