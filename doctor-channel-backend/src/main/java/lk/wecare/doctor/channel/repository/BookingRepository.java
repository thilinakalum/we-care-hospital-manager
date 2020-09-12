package lk.wecare.doctor.channel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.wecare.doctor.channel.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

  @Query(
      value =
          "SELECT booking.id, booking_no, booking.fk_doctor, booking.fk_session, booking.fk_customer  FROM booking \n"
              + "INNER JOIN doctor_session \n"
              + "ON booking.fk_session = doctor_session.id \n"
              + "WHERE doctor_session.session_date BETWEEN :startDate AND :endDate",
      nativeQuery = true)
  List<Object[]> getAppointmentsByDate(
      @Param("startDate") String startDate, @Param("endDate") String endDate);

  @Query(value = "SELECT MAX(booking_no)FROM booking", nativeQuery = true)
  Integer getMaximumNumber();
}
