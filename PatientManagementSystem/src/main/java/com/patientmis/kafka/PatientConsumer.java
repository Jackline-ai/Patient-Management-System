package com.patientmis.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.patientmis.dto.PatientRegistrationEvent;

@Service
public class PatientConsumer {

    @KafkaListener(topics = "patient-registrations", groupId = "patient-registrations-group")

    public void handlePatientRegistration(PatientRegistrationEvent event) {
	System.out.println("Received Patient Event: " + event.getFullName() + " [" + event.getEventType() + "]");

    }

}
