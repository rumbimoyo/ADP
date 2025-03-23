package factory;

/*
ParkingSpotFactoryTest
Rumbidzai Moyo
230098789
 */

import domain.ParkingLot;
import domain.ParkingSpot;
import factory.ParkingSpotFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotFactoryTest {

    private ParkingSpot parkingSpot;
    private ParkingLot parkingLot;

    @Test
    @DisplayName("Test creating a ParkingSpot with all attributes")
    void testCreateParkingSpot_WithAllAttributes() {

        parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");
        parkingSpot = ParkingSpotFactory.createParkingSpot(
                101, "open", "compact", parkingLot
        );

        System.out.println("Created Parking Spot: " + parkingSpot);

        assertNotNull(parkingSpot, "Parking spot creation failed!");
        assertTrue(parkingSpot instanceof ParkingSpot, "The created object should be a ParkingSpot");
        assertEquals(101, parkingSpot.getSpotNumber(), "The spot number should be 101");
        assertEquals("open", parkingSpot.getStatus(), "The status should be 'open'");
        assertEquals("compact", parkingSpot.getType(), "The type should be 'compact'");
        assertNotNull(parkingSpot.getParkingLot(), "The parking lot should not be null");
        assertEquals("Central Parking Lot", parkingSpot.getParkingLot().getTitle(), "The parking lot title should match");
    }

    @Test
    @DisplayName("Test creating a ParkingSpot with an invalid status")
    void testCreateParkingSpot_WithInvalidStatus() {

        parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");

        parkingSpot = ParkingSpotFactory.createParkingSpot(
                101, "invalid_status", "compact", parkingLot
        );

        assertNull(parkingSpot, "The factory should return null for invalid status");
    }


    @Test
    @DisplayName("Test creating a ParkingSpot with a null ParkingLot")
    void testCreateParkingSpot_WithNullParkingLot() {

        parkingSpot = ParkingSpotFactory.createParkingSpot(
                101, "open", "compact", null
        );
        assertNull(parkingSpot, "The factory should return null for a null parking lot");
    }

    @Test
    @DisplayName("Test creating a ParkingSpot with basic details")
    void testCreateParkingSpotWithBasicDetails() {
        parkingSpot = ParkingSpotFactory.createParkingSpotWithBasicDetails(
                101, "open"
        );
        assertNotNull(parkingSpot, "Parking spot creation failed!");
        assertEquals(101, parkingSpot.getSpotNumber(), "The spot number should be 101");
        assertEquals("open", parkingSpot.getStatus(), "The status should be 'open'");
        assertNull(parkingSpot.getType(), "The type should be null");
        assertNull(parkingSpot.getParkingLot(), "The parking lot should be null");
    }

    @Test
    @DisplayName("Test creating a ParkingSpot with spot details")
    void testCreateParkingSpotWithSpotDetails() {
        // Create a parking spot with spot details (spot number, status, and type)
        parkingSpot = ParkingSpotFactory.createParkingSpotWithSpotDetails(
                101, "open", "compact"
        );
        assertNotNull(parkingSpot, "Parking spot creation failed!");
        assertEquals(101, parkingSpot.getSpotNumber(), "The spot number should be 101");
        assertEquals("open", parkingSpot.getStatus(), "The status should be 'open'");
        assertEquals("compact", parkingSpot.getType(), "The type should be 'compact'");

        assertNull(parkingSpot.getParkingLot(), "The parking lot should be null");
    }

    @Test
    @DisplayName("Test creating a ParkingSpot with a parking lot")
    void testCreateParkingSpotWithParkingLot() {
        parkingLot = new ParkingLot();
        parkingLot.setLotID(1L);
        parkingLot.setTitle("Central Parking Lot");

        parkingSpot = ParkingSpotFactory.createParkingSpotWithParkingLot(
                101, "open", parkingLot
        );

        assertNotNull(parkingSpot, "Parking spot creation failed!");
        assertEquals(101, parkingSpot.getSpotNumber(), "The spot number should be 101");
        assertEquals("open", parkingSpot.getStatus(), "The status should be 'open'");
        assertNotNull(parkingSpot.getParkingLot(), "The parking lot should not be null");
        assertEquals("Central Parking Lot", parkingSpot.getParkingLot().getTitle(), "The parking lot title should match");
    }
}