package lk.wecare.doctor.channel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Autowired private DoctorRepository doctorRepository;

  @Autowired private DoctorCategoryRepository doctorCategoryRepository;

  @Autowired private DoctorSessionRepository doctorSessionRepository;

  @Autowired private BookingRepository bookingRepository;

  @Autowired private CustomerRepository customerRepository;

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
    booking.setFkCustomer(saveCustomer);
    return bookingRepository.save(booking);
  }
}
