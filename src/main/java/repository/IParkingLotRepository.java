package repository;

/*
IParkingLotRepository
Interface for ParkingLot Repository
Author: Thulani Lunyawo(222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;
import java.util.Set;

public interface IParkingLotRepository<T, ID> {

    // Create a new parking lot
    T create(T parkingLot);

    // Read (find) a parking lot by its ID
    T read(ID lotId);

    // Update an existing parking lot
    T update(T parkingLot);

    // Delete a parking lot by its ID
    boolean delete(ID lotId);

    // Get all parking lots
    Set<T> getAll();
}
