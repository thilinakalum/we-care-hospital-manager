package lk.wecare.doctor.channel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.wecare.doctor.channel.entity.DoctorCategory;

@Repository
public interface DoctorCategoryRepository extends JpaRepository<DoctorCategory, Integer> {}
