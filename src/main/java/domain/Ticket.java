package domain;

/*
domain.Ticket entity class
Author: Affan Ebrahim(223109878)
Date: 19/03/2025
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket {
    private  long ticketID;
    private  String entryTime;
    private  String exitTime;
    private  ParkingLot parkingLot;
    private  Vehicle vehicle;
    private  double price;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public Ticket() {
    }

    public Ticket(long ticketID, String entryTime, String exitTime, ParkingLot parkingLot, Vehicle vehicle, double price) {
        this.ticketID = ticketID;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingLot = parkingLot;
        this.vehicle = vehicle;
        this.price = price;
    }
public long getTicketID() {
        return ticketID;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPrice() {
        return price;
    }
    // Builder Class
     public static class Builder {
        private long ticketID;
        private String entryTime;
        private String exitTime;
        private ParkingLot parkingLot;
        private Vehicle vehicle;
        private double price;

        public Builder ticketID(long ticketID) {
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

        public Builder parkingLot(ParkingLot parkingLot) {
            this.parkingLot = parkingLot;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }
        public Ticket build() {
            return new Ticket(ticketID, entryTime, exitTime, parkingLot, vehicle, price);
        }
    }
   


      //This method Calculates how long the car has been in the  lot

    public long calculateDuration() {
        if (entryTime == null || exitTime == null) return 0;

        LocalDateTime entry = LocalDateTime.parse(entryTime, formatter);
        LocalDateTime exit = LocalDateTime.parse(exitTime, formatter);

        long hours = Duration.between(entry, exit).toHours();
        if (Duration.between(entry, exit).toMinutes() % 60 > 0) {
            hours++;
        }
        return hours;
    }


      //Calculates the total price based on the total duration of the stay

   /* public double calculatePrice() {
        if (parkingLot == null || entryTime == null || exitTime == null) return 0.0;
        return calculateDuration() * parkingLot.getPricePerHour();
    }
**/
   
       
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", entryTime='" + entryTime + '\'' +
                ", exitTime='" + exitTime + '\'' +
                ", parkingLot=" + parkingLot +
                ", vehicle=" + vehicle +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketID == ticket.ticketID && Double.compare(ticket.price, price) == 0 &&
                Objects.equals(entryTime, ticket.entryTime) &&
                Objects.equals(exitTime, ticket.exitTime) &&
                Objects.equals(parkingLot, ticket.parkingLot) &&
                Objects.equals(vehicle, ticket.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, entryTime, exitTime, parkingLot, vehicle, price);
    }

}
