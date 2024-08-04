package com.github.kirito0018.saveimagetodb.repository;

import com.github.kirito0018.saveimagetodb.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
