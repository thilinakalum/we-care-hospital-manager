package lk.wecare.doctor.channel.service;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.wecare.doctor.channel.entity.Booking;
import lk.wecare.doctor.channel.entity.Customer;
import lk.wecare.doctor.channel.entity.Doctor;
import lk.wecare.doctor.channel.entity.DoctorSession;
import lk.wecare.doctor.channel.model.BookingDetailModel;
import lk.wecare.doctor.channel.repository.BookingRepository;
import lk.wecare.doctor.channel.repository.CustomerRepository;
import lk.wecare.doctor.channel.repository.DoctorRepository;
import lk.wecare.doctor.channel.repository.DoctorSessionRepository;

@Service
@Transactional
public class BookingService {

  @Autowired private BookingRepository bookingRepository;

  @Autowired private CustomerRepository customerRepository;

  @Autowired private DoctorRepository doctorRepository;

  @Autowired private DoctorSessionRepository doctorSessionRepository;

  private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public List<BookingDetailModel> getAllBookingDetails() {
    List<BookingDetailModel> list = new ArrayList<>();
    try {

      List<Booking> bookingList = bookingRepository.findAll();
      if (bookingList != null && !bookingList.isEmpty()) {
        for (Booking booking : bookingList) {
          BookingDetailModel bookingDetailModel = new BookingDetailModel();

          bookingDetailModel.setBookingId(booking.getId());
          bookingDetailModel.setBookingNumber(booking.getBookingNo());

          int customerId = 0;
          Customer customer = booking.getFkCustomer();
          if (customer != null) {
            customerId = customer.getId();
            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
            Customer customer1 = optionalCustomer.get();
            bookingDetailModel.setCustomerName(customer1.getFname() + " " + customer1.getLname());
          }

          int doctorId = 0;
          Doctor doctor = booking.getFkDoctor();
          if (doctor != null) {
            doctorId = doctor.getId();
            Doctor doctor1 = doctorRepository.findDoctorById(doctorId);
            bookingDetailModel.setDoctorName(doctor1.getName());
          }

          int doctorSessionId = 0;
          DoctorSession fkSession = booking.getFkSession();
          if (fkSession != null) {
            doctorSessionId = fkSession.getId();
            DoctorSession doctorSession =
                doctorSessionRepository.findDoctorSessionById(doctorSessionId);
            Date sessionDate = doctorSession.getSessionDate();
            bookingDetailModel.setSessionDate(simpleDateFormat.format(sessionDate));
            bookingDetailModel.setStartTime(doctorSession.getStartTime());
            bookingDetailModel.setEndTime(doctorSession.getEndTime());
          }

          list.add(bookingDetailModel);
        }
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return list;
  }

  public List<BookingDetailModel> getAppointmentsByDate(String startDate, String endDate) {
    List<BookingDetailModel> list = new ArrayList<>();
    try {

      List<Object[]> bookingList = bookingRepository.getAppointmentsByDate(startDate, endDate);

      if (!bookingList.isEmpty()) {

        for (Object[] object : bookingList) {
          BookingDetailModel bookingDetailModel = new BookingDetailModel();

          bookingDetailModel.setBookingId(Integer.parseInt(String.valueOf(object[0])));
          bookingDetailModel.setBookingNumber(Integer.parseInt(String.valueOf(object[1])));

          Doctor doctor1 =
              doctorRepository.findDoctorById(Integer.parseInt(String.valueOf(object[2])));
          bookingDetailModel.setDoctorName(doctor1.getName());

          DoctorSession doctorSession =
              doctorSessionRepository.findDoctorSessionById(
                  Integer.parseInt(String.valueOf(object[3])));
          Date sessionDate = doctorSession.getSessionDate();
          bookingDetailModel.setSessionDate(simpleDateFormat.format(sessionDate));
          bookingDetailModel.setStartTime(doctorSession.getStartTime());
          bookingDetailModel.setEndTime(doctorSession.getEndTime());

          Optional<Customer> optionalCustomer =
              customerRepository.findById(Integer.parseInt(String.valueOf(object[4])));
          Customer customer1 = optionalCustomer.get();
          bookingDetailModel.setCustomerName(customer1.getFname() + " " + customer1.getLname());

          list.add(bookingDetailModel);
        }
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return list;
  }
}
