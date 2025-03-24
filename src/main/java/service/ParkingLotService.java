package service;

/*
service.ParkingLotService
ParkingLot Service class
Author: Thulani Lunyawo (222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;
import repository.ParkingLotRepository;

import java.util.Set;

public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    // Constructor to initialize the repository
    public ParkingLotService() {
        this.parkingLotRepository = ParkingLotRepository.getInstance();
    }

    // Save a new parking lot
    public boolean saveParkingLot(ParkingLot parkingLot) {
        if (parkingLot != null && parkingLotRepository.findById(parkingLot.getLotId()) == null) {
            parkingLotRepository.save(parkingLot);
            return true; // Successfully saved
        }
        return false;
    }

    // Update an existing parking lot
    public boolean updateParkingLot(ParkingLot parkingLot) {
        if (parkingLot != null && parkingLotRepository.findById(parkingLot.getLotId()) != null) {
            parkingLotRepository.update(parkingLot);
            return true; // Successfully updated
        }
        return false;
    }

    // Delete a parking lot by ID
    public boolean deleteParkingLot(String lotId) {
        if (lotId != null && parkingLotRepository.findById(lotId) != null) {
            parkingLotRepository.delete(lotId);
            return true; // Successfully deleted
        }
        return false; 
    }

    // Get a parking lot by ID
    public ParkingLot getParkingLotById(String lotId) {
        return parkingLotRepository.findById(lotId);
    }

    // Get all parking lots
    public Set<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.getAll();
    }
}
