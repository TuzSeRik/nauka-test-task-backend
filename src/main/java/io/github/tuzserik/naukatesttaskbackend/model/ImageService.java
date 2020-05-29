package io.github.tuzserik.naukatesttaskbackend.model;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class ImageService {
    private final ImageRepository repository;

    public ImageService(ImageRepository repository) {
        this.repository = repository;
    }


    public List<Image> getImages() {
        return repository.findAll();
    }

    public Image getImage(long id) {
        if (repository.existsById(id)) {
            return repository.getOne(id);
        }
        else return null;
    }

    public Image getLast() {
        return repository.findTopByOrderByIdDesc();
    }

    public boolean saveImage(MultipartFile file) throws IOException {
        if (repository.existsByName(file.getName())) {
            repository.saveAndFlush(new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes()));
            return true;
        }
        else {
            repository.saveAndFlush(new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes()));
            return false;
        }
    }

    public boolean deleteImage(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
