package io.github.tuzserik.naukatesttaskbackend.controller;

import io.github.tuzserik.naukatesttaskbackend.model.Image;

import java.util.List;

public class ImageResponse {
    int status;
    long id;
    String message;
    Image image;
    List<Image> array;

    public ImageResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ImageResponse(int status, long id) {
        this.status = status;
        this.id = id;
    }

    public ImageResponse(int status, Image image) {
        this.status = status;
        this.image = image;
    }

    public ImageResponse(int status, List<Image> array) {
        this.status = status;
        this.array = array;
    }
}
