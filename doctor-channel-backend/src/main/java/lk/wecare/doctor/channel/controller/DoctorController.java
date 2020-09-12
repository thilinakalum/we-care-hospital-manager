package lk.wecare.doctor.channel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.wecare.doctor.channel.entity.Doctor;
import lk.wecare.doctor.channel.entity.DoctorSession;
import lk.wecare.doctor.channel.service.DoctorService;

@RestController
@CrossOrigin
@RequestMapping("/api/doctor")
public class DoctorController {

  @Autowired
  private DoctorService doctorService;

  @PostMapping("/save")
  public Doctor save(@RequestBody Doctor doctor) {
    return doctorService.save(doctor);
  }

  @GetMapping("/find-all")
  public List<Doctor> findAll() {
    return doctorService.findAll();
  }

  @DeleteMapping("/delete/{id}")
  public Doctor delete(@PathVariable Integer id) {
    return doctorService.delete(id);
  }

  @GetMapping("/find-all-doctor-sessions")
  public List<DoctorSession> findAllDoctorSessions() {
    return doctorService.findAllDoctorSessions();
  }

  @PostMapping("/save-doctor-sessions")
  public DoctorSession saveDoctorSession(@RequestBody DoctorSession doctorSession) {
    return doctorService.saveDoctorSession(doctorSession);
  }

  @DeleteMapping("/delete-doctor-sessions/{id}")
  public DoctorSession deleteDoctorSession(@PathVariable Integer id) {
    return doctorService.deleteDoctorSession(id);
  }

}
