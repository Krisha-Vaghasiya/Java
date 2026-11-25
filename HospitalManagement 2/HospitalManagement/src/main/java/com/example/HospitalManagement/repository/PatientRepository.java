package com.example.HospitalManagement.repository;

import com.example.HospitalManagement.dto.PatientGroupByDto;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByBirthDateOrName(LocalDate birthDate, String name);

    List<Patient> findByBirthDateBetween(LocalDate birthDateAfter, LocalDate birthDateBefore);

    List<Patient> findByNameContainingOrderByIdDesc(String name);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("BloodGroupType") BloodGroupType bloodGroupType);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornDayAfter(@Param("birthDate") LocalDate birthDate);

    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
    List<Object[]> findByBloodGroupOrderBy();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Query("select p from Patient p")
    Page<Patient> findAllPatientsPage(Pageable pageable);

    @Query("select new com.example.HospitalManagement.dto.PatientGroupByDto(p.bloodGroup, Count(p)) from Patient p group by p.bloodGroup")
    List<PatientGroupByDto> findByBloodGroupOrderByProjection();

    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.Id = :id")
    int updatePatientNameById(@Param("name") String name, @Param("id") Long id);
}
