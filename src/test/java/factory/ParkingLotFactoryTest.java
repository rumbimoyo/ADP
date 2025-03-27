package factory;

/*
test.factory.ParkingLotFactoryTest
ParkingLotFactoryTest class
Author: Thulani Lunyawo (222828250)
Date: 20/03/2025
 */

import domain.ParkingLot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotFactoryTest {

    @Test
    @DisplayName("Test: Create ParkingLot with all attributes")
    void createParkingLot_AllAttributes() {
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL001", "City Center Parking", "Downtown", "08:00", "20:00", 5.0);

        assertNotNull(parkingLot, "Should create a valid ParkingLot instance");
        assertEquals("PL001", parkingLot.getLotId(), "Lot ID should be PL001");
        assertEquals("City Center Parking", parkingLot.getTitle(), "Title should be City Center Parking");
        assertEquals("Downtown", parkingLot.getLocation(), "Location should be Downtown");
        assertEquals("08:00", parkingLot.getOpenTime(), "Opening time should be 08:00");
        assertEquals("20:00", parkingLot.getClosingTime(), "Closing time should be 20:00");
        assertEquals(5.0, parkingLot.getPricePerHour(), "Price per hour should be 5.0");
    }

    @Test
    @DisplayName("Test: Create ParkingLot without closing time")
    void createParkingLot_NoClosingTime() {
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL002", "Mall Parking", "Uptown", "09:00", 4.0);

        assertNotNull(parkingLot);
        assertEquals("PL002", parkingLot.getLotId());
        assertEquals("Mall Parking", parkingLot.getTitle());
        assertEquals("Uptown", parkingLot.getLocation());
        assertEquals("09:00", parkingLot.getOpenTime());
        assertNull(parkingLot.getClosingTime(), "Closing time should be null");
        assertEquals(4.0, parkingLot.getPricePerHour());
    }

    @Test
    @DisplayName("Test: Create ParkingLot without open and closing times")
    void createParkingLot_NoTimes() {
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL003", "Garage Parking", "Midtown", 3.5);

        assertNotNull(parkingLot);
        assertEquals("PL003", parkingLot.getLotId());
        assertEquals("Garage Parking", parkingLot.getTitle());
        assertEquals("Midtown", parkingLot.getLocation());
        assertNull(parkingLot.getOpenTime(), "Opening time should be null");
        assertNull(parkingLot.getClosingTime(), "Closing time should be null");
        assertEquals(3.5, parkingLot.getPricePerHour());
    }

    @Test
    @DisplayName("Test: Create ParkingLot without price per hour")
    void createParkingLot_NoPrice() {
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL004", "Suburb Parking", "Suburb", "07:00", "19:00");

        assertNotNull(parkingLot);
        assertEquals("PL004", parkingLot.getLotId());
        assertEquals("Suburb Parking", parkingLot.getTitle());
        assertEquals("Suburb", parkingLot.getLocation());
        assertEquals("07:00", parkingLot.getOpenTime());
        assertEquals("19:00", parkingLot.getClosingTime());
        assertEquals(0.0, parkingLot.getPricePerHour(), "Price per hour should default to 0.0");
    }

    @Test
    @DisplayName("Test: Create ParkingLot with only essential attributes")
    void createParkingLot_EssentialAttributesOnly() {
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("PL005", "Private Parking", "Industrial Area");

        assertNotNull(parkingLot);
        assertEquals("PL005", parkingLot.getLotId());
        assertEquals("Private Parking", parkingLot.getTitle());
        assertEquals("Industrial Area", parkingLot.getLocation());
        assertNull(parkingLot.getOpenTime());
        assertNull(parkingLot.getClosingTime());
        assertEquals(0.0, parkingLot.getPricePerHour(), "Price per hour should default to 0.0");
    }

    @Test
    @DisplayName("Test: Factory should return null for invalid input")
    void createParkingLot_InvalidInput() {
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot("", "", "", "", "", -1.0);
        assertNull(parkingLot, "Should return null for invalid input");
    }
}
