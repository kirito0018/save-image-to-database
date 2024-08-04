package com.github.kirito0018.saveimagetodb.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ImageUploadDTO {

    private String name;
    private MultipartFile file;

}
