package io.github.tuzserik.naukatesttaskbackend.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findTopByOrderByIdDesc();
    Boolean existsByName(String name);
}
