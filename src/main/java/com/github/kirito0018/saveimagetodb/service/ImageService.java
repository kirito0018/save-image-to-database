package com.github.kirito0018.saveimagetodb.service;

import com.github.kirito0018.saveimagetodb.dto.ImageResponseDTO;
import com.github.kirito0018.saveimagetodb.dto.ImageUploadDTO;
import com.github.kirito0018.saveimagetodb.entity.Image;
import com.github.kirito0018.saveimagetodb.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageResponseDTO saveImage(ImageUploadDTO imageUploadDTO) throws IOException {
        Image image = new Image();
        image.setName(imageUploadDTO.getName());
        image.setData(imageUploadDTO.getFile().getBytes());
        Image savedImage = imageRepository.save(image);
        return new ImageResponseDTO(savedImage.getId(), savedImage.getName(), "/image/" + savedImage.getId());
    }

    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(null);
    }
}
