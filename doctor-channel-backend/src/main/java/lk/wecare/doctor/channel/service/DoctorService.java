package lk.wecare.doctor.channel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import lk.wecare.doctor.channel.entity.Doctor;
import lk.wecare.doctor.channel.entity.DoctorSession;
import lk.wecare.doctor.channel.repository.DoctorRepository;
import lk.wecare.doctor.channel.repository.DoctorSessionRepository;

@Service
@Transactional
public class DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private DoctorSessionRepository doctorSessionRepository;

  public Doctor save(Doctor doctor) {
    return doctorRepository.save(doctor);
  }

  public List<Doctor> findAll() {
    return doctorRepository.findAll();
  }

  public Doctor delete(Integer id) {
    Doctor oneDoctor = doctorRepository.getOne(id);
    doctorRepository.delete(oneDoctor);
    return oneDoctor;
  }

  public List<DoctorSession> findAllDoctorSessions() {
    return doctorSessionRepository.findAll();
  }

  public DoctorSession saveDoctorSession(DoctorSession doctorSession) {
    doctorSession.setAvailaility(1);
    return doctorSessionRepository.save(doctorSession);
  }

  public DoctorSession deleteDoctorSession(Integer id) {
    DoctorSession oneDoctor = doctorSessionRepository.getOne(id);
    doctorSessionRepository.delete(oneDoctor);
    return oneDoctor;
  }
}
