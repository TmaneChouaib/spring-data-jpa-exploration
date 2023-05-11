package ma.emsi.patientsjpa.repositories;

import ma.emsi.patientsjpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
