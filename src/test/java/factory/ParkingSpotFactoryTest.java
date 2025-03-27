package factory;

/*
ParkingSpotFactoryTest
Rumbidzai Moyo
230098789
 */

import domain.ParkingLot;
import domain.ParkingSpot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpotFactoryTest {

    ParkingLot parkingLot = ParkingLotFactory.createParkingLot("1", "parking lot", "s", "1","1", 12.5);
    ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(111, "open","compact" ,parkingLot);


    @Test
    @DisplayName("Test creating a ParkingSpot with all attributes")
    void testCreateParkingSpot_WithAllAttributes() {

        assertNotNull(parkingSpot, "Parking spot creation failed!");
        assertTrue(parkingSpot instanceof ParkingSpot, "The created object should be a ParkingSpot");
        assertEquals(111, parkingSpot.getSpotNumber(), "The spot number should be 101");
        assertEquals("open", parkingSpot.getStatus(), "The status should be 'open'");
        assertEquals("compact", parkingSpot.getType(), "The type should be 'compact'");
        assertNotNull(parkingSpot.getParkingLot(), "The parking lot should not be null");

    }

    @Test
    @DisplayName("Test creating a ParkingSpot with an invalid status")
    void testCreateParkingSpot_WithInvalidStatus() {
        ParkingSpot parkingSpot = ParkingSpotFactory.createParkingSpot(
                111, "1","compact" ,parkingLot);

        assertNull(parkingSpot, "The factory should return null for invalid status");
    }

    @Test
    @DisplayName("Test creating a ParkingSpot with a null ParkingLot")
    void testCreateParkingSpot_WithNullParkingLot() {

        parkingSpot = ParkingSpotFactory.createParkingSpot(
                111, "open","compact" ,null);

        assertNull(parkingSpot, "The factory should return null for a null parking lot");
    }

    @Test
    @DisplayName("Test creating a ParkingSpot with basic details")
    void testCreateParkingSpotWithBasicDetails() {
        // Act: Create a ParkingSpot with basic details
        parkingSpot = ParkingSpotFactory.createParkingSpot(
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
        // Act: Create a ParkingSpot with spot details (spot number, status, and type)
        parkingSpot = ParkingSpotFactory.createParkingSpot(
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

        // Act: Create a ParkingSpot with a parking lot
        parkingSpot = ParkingSpotFactory.createParkingSpot(
                101, "open", parkingLot
        );

        // Assert: Validate the created ParkingSpot
        assertNotNull(parkingSpot, "Parking spot creation failed!");
        assertEquals(101, parkingSpot.getSpotNumber(), "The spot number should be 101");
        assertEquals("open", parkingSpot.getStatus(), "The status should be 'open'");
        assertNotNull(parkingSpot.getParkingLot(), "The parking lot should not be null");

    }
}