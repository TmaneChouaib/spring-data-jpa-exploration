package ma.emsi.patientsjpa;

import ma.emsi.patientsjpa.entities.Patient;
import ma.emsi.patientsjpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientsJpaApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(PatientsJpaApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        /*
       for(int i=0 ; i < 10 ;i++){
            patientRepository.save(new Patient(null,"ching",40,new Date(),false));
        }
        */

        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println("************************************");
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getAge());
            System.out.println(p.getDate());
            System.out.println(p.isSick());
        });


        Page<Patient> patientPage = patientRepository.findAll(PageRequest.of(1,10));
        System.out.println("nbr of pages :"+patientPage.getTotalPages());
        System.out.println("nbr of elements :"+patientPage.getTotalElements());
        System.out.println("Num of current page :"+patientPage.getNumber());
        /*
        patientPage.forEach(p->{
            System.out.println("************************************");
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getAge());
            System.out.println(p.getDate());
            System.out.println(p.isSick());
        });
        */

        /*
        Page<Patient> bySick =patientRepository.findBySick(false,PageRequest.of(10,4));
        bySick.forEach(p->{
            System.out.println("************************************");
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getAge());
            System.out.println(p.getDate());
            System.out.println(p.isSick());
        });
        */

        /*
        List<Patient> patientL = patientRepository.findPatientByParams("%p%",30);
        patientL.forEach(p->{
            System.out.println("************************************");
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getAge());
            System.out.println(p.getDate());
            System.out.println(p.isSick());
        });
        */

        /*
        System.out.println("************************************");
        Patient patient= patientRepository.findById(4L).orElseThrow(() -> new RuntimeException("Patient not found"));
        if (patient != null){
            System.out.println(patient.getName());
            System.out.println(patient.isSick());
            System.out.println(patient.getAge());
        }
        */

        //patient.setAge(300);
        //patientRepository.save(patient);

        //patientRepository.deleteById(2L);


    }
}
