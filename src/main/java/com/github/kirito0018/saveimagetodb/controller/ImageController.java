package com.github.kirito0018.saveimagetodb.controller;

import com.github.kirito0018.saveimagetodb.dto.ImageResponseDTO;
import com.github.kirito0018.saveimagetodb.dto.ImageUploadDTO;
import com.github.kirito0018.saveimagetodb.entity.Image;
import com.github.kirito0018.saveimagetodb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<ImageResponseDTO> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            ImageUploadDTO imageUploadDTO = new ImageUploadDTO();
            imageUploadDTO.setName(file.getOriginalFilename());
            imageUploadDTO.setFile(file);
            ImageResponseDTO responseDTO = imageService.saveImage(imageUploadDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Image image = imageService.getImage(id);
        if (image != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
                    .body(image.getData());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}

