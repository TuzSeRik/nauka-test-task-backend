package io.github.tuzserik.naukatesttaskbackend.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(long id) {
        if (repository.existsById(id)) {
            return repository.getOne(id);
        }
        else return null;
    }

    public boolean saveUser(User user) {
        if (repository.existsById(user.getId())) {
            repository.saveAndFlush(user);
            return true;
        }
        else {
            repository.saveAndFlush(user);
            return false;
        }
    }

    public boolean deleteUser(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
