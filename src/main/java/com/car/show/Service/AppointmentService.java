package com.car.show.Service;

import com.car.show.Model.Appointment;
import com.car.show.Model.Car;
import com.car.show.Repository.AppointmentRepository;
import com.car.show.Repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CarRepository carRepository;

    @Transactional
    public void createAppointmentWithCarName(Appointment appointment, String carName) {
        Car car = carRepository.findByName(carName)
                .orElseThrow(() -> new EntityNotFoundException("Car not found with name: " + carName));
        appointment.setCar(car);
        appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment createAppointment(Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        String recipientEmail = "hei.harizo@gmail.com";
        sendAppointmentEmail(savedAppointment, recipientEmail);
        return savedAppointment;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
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

    private void sendAppointmentEmail(Appointment appointment, String recipientEmail) {
        emailService.sendAppointmentEmail(recipientEmail, appointment);
    }
}
