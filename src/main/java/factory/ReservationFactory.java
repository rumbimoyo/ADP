
package factory;

//factory.ReservationFactory
//Reservation Factory class
//Author: Avela Bonakali
//Date: 20/03/2025
// */

import domain.Reservation;
import domain.Vehicle;
import domain.ParkingSpot;
import domain.User;
import util.Helper;

import java.time.LocalDate;

public class ReservationFactory {


    // Object of Reservation with all factory methods
    public static Reservation createReservation(String reservationID,
                                      String startTime,
                                      String endTime,
                                      LocalDate localDate,
                                      double price,
                                      Vehicle vehicle,
                                      ParkingSpot parkingSpot,
                                      User user
                                     ) {

       if(Helper.isNullorEmpty(reservationID) ||
               Helper.isNullorEmpty(startTime) ||
               Helper.isNullorEmpty(endTime) ||
               Helper.isNullorEmpty(localDate) ||
               Helper.isNullorEmpty(price) ||
               Helper.isNullorEmpty(vehicle) ||
               Helper.isNullorEmpty(parkingSpot) ||
               Helper.isNullorEmpty(user) ||
               Helper.isValidTime(startTime) ||
               Helper.isValidTime(endTime) ||
                price < 0)
       {
            return null;
       }

        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setLocalDate(localDate)
                .setPrice(price)
                .setVehicle(vehicle)
                .setParkingSpot(parkingSpot)
                .setUser(user)
                .build();
    }

    // no vehicle
    public static Reservation createReservation(String reservationID,
                                                String startTime,
                                                String endTime,
                                                LocalDate localDate,
                                                double price,
                                                ParkingSpot parkingSpot,
                                                User user
    ) {

        if(Helper.isNullorEmpty(reservationID) ||
                Helper.isNullorEmpty(startTime) ||
                Helper.isNullorEmpty(endTime) ||
                Helper.isNullorEmpty(localDate) ||
                Helper.isNullorEmpty(price) ||
                Helper.isNullorEmpty(parkingSpot) ||
                Helper.isNullorEmpty(user) ||
                Helper.isValidTime(startTime) ||
                Helper.isValidTime(endTime) ||
                price < 0)
        {
            return null;
        }

        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setLocalDate(localDate)
                .setPrice(price)
                .setParkingSpot(parkingSpot)
                .setUser(user)
                .build();
    }

    // no user
    public static Reservation createReservation(String reservationID,
                                                String startTime,
                                                String endTime,
                                                LocalDate localDate,
                                                double price,
                                                Vehicle vehicle,
                                                ParkingSpot parkingSpot
    ) {

        if(Helper.isNullorEmpty(reservationID) ||
                Helper.isNullorEmpty(startTime) ||
                Helper.isNullorEmpty(endTime) ||
                Helper.isNullorEmpty(localDate) ||
                Helper.isNullorEmpty(price) ||
                Helper.isNullorEmpty(vehicle) ||
                Helper.isNullorEmpty(parkingSpot) ||
                Helper.isValidTime(startTime) ||
                Helper.isValidTime(endTime) ||
                price < 0)
        {
            return null;
        }

        return new Reservation.Builder()
                .setReservationID(reservationID)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setLocalDate(localDate)
                .setPrice(price)
                .setVehicle(vehicle)
                .setParkingSpot(parkingSpot)
                .build();
    }

}