package com.car.show.Service;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FirebaseService {

    private final Storage storage;

    public FirebaseService() throws IOException {
        storage = StorageOptions.newBuilder()
                .setProjectId("carshow-85232")
                .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("google-services.json").getInputStream()))
                .build()
                .getService();
    }

    public String uploadFile(MultipartFile file, int carId) throws IOException {
        Bucket bucket = StorageClient.getInstance().bucket();
        String fileName = "car/" + carId + "/" + file.getOriginalFilename();
        Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());
        return blob.getMediaLink();
    }

    public List<Blob> getAllFiles() {
        List<Blob> blobs = new ArrayList<>();
        Page<Blob> blobsPage = storage.list("carshow-85232.appspot.com");
        for (Blob blob : blobsPage.iterateAll()) {
            blobs.add(blob);
        }
        return blobs;
    }

    private String generateFileName(MultipartFile multipartFile) {
        return UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
    }
}
