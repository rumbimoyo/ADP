package repository;

/*
repository.IParkingLotRepository
ParkingLot Repository class
Author: Thulani Lunyuawo(222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;
import java.util.Set;

public interface IParkingLotRepository {

    void save(ParkingLot parkingLot);

    ParkingLot findById(String lotId);

    void delete(String lotId);

    void update(ParkingLot parkingLot);

    Set<ParkingLot> getAll();
}
