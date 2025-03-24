////package service;
////
////public class ReservationServiceTest {
////}
//package service;
//
//import domain.ParkingSpot;
//import domain.Reservation;
//import domain.User;
//import factory.ParkingSpotFactory;
//import factory.ReservationFactory;
//import factory.UserFactory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import repository.ParkingSpotRepository;
//import repository.ReservationRepository;
//import repository.UserRepository;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ReservationServiceTest {
//
//    private ReservationService service;
//    private ReservationRepository reservationRepository;
//    private UserRepository userRepository;
//    private ParkingSpotRepository parkingSpotRepository;
//
//    private Reservation testReservation;
//    private User testUser;
//    private ParkingSpot testParkingSpot;
//
//    @BeforeEach
//    void setUp() {
//        // Get singleton instances
//        service = ReservationService.getService();
//        reservationRepository = ReservationRepository.getInstance();
//        userRepository = UserRepository.getInstance();
//        parkingSpotRepository = ParkingSpotRepository.getInstance();
//
//        // Clean repositories
//        for (Reservation r : reservationRepository.getAll()) {
//            reservationRepository.delete(r.getReservationID());
//        }
//
//        for (User u : userRepository.getAll()) {
//            userRepository.delete(u.getID());
//        }
//
//        for (ParkingSpot p : parkingSpotRepository.getAll()) {
//            parkingSpotRepository.delete(p.getSpotID());
//        }
//
//        // Create test objects
// //       testUser = UserFactory.createUser("John", "Doe", "john@example.com", "password123", "0123456789");
//        userRepository.create(testUser);
//
//        testParkingSpot = ParkingSpotFactory.createParkingSpot("A1", "Regular", "open", 10.0);
//        parkingSpotRepository.create(testParkingSpot);
//
////        testReservation = ReservationFactory.createReservation(
////                testUser,
////                null, // No vehicle for now
////                testParkingSpot,
////                new Date(), // Today's date
////                "09:00",
////                "11:00",
////                20.0
////        );
////    }
//
//    @Test
//    void create() {
//        // When
//        Reservation created = service.create(testReservation);
//
//        // Then
//        assertNotNull(created);
//        assertEquals(testReservation.getReservationID(), created.getReservationID());
//
//        // Check if parking spot status was updated
//        ParkingSpot spot = parkingSpotRepository.read(testParkingSpot.getSpotID());
//        assertEquals("reserved", spot.getStatus());
//
//        // Check if user's reservations were updated
//        User user = userRepository.read(testUser.getID());
//        assertTrue(user.getReservations().contains(created));
//    }
//
//    @Test
//    void createNullReservation() {
//        // When
//        Reservation created = service.create(null);
//
//        // Then
//        assertNull(created);
//    }
//
//    @Test
//    void read() {
//        // Given
//        Reservation created = service.create(testReservation);
//
//        // When
//        Reservation found = service.read(created.getReservationID());
//
//        // Then
//        assertNotNull(found);
//        assertEquals(created.getReservationID(), found.getReservationID());
//    }
//
//    @Test
//    void readNonExistent() {
//        // When
//        Reservation found = service.read("non-existent-id");
//
//        // Then
//        assertNull(found);
//    }
//
//    @Test
//    void update() {
//        // Given
//        Reservation created = service.create(testReservation);
//        String newStartTime = "10:00";
//        created.setStartTime(newStartTime);
//
//        // When
//        Reservation updated = service.update(created);
//
//        // Then
//        assertNotNull(updated);
//        assertEquals(newStartTime, updated.getStartTime());
//    }
//
//    @Test
//    void updateWithUserChange() {
//        // Given
//        Reservation created = service.create(testReservation);
////        User newUser = UserFactory.createUser("Jane", "Doe", "jane@example.com", "password456", "9876543210");
//        userRepository.create(newUser);
//
//        created.setUser(newUser);
//
//        // When
//        Reservation updated = service.update(created);
//
//        // Then
//        assertNotNull(updated);
//        assertEquals(newUser.getID(), updated.getUser().getID());
//
//        // Check old user doesn't have reservation
//        User oldUser = userRepository.read(testUser.getID());
//        assertFalse(oldUser.getReservations().contains(updated));
//
//        // Check new user has reservation
//        User updatedUser = userRepository.read(newUser.getID());
//        assertTrue(updatedUser.getReservations().contains(updated));
//    }
//
//    @Test
//    void updateWithParkingSpotChange() {
//        // Given
//        Reservation created = service.create(testReservation);
//        ParkingSpot newSpot = ParkingSpotFactory.createParkingSpot("B2", "Premium", "open", 15.0);
//        parkingSpotRepository.create(newSpot);
//
//        created.setParkingSpot(newSpot);
//
//        // When
//        Reservation updated = service.update(created);
//
//        // Then
//        assertNotNull(updated);
//        assertEquals(newSpot.getSpotID(), updated.getParkingSpot().getSpotID());
//
//        // Check old spot is now open
//        ParkingSpot oldSpot = parkingSpotRepository.read(testParkingSpot.getSpotID());
//        assertEquals("open", oldSpot.getStatus());
//
//        // Check new spot is now reserved
//        ParkingSpot updatedSpot = parkingSpotRepository.read(newSpot.getSpotID());
//        assertEquals("reserved", updatedSpot.getStatus());
//    }
//
//    @Test
//    void delete() {
//        // Given
//        Reservation created = service.create(testReservation);
//
//        // When
//        boolean deleted = service.delete(created.getReservationID());
//
//        // Then
//        assertTrue(deleted);
//        assertNull(service.read(created.getReservationID()));
//
//        // Check if parking spot status was updated
//        ParkingSpot spot = parkingSpotRepository.read(testParkingSpot.getSpotID());
//        assertEquals("open", spot.getStatus());
//
//        // Check if user's reservations were updated
//        User user = userRepository.read(testUser.getID());
//        assertFalse(user.getReservations().contains(created));
//    }
//
//    @Test
//    void deleteNonExistent() {
//        // When
//        boolean deleted = service.delete("non-existent-id");
//
//        // Then
//        assertFalse(deleted);
//    }
//
//    @Test
//    void getAll() {
//        // Given
//        service.create(testReservation);
//
//        // Create another reservation
//        Reservation anotherReservation = ReservationFactory.createReservation(
//                testUser,
//                null,
//                testParkingSpot,
//                new Date(),
//                "13:00",
//                "15:00",
//                20.0
//        );
//        service.create(anotherReservation);
//
//        // When
//        Set<Reservation> allReservations = service.getAll();
//
//        // Then
//        assertEquals(2, allReservations.size());
//    }
//
//    @Test
//    void getUserReservations() {
//        // Given
//        service.create(testReservation);
//
//        // When
//        Set<Reservation> userReservations = service.getUserReservations(testUser.getID());
//
//        // Then
//        assertEquals(1, userReservations.size());
//        assertTrue(userReservations.contains(testReservation));
//    }
//
//    @Test
//    void getParkingSpotReservations() {
//        // Given
//        service.create(testReservation);
//
//        // When
//        Set<Reservation> spotReservations = service.getParkingSpotReservations(testParkingSpot.getSpotID());
//
//        // Then
//        assertEquals(1, spotReservations.size());
//        assertTrue(spotReservations.contains(testReservation));
//    }
//
//    @Test
//    void isParkingSpotAvailable() {
//        // Given
//        service.create(testReservation);
//        String dateStr = testReservation.getDate().toString();
//
//        // Then - Non-overlapping time should be available
//        assertTrue(service.isParkingSpotAvailable(testParkingSpot.getSpotID(), dateStr, "12:00", "14:00"));
//
//        // Then - Overlapping time should not be available
//        assertFalse(service.isParkingSpotAvailable(testParkingSpot.getSpotID(), dateStr, "10:00", "12:00"));
//    }
//
//    @Test
//    void calculateReservationPrice() {
//        // When
//        double price = service.calculateReservationPrice("09:00", "11:00", 10.0);
//
//        // Then
//        assertEquals(20.0, price, 0.01);
//    }
//
//    @Test
//    void getReservationsForDate() {
//        // Given
//        service.create(testReservation);
//
//        // When
//        Set<Reservation> dateReservations = service.getReservationsForDate(testReservation.getDate());
//
//        // Then
//        assertEquals(1, dateReservations.size());
//        assertTrue(dateReservations.contains(testReservation));
//    }
//
//    @Test
//    void cancelReservation() {
//        // Given
//        Reservation created = service.create(testReservation);
//
//        // When
//        service.cancelReservation(created.getReservationID());
//
//        // Then
//        assertNull(service.read(created.getReservationID()));
//
//        // Check if parking spot status was updated
//        ParkingSpot spot = parkingSpotRepository.read(testParkingSpot.getSpotID());
//        assertEquals("open", spot.getStatus());
//    }
//}