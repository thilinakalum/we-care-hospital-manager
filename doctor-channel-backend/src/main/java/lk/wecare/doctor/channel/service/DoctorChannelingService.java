package lk.wecare.doctor.channel.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lk.wecare.doctor.channel.entity.Booking;
import lk.wecare.doctor.channel.entity.Customer;
import lk.wecare.doctor.channel.entity.Doctor;
import lk.wecare.doctor.channel.entity.DoctorCategory;
import lk.wecare.doctor.channel.entity.DoctorSession;
import lk.wecare.doctor.channel.repository.BookingRepository;
import lk.wecare.doctor.channel.repository.CustomerRepository;
import lk.wecare.doctor.channel.repository.DoctorCategoryRepository;
import lk.wecare.doctor.channel.repository.DoctorRepository;
import lk.wecare.doctor.channel.repository.DoctorSessionRepository;

@Service
@Transactional
public class DoctorChannelingService {

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private DoctorCategoryRepository doctorCategoryRepository;

  @Autowired
  private DoctorSessionRepository doctorSessionRepository;

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private CustomerRepository customerRepository;

  public List<Doctor> findAllDoctolers() {
    return doctorRepository.findAll();
  }

  public List<DoctorCategory> findAllDoctorCategory() {
    return doctorCategoryRepository.findAll();
  }

  public List<DoctorSession> findByDoctorAndDate(Integer doctor, String date) {
    if (date != null && doctor != null) {
      return doctorSessionRepository.findByDoctorAndDate(doctor, date);
    }
    if (date != null) {
      return doctorSessionRepository.findByDate(date);
    }
    if (doctor != null) {
      return doctorSessionRepository.findByDoctor(doctor);
    }
    return doctorSessionRepository.findDoctorSessions();
  }

  public DoctorSession findSessionDetails(Integer id) {
    DoctorSession doctorSessionById = doctorSessionRepository.findDoctorSessionById(id);
    return doctorSessionById;
  }

  public Booking saveBooking(Booking booking) {
    Customer saveCustomer = customerRepository.save(booking.getFkCustomer());
    booking.setCreatedDateTime(new java.sql.Date(new Date().getTime()));
    Integer lastBookingNo = bookingRepository.getMaximumNumber();
    booking.setBookingNo(lastBookingNo + 1);
    booking.setFkCustomer(saveCustomer);

    String message = "";
    message =
        message + booking.getFkCustomer().getTitle() + " " + booking.getFkCustomer().getFname()
            + " " + booking.getFkCustomer().getLname() + "\n";
    message = message + "Your appointment to " + "\n";
    message = message + booking.getFkDoctor().getName() + "\n";
    message = message + "has been confirmed" + "\n";
    message = message + "Appointment number - " + booking.getBookingNo() + "\n";
    message =
        message + "Appointment Date" + " " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())
            + "\n";
    message =
        message + "Appointment Time" + " " + new SimpleDateFormat("hh:mm a").format(new Date())
            + "\n";
    message = message + "\n";
    message = message + "- We Care." + "\n";
    String uri =
        "http://supervision-sms.supervisionglobal.com/send_sms.php?api_key=9963327589&number=94"
            + booking.getFkCustomer().getMobile() + "&message=" + message;
    System.out.println("MESSAGE " + uri);
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);
    if ("0".equals(result)) {
      System.out.println("SENT");
    } else {
      System.out.println("ERROR");
    }

    return bookingRepository.save(booking);
  }
}
