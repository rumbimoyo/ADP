package service;

/*
test.service.ParkingLotServiceTest
ParkingLotServiceTest class
Author: Thulani Lunyawo(222828250)
Date: 17/03/2025
 */

import domain.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotServiceTest {

    private ParkingLotService parkingLotService;

    @BeforeEach
    void setUp() {
        parkingLotService = new ParkingLotService();
    }

    @Test
    @DisplayName("Testing saveParkingLot method")
    void saveParkingLot() {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL001")
                .setLocation("Downtown")
                .setOpenTime("08:00")
                .setClosingTime("20:00")
                .setPricePerHour(5.0)
                .build();

        boolean result = parkingLotService.saveParkingLot(parkingLot);
        assertTrue(result, "Parking lot should be saved successfully");

        result = parkingLotService.saveParkingLot(parkingLot);
        assertFalse(result, "Duplicate parking lot should not be saved");
    }

    @Test
    @DisplayName("Testing updateParkingLot method")
    void updateParkingLot() {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL002")
                .setLocation("Midtown")
                .setOpenTime("09:00")
                .setClosingTime("21:00")
                .setPricePerHour(4.5)
                .build();

        parkingLotService.saveParkingLot(parkingLot);

        ParkingLot updatedLot = new ParkingLot.Builder()
                .setLotId("PL002")
                .setLocation("Uptown")
                .setOpenTime("09:00")
                .setClosingTime("21:00")
                .setPricePerHour(6.0)
                .build();

        boolean result = parkingLotService.updateParkingLot(updatedLot);
        assertTrue(result, "Parking lot should be updated successfully");

        ParkingLot fetchedLot = parkingLotService.getParkingLotById("PL002");
        assertNotNull(fetchedLot);
        assertEquals("Uptown", fetchedLot.getLocation(), "Location should be updated");
        assertEquals(6.0, fetchedLot.getPricePerHour(), "Price per hour should be updated");
    }

    @Test
    @DisplayName("Testing deleteParkingLot method")
    void deleteParkingLot() {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL003")
                .setLocation("City Center")
                .setOpenTime("07:00")
                .setClosingTime("23:00")
                .setPricePerHour(7.0)
                .build();

        parkingLotService.saveParkingLot(parkingLot);
        boolean result = parkingLotService.deleteParkingLot("PL003");

        assertTrue(result, "Parking lot should be deleted successfully");
        assertNull(parkingLotService.getParkingLotById("PL003"), "Parking lot should no longer exist");
    }

    @Test
    @DisplayName("Testing getParkingLotById method")
    void getParkingLotById() {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .setLotId("PL004")
                .setLocation("Airport")
                .setOpenTime("06:00")
                .setClosingTime("22:00")
                .setPricePerHour(8.5)
                .build();

        parkingLotService.saveParkingLot(parkingLot);
        ParkingLot fetchedLot = parkingLotService.getParkingLotById("PL004");

        assertNotNull(fetchedLot, "Parking lot should be found");
        assertEquals("PL004", fetchedLot.getLotId(), "IDs should match");
    }

    @Test
    @DisplayName("Testing getAllParkingLots method")
    void getAllParkingLots() {
        ParkingLot parkingLot1 = new ParkingLot.Builder()
                .setLotId("PL005")
                .setLocation("Mall")
                .setOpenTime("10:00")
                .setClosingTime("22:00")
                .setPricePerHour(6.0)
                .build();

        ParkingLot parkingLot2 = new ParkingLot.Builder()
                .setLotId("PL006")
                .setLocation("Stadium")
                .setOpenTime("12:00")
                .setClosingTime("23:00")
                .setPricePerHour(4.0)
                .build();

        parkingLotService.saveParkingLot(parkingLot1);
        parkingLotService.saveParkingLot(parkingLot2);

        Set<ParkingLot> parkingLots = parkingLotService.getAllParkingLots();
        assertNotNull(parkingLots, "Parking lots set should not be null");
        assertTrue(parkingLots.size() >= 2, "At least two parking lots should be present");
    }
}
