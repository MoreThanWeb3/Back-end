package com.car.show.Controller;

import com.car.show.Model.Admin;
import com.car.show.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/sign-in")
    public ResponseEntity<String> signInAdmin(@RequestBody Admin admin) {
        boolean adminExists = adminService.existsByEmailAndPassword(admin.getEmail(), admin.getPassword());
        if (adminExists) {
            return ResponseEntity.ok("Sign-in successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @PostMapping
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        if (adminService.existsByEmail(admin.getEmail())) {
            return ResponseEntity.badRequest().body("Admin with this email already exists");
        }

        adminService.saveAdmin(admin);
        return ResponseEntity.ok("Admin created successfully");
    }
}
