package com.car.show.Controller;

import com.car.show.Model.Appointment;
import com.car.show.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        if (appointment.isPresent()) {
            Appointment updatedAppointment = appointment.get();
            updatedAppointment.setCar(appointmentDetails.getCar());
            updatedAppointment.setName(appointmentDetails.getName());
            updatedAppointment.setFirstName(appointmentDetails.getFirstName());
            updatedAppointment.setEmail(appointmentDetails.getEmail());
            updatedAppointment.setMessage(appointmentDetails.getMessage());
            updatedAppointment.setContact(appointmentDetails.getContact());
            updatedAppointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            updatedAppointment.setStatus(appointmentDetails.getStatus());
            return ResponseEntity.ok(appointmentService.saveAppointment(updatedAppointment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
