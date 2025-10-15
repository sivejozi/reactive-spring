package org.example;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Flux<User> getAllUsers() {
        return repository.findAll();
    }

    public Mono<User> getUserById(String id) {
        return repository.findById(id);
    }

    public Mono<User> createUser(User user) {
        return repository.save(user);
    }

    public Flux<User> getAdults() {
        return repository.findByAgeGreaterThan(17);
    }
}

