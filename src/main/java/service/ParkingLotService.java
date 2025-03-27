package service;

/*
service.ParkingLotService
ParkingLot Service class
Author: Thulani Lunyawo (222828250)
Date: 21/03/2025
*/

import domain.ParkingLot;
import repository.ParkingLotRepository;

import java.util.Set;

public class ParkingLotService {

    // Singleton instance of the repository
    private final ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

    // Adds a new parking lot
    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.create(parkingLot);
    }

    // Retrieves a parking lot by ID
    public ParkingLot findParkingLot(String lotId) {
        return parkingLotRepository.read(lotId);
    }

    // Updates an existing parking lot
    public ParkingLot editParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.update(parkingLot);
    }

    // Deletes a parking lot by ID
    public void deleteParkingLot(String lotId) {
        parkingLotRepository.delete(lotId);
    }

    // Retrieves all parking lots
    public Set<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.getAll();
    }
}
