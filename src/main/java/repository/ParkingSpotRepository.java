package repository;

/*
rumbidzai moyo
230098789
parkingspot
 */

import domain.ParkingSpot;


import java.util.HashSet;
import java.util.Set;


public class ParkingSpotRepository {


    private static ParkingSpotRepository instance;
    private Set<ParkingSpot> parkingSpotDB;


    private ParkingSpotRepository() {
        parkingSpotDB = new HashSet<>();
    }


    public static synchronized ParkingSpotRepository getInstance() {
        if (instance == null) {
            instance = new ParkingSpotRepository();
        }
        return instance;
    }

    //  make a parking spot
    public boolean create(ParkingSpot parkingSpot) {
        if (parkingSpotDB==null) {
            throw new IllegalArgumentException("Parking Spot cannot be null");
        }
        return parkingSpotDB.add(parkingSpot);
    }

    //find a parking spot by using its ID
    public ParkingSpot read(Long spotID) {
        for (ParkingSpot parkingSpot : parkingSpotDB) {
            if (parkingSpot.getSpotID().equals(spotID)) {
                return parkingSpot;
            }
        }
        return null; // If no parking spot is found
    }

    //update
    public ParkingSpot update(ParkingSpot updatedParkingSpot) {
        ParkingSpot existingParkingSpot = this.read(updatedParkingSpot.getSpotID());
        if (existingParkingSpot != null) {
            parkingSpotDB.remove(existingParkingSpot); //remove the old object
            parkingSpotDB.add(updatedParkingSpot); //add the updated object
            return updatedParkingSpot;
        }
        return null;
    }

    // Delete
    public void delete(Long spotID) {
        ParkingSpot parkingSpot = this.read(spotID);
        if (parkingSpot != null) {
            parkingSpotDB.remove(parkingSpot);
        }
    }

    // Retrieve all parking spots in the database
    public Set<ParkingSpot> getAll() {
        return parkingSpotDB;
    }
}