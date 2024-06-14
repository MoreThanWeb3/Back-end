package com.car.show.Service;

import com.car.show.Model.Appointment;
import com.car.show.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailService emailService;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        String recipientEmail = "hei.harizo@gmail.com";
        sendAppointmentEmail(savedAppointment, recipientEmail);
        return savedAppointment;
    }

    private void sendAppointmentEmail(Appointment appointment, String recipientEmail) {
        emailService.sendAppointmentEmail(recipientEmail, appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void validateAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(Appointment.Status.VALIDATED);
        appointmentRepository.save(appointment);
    }
}



