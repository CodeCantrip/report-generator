package io.github.codecantrip.reportgenerator.data;

import io.github.codecantrip.reportgenerator.entity.*;
import io.github.codecantrip.reportgenerator.repository.AppUserRepository;
import io.github.codecantrip.reportgenerator.repository.ModalityRepository;
import io.github.codecantrip.reportgenerator.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DemoDataInitializer implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final ModalityRepository modalityRepository;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DemoDataInitializer(PasswordEncoder passwordEncoder, PatientRepository patientRepository, ModalityRepository modalityRepository, AppUserRepository appUserRepository){
        this.patientRepository = patientRepository;
        this.modalityRepository = modalityRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;

    }
    @Override
    public void run(String...args) {

        if(appUserRepository.findByUsername("rtuser").isEmpty()) {
            AppUser appUser = new AppUser(
                    "rtuser",
                    passwordEncoder.encode("password"),
                    "USER"

            );
            appUserRepository.save(appUser);
        }

        if (patientRepository.count() > 0) {
            return;
        }


        Patient patient1 = new Patient(
                "312",
                "ICU",
                "George Hat",
                LocalDate.of(1965, 4, 12),
                "Full Code",
                "COPD exacerbation"
        );
        patientRepository.save(patient1);

        Vent vent1 = new Vent();
        vent1.setVentMode("AC/VC");
        vent1.setVentSettings("14/500/6/40%");
        vent1.setPatient(patient1);
        modalityRepository.save(vent1);

        Ett ett1 = new Ett();
        ett1.setEttSize(7.5);
        ett1.setEttPlacement("23@teeth");
        ett1.setPatient(patient1);
        modalityRepository.save(ett1);

        Patient patient2 = new Patient(
                "320",
                "ICU",
                "George Hatter",
                LocalDate.of(1960, 6, 15),
                "Full Code",
                "CHF"
        );

        patientRepository.save(patient2);


        Patient patient3 = new Patient(
                "412",
                "CCU",
                "Mike Sat",
                LocalDate.of(1983, 5, 12),
                "Full Code",
                "Asthma Exacerbation"
        );

        patientRepository.save(patient3);

        Medication medication3 = new Medication();
        medication3.setMedicationName("Duoneb");
        medication3.setMedFrequency("Q6H");
        medication3.setPatient(patient3);
        modalityRepository.save(medication3);

        Medication medication4 = new Medication();
        medication4.setMedicationName("Albuterol");
        medication4.setMedFrequency("Q2PRN");
        medication4.setPatient(patient3);
        modalityRepository.save(medication4);


        Patient patient4 = new Patient(
                "301",
                "ICU",
                "Scott Pat",
                LocalDate.of(1943, 9, 12),
                "Full Code",
                "Hypoxic/Hypercapneic Respiratory Failure"
        );

        patientRepository.save(patient4);

        Trach trach1 = new Trach();
        trach1.setTrachSize(8.0);
        trach1.setTrachType("Shiley XLTD");
        trach1.setPatient(patient4);
        modalityRepository.save(trach1);

        Oxygen oxygen1 = new Oxygen();
        oxygen1.setOxygenDevice("Heated Trach Collar");
        oxygen1.setOxygenSetting("8L 35%");
        oxygen1.setPatient(patient4);
        modalityRepository.save(oxygen1);


        Patient patient5 = new Patient(
                "512",
                "PGCU",
                "Dwight Shrute",
                LocalDate.of(1979, 10, 9),
                "Full Code",
                "Obesity Hypoventilation/PNA"
        );
        patientRepository.save(patient5);

        Niv niv1 = new Niv();
        niv1.setNivMode("AVAPS");
        niv1.setNivSettings("12/ 480/ MAX P 35/ MIN P 10/ EPAP 12/ 35%");
        niv1.setNivFrequency("QHS/PRN");
        niv1.setPatient(patient5);
        modalityRepository.save(niv1);

        Cpt cpt1 = new Cpt();
        cpt1.setTherapyType("Metaneb");
        cpt1.setCptFrequency("Q6H");
        cpt1.setPatient(patient5);
        modalityRepository.save(cpt1);

        Medication medication5 = new Medication();
        medication5.setMedicationName("Hypertonic Saline 3%");
        medication5.setMedFrequency("Q6H");
        medication5.setPatient(patient5);
        modalityRepository.save(medication5);

        Medication medication6 = new Medication();
        medication6.setMedicationName("Albuterol");
        medication6.setMedFrequency("Q6H");
        medication6.setPatient(patient5);
        modalityRepository.save(medication6);

        Patient patient6 = new Patient(
                "515",
                "PGCU",
                "William Faulkner",
                LocalDate.of(1959, 12, 13),
                "Full Code",
                "Acute Kidney Failure"
        );
        patientRepository.save(patient6);


        Patient patient7 = new Patient(
                "401",
                "CCU",
                "Mary Brick",
                LocalDate.of(1947, 11, 10),
                "Full Code",
                "Hypoxic Respiratory Failure"
        );
        patientRepository.save(patient7);

        Oxygen oxygen2 = new Oxygen();
        oxygen2.setOxygenDevice("Nasal Cannula");
        oxygen2.setOxygenSetting("2L");
        oxygen2.setPatient(patient7);
        modalityRepository.save(oxygen2);


        Patient patient8 = new Patient(
                "321",
                "PGCU",
                "Billy Jean",
                LocalDate.of(1955, 2, 26),
                "Full Code",
                "Flu B"
        );
        patientRepository.save(patient8);

        Niv niv2 = new Niv();
        niv2.setNivMode("S/T");
        niv2.setNivSettings("12/6/35%");
        niv2.setNivFrequency("4 hours on 4 hours off");
        niv2.setPatient(patient8);
        modalityRepository.save(niv2);

        Oxygen oxygen3 = new Oxygen();
        oxygen3.setOxygenDevice("Salter HFNC");
        oxygen3.setOxygenSetting("8L");
        oxygen3.setPatient(patient8);
        modalityRepository.save(oxygen3);



    }

}
