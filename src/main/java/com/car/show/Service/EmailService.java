package com.car.show.Service;

import com.car.show.Model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendAppointmentEmail(String recipientEmail, Appointment appointment) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(recipientEmail);
            mailMessage.setSubject("Appointment Confirmation");
            mailMessage.setText("Dear " + appointment.getFirstName() + " " + appointment.getName() + ",\n\n" +
                    "Your appointment has been scheduled on " + appointment.getAppointmentDate() + ".\n\n" +
                    "Details:\n" +
                    "Contact: " + appointment.getContact() + "\n" +
                    "Message: " + appointment.getMessage() + "\n\n" +
                    "Best Regards,\n" +
                    "Car Show Team");

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}
