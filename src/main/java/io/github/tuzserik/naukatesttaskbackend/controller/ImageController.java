package io.github.tuzserik.naukatesttaskbackend.controller;

import io.github.tuzserik.naukatesttaskbackend.model.Image;
import io.github.tuzserik.naukatesttaskbackend.model.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = {"/api/images"})
    public ImageResponse getImages() {
        return new ImageResponse(200, imageService.getImages());
    }

    @GetMapping(value = {"/api/image"})
    public ImageResponse getImage(@RequestParam long id){
        Image image = imageService.getImage(id);
        if (image != null) {
            return new ImageResponse(200, imageService.getImage(id));
        }
        else return new ImageResponse(400, "Cannot get this user.");
    }

    @PostMapping(value = {"/api/image"})
    public ImageResponse saveImage(@RequestParam MultipartFile image) {
        try {
            if (imageService.saveImage(image)) {
                return new ImageResponse(200, imageService.getLast());
            }
            else {
                return new ImageResponse(400, "Cannot add or update provided image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping(value = {"/api/image"})
    public ImageResponse deleteImage(@RequestParam Long id) {
        if (imageService.deleteImage(id)) {
            return new ImageResponse(200, id);
        }
        else {
            return new ImageResponse(400, "Cannot delete provided image.");
        }
    }
}
