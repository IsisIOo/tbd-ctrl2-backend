package com.example.control2dba.controllers;

import com.example.control2dba.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        try {
            emailService.sendEmail(to, subject, text);
            return "Correo enviado exitosamente";
        } catch (Exception e) {
            return "Error al enviar el correo: " + e.getMessage();
        }
    }
}

