package lk.wecare.doctor.channel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import lk.wecare.doctor.channel.entity.Doctor;
import lk.wecare.doctor.channel.entity.DoctorCategory;
import lk.wecare.doctor.channel.repository.DoctorRepository;

class DoctorServiceTest {

  @Mock private DoctorRepository mockDoctorRepository;

  @InjectMocks private DoctorService doctorServiceUnderTest;

  @BeforeEach
  void setUp() {
    initMocks(this);
  }

  @Test
  void testSave() {
    // Setup
    final Doctor doctor = new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"));
    final Doctor expectedResult = new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"));

    // Configure DoctorRepository.save(...).
    final Doctor doctor1 = new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"));
    when(mockDoctorRepository.save(new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"))))
        .thenReturn(doctor1);

    // Run the test
    final Doctor result = doctorServiceUnderTest.save(doctor);

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testFindAll() {
    // Setup
    final List<Doctor> expectedResult =
        Arrays.asList(new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")));

    // Configure DoctorRepository.findAll(...).
    final List<Doctor> doctors =
        Arrays.asList(new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")));
    when(mockDoctorRepository.findAll()).thenReturn(doctors);

    // Run the test
    final List<Doctor> result = doctorServiceUnderTest.findAll();

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testDelete() {
    // Setup
    final Doctor expectedResult = new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"));

    // Configure DoctorRepository.getOne(...).
    final Doctor doctor = new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name"));
    when(mockDoctorRepository.getOne(0)).thenReturn(doctor);

    // Run the test
    final Doctor result = doctorServiceUnderTest.delete(0);

    // Verify the results
    assertEquals(expectedResult, result);
    verify(mockDoctorRepository)
        .delete(new Doctor(0, "name", "description", "qualification", new DoctorCategory(0, "name")));
  }
}
