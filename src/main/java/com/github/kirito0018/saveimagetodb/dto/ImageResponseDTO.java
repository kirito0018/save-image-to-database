package com.github.kirito0018.saveimagetodb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ImageResponseDTO {

    private Long id;
    private String name;
    private String url;

}
