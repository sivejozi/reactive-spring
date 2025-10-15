package org.example;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<String, User> store = new ConcurrentHashMap<>();

    public Flux<User> findAll() {
        return Flux.fromIterable(store.values());
    }

    public Mono<User> findById(String id) {
        return Mono.justOrEmpty(store.get(id));
    }

    public Mono<User> save(User user) {
        store.put(user.getId(), user);
        return Mono.just(user);
    }

    public Flux<User> findByAgeGreaterThan(int age) {
        return Flux.fromIterable(store.values())
                .filter(u -> u.getAge() > age);
    }
}
