package repository;

/*
Rumbidzai Moyo Chaka
230098789
parkingspot repository test
 */

import domain.ParkingLot;

import domain.ParkingSpot;
import factory.ParkingLotFactory;
import factory.ParkingSpotFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotRepositoryTest {

    private final ParkingSpotRepository parkingSpotRepository = ParkingSpotRepository.getInstance();
    ParkingLot parkingLot = ParkingLotFactory.createParkingLot("1", "parking lot", "s", "1","1", 12.5);
    ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(101, "open", "compact", parkingLot);


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

        boolean isCreated = parkingSpotRepository.create(parkingSpot);
        assertTrue(isCreated, "Parking spot creation should return true");
        boolean isDuplicate = parkingSpotRepository.create(parkingSpot);
        assertFalse(isDuplicate, "Duplicate parking spot should not be added");
    }

    @Test
    @DisplayName("Testing read method")
    void read() {

        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(102, "open", "compact", parkingLot);
        parkingSpotRepository.create(parkingSpot);

        ParkingSpot foundSpot = parkingSpotRepository.read(102);
        assertNotNull(foundSpot, "Parking spot should not be null");
        assertEquals(102, foundSpot.getSpotNumber(), "Spot number should match");
    }

    @Test
    @DisplayName("Testing if read returns null")
    void readNull() {
        ParkingSpot foundSpot = parkingSpotRepository.read(999);
        assertNull(foundSpot, "Non-existent parking spot should return null");
    }

    @Test
    @DisplayName("Testing update method")
    void update() {
        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(110, "open","disabled", parkingLot);
        parkingSpotRepository.create(parkingSpot);

        ParkingSpot spot = ParkingSpotFactory.createParkingSpot(110, "reserved", "disabled", parkingLot);
        assert spot != null;
        ParkingSpot updatedSpot = parkingSpotRepository.update(spot);
        System.out.println(updatedSpot);

        assertNotNull(updatedSpot, "Updated parking spot should not be null");
        assertEquals("reserved", updatedSpot.getStatus(), "Status should be updated to 'reserved'");
    }

    @Test
    @DisplayName("Testing if update returns null")
    void updateNull() {

        ParkingSpot nonExistentSpot = ParkingSpotFactory.createParkingSpot(999, "open", "compact", parkingLot);
        ParkingSpot updatedSpot = parkingSpotRepository.update(nonExistentSpot);
        assertNull(updatedSpot, "Non-existent parking spot should return null");
    }

    @Test
    @DisplayName("Testing delete method")
    void delete() {

        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(102, "open", "compact", parkingLot);
        parkingSpotRepository.create(parkingSpot);
        parkingSpotRepository.delete(102);

        assertNull( parkingSpotRepository.read(102), "Deleted parking spot should return null");
    }

    @Test
    @DisplayName("Testing if delete works for non-existent object")
    void deleteNull() {
        parkingSpotRepository.delete(101);
        ParkingSpot deletedSpot = parkingSpotRepository.read(101);
        assertNull(deletedSpot, "Non-existent parking spot should remain null");
    }

    @Test
    @DisplayName("Testing getAll method")
    void getAll() {

        ParkingSpot parkingSpot2 = ParkingSpotFactory.createParkingSpot(103, "reserved", "compact", parkingLot);
        parkingSpotRepository.create(parkingSpot2);
        var allSpots = parkingSpotRepository.getAll();

        assertNotNull(allSpots, "All parking spots should not be null");
        assertEquals(2, allSpots.size(), "There should be two parking spots in the repository");
        for (var spot : allSpots) {
            assertTrue(spot instanceof ParkingSpot, "Each item should be an instance of ParkingSpot");
        }
    }
}
