package com.car.show.Service;

import com.google.api.services.storage.Storage;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseService {
    public String getImageUrl(String imageName) throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("path/to/serviceAccountKey.json");

        Storage storage = (Storage) StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()
                .getService();

        // Replace "bucketName" with your Firebase Storage bucket name
        String bucketName = "carshow";
        String imageUrl = "gs://carshow-85232.appspot.com/Tesla Model 5/3316b5c844a575274a6cbf4fee532701.jpg" + bucketName + "/o/" + imageName + "?alt=media";

        return imageUrl;
    }
}
