//package service;
//
//import domain.*;
//import org.junit.jupiter.api.*;
//import java.util.Date;
//import java.util.Set;
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class ReservationServiceTest {
//    private static ReservationService service;
//    private static User testUser;
//    private static Vehicle testVehicle;
//    private static ParkingSpot testParkingSpot;
//    private static Date testDate;
//
//    @BeforeAll
//    static void setup() {
//        service = ReservationService.getInstance();
//
//        // Initialize test data
//        testUser = new User.Builder()
//                .setUserID("USER-001")
//                .setName("John Doe")
//                .build();
//
//        testVehicle = new Vehicle.Builder()
//                .setLicensePlate("ABC123")
//                .build();
//
//        ParkingLot parkingLot = new ParkingLot.Builder()
//                .setLotId("LOT-001")
//                .build();
//
//        testParkingSpot = new ParkingSpot.Builder()
//                .setSpotNumber(101)
//                .setStatus("open")
//                .setParkingLot(parkingLot)
//                .build();
//
//        testDate = new Date();
//    }
//
//    @Test
//    @Order(1)
//    @DisplayName("Test Create and Retrieve Reservation")
//    void testCreateAndRetrieve() {
//        Reservation reservation = service.addReservation(
//                "RES-001", "09:00", "11:00", testDate,
//                20.0, testVehicle, testParkingSpot, testUser
//        );
//        assertNotNull(reservation);
//        assertEquals("RES-001", reservation.getReservationID());
//    }
//
//    @Test
//    @Order(2)
//    @DisplayName("Test Update Reservation")
//    void testUpdate() {
//        Reservation updatedReservation = new Reservation.Builder()
//                .setReservationID("RES-001")
//                .setStartTime("10:00")
//                .setEndTime("12:00")
//                .setLocalDate(testDate)
//                .setPrice(25.0)
//                .setVehicle(testVehicle)
//                .setParkingSpot(testParkingSpot)
//                .setUser(testUser)
//                .build();
//
//        Reservation result = service.editReservation(updatedReservation);
//        assertNotNull(result);
//        assertEquals("10:00", result.getStartTime());
//    }
//
//    @Test
//    @Order(3)
//    @DisplayName("Test Delete Reservation")
//    void testDelete() {
//        boolean isDeleted = service.deleteReservation("RES-001");
//        assertTrue(isDeleted);
//    }
//
//    @Test
//    @Order(4)
//    @DisplayName("Test View All Reservations")
//    void testViewAll() {
//        service.addReservation(
//                "RES-002", "14:00", "16:00", testDate,
//                30.0, testVehicle, testParkingSpot, testUser
//        );
//
//        Set<Reservation> allReservations = service.viewReservations();
//        assertFalse(allReservations.isEmpty());
//        assertEquals(1, allReservations.size());
//    }
//}