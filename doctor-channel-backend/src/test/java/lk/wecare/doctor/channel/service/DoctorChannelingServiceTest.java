//package lk.wecare.doctor.channel.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//import java.sql.Date;
//import java.sql.Time;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import lk.wecare.doctor.channel.entity.Booking;
//import lk.wecare.doctor.channel.entity.Customer;
//import lk.wecare.doctor.channel.entity.Doctor;
//import lk.wecare.doctor.channel.entity.DoctorCategory;
//import lk.wecare.doctor.channel.entity.DoctorSession;
//import lk.wecare.doctor.channel.repository.BookingRepository;
//import lk.wecare.doctor.channel.repository.CustomerRepository;
//import lk.wecare.doctor.channel.repository.DoctorCategoryRepository;
//import lk.wecare.doctor.channel.repository.DoctorRepository;
//import lk.wecare.doctor.channel.repository.DoctorSessionRepository;
//
//class DoctorChannelingServiceTest {
//
//  @Mock private DoctorRepository mockDoctorRepository;
//  @Mock private DoctorCategoryRepository mockDoctorCategoryRepository;
//  @Mock private DoctorSessionRepository mockDoctorSessionRepository;
//  @Mock private BookingRepository mockBookingRepository;
//  @Mock private CustomerRepository mockCustomerRepository;
//
//  @InjectMocks private DoctorChannelingService doctorChannelingServiceUnderTest;
//
//  @BeforeEach
//  void setUp() {
//    initMocks(this);
//  }
//
//  @Test
//  void testFindAllDoctolers() {
//    // Setup
//    final List<Doctor> expectedResult =
//        Arrays.asList(new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")));
//
//    // Configure DoctorRepository.findAll(...).
//    final List<Doctor> doctors =
//        Arrays.asList(new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")));
//    when(mockDoctorRepository.findAll()).thenReturn(doctors);
//
//    // Run the test
//    final List<Doctor> result = doctorChannelingServiceUnderTest.findAllDoctolers();
//
//    // Verify the results
//    assertEquals(expectedResult, result);
//  }
//
//  @Test
//  void testFindAllDoctorCategory() {
//    // Setup
//    final List<DoctorCategory> expectedResult = Arrays.asList(new DoctorCategory(0, "name"));
//
//    // Configure DoctorCategoryRepository.findAll(...).
//    final List<DoctorCategory> doctorCategories = Arrays.asList(new DoctorCategory(0, "name"));
//    when(mockDoctorCategoryRepository.findAll()).thenReturn(doctorCategories);
//
//    // Run the test
//    final List<DoctorCategory> result = doctorChannelingServiceUnderTest.findAllDoctorCategory();
//
//    // Verify the results
//    assertEquals(expectedResult, result);
//  }
//
//  @Test
//  void testFindByDoctorAndDate() {
//    // Setup
//    final List<DoctorSession> expectedResult = Collections.emptyList();
//
//    // Configure DoctorSessionRepository.findByDoctorAndDate(...).
//    final List<DoctorSession> doctorSessions =
//        Arrays.asList(
//            new DoctorSession(0, new Date(0L), new Time(0L), new Time(0L), 0, (short) 0,
//                new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"))));
//    when(mockDoctorSessionRepository.findByDoctorAndDate(0, "sessionDate"))
//        .thenReturn(doctorSessions);
//
//    // Configure DoctorSessionRepository.findByDate(...).
//    final List<DoctorSession> doctorSessions1 =
//        Arrays.asList(
//            new DoctorSession(0, new Date(0L), new Time(0L), new Time(0L), 0, (short) 0,
//                new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"))));
//    when(mockDoctorSessionRepository.findByDate("sessionDate")).thenReturn(doctorSessions1);
//
//    // Configure DoctorSessionRepository.findByDoctor(...).
//    final List<DoctorSession> doctorSessions2 =
//        Arrays.asList(
//            new DoctorSession(0, new Date(0L), new Time(0L), new Time(0L), 0, (short) 0,
//                new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"))));
//    when(mockDoctorSessionRepository.findByDoctor(0)).thenReturn(doctorSessions2);
//
//    // Configure DoctorSessionRepository.findDoctorSessions(...).
//    final List<DoctorSession> doctorSessions3 =
//        Arrays.asList(
//            new DoctorSession(0, new Date(0L), new Time(0L), new Time(0L),
//                0, (short) 0, new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"))));
//    when(mockDoctorSessionRepository.findDoctorSessions()).thenReturn(doctorSessions3);
//
//    // Run the test
//    final List<DoctorSession> result =
//        doctorChannelingServiceUnderTest.findByDoctorAndDate(0, "date");
//
//    // Verify the results
//    assertEquals(expectedResult, result);
//  }
//
//  @Test
//  void testFindSessionDetails() {
//    // Setup
//    final DoctorSession expectedResult =
//        new DoctorSession(
//            0,
//            new Date(0L),
//            new Time(0L),
//            new Time(0L),
//            0,
//            (short) 0,
//            new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")));
//
//    // Configure DoctorSessionRepository.findDoctorSessionById(...).
//    final DoctorSession doctorSession =
//        new DoctorSession(
//            0,
//            new Date(0L),
//            new Time(0L),
//            new Time(0L),
//            0,
//            (short) 0,
//            new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")));
//    when(mockDoctorSessionRepository.findDoctorSessionById(0)).thenReturn(doctorSession);
//
//    // Run the test
//    final DoctorSession result = doctorChannelingServiceUnderTest.findSessionDetails(0);
//
//    // Verify the results
//    assertEquals(expectedResult, result);
//  }
//
//  @Test
//  void testSaveBooking() {
//    // Setup
//    final Booking booking =
//        new Booking(
//            0,
//            0,
//            new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")),
//            new DoctorSession(
//                0,
//                new Date(0L),
//                new Time(0L),
//                new Time(0L),
//                0,
//                (short) 0,
//                new Doctor(
//                    0, "name", "description", "qualification", new DoctorCategory(0, "name"))),
//            new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L)),
//            new Date(0L));
//    final Booking expectedResult =
//        new Booking(
//            0,
//            0,
//            new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")),
//            new DoctorSession(
//                0,
//                new Date(0L),
//                new Time(0L),
//                new Time(0L),
//                0,
//                (short) 0,
//                new Doctor(
//                    0, "name", "description", "qualification", new DoctorCategory(0, "name"))),
//            new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L)),
//            new Date(0L));
//
//    // Configure CustomerRepository.save(...).
//    final Customer customer =
//        new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L));
//    when(mockCustomerRepository.save(
//            new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L))))
//        .thenReturn(customer);
//
//    // Configure BookingRepository.save(...).
//    final Booking booking1 =
//        new Booking(
//            0,
//            0,
//            new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")),
//            new DoctorSession(
//                0,
//                new Date(0L),
//                new Time(0L),
//                new Time(0L),
//                0,
//                (short) 0,
//                new Doctor(
//                    0, "name", "description", "qualification", new DoctorCategory(0, "name"))),
//            new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L)),
//            new Date(0L));
//    when(mockBookingRepository.save(
//            new Booking(
//                0,
//                0,
//                new Doctor(
//                    0, "name", "description", "qualification", new DoctorCategory(0, "name")),
//                new DoctorSession(
//                    0,
//                    new Date(0L),
//                    new Time(0L),
//                    new Time(0L),
//                    0,
//                    (short) 0,
//                    new Doctor(
//                        0, "name", "description", "qualification", new DoctorCategory(0, "name"))),
//                new Customer(
//                    0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L)),
//                new Date(0L))))
//        .thenReturn(booking1);
//
//    // Run the test
//    final Booking result = doctorChannelingServiceUnderTest.saveBooking(booking);
//
//    // Verify the results
//    assertEquals(expectedResult, result);
//  }
//}
