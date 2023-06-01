package ma.emsi.patientsjpa.repositories;

import ma.emsi.patientsjpa.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    public List<Patient> findBySick(boolean s);
    Page<Patient> findBySick(boolean s, Pageable pageable);
    List<Patient> findBySickAndAgeLessThan(boolean m, int age);
    List<Patient> findBySickIsTrueAndAgeGreaterThan(int age);
    List<Patient> findByDateBetween(Date d1,Date d2);
    List<Patient> findByDateBetweenAndSickIsTrueOrNameLike(Date d1,Date d2,String name);

    @Query("select p from Patient p where p.name like :x and p.age<:a")
    List<Patient> findPatientByParams(@Param("x") String name, @Param("a") int ageMin);


}
