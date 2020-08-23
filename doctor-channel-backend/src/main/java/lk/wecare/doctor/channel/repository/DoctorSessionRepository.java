package lk.wecare.doctor.channel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.wecare.doctor.channel.entity.DoctorSession;

@Repository
public interface DoctorSessionRepository extends JpaRepository<DoctorSession, Integer> {

  @Query(
      value = "SELECT * FROM doctor_session WHERE DATE(doctor_session.session_date) >= DATE(NOW())",
      nativeQuery = true)
  List<DoctorSession> findDoctorSessions();

  @Query(
      value = "SELECT * FROM doctor_session WHERE DATE(doctor_session.session_date) = :sessionDate",
      nativeQuery = true)
  public List<DoctorSession> findByDate(@Param("sessionDate") String sessionDate);

  //
  @Query(
      value =
          "SELECT * FROM doctor_session WHERE doctor_session.fk_doctor = :doctor AND DATE(doctor_session.session_date) >= DATE(NOW())",
      nativeQuery = true)
  public List<DoctorSession> findByDoctor(@Param("doctor") Integer doctor);

  @Query(
      value =
          "SELECT * FROM doctor_session WHERE (doctor_session.fk_doctor = :doctor) AND (DATE(doctor_session.session_date) = :sessionDate)",
      nativeQuery = true)
  public List<DoctorSession> findByDoctorAndDate(
      @Param("doctor") Integer doctor, @Param("sessionDate") String sessionDate);

  DoctorSession findDoctorSessionById(Integer id);
}
