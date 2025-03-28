package repository;

/*
repository.ParkingLotRepository
ParkingLot Repository class
Author: Thulani Lunyawo (222828250)
Date: 23/03/2025
 */

import domain.ParkingLot;
import domain.User;

import java.util.HashSet;
import java.util.Set;

public class ParkingLotRepository implements IRepository<ParkingLot, String>{

    private static ParkingLotRepository instance;
    private final Set<ParkingLot> parkingLotDB;

    // Private constructor to prevent instantiation
    private ParkingLotRepository() {
        parkingLotDB = new HashSet<>();
    }

    // Singleton pattern to ensure a single instance
    public static synchronized ParkingLotRepository getInstance() {
        if (instance == null) {
            instance = new ParkingLotRepository();
        }
        return instance;
    }


    public boolean create(ParkingLot parkingLot) {
       return parkingLotDB.add(parkingLot);
    }


    public ParkingLot read(String lotId) {
        return parkingLotDB.stream()
                .filter(parkingLot -> parkingLot.getLotId().equals(lotId))
                .findFirst()
                .orElse(null); // if no parking lot is found
    }


    public ParkingLot update(ParkingLot newParkingLot) {
        ParkingLot oldParkingLot = this.read(newParkingLot.getLotId());
        if (oldParkingLot != null) {
            parkingLotDB.remove(oldParkingLot);
            parkingLotDB.add(newParkingLot);
            return newParkingLot;
        }
        return null;
    }


    public void delete(String lotId) {
        parkingLotDB.removeIf(parkingLot -> parkingLot.getLotId().equals(lotId));
    }


    public Set<ParkingLot> getAll() {
        return parkingLotDB;
    }
}
