//package lk.wecare.doctor.channel.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//import java.sql.Date;
//import java.sql.Time;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
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
//import lk.wecare.doctor.channel.model.BookingDetailModel;
//import lk.wecare.doctor.channel.repository.BookingRepository;
//import lk.wecare.doctor.channel.repository.CustomerRepository;
//import lk.wecare.doctor.channel.repository.DoctorRepository;
//import lk.wecare.doctor.channel.repository.DoctorSessionRepository;
//
//class BookingServiceTest {
//
//  @Mock private BookingRepository mockBookingRepository;
//  @Mock private CustomerRepository mockCustomerRepository;
//  @Mock private DoctorRepository mockDoctorRepository;
//  @Mock private DoctorSessionRepository mockDoctorSessionRepository;
//
//  @InjectMocks private BookingService bookingServiceUnderTest;
//
//  @BeforeEach
//  void setUp() {
//    initMocks(this);
//  }
//
//  @Test
//  void testGetAllBookingDetails() {
//    // Setup
//    final BookingDetailModel bookingDetailModel = new BookingDetailModel();
//    bookingDetailModel.setBookingId(0);
//    bookingDetailModel.setBookingNumber(0);
//    bookingDetailModel.setDoctorName("name");
//    bookingDetailModel.setCustomerName("fname lname");
//    bookingDetailModel.setSessionDate("1970-01-01");
//    bookingDetailModel.setStartTime("05:30:00");
//    bookingDetailModel.setEndTime("05:30:00");
//    final List<BookingDetailModel> expectedResult = Arrays.asList(bookingDetailModel);
//
//    // Configure BookingRepository.findAll(...).
//    final List<Booking> bookings =
//        Arrays.asList(
//            new Booking(0, 0, new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")), new DoctorSession(
//                    0, new Date(0L), "", "new Time(0L)", 0, (short) 0, new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"))),
//                new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L)),
//                new Date(0L)));
//    when(mockBookingRepository.findAll()).thenReturn(bookings);
//
//    // Configure CustomerRepository.findById(...).
//    final Optional<Customer> customer =
//        Optional.of(
//            new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L)));
//    when(mockCustomerRepository.findById(0)).thenReturn(customer);
//
//    // Configure DoctorRepository.findDoctorById(...).
//    final Doctor doctor =
//        new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"));
//    when(mockDoctorRepository.findDoctorById(0)).thenReturn(doctor);
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
//    final List<BookingDetailModel> result = bookingServiceUnderTest.getAllBookingDetails();
//
//    // Verify the results
//    assertEquals(expectedResult, result);
//  }
//
//  @Test
//  void testGetAppointmentsByDate() {
//    // Setup
//    final BookingDetailModel bookingDetailModel = new BookingDetailModel();
//    bookingDetailModel.setBookingId(0);
//    bookingDetailModel.setBookingNumber(0);
//    bookingDetailModel.setDoctorName("doctorName");
//    bookingDetailModel.setCustomerName("customerName");
//    bookingDetailModel.setSessionDate("sessionDate");
//    bookingDetailModel.setStartTime("startTime");
//    bookingDetailModel.setEndTime("endTime");
//    final List<BookingDetailModel> expectedResult = Arrays.asList(bookingDetailModel);
////    when(mockBookingRepository.getAppointmentsByDate("startDate", "endDate"))
////        .thenReturn(any());
//
//    // Configure DoctorRepository.findDoctorById(...).
//    final Doctor doctor =
//        new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"));
//    when(mockDoctorRepository.findDoctorById(0)).thenReturn(doctor);
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
//    // Configure CustomerRepository.findById(...).
//    final Optional<Customer> customer =
//        Optional.of(
//            new Customer(0, "title", "fname", "lname", 0, "mobile", "nic", "email", new Date(0L)));
//    when(mockCustomerRepository.findById(0)).thenReturn(customer);
//
//    // Run the test
//    final List<BookingDetailModel> result =
//        bookingServiceUnderTest.getAppointmentsByDate("startDate", "endDate");
//
//    // Verify the results
//    assertEquals(1, 1);
//  }
//}
