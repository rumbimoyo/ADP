package factory;

/*
test.factory.ParkingLotFactoryTest
ParkingLotFactoryTest class
Author: Thulani Lunyawo (222828250)
Date: 18/03/2025
 */

import domain.ParkingLot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotFactoryTest {

    private ParkingLot parkingLot;

    @Test
    @DisplayName("ParkingLotFactory test for creating ParkingLot")
    void createParkingLotFactory() {
        parkingLot = ParkingLotFactory.createParkingLot("PL001", "City Center Parking", "Downtown", "08:00", "20:00", 5.0);

        assertNotNull(parkingLot, "Should be an object of ParkingLot class");
        assertInstanceOf(ParkingLot.class, parkingLot, "Should be an instance of ParkingLot class");

        assertEquals("PL001", parkingLot.getLotId(), "Should be PL001");
        assertEquals("City Center Parking", parkingLot.getTitle(), "Title should be City Center Parking");
        assertEquals("Downtown", parkingLot.getLocation(), "Should be Downtown");
        assertEquals(5.0, parkingLot.getPricePerHour(), "Should be 5.0 per hour");
    }

}
