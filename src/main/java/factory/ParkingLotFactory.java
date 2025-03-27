package factory;

/*
factory.ParkingLotFactory
ParkingLot Factory class
Author: Thulani Lunyawo (222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;
import util.Helper;
import static util.Helper.*;

public class ParkingLotFactory {

    // Creates ParkingLot object with all attributes
    public static ParkingLot createParkingLot(String lotId, String title, String location,
                                              String openTime, String closingTime, double pricePerHour) {

        if (isNullorEmpty(lotId) ||
                isNullorEmpty(title) ||
                isNullorEmpty(location) ||
                isNullorEmpty(openTime) ||
                isNullorEmpty(closingTime) ||
                pricePerHour <= 0) {
            return null;
        }

        return new ParkingLot.Builder()
                .setLotId(lotId)
                .setTitle(title)
                .setLocation(location)
                .setOpenTime(openTime)
                .setClosingTime(closingTime)
                .setPricePerHour(pricePerHour)
                .build();
    }

    // Creates ParkingLot object without closing time
    public static ParkingLot createParkingLot(String lotId, String title, String location,
                                              String openTime, double pricePerHour) {

        if (isNullorEmpty(lotId) ||
                isNullorEmpty(title) ||
                isNullorEmpty(location) ||
                isNullorEmpty(openTime) ||
                pricePerHour <= 0) {
            return null;
        }

        return new ParkingLot.Builder()
                .setLotId(lotId)
                .setTitle(title)
                .setLocation(location)
                .setOpenTime(openTime)
                .setPricePerHour(pricePerHour)
                .build();
    }

    // Creates ParkingLot object without open and closing times
    public static ParkingLot createParkingLot(String lotId, String title, String location, double pricePerHour) {

        if (isNullorEmpty(lotId) ||
                isNullorEmpty(title) ||
                isNullorEmpty(location) ||
                pricePerHour <= 0) {
            return null;
        }

        return new ParkingLot.Builder()
                .setLotId(lotId)
                .setTitle(title)
                .setLocation(location)
                .setPricePerHour(pricePerHour)
                .build();
    }

    // Creates ParkingLot object without price per hour
    public static ParkingLot createParkingLot(String lotId, String title, String location,
                                              String openTime, String closingTime) {

        if (isNullorEmpty(lotId) ||
                isNullorEmpty(title) ||
                isNullorEmpty(location) ||
                isNullorEmpty(openTime) ||
                isNullorEmpty(closingTime)) {
            return null;
        }

        return new ParkingLot.Builder()
                .setLotId(lotId)
                .setTitle(title)
                .setLocation(location)
                .setOpenTime(openTime)
                .setClosingTime(closingTime)
                .build();
    }

    // Creates ParkingLot object with only essential attributes
    public static ParkingLot createParkingLot(String lotId, String title, String location) {

        if (isNullorEmpty(lotId) ||
                isNullorEmpty(title) ||
                isNullorEmpty(location)) {
            return null;
        }

        return new ParkingLot.Builder()
                .setLotId(lotId)
                .setTitle(title)
                .setLocation(location)
                .build();
    }
}
