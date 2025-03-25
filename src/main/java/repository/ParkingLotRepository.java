package repository;

/*
repository.ParkingLotRepository
ParkingLot Repository class
Author: Thulani Lunyuawo(222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;
import java.util.HashSet;
import java.util.Set;

public class ParkingLotRepository implements IParkingLotRepository {

    private static ParkingLotRepository instance;
    private Set<ParkingLot> parkingLotDatabase = new HashSet<>();

    // Private constructor to prevent instantiation
    private ParkingLotRepository() {}

    // Singleton pattern to ensure a single instance
    public static synchronized ParkingLotRepository getInstance() {
        if (instance == null) {
            instance = new ParkingLotRepository();
        }
        return instance;
    }

    @Override
    public void save(ParkingLot parkingLot) {
        parkingLotDatabase.add(parkingLot);
    }

    @Override
    public ParkingLot findById(String lotId) {
        return parkingLotDatabase.stream()
                .filter(parkingLot -> parkingLot.getLotId().equals(lotId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String lotId) {
        parkingLotDatabase.removeIf(parkingLot -> parkingLot.getLotId().equals(lotId));
    }

    @Override
    public void update(ParkingLot parkingLot) {
        delete(parkingLot.getLotId());
        save(parkingLot);
    }

    @Override
    public Set<ParkingLot> getAll() {
        return parkingLotDatabase;
    }
}
