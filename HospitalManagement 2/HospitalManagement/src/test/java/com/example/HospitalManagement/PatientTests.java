package com.example.HospitalManagement;

import com.example.HospitalManagement.dto.PatientGroupByDto;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.entity.type.BloodGroupType;
import com.example.HospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
//        Patient patient = patientRepository.findByName("Vishal");
//        System.out.println(patient);

//        List<Patient> patientList = patientRepository.findByBirthDateOrName(LocalDate.of(1990,5,23),"Raj");
//        for(Patient p: patientList){
//            System.out.println(p);
//        }

//        List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("a");
//        for(Patient p: patientList){
//            System.out.println(p);
//        }

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.O_POSITIVE);
//        for(Patient p: patientList){
//            System.out.println(p);
//        }

//        List<Patient> patientList = patientRepository.findByBornDayAfter(LocalDate.of(1991,5,23));
//        for(Patient p: patientList){
//            System.out.println(p);
//        }

//        List<Object[]> patientList = patientRepository.findByBloodGroupOrderBy();
//        for(Object[] p: patientList){
//            System.out.println(p[0] + ":" + p[1]);
//        }

//        List<Patient> patientList = patientRepository.findAllPatients();
//        for(Patient p: patientList){
//            System.out.println(p);
//        }

//        Page<Patient> patients =patientRepository.findAllPatientsPage(PageRequest.of(1,2));
//
//        for (Patient p: patients){
//            System.out.println(p);
//        }

//        List<PatientGroupByDto> patientGroupByDtos= patientRepository.findByBloodGroupOrderByProjection();
//        for (PatientGroupByDto p: patientGroupByDtos){
//            System.out.println(p);
//        }

        int update = patientRepository.updatePatientNameById("Vishal Desai", 1L);
        System.out.println("Update Status: " + update);

    }
}
