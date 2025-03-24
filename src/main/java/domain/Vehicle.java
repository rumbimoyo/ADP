package domain;

/*Vehicle.java
Vehicle model class
Author:Casey Abigail Nolte (218275161)
Date: 21 March 2025
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vehicle {
    private Long licensePlate;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleColour;
    private Long vehicleVIN;

    private Set<User> users;
    private Set<Ticket> tickets;
    private Set<Reservation> reservations;

    public Vehicle(Long licensePlate, String vehicleMake, String vehicleModel, String vehicleColour, Long vehicleVIN) {
        this.licensePlate = licensePlate;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleColour = vehicleColour;
        this.vehicleVIN = vehicleVIN;
        this.users = new HashSet<>();
        this.tickets = new HashSet<>();
        this.reservations = new HashSet<>();
    }


    public Long getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Long licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public Long getVehicleVIN() {
        return vehicleVIN;
    }

    public void setVehicleVIN(Long vehicleVIN) {
        this.vehicleVIN = vehicleVIN;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate=" + licensePlate +
                ", vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleColour='" + vehicleColour + '\'' +
                ", vehicleVIN=" + vehicleVIN +
                '}';
    }
}
