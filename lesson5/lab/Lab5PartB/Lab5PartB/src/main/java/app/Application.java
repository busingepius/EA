package app;

import domain.Patient;
import domain.Appointment;
import domain.Doctor;
import domain.Payment;

import repositories.AppointmentRepository;
import repositories.DoctorRepository;
import repositories.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Create a doctor
        Doctor doctor1 = new Doctor("Chirurg", "Frank", "Brown");
        Doctor doctor2 = new Doctor("Nurse", "Mary", "Jones");
        Doctor doctor3 = new Doctor("Dentist", "John", "Smith");
        Doctor doctor4 = new Doctor("Surgeon", "Sam", "White");

        // Create a payment
        Payment payment1 = new Payment("10-10-2008", 12.50);
        Payment payment2 = new Payment("11-10-2008", 45.00);
        Payment payment3 = new Payment("12-10-2008", 99.60);
        Payment payment4 = new Payment("13-10-2008", 55.80);

        // Create a patient
        Patient patient1 = new Patient("Jerry Lewis", "34 4th avenue", "13221", "New York");
        Patient patient2 = new Patient("Frank Moore", "34 Mainstret", "13221", "New York");
        Patient patient3 = new Patient("Sam ruby", "105 N Street", "13221", "New York");
        Patient patient4 = new Patient("Mary White", "34 4th avenue", "13221", "New York");

        // Create an appointment
        Appointment appointment1 = new Appointment("11-11-2008", patient1, payment1, doctor1);
        // Create an appointment
        Appointment appointment2 = new Appointment("12-11-2008", patient2, payment2, doctor2);
        // Create an appointment
        Appointment appointment3 = new Appointment("13-11-2008", patient3, payment3, doctor3);
        // Create an appointment
        Appointment appointment4 = new Appointment("14-11-2008", patient4, payment4, doctor4);

        appointmentRepository.save(appointment1);
        appointmentRepository.save(appointment2);
        appointmentRepository.save(appointment3);
        appointmentRepository.save(appointment4);

        // Display all appointments
        appointmentRepository.findAll().forEach(System.out::println);

    }


}
