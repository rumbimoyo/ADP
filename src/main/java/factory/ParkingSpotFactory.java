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
    public static ParkingSpot createParkingSpot(int spotNumber, String status, String type, ParkingLot parkingLot) {
        if (!Helper.isValidStatus(status) || !Helper.isValidType(type) || isNullorEmpty(parkingLot)) {
            return null;
        }

        if (isNullOrZero(spotNumber)) {
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
    public static ParkingSpot createParkingSpotWithBasicDetails(int spotNumber, String status) {
        if (!Helper.isValidStatus(status)) {
            return null;
        }

        if (isNullOrZero(spotNumber)) {
            return null;
        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .build();
    }

    // Creates with spot number, status, and type
    public static ParkingSpot createParkingSpotWithSpotDetails(int spotNumber, String status, String type) {
        if (!Helper.isValidStatus(status) || !Helper.isValidType(type)) {
            return null;
        }

        if (isNullOrZero(spotNumber)) {
            return null;
        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .setType(type)
                .build();
    }

    // Creates with spot number, status, and parking lot
    public static ParkingSpot createParkingSpotWithParkingLot(int spotNumber, String status, ParkingLot parkingLot) {
        if (!Helper.isValidStatus(status) || isNullorEmpty(ParkingLot)) {
            return null;
        }

        if (isNullOrZero(spotNumber)) {
            return null;
        }

        return new ParkingSpot.Builder()
                .setSpotNumber(spotNumber)
                .setStatus(status)
                .setParkingLot(parkingLot)
                .build();
    }
}