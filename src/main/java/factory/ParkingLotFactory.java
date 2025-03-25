package factory;

/*
factory.ParkingLotFactory
ParkingLot Factory class
Author: Thulani Lunyawo (222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;

public class ParkingLotFactory {

    // Factory method to create a ParkingLot instance
    public static ParkingLot createParkingLot(String lotId, String title, String location, String openTime, String closingTime, double pricePerHour) {
        return new ParkingLot.Builder()
                .setLotId(lotId)
                .setTitle(title)
                .setLocation(location)
                .setOpenTime(openTime)
                .setClosingTime(closingTime)
                .setPricePerHour(pricePerHour)
                .build();
    }

}

