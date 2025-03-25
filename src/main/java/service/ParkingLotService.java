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

    private final ParkingLotRepository parkingLotRepository;

    // Constructor to initialize the repository
    public ParkingLotService() {
        this.parkingLotRepository = ParkingLotRepository.getInstance();
    }

    // Save a new parking lot
    public boolean saveParkingLot(ParkingLot parkingLot) {
        if (parkingLot != null && parkingLotRepository.read(parkingLot.getLotId()) == null) {
            parkingLotRepository.create(parkingLot); // Changed to create method
            return true; // Successfully saved
        }
        return false;
    }

    // Update an existing parking lot
    public boolean updateParkingLot(ParkingLot parkingLot) {
        if (parkingLot != null && parkingLotRepository.read(parkingLot.getLotId()) != null) {
            parkingLotRepository.update(parkingLot); // Corrected method call
            return true; // Successfully updated
        }
        return false;
    }

    // Delete a parking lot by ID
    public boolean deleteParkingLot(String lotId) {
        if (lotId != null && parkingLotRepository.read(lotId) != null) {
            parkingLotRepository.delete(lotId); // Corrected method call
            return true; // Successfully deleted
        }
        return false;
    }

    // Get a parking lot by ID
    public ParkingLot getParkingLotById(String lotId) {
        return parkingLotRepository.read(lotId); // Corrected method call
    }

    // Get all parking lots
    public Set<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.getAll(); // Corrected method call
    }
}
