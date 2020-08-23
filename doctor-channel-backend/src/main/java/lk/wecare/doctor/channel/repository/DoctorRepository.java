package lk.wecare.doctor.channel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.wecare.doctor.channel.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

  Doctor findDoctorById(Integer fkDoctor);
}
