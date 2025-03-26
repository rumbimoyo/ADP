package factory;

/*Rumbidzai Moyo
230098789
Parking spot Factory
*/

import domain.ParkingLot;
import domain.ParkingSpot;
import util.Helper;

import static util.Helper.isNullorEmpty;
import static util.Helper.isNullOrZero;


public class ParkingSpotFactory {

    // Creates a spot with all attributes
    public static ParkingSpot createParkingSpot(String spotID, String spotNumber, String status, String type, ParkingLot parkingLot) {
        if(Helper.isNullorEmpty(spotID)|| Helper.isNullorEmpty(spotNumber) || Helper.isNullorEmpty(status) || Helper.isNullorEmpty(type) || Helper.isNullorEmptyParkingLot(parkingLot)) {
            return null;

        }
        if (!Helper.isValidStatus(status) || !Helper.isValidType(type)) {
            return null;
        }

        return new ParkingSpot.Builder()
                .setSpotID(spotID)
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .setType(type)
                .setParkingLot(parkingLot)
                .build();
    }

    // Creates a spot with only spot number and status
    public static ParkingSpot createParkingSpotWithBasicDetails(String spotNumber, String status) {
        if(Helper.isNullorEmpty(spotNumber) || Helper.isNullorEmpty(status) || !Helper.isValidStatus(status)) {
            return null;

        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .build();
    }

    // Creates with spot number, status, and type
    public static ParkingSpot createParkingSpotWithSpotDetails(String spotNumber, String status, String type) {
        if( Helper.isNullorEmpty(spotNumber) || Helper.isNullorEmpty(status) || Helper.isNullorEmpty(type)) {
            return null;

        }
        if (!Helper.isValidStatus(status) || !Helper.isValidType(type)) {
            return null;
        }

        return new ParkingSpot.Builder()
                .setStatus(status)
                .setType(type)
                .build();
    }

    // Creates with spot number, status, and parking lot
    public static ParkingSpot createParkingSpotWithParkingLot(String spotNumber, String status, ParkingLot parkingLot) {
        if(Helper.isNullorEmpty(spotNumber) || Helper.isNullorEmpty(status) || Helper.isNullorEmptyParkingLot(parkingLot)) {
            return null;

        }
        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .setParkingLot(parkingLot)
                .build();
    }
}