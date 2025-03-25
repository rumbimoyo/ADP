package repository;

/*
repository.ParkingLotRepository
ParkingLot Repository class
Author: Thulani Lunyawo (222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;
import java.util.HashSet;
import java.util.Set;

public class ParkingLotRepository implements IParkingLotRepository<ParkingLot, String> {

    private static ParkingLotRepository instance;
    private Set<ParkingLot> parkingLotDB;

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

    @Override
    public ParkingLot create(ParkingLot parkingLot) {
        parkingLotDB.add(parkingLot);
        return parkingLot;
    }

    @Override
    public ParkingLot read(String lotId) {
        return parkingLotDB.stream()
                .filter(parkingLot -> parkingLot.getLotId().equals(lotId))
                .findFirst()
                .orElse(null); // if no parking lot is found
    }

    @Override
    public ParkingLot update(ParkingLot newParkingLot) {
        ParkingLot oldParkingLot = this.read(newParkingLot.getLotId());
        if (oldParkingLot != null) {
            parkingLotDB.remove(oldParkingLot);
            parkingLotDB.add(newParkingLot);
            return newParkingLot;
        }
        return null;
    }

    @Override
    public boolean delete(String lotId) {
        return parkingLotDB.removeIf(parkingLot -> parkingLot.getLotId().equals(lotId));
    }

    @Override
    public Set<ParkingLot> getAll() {
        return parkingLotDB;
    }
}
