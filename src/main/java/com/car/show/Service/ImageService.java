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

    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
