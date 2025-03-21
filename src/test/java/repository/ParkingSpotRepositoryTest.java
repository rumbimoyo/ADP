package repository;

/*
Rumbidzai Moyo Chaka
230098789
parkingspot repository test
 */

import domain.ParkingLot;
import domain.ParkingSpot;
import factory.ParkingSpotFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.ParkingSpotRepository;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotRepositoryTest {

    private final ParkingSpotRepository parkingSpotRepository = ParkingSpotRepository.getInstance();

    @Test
    @DisplayName("Testing instance method")
    void getInstance() {
        ParkingSpotRepository newRepository = ParkingSpotRepository.getInstance();
        assertNotNull(parkingSpotRepository, "Repository should not be null");
        assertSame(parkingSpotRepository, newRepository, "Should return the same instance of the repository");
    }

    @Test
    @DisplayName("Testing create method")
    void create() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");

        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", parkingLot);
        boolean isCreated = parkingSpotRepository.create(parkingSpot);
        assertTrue(isCreated, "Parking spot creation should return true");
        boolean isDuplicate = parkingSpotRepository.create(parkingSpot);
        assertFalse(isDuplicate, "Duplicate parking spot should not be added");
    }

    @Test
    @DisplayName("Testing read method")
    void read() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");

        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", parkingLot);
        parkingSpotRepository.create(parkingSpot);

        ParkingSpot foundSpot = parkingSpotRepository.read(101L);
        assertNotNull(foundSpot, "Parking spot should not be null");
        assertEquals(101, foundSpot.getSpotNumber(), "Spot number should match");
    }

    @Test
    @DisplayName("Testing if read returns null")
    void readNull() {
        ParkingSpot foundSpot = parkingSpotRepository.read(999L);
        assertNull(foundSpot, "Non-existent parking spot should return null");
    }

    @Test
    @DisplayName("Testing update method")
    void update() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");
        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", parkingLot);
        parkingSpotRepository.create(parkingSpot);
        ParkingSpot updatedSpot = ParkingSpotFactory.createParkingSpot(101, "reserved", "compact", parkingLot);
        updatedSpot = parkingSpotRepository.update(updatedSpot);
        assertNotNull(updatedSpot, "Updated parking spot should not be null");
        assertEquals("reserved", updatedSpot.getStatus(), "Status should be updated to 'reserved'");
    }

    @Test
    @DisplayName("Testing if update returns null")
    void updateNull() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");
        ParkingSpot nonExistentSpot = ParkingSpotFactory.createParkingSpot(999, "open", "compact", parkingLot);
        ParkingSpot updatedSpot = parkingSpotRepository.update(nonExistentSpot);
        assertNull(updatedSpot, "Non-existent parking spot should return null");
    }

    @Test
    @DisplayName("Testing delete method")
    void delete() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");
        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", parkingLot);
        parkingSpotRepository.create(parkingSpot);
        parkingSpotRepository.delete(101L);
        ParkingSpot deletedSpot = parkingSpotRepository.read(101L);
        assertNull(deletedSpot, "Deleted parking spot should return null");
    }

    @Test
    @DisplayName("Testing if delete works for non-existent object")
    void deleteNull() {
        parkingSpotRepository.delete(999L); // Attempt to delete a non-existent parking spot
        ParkingSpot deletedSpot = parkingSpotRepository.read(999L);
        assertNull(deletedSpot, "Non-existent parking spot should remain null");
    }

    @Test
    @DisplayName("Testing getAll method")
    void getAll() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");
        ParkingSpot parkingSpot1 = ParkingSpotFactory.createParkingSpot(101, "open", "compact", parkingLot);
        ParkingSpot parkingSpot2 = ParkingSpotFactory.createParkingSpot(102, "reserved", "compact", parkingLot);
        parkingSpotRepository.create(parkingSpot1);
        parkingSpotRepository.create(parkingSpot2);
        var allSpots = parkingSpotRepository.getAll();
        assertNotNull(allSpots, "All parking spots should not be null");
        assertEquals(2, allSpots.size(), "There should be two parking spots in the repository");
        for (var spot : allSpots) {
            assertTrue(spot instanceof ParkingSpot, "Each item should be an instance of ParkingSpot");
        }
    }
}
