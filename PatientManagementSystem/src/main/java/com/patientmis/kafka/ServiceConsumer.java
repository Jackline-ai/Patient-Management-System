package com.patientmis.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.patientmis.dto.ServiceRegistrationEvent;

@Service

public class ServiceConsumer {
    @KafkaListener(topics = "service-registrations", groupId = "service-registrations-group")
    public void handleServiceRegistration(ServiceRegistrationEvent event) {
	System.out.println("Received Service Event: " + event.getServiceName() + " [" + event.getEventType() + "]");
    }

}
