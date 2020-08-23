package lk.wecare.doctor.channel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.wecare.doctor.channel.entity.Doctor;
import lk.wecare.doctor.channel.repository.DoctorRepository;

@Service
@Transactional
public class DoctorService {

  @Autowired private DoctorRepository doctorRepository;

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
}
