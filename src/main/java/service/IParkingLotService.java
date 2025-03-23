package service;

import domain.ParkingLot;
import java.util.Set;

public interface IParkingLotService {
    ParkingLot save(ParkingLot parkingLot);
    ParkingLot findById(String lotId);
    Set<ParkingLot> findAll();
    void delete(String lotId);
    ParkingLot update(ParkingLot parkingLot);
    String generateTicket(String lotId);
}
