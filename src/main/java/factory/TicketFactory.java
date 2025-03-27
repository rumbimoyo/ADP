package factory;

/*
factory.TicketFactory
Ticket Factory class
Author: Affan Ebrahim (223109878)
Date: 20/03/2025
 */

import domain.ParkingLot;
import domain.Ticket;
import domain.Vehicle;
import util.Helper;

import java.time.LocalDate;

public class TicketFactory {

    // object of Ticket with all attributes
    public static Ticket createTicket(String ticketID, String entryTime, String exitTime, double price, LocalDate localDate, ParkingLot parkingLot, Vehicle vehicle) {

        if(Helper.isNullorEmpty(ticketID) ||
                Helper.isNullorEmpty(entryTime) ||
                Helper.isNullorEmpty(exitTime) ||
                Helper.isNullorEmpty(price) ||
                Helper.isNullorEmpty(localDate) ||
                Helper.isNullorEmpty(parkingLot) ||
                Helper.isNullorEmpty(vehicle) ||
                Helper.isValidTime(entryTime) ||
                Helper.isValidTime(exitTime)
                 ){
                return null;
        }

        return new Ticket.Builder()
                .ticketID(ticketID)
                .entryTime(entryTime)
                .exitTime(exitTime)
                .price(price)
                .localDate(localDate)
                .parkingLot(parkingLot)
                .vehicle(vehicle)
                .build();
    }

    // object of Ticket no vehicle
    public static Ticket createTicket(String ticketID, String entryTime, String exitTime, double price, LocalDate localDate, ParkingLot parkingLot) {

        if(Helper.isNullorEmpty(ticketID) ||
                Helper.isNullorEmpty(entryTime) ||
                Helper.isNullorEmpty(exitTime) ||
                Helper.isNullorEmpty(price) ||
                Helper.isNullorEmpty(localDate) ||
                Helper.isNullorEmpty(parkingLot) ||
                Helper.isValidTime(entryTime) ||
                Helper.isValidTime(exitTime)){
            return null;
        }

        return new Ticket.Builder()
                .ticketID(ticketID)
                .entryTime(entryTime)
                .exitTime(exitTime)
                .price(price)
                .localDate(localDate)
                .parkingLot(parkingLot)
                .build();
    }

    // object of Ticket with no date
    public static Ticket createTicket(String ticketID, String entryTime, String exitTime, double price, ParkingLot parkingLot, Vehicle vehicle) {

        if(Helper.isNullorEmpty(ticketID) ||
                Helper.isNullorEmpty(entryTime) ||
                Helper.isNullorEmpty(exitTime) ||
                Helper.isNullorEmpty(price) ||
                Helper.isNullorEmpty(parkingLot) ||
                Helper.isNullorEmpty(vehicle) ||
                Helper.isValidTime(entryTime) ||
                Helper.isValidTime(exitTime)){
            return null;
        }

        return new Ticket.Builder()
                .ticketID(ticketID)
                .entryTime(entryTime)
                .exitTime(exitTime)
                .price(price)
                .parkingLot(parkingLot)
                .vehicle(vehicle)
                .build();
    }

    // object of Ticket with no price
    public static Ticket createTicket(String ticketID, String entryTime, String exitTime, LocalDate localDate, ParkingLot parkingLot, Vehicle vehicle) {

        if(Helper.isNullorEmpty(ticketID) ||
                Helper.isNullorEmpty(entryTime) ||
                Helper.isNullorEmpty(exitTime) ||
                Helper.isNullorEmpty(localDate) ||
                Helper.isNullorEmpty(parkingLot) ||
                Helper.isNullorEmpty(vehicle) ||
                Helper.isValidTime(entryTime) ||
                Helper.isValidTime(exitTime)){
            return null;
        }

        return new Ticket.Builder()
                .ticketID(ticketID)
                .entryTime(entryTime)
                .exitTime(exitTime)
                .localDate(localDate)
                .parkingLot(parkingLot)
                .vehicle(vehicle)
                .build();
    }

    // no price and date
    public static Ticket createTicket(String ticketID, String entryTime, String exitTime, ParkingLot parkingLot, Vehicle vehicle) {

        if(Helper.isNullorEmpty(ticketID) ||
                Helper.isNullorEmpty(entryTime) ||
                Helper.isNullorEmpty(exitTime) ||
                Helper.isNullorEmpty(parkingLot) ||
                Helper.isNullorEmpty(vehicle) ||
                Helper.isValidTime(entryTime) ||
                Helper.isValidTime(exitTime)){
            return null;
        }

        return new Ticket.Builder()
                .ticketID(ticketID)
                .entryTime(entryTime)
                .exitTime(exitTime)
                .parkingLot(parkingLot)
                .vehicle(vehicle)
                .build();
    }




}

