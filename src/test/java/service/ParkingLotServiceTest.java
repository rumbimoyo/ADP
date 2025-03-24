package service;

/*
service.ParkingLotServiceTest
ParkingLotServiceTest class
Author: Thulani Lunyawo(222828250)
Date: 17/03/2025
 */

import domain.ParkingLot;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ParkingLotServiceTest {

    ParkingLotService parkingLotService = new ParkingLotService();

    @Test
    @DisplayName("Testing save and findById method")
    public void a_testSaveAndFindById() {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setTitle("City Center Parking")
                .setLocation("Downtown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(5.0)
                .build();

        parkingLotService.saveParkingLot(parkingLot);
        ParkingLot foundLot = parkingLotService.getParkingLotById("PL001");

        assertNotNull(foundLot, "Parking lot should not be null");
        assertEquals("PL001", foundLot.getLotId(), "Lot ID should match");
        assertEquals("City Center Parking", foundLot.getTitle(), "Title should match");
        assertEquals("Downtown", foundLot.getLocation(), "Location should match");
    }

    @Test
    @DisplayName("Testing delete method")
    public void c_testDelete() {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setTitle("City Center Parking")
                .setLocation("Downtown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(5.0)
                .build();

        parkingLotService.saveParkingLot(parkingLot);
        parkingLotService.deleteParkingLot("PL001");

        ParkingLot foundLot = parkingLotService.getParkingLotById("PL001");
        assertNull(foundLot, "Parking lot should be null after deletion");
    }

    @Test
    @DisplayName("Testing update method")
    public void b_testUpdate() {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setTitle("City Center Parking")
                .setLocation("Downtown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(5.0)
                .build();

        parkingLotService.saveParkingLot(parkingLot);

        parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setTitle("Uptown Parking")
                .setLocation("Uptown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(6.0)
                .build();

        parkingLotService.updateParkingLot(parkingLot);
        ParkingLot updatedLot = parkingLotService.getParkingLotById("PL001");

        assertNotNull(updatedLot, "Updated parking lot should not be null");
        assertEquals("Uptown Parking", updatedLot.getTitle(), "Title should be updated to Uptown Parking");
        assertEquals("Uptown", updatedLot.getLocation(), "Location should be updated to Uptown");
        assertEquals(6.0, updatedLot.getPricePerHour(), "Price per hour should be updated to 6.0");
    }
}
