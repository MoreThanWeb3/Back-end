package com.car.show.Service;

import com.car.show.Model.Image;
import com.car.show.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public List<Image> getImagesByCarId(Long carId) {
        return imageRepository.findByCarId(carId);
    }
    public String getMainImageByCarId(Long carId) {
        List<Image> images = imageRepository.findByCarId(carId);
        if (images != null && !images.isEmpty()) {
            return images.get(0).getUrl();
        }
        return null;
    }
}
