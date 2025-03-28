package factory;

/*Rumbidzai Moyo
230098789
Parking spot Factory
*/

import domain.ParkingLot;
import domain.ParkingSpot;
import util.Helper;

public class ParkingSpotFactory {

    // Creates a spot with all attributes
    public static ParkingSpot createParkingSpot(int spotNumber, String status, String type, ParkingLot parkingLot) {

        if(Helper.isNullorEmpty(spotNumber) ||
                Helper.isNullorEmpty(status) ||
                Helper.isNullorEmpty(type) ||
                Helper.isNullorEmpty(parkingLot) ||
                !Helper.isValidStatus(status) ||
                !Helper.isValidType(type)||
                !Helper.isValidSpotNumber(spotNumber)) {
            return null;

        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .setType(type)
                .setParkingLot(parkingLot)
                .build();
    }

    // Creates a spot with only spot number and status
    public static ParkingSpot createParkingSpot(int spotNumber, String status) {

        if(Helper.isNullorEmpty(spotNumber) ||
                Helper.isNullorEmpty(status)
                || !Helper.isValidStatus(status) ||
                !Helper.isValidSpotNumber(spotNumber)) {
            return null;

        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .build();
    }

    // Creates with spot number, status, and type
    public static ParkingSpot createParkingSpot(int spotNumber, String status, String type) {

        if( Helper.isNullorEmpty(spotNumber) ||
                Helper.isNullorEmpty(status) ||
                Helper.isNullorEmpty(type) ||
                !Helper.isValidStatus(status) ||
                !Helper.isValidType(type) ||
                !Helper.isValidSpotNumber(spotNumber)) {
            return null;

        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .setType(type)
                .build();
    }

    // Creates with spot number, status, and parking lot
    public static ParkingSpot createParkingSpot(int spotNumber, String status, ParkingLot parkingLot) {

        if(Helper.isNullorEmpty(spotNumber) ||
                Helper.isNullorEmpty(status) ||
                Helper.isNullorEmpty(parkingLot) ||
                !Helper.isValidStatus(status) ||
                !Helper.isValidSpotNumber(spotNumber)) {
            return null;

        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .setParkingLot(parkingLot)
                .build();
    }
}