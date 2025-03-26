//package service;
//
///*
//service.ParkingLotServiceTest
//ParkingLotServiceTest class
//Author: Thulani Lunyawo (222828250)
//Date: 17/03/2025
// */
//
//import domain.ParkingLot;
//import org.junit.jupiter.api.*;
//import repository.ParkingLotRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class ParkingLotServiceTest {
//
//    private static ParkingLotService parkingLotService;
//    private static ParkingLot parkingLot;
//
//    @BeforeAll
//    static void setup() {
//        parkingLotService = new ParkingLotService();
//    }
//
//    @Test
//    @Order(1)
//    @DisplayName("Testing save and findById method")
//    void testSaveAndFindById() {
//        parkingLot = new ParkingLot.Builder()
//                .setLotId("PL001")
//                .setTitle("City Center Parking")
//                .setLocation("Downtown")
//                .setOpenTime("08:00")
//                .setClosingTime("20:00")
//                .setPricePerHour(5.0)
//                .build();
//
//        parkingLotService.addParkingLot(parkingLot);
//        ParkingLot foundLot = parkingLotService.findParkingLot("PL001");
//
//        assertNotNull(foundLot, "Parking lot should not be null");
//        assertEquals("PL001", foundLot.getLotId(), "Lot ID should match");
//        assertEquals("City Center Parking", foundLot.getTitle(), "Title should match");
//        assertEquals("Downtown", foundLot.getLocation(), "Location should match");
//    }
//
//    @Test
//    @Order(2)
//    @DisplayName("Testing update method")
//    void testUpdate() {
//        ParkingLot updatedParkingLot = new ParkingLot.Builder()
//                .setLotId("PL001")
//                .setTitle("Uptown Parking")
//                .setLocation("Uptown")
//                .setOpenTime("08:00")
//                .setClosingTime("20:00")
//                .setPricePerHour(6.0)
//                .build();
//
//        parkingLotService.editParkingLot(updatedParkingLot);
//        ParkingLot updatedLot = parkingLotService.findParkingLot("PL001");
//
//        assertNotNull(updatedLot, "Updated parking lot should not be null");
//        assertEquals("Uptown Parking", updatedLot.getTitle(), "Title should be updated to Uptown Parking");
//        assertEquals("Uptown", updatedLot.getLocation(), "Location should be updated to Uptown");
//        assertEquals(6.0, updatedLot.getPricePerHour(), "Price per hour should be updated to 6.0");
//    }
//
//    @Test
//    @Order(3)
//    @DisplayName("Testing delete method")
//    void testDelete() {
//        parkingLotService.deleteParkingLot("PL001");
//        ParkingLot foundLot = parkingLotService.findParkingLot("PL001");
//        assertNull(foundLot, "Parking lot should be null after deletion");
//    }
//}