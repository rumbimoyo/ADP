package repository;

/*
test.repository.ParkinngLotrRepositoryTest
ParkingLotFactoryTest class
Author: Thulani Lunyawo(222828250)
Date: 17/03/2025
 */


import domain.ParkingLot;
import repository.ParkingLotRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotRepositoryTest {

    ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance();

    @Test
    @DisplayName("Testing save and findById method")
    public void testSaveAndFindById() {
        // Create an instance of the repository and parking lot
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setLocation("Downtown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(5.0)
                .build();

        // Save the parking lot to the repository
        parkingLotRepository.save(parkingLot);

        // Retrieve it by ID and assert it's correct
        ParkingLot foundLot = parkingLotRepository.findById("PL001");

        assertNotNull(foundLot, "Parking lot should not be null");
        assertEquals("PL001", foundLot.getLotId(), "Lot ID should match");
        assertEquals("Downtown", foundLot.getLocation(), "Location should match");
    }

    @Test
    @DisplayName("Testing delete method")
    public void testDelete() {
        // Create an instance of the repository and parking lot
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setLocation("Downtown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(5.0)
                .build();

        // Save the parking lot to the repository
        parkingLotRepository.save(parkingLot);

        // Delete the parking lot
        parkingLotRepository.delete("PL001");

        // Assert that it no longer exists in the repository
        ParkingLot foundLot = parkingLotRepository.findById("PL001");
        assertNull(foundLot, "Parking lot should be null after deletion");
    }

    @Test
    @DisplayName("Testing update method")
    public void testUpdate() {
        // Create an instance of the repository and parking lot
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setLocation("Downtown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(5.0)
                .build();

        // Save the parking lot to the repository
        parkingLotRepository.save(parkingLot);

        // Update location and price
        parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setLocation("Uptown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(6.0)
                .build();

        // Update the parking lot in the repository
        parkingLotRepository.update(parkingLot);

        // Retrieve the updated parking lot and assert changes
        ParkingLot updatedLot = parkingLotRepository.findById("PL001");

        assertNotNull(updatedLot, "Updated parking lot should not be null");
        assertEquals("Uptown", updatedLot.getLocation(), "Location should be updated to Uptown");
        assertEquals(6.0, updatedLot.getPricePerHour(), "Price per hour should be updated to 6.0");
    }
}
