package com.car.show.Controller;

import com.car.show.Model.Image;
import com.car.show.Service.FirebaseService;
import com.car.show.Service.ImageService;
import com.google.cloud.storage.Blob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private FirebaseService firebaseService;
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("carId") int carId) {
        try {
            String url = firebaseService.uploadFile(file, carId);
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<String>> getAllFiles() {
        List<Blob> blobs = firebaseService.getAllFiles();
        List<String> fileNames = blobs.stream()
                .map(Blob::getName)
                .collect(Collectors.toList());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fileNames);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<String> getMainImageByCarId(@PathVariable Long carId) {
        String mainImageUrl = imageService.getMainImageByCarId(carId);
        if (mainImageUrl != null) {
            return ResponseEntity.ok(mainImageUrl);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found for carId: " + carId);
        }
    }}
